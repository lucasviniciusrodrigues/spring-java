package com.lab.person.onboarding.adapter.controller;

import com.lab.person.onboarding.infrastructure.service.PersonService;
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
public class PersonControllerTest {

    @Mock
    private PersonService personService;

    PersonController personController;

    @Before
    public void setup(){
        personController = new PersonController(personService);
        doNothing().when(personService).deletePerson(anyString());
    }

    @Test
    public void shouldReturn204() throws Exception {
        ResponseEntity responseEntity = personController.deletePerson("");
        assertEquals(responseEntity.getStatusCode(), HttpStatus.NO_CONTENT);
    }

}
