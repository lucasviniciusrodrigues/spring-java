package com.lab.person.onboarding.adapter.controller;
import com.lab.person.onboarding.adapter.controller.base.ITransactionDownloadController;
import com.lab.person.onboarding.infrastructure.entity.TransactionEntity;
import com.lab.person.onboarding.infrastructure.service.DownloadService;
import com.lab.person.onboarding.infrastructure.service.TransactionService;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
public class TransactionDownloadController implements ITransactionDownloadController {

    TransactionService transactionService;

    public TransactionDownloadController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @Override
    public TransactionEntity getAll(String document) {
        return transactionService.getTransaction(document).get();
    }

    public void downloadCSV(HttpServletResponse response) throws IOException {
        response.setContentType("text/csv");
        response.setHeader("Content-Disposition", "attachment; file=listTransaction.csv");
        DownloadService.downloadCsv(response.getWriter(), (List<TransactionEntity>) transactionService);
    }
}