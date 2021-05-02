package com.lab.person.onboarding.infrastructure.repository;

import com.lab.person.onboarding.infrastructure.entity.TransactionEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TransactionRepository extends MongoRepository<TransactionEntity, String> {
    List<TransactionEntity> findAllByDocument(String document);
}