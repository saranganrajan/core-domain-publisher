package com.saranganrajan.apps.coredomainpublisher.dto.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDomain {
    private String customerTransactionId;
    private String customerNumber;
    private String customerName;
    private String dateOfBirth;
    private String email;
    private String phoneNumber;
    private List<LinkedPolicy> linkedPolicies;


}
