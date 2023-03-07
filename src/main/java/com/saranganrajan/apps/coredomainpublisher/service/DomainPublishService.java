package com.saranganrajan.apps.coredomainpublisher.service;

import com.saranganrajan.apps.coredomainpublisher.dto.domain.CustomerDomain;
import com.saranganrajan.apps.coredomainpublisher.dto.domain.PolicyDomain;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DomainPublishService {
    void publishPolicyDomain(PolicyDomain policyDomain);
    void publishCustomerDomain(CustomerDomain customerDomain);
}
