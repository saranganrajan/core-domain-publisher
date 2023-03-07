package com.saranganrajan.apps.coredomainpublisher.external.database.repository;

import com.saranganrajan.apps.coredomainpublisher.external.database.entity.PolicyTransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PolicyTransactionRepository extends JpaRepository<PolicyTransactionEntity, String> {
}
