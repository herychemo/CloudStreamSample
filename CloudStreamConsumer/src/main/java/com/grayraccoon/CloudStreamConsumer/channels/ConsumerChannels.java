package com.grayraccoon.CloudStreamConsumer.channels;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface ConsumerChannels {

    String ProducerChannel = "producerMessageChannel";

    @Input(value = ConsumerChannels.ProducerChannel)
    SubscribableChannel producerMessageChannel();

}
