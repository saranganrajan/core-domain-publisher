package com.saranganrajan.apps.coredomainpublisher.dto;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    private String customerTransactionId;
    private String customerNumber;
    private String customerName;
    private String dateOfBirth;
    private String email;
    private String phoneNumber;

}
