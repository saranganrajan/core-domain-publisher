package com.saranganrajan.apps.coredomainpublisher.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerPolicy {
    private String policyNumber;
    private String customerNumber;
    private String linkType;
    private String Description;
}
