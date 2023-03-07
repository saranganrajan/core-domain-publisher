package com.saranganrajan.apps.coredomainpublisher.external.database.repository;

import com.saranganrajan.apps.coredomainpublisher.external.database.entity.CustomerDomainEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDomainRepository extends JpaRepository<CustomerDomainEntity, String> {
}
