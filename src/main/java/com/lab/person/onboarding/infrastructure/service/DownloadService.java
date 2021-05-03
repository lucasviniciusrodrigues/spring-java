package com.lab.person.onboarding.infrastructure.service;

import com.lab.person.onboarding.infrastructure.entity.TransactionEntity;
import org.springframework.stereotype.Service;
import java.io.PrintWriter;
import java.util.List;

@Service
public class DownloadService {

    public static void downloadCsv(PrintWriter writer, List<TransactionEntity> transactionEntityList){
        writer.write("TransactionID, Document, CardNumber, StoreName, StoreDocument, Value \n");
        for (TransactionEntity transactionEntity: transactionEntityList){
            writer.write(transactionEntity.getTransactionId() + "," + transactionEntity.getDocument() + ","
            + transactionEntity.getCardNumber() + "," + transactionEntity.getStoreName() + "," + transactionEntity.getStoreDocument() + ","
                    + transactionEntity.getValue() + "\n");
        }
    }
}