package com.lab.person.onboarding.adapter.infrastructure.service;

import com.lab.person.onboarding.infrastructure.entity.PersonEntity;
import com.lab.person.onboarding.infrastructure.repository.PersonRepository;
import com.lab.person.onboarding.infrastructure.service.PersonService;
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
import static com.lab.person.onboarding.utils.Mocks.getPersonEntity;

@RunWith(MockitoJUnitRunner.class)
public class PersonServiceTest {

    @Mock
    PersonRepository personRepository;

    PersonEntity personEntity;
    PersonService personService;


    @Before
    public void setup(){
        personEntity = getPersonEntity();
        personService = new PersonService(personRepository);

        when(personRepository.findById(Mockito.anyString())).thenReturn(Optional.of(personEntity));
        when(personRepository.save(Mockito.any())).thenReturn(personEntity);
        doNothing().when(personRepository).deleteById(Mockito.anyString());
    }

    @Test
    public void shouldInsertPersonAtDatabase(){
        personService.insertPerson(Mockito.any());
        Asserts.assertPersonEntity(personEntity);
    }

    @Test
    public void shouldDeletePersonAtDatabase(){
        personService.deletePerson(Mockito.anyString());
        Asserts.assertPersonEntity(personEntity);
    }

    @Test
    public void shouldGetPersonAtDatabase(){
        personService.getPerson(Mockito.anyString());
        Asserts.assertPersonEntity(personEntity);
    }

}
