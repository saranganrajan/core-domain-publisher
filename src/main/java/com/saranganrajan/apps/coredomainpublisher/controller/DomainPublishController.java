package com.saranganrajan.apps.coredomainpublisher.controller;

import com.saranganrajan.apps.coredomainpublisher.dto.domain.CustomerDomain;
import com.saranganrajan.apps.coredomainpublisher.dto.domain.PolicyDomain;
import com.saranganrajan.apps.coredomainpublisher.service.DomainPublishService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class DomainPublishController {

    @Autowired
    DomainPublishService domainPublishService;

    public DomainPublishController(DomainPublishService domainPublishService) {
        this.domainPublishService = domainPublishService;
    }

    @PostMapping(path = "/domain/policy/publish", consumes = "application/json")
    public ResponseEntity publishPolicyDomain(@RequestBody PolicyDomain policyDomain) {
        domainPublishService.publishPolicyDomain(policyDomain);
        return ResponseEntity.ok().build();
    }

    @PostMapping(path = "/domain/customer/publish", consumes = "application/json")
    public ResponseEntity publishCustomerDomain(@RequestBody List<CustomerDomain> customerDomains) {
        domainPublishService.publishCustomerDomain(customerDomains);
        return ResponseEntity.ok().build();
    }

}
