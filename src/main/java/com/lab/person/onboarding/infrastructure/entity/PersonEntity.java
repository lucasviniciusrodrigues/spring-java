package com.lab.person.onboarding.infrastructure.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class PersonEntity {

    @Id
    String document;
    String name;
    String birthday;

    public PersonEntity(){}

    public PersonEntity(String document, String name, String birthday) {
        this.document = document;
        this.name = name;
        this.birthday = birthday;
    }
}
