package com.grayraccoon.CloudStreamConsumer;

import com.grayraccoon.CloudStreamConsumer.channels.ConsumerChannels;
import org.apache.commons.text.WordUtils;
import org.springframework.beans.factory.InjectionPoint;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;

import java.util.Objects;
import java.util.logging.Logger;

@SpringBootApplication
@EnableBinding(ConsumerChannels.class)
public class CloudStreamConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudStreamConsumerApplication.class, args);
	}

	@Bean
	@Scope("prototype")
	Logger logger (InjectionPoint ip) {
		return Logger.getLogger(ip.getDeclaredType().getName());
	}

	/*
	@StreamListener(ConsumerChannels.ProducerChannel)
	public void simpleConsumer(String data) {
		System.out.print("Without processing: " + data );
	}
	*/

	@Bean
	public IntegrationFlow integrationFlow(ConsumerChannels c, Logger logger) {
		return IntegrationFlows.from(c.producerMessageChannel())
				.filter(Objects::nonNull)
				.transform(String.class, WordUtils::capitalizeFully)
				.handle(String.class, (payload, messageHeaders) -> {
					logger.info("new message: " + payload);
					return null;
				})
				.get();
	}

}
