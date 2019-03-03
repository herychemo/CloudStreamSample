package com.grayraccoon.CloudStreamProducer.ws;

import com.grayraccoon.CloudStreamProducer.channels.ProducerChannels;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ws")
public class PublisherWebService {

    private final MessageChannel consumerMessageChannel;

    @Autowired
    public PublisherWebService(ProducerChannels channels) {
        this.consumerMessageChannel = channels.consumerMessageChannel();
    }

    @PostMapping("/greet/{name}")
    public String publish(@PathVariable String name) {
        String greeting = String.format("Hello, %s!", name);

        Message<String> msg = MessageBuilder
                .withPayload(greeting)
                .build();
         boolean isSent = this.consumerMessageChannel.send(msg);

        if (isSent) {
            return "greeting sent...";
        }else {
            return "greeting failed...";
        }
    }


}
