package com.grayraccoon.CloudStreamConsumer.channels;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface ConsumerChannels {

    @Input
    SubscribableChannel producer();

}
