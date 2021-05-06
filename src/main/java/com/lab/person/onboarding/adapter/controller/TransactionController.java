package com.lab.person.onboarding.adapter.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lab.person.onboarding.adapter.controller.base.ITransactionController;
import com.lab.person.onboarding.infrastructure.entity.TransactionEntity;
import com.lab.person.onboarding.infrastructure.service.TransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController implements ITransactionController {

    TransactionService transactionService;

    public TransactionController(TransactionService transactionService){
        this.transactionService = transactionService;
    }

    @Override
    public TransactionEntity getTransactionById(String transactionId){
        return transactionService.getTransaction(transactionId).get();
    }

    public String downloadTransactionsByDocument(String document) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(transactionService.getTransactionByDoc(document));
    }

    @Override
    public TransactionEntity postTransaction(TransactionEntity transactionEntity){
        return transactionService.insertTransaction(transactionEntity);
    }

    @Override
    public ResponseEntity<Object> deleteTransaction(String transaction){
        transactionService.deleteTransaction(transaction);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
