package com.saranganrajan.apps.coredomainpublisher.config;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

@Component
public interface CustomerMessageChannel {
    @Output(StreamChannel.CUSTOMER_OUTPUT)
    MessageChannel output();
}
