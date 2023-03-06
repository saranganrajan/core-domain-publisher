package com.saranganrajan.apps.coredomainpublisher.publisher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.saranganrajan.apps.coredomainpublisher.config.PolicyMessageChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(PolicyMessageChannel.class)
public class PolicyDomainPublisher implements MessagePublishAdapter {
    @Autowired
    private final PolicyMessageChannel policyMessageChannel;

    public PolicyDomainPublisher(PolicyMessageChannel policyMessageChannel) {
        this.policyMessageChannel = policyMessageChannel;
    }

    @Override
    public <T> void publish(T message, String label) {
        policyMessageChannel.output().send(MessageBuilder
                .withPayload(message)
                .setHeader("Policy", label)
                .build());
    }
}
