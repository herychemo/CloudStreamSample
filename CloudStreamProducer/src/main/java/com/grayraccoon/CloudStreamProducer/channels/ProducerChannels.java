package com.grayraccoon.CloudStreamProducer.channels;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface ProducerChannels {

    String ConsumerChannel = "consumerMessageChannel";

    //We might have more channels.
    @Output(value = ProducerChannels.ConsumerChannel)
    MessageChannel consumerMessageChannel();

}
