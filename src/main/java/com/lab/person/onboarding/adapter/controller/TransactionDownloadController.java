package com.lab.person.onboarding.adapter.controller;
import com.lab.person.onboarding.adapter.controller.base.ITransactionDownloadController;
import com.lab.person.onboarding.infrastructure.entity.TransactionEntity;
import com.lab.person.onboarding.infrastructure.service.DownloadService;
import com.lab.person.onboarding.infrastructure.service.TransactionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class TransactionDownloadController implements ITransactionDownloadController {

    TransactionService transactionService;

    private List<TransactionEntity> testEntity() {
    List<TransactionEntity> data = new ArrayList<>();
    data.add(new TransactionEntity("123",
    "1234","123123", "Teste",
    "231231", 125454));
    return testEntity();
    }

    public TransactionDownloadController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @Override
    public TransactionEntity getAll(String document) {
        return transactionService.getTransaction(document).get();
    }

    @GetMapping("/download/teste.csv")
    public void downloadCSV(HttpServletResponse response) throws IOException {
        response.setContentType("text/csv");
        response.setHeader("Content-Disposition", "attachment; file=listTransaction.csv");
        DownloadService.downloadCsv(response.getWriter(), testEntity());
    }
}