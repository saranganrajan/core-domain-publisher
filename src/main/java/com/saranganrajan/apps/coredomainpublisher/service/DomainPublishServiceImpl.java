package com.saranganrajan.apps.coredomainpublisher.service;

import com.saranganrajan.apps.coredomainpublisher.dto.domain.CustomerDomain;
import com.saranganrajan.apps.coredomainpublisher.dto.domain.PolicyDomain;
import com.saranganrajan.apps.coredomainpublisher.publisher.CustomerDomainPublisher;
import com.saranganrajan.apps.coredomainpublisher.publisher.PolicyDomainPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DomainPublishServiceImpl implements DomainPublishService {

    @Autowired
    private CustomerDomainPublisher customerDomainPublisher;
    @Autowired
    private PolicyDomainPublisher policyDomainPublisher;

    public DomainPublishServiceImpl(CustomerDomainPublisher customerDomainPublisher,
                                    PolicyDomainPublisher policyDomainPublisher) {
        this.customerDomainPublisher = customerDomainPublisher;
        this.policyDomainPublisher = policyDomainPublisher;
    }


    @Override
    public void publishPolicyDomain(PolicyDomain policyDomain) {
        policyDomainPublisher.publish(policyDomain, "Policy Upload");
    }

    @Override
    public void publishCustomerDomain(List<CustomerDomain> customerDomain) {
        customerDomainPublisher.publish(customerDomain, "Customer Upload");
    }
}
