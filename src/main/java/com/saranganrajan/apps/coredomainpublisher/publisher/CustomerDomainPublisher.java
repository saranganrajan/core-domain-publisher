package com.saranganrajan.apps.coredomainpublisher.publisher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.saranganrajan.apps.coredomainpublisher.config.CustomerMessageChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(CustomerMessageChannel.class)
public class CustomerDomainPublisher implements MessagePublishAdapter {

    private final CustomerMessageChannel customerMessageChannel;

    @Autowired
    public CustomerDomainPublisher(CustomerMessageChannel customerMessageChannel) {
        this.customerMessageChannel = customerMessageChannel;
    }

    @Override
    public <T> void publish(T message, String label) {
       customerMessageChannel.output().send(MessageBuilder
                .withPayload(message)
                .setHeader("customer", label)
                .build());

    }
}
