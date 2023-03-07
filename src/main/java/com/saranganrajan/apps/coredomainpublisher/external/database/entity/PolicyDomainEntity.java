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
@Table(name = "ahmf_policy_domain")
public class PolicyDomainEntity {
    @Id
    @Column(name = "policy_number")
    private String policyNumber;
    @Column(name = "payload")
    private String payload;
}
