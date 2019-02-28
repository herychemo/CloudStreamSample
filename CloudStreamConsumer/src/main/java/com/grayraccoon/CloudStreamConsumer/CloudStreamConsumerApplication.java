package com.grayraccoon.CloudStreamConsumer;

import com.grayraccoon.CloudStreamConsumer.channels.ConsumerChannels;
import org.springframework.beans.factory.InjectionPoint;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;

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

	@Bean
	public IntegrationFlow integrationFlow(ConsumerChannels c, Logger logger) {
		return IntegrationFlows.from(c.producer())
				.handle(String.class, (payload, messageHeaders) -> {
					logger.info("new message: " + payload);
					return null;
				})
				.get();
	}


}
