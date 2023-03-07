package com.saranganrajan.apps.coredomainpublisher.external.database.repository;

import com.saranganrajan.apps.coredomainpublisher.external.database.entity.PolicyDomainEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PolicyDomainRepository extends JpaRepository<PolicyDomainEntity, String> {
}
