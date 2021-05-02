package com.lab.person.onboarding.infrastructure.service;

import com.lab.person.onboarding.adapter.controller.TransactionDownloadController;
import com.lab.person.onboarding.infrastructure.entity.TransactionEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Service
public class DownloadService {

    public void downloadCsv(HttpServletResponse response) throws IOException {
        response.setContentType("text/csv");
        response.setHeader("Content-Disposition", "attachment; file=text.csv");
        TransactionService.(response.getWriter());
    }



//    public void dowloadTransaction(HttpServletResponse response) throws IOException{
//
//        String csvFileName = "transações.csv";
//        response.setContentType("text/csv");
//
//
//
}
