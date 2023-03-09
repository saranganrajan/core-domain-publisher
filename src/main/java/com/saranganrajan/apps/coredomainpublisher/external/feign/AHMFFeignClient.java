package com.saranganrajan.apps.coredomainpublisher.external.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name="ahmf-manager", url="http://localhost:8086")
public interface AHMFFeignClient {
    @PostMapping(path = "/manager/audit/update/{transactionId}/{status}")
    int updateStatus(@PathVariable String transactionId, @PathVariable String status);
}
