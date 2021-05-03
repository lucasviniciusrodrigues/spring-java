package com.lab.person.onboarding.utils;

import com.lab.person.onboarding.infrastructure.entity.PersonEntity;
import com.lab.person.onboarding.infrastructure.entity.TransactionEntity;

import static com.lab.person.onboarding.utils.Mocks.getTransactionEntity;
import static org.junit.Assert.assertEquals;
import static com.lab.person.onboarding.utils.Mocks.getPersonEntity;

public class Asserts {

    public static void assertPersonEntity(PersonEntity personEntity){
        PersonEntity basePersonEntity = getPersonEntity();

        assertEquals(basePersonEntity.getDocument(), personEntity.getDocument());
        assertEquals(basePersonEntity.getName(), personEntity.getName());
        assertEquals(basePersonEntity.getAnotherInfo(), personEntity.getAnotherInfo());
    }

    public static void assertTransactionEntity(TransactionEntity transactionEntity){
        TransactionEntity baseTransactionEntity = getTransactionEntity();

        assertEquals(baseTransactionEntity.getTransactionId(), transactionEntity.getTransactionId());
        assertEquals(baseTransactionEntity.getStoreName(), transactionEntity.getStoreName());
    }

}
