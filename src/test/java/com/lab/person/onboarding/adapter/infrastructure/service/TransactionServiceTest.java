package com.lab.person.onboarding.adapter.infrastructure.service;

import com.lab.person.onboarding.infrastructure.entity.TransactionEntity;
import com.lab.person.onboarding.infrastructure.repository.TransactionRepository;
import com.lab.person.onboarding.infrastructure.service.TransactionService;
import com.lab.person.onboarding.utils.Asserts;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static com.lab.person.onboarding.utils.Mocks.getTransactionEntity;

@RunWith(MockitoJUnitRunner.class)
public class TransactionServiceTest {

    @Mock
    TransactionRepository transactionRepository;
    TransactionEntity transactionEntity;
    TransactionService transactionService;

    @Before
    public void setup(){
        transactionEntity = getTransactionEntity();
        transactionService = new TransactionService(transactionRepository);

        when(transactionRepository.findById(Mockito.anyString())).thenReturn(Optional.of(transactionEntity));
        when(transactionRepository.save(Mockito.any())).thenReturn(transactionEntity);
        doNothing().when(transactionRepository).deleteById(Mockito.anyString());
    }

    @Test
    public void shouldInsertTransactionAtDatabase(){
        transactionService.insertTransaction(Mockito.any());
        Asserts.assertTransactionEntity(transactionEntity);
    }
    @Test
    public void shouldGetTransactionAtDatabase(){
        transactionService.getTransaction(Mockito.anyString());
        Asserts.assertTransactionEntity(transactionEntity);
    }

}