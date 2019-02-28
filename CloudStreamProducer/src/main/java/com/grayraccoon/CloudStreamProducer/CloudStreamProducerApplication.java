package com.grayraccoon.CloudStreamProducer;

import com.grayraccoon.CloudStreamProducer.channels.ProducerChannels;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding(ProducerChannels.class)
@SpringBootApplication
public class CloudStreamProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudStreamProducerApplication.class, args);
	}

}
