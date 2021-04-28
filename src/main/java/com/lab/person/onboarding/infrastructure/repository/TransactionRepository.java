package com.lab.person.onboarding.infrastructure.repository;

import com.lab.person.onboarding.infrastructure.entity.TransactionEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TransactionRepository extends MongoRepository<TransactionEntity, String> {
}