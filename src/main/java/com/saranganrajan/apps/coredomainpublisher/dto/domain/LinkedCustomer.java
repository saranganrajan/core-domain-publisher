package com.saranganrajan.apps.coredomainpublisher.dto.domain;

import com.saranganrajan.apps.coredomainpublisher.dto.Customer;
import lombok.*;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LinkedCustomer {
    private String linkType;
    private Customer customer;
}
