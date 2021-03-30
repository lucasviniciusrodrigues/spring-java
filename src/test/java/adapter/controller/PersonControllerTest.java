package adapter.controller;

import adapter.infrastructure.service.PersonService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
    public void shouldReturn200() throws Exception {
        ResponseEntity responseEntity = personController.deletePerson("");
        assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
    }

}
