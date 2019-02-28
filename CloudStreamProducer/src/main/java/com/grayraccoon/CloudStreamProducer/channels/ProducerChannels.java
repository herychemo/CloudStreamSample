package com.grayraccoon.CloudStreamProducer.channels;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface ProducerChannels {

    //We might have more channels.
    @Output
    MessageChannel consumer();

}
