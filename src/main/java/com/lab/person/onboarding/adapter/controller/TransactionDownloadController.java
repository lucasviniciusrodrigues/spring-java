package com.lab.person.onboarding.adapter.controller;
import com.lab.person.onboarding.adapter.controller.base.ITransactionDonwnloadController;
import com.lab.person.onboarding.infrastructure.entity.TransactionEntity;
import com.lab.person.onboarding.infrastructure.service.TransactionService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionDownloadController implements ITransactionDonwnloadController {

    TransactionService transactionService;

    public TransactionDownloadController(TransactionService transactionService){
        this.transactionService = transactionService;
    }

    @Override
    public TransactionEntity getAll(String document){
        return transactionService.getTransaction(document).get();
    }
}