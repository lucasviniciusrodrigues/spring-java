package com.lab.person.onboarding.infrastructure.repository;

import com.lab.person.onboarding.infrastructure.entity.PersonEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonRepository extends MongoRepository<PersonEntity, String> {}