package com.saranganrajan.apps.coredomainpublisher.subscriber;

import com.google.gson.Gson;
import com.saranganrajan.apps.coredomainpublisher.config.PolicyMessageChannel;
import com.saranganrajan.apps.coredomainpublisher.config.StreamChannel;
import com.saranganrajan.apps.coredomainpublisher.dto.domain.PolicyDomain;
import com.saranganrajan.apps.coredomainpublisher.external.database.entity.CustomerDomainEntity;
import com.saranganrajan.apps.coredomainpublisher.external.database.entity.PolicyDomainEntity;
import com.saranganrajan.apps.coredomainpublisher.external.database.repository.PolicyDomainRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
@EnableBinding(PolicyMessageChannel.class)
public class PolicyDomainSubscriber {

    @Autowired
    private PolicyDomainRepository policyDomainRepository;

    @StreamListener(target = StreamChannel.POLICY_INPUT, condition = "headers.containsValue('Policy Upload')")
    public void handlePolicyDomain(MessageHeaders headers, PolicyDomain policyDomain) {
        log.info("Policy Domain Received: {}", policyDomain);
        //Retrieve from Database
        PolicyDomainEntity policyDomainEntity = new PolicyDomainEntity();
        policyDomainEntity.setPolicyNumber(policyDomain.getPolicyNumber());
        policyDomainEntity.setPayload(new Gson().toJson(policyDomain));
        //Update the Policy Domain
        policyDomainRepository.save(policyDomainEntity);
    }
}
