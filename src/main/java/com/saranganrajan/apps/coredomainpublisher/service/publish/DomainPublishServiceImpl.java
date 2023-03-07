package com.saranganrajan.apps.coredomainpublisher.service.publish;

import com.saranganrajan.apps.coredomainpublisher.dto.domain.CustomerDomain;
import com.saranganrajan.apps.coredomainpublisher.dto.domain.PolicyDomain;
import com.saranganrajan.apps.coredomainpublisher.external.feign.AHMFFeignClient;
import com.saranganrajan.apps.coredomainpublisher.publisher.CustomerDomainPublisher;
import com.saranganrajan.apps.coredomainpublisher.publisher.PolicyDomainPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DomainPublishServiceImpl implements DomainPublishService {

    @Autowired
    private CustomerDomainPublisher customerDomainPublisher;
    @Autowired
    private PolicyDomainPublisher policyDomainPublisher;
    @Autowired
    AHMFFeignClient ahmfFeignClient;

    public DomainPublishServiceImpl(CustomerDomainPublisher customerDomainPublisher,
                                    PolicyDomainPublisher policyDomainPublisher,
                                    AHMFFeignClient ahmfFeignClient) {
        this.customerDomainPublisher = customerDomainPublisher;
        this.policyDomainPublisher = policyDomainPublisher;
        this.ahmfFeignClient = ahmfFeignClient;
    }


    @Override
    public void publishPolicyDomain(PolicyDomain policyDomain) {
        try {
            policyDomainPublisher.publish(policyDomain, "Policy Upload");
            ahmfFeignClient.updateStatus(policyDomain.getPolicyTransactionId(), "COMPLETED");
        } catch (Exception e) {
            ahmfFeignClient.updateStatus(policyDomain.getPolicyTransactionId(), "FAILED");
        }
    }

    @Override
    public void publishCustomerDomain(CustomerDomain customerDomain) {
        try{
            customerDomainPublisher.publish(customerDomain, "Customer Upload");
            ahmfFeignClient.updateStatus(customerDomain.getLinkedPolicies().get(0).getPolicy().getPolicyTransactionId(), "COMPLETED");
        } catch (Exception e) {
            ahmfFeignClient.updateStatus(customerDomain.getLinkedPolicies().get(0).getPolicy().getPolicyTransactionId(), "FAILED");
        }
    }
}
