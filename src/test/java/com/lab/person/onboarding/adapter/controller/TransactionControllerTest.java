package com.lab.person.onboarding.adapter.controller;

import com.lab.person.onboarding.infrastructure.service.TransactionService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;

@RunWith(MockitoJUnitRunner.class)
public class TransactionControllerTest {

    @Mock
    private TransactionService transactionService;

    TransactionController transactionController;

    @Before
    public void setup(){
        transactionController = new TransactionController((transactionService));
        doNothing().when(transactionService).deleteTransaction(anyString());
    }

    @Test
    public void shouldReturn204() throws Exception{
        ResponseEntity responseEntity = transactionController.deleteTransaction("");
        assertEquals(responseEntity.getStatusCode(), HttpStatus.NO_CONTENT);
    }
}
