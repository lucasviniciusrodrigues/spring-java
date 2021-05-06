
package com.lab.person.onboarding.infrastructure.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import java.math.BigDecimal;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class TransactionEntity {

    @Id
    private String transactionId;
    private String document;
    private String cardNumber;
    private String storeName;
    private String storeDocument;
    private BigDecimal value;

    public TransactionEntity(){}

    public TransactionEntity(String transactionId, String document, String cardNumber, String storeName,
                             String storeDocument, BigDecimal value){
        this.transactionId = transactionId;
        this.document = document;
        this.cardNumber = cardNumber;
        this.storeName = storeName;
        this.storeDocument = storeDocument;
        this.value = value;
    }
}
