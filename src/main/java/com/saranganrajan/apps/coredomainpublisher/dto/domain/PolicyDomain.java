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
public class PolicyDomain {
    private String policyTransactionId;
    private String policyNumber;
    private String plan;
    private String policyEffectiveDate;
    private String policySubmissionDate;
    private double premiumPaid;
    private double premiumDue;
    private String paymentMode;
    private String status;
    private String agentName;
    private List<LinkedCustomer> linkedCustomers;

}
