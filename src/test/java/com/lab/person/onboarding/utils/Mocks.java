package com.lab.person.onboarding.utils;

import com.lab.person.onboarding.infrastructure.entity.PersonEntity;
import com.lab.person.onboarding.infrastructure.entity.TransactionEntity;

public class Mocks {

    public static PersonEntity getPersonEntity() {
        return new PersonEntity("Aquela Pessoa", "123", "Outra coisa ai");
    }

    public static TransactionEntity getTransactionEntity() {
        return new TransactionEntity("78780","9985578547","1234-1123-4556-44567","Loja Da Apple", "11234568790011", 25156);
    }
}
