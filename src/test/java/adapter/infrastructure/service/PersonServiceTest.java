package adapter.infrastructure.service;

import adapter.infrastructure.entity.PersonEntity;
import adapter.infrastructure.repository.PersonRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static utils.mocks.Asserts.assertPersonEntity;
import static utils.mocks.Mocks.getPersonEntity;

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
        assertPersonEntity(personEntity);
    }

    @Test
    public void shouldDeletePersonAtDatabase(){
        personService.deletePerson(Mockito.anyString());
        assertPersonEntity(personEntity);
    }

    @Test
    public void shouldGetPersonAtDatabase(){
        personService.getPerson(Mockito.anyString());
        assertPersonEntity(personEntity);
    }

}
