package com.saranganrajan.apps.coredomainpublisher.subscriber;

import com.google.gson.Gson;
import com.saranganrajan.apps.coredomainpublisher.config.CustomerMessageChannel;
import com.saranganrajan.apps.coredomainpublisher.config.StreamChannel;
import com.saranganrajan.apps.coredomainpublisher.dto.domain.CustomerDomain;
import com.saranganrajan.apps.coredomainpublisher.external.database.entity.CustomerDomainEntity;
import com.saranganrajan.apps.coredomainpublisher.external.database.repository.CustomerDomainRepository;
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
@EnableBinding(CustomerMessageChannel.class)
public class CustomerDomainSubscriber {

    @Autowired
    private CustomerDomainRepository customerDomainRepository;

    public CustomerDomainSubscriber(CustomerDomainRepository customerDomainRepository) {
        this.customerDomainRepository = customerDomainRepository;
    }

    @StreamListener(target = StreamChannel.CUSTOMER_INPUT, condition = "headers.containsValue('Customer Upload')")
    public void handleCustomerDomain(MessageHeaders headers, CustomerDomain customerDomain) {
        log.info("Customer Domain Received: {}", customerDomain);
        //Retrieve from Database
        CustomerDomainEntity customerDomainEntity = new CustomerDomainEntity();
        customerDomainEntity.setCustomerNumber(customerDomain.getCustomerNumber());
        customerDomainEntity.setPayload(new Gson().toJson(customerDomain));
        //Update the Customer Domain
        customerDomainRepository.save(customerDomainEntity);
    }
}
