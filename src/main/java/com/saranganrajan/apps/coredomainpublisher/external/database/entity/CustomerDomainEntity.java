package com.saranganrajan.apps.coredomainpublisher.external.database.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ahmf_customer_domain")
public class CustomerDomainEntity {
    @Id
    @Column(name = "customer_number")
    private String customerNumber;
    @Column(name = "payload")
    private String payload;
}
