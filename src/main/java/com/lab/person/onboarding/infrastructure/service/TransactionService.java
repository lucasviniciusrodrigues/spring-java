package com.lab.person.onboarding.infrastructure.service;

import com.lab.person.onboarding.infrastructure.entity.TransactionEntity;
import com.lab.person.onboarding.infrastructure.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public Optional<TransactionEntity> getTransaction(String transactionId) {
        return transactionRepository.findById(transactionId);
    }

    public TransactionEntity insertTransaction(TransactionEntity transactionEntity){
        return transactionRepository.save(transactionEntity);
    }

    public void deleteTransaction(String transactionId){
        transactionRepository.deleteById(transactionId);
    }

    public List<TransactionEntity> getTransactionByDoc(String document) {
        return transactionRepository.findAllByDocument(document);
    }
}
