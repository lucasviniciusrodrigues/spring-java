package com.lab.person.onboarding.infrastructure.service;

import com.lab.person.onboarding.infrastructure.entity.PersonEntity;
import com.lab.person.onboarding.infrastructure.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    PersonRepository personRepository;

    public PersonService(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    public Optional<PersonEntity> getPerson(String document){
        return personRepository.findById(document);
    }

    public List<PersonEntity> getAllPersons(){
        return personRepository.findAll();
    }

    public PersonEntity insertPerson(PersonEntity personEntity){
        return personRepository.save(personEntity);
    }

    public void deletePerson(String document){
        personRepository.deleteById(document);
    }

}
