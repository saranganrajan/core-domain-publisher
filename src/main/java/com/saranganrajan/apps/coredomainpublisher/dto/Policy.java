package com.saranganrajan.apps.coredomainpublisher.dto;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Policy {

    private String policyNumber;
    private String planCode;
    private String plan;
    private String policyEffectiveDate;
    private String policySubmissionDate;
    private double premiumPaid;
    private double premiumDue;
    private String lastPaymentMode;
    private String paymentMode;
    private String policyStatusCode;
    private String status;
    private String agentCode;
    private String agentName;
    private String freezeCode;

}
