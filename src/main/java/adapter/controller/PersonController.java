package adapter.controller;

import adapter.controller.base.IPersonController;
import adapter.infrastructure.entity.PersonEntity;
import adapter.infrastructure.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class PersonController implements IPersonController {

    PersonService personService;

    PersonController(PersonService personService){
        this.personService = personService;
    }

    @Override
    public PersonEntity getPersonById(String document) {
        return personService.getPerson(document).get();
    }

    @Override
    public PersonEntity postPerson(PersonEntity personEntity) {
        return personService.insertPerson(personEntity);
    }

    @Override
    public PersonEntity updatePerson(PersonEntity personEntity) {
        return personService.insertPerson(personEntity);
    }

    @Override
    public ResponseEntity<Object> deletePerson(String document) {
        personService.deletePerson(document);
        return new ResponseEntity(HttpStatus.OK);
    }

}
