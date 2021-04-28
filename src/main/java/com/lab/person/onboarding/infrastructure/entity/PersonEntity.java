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
    String anotherInfo;

    public PersonEntity(){}

    public PersonEntity(String name, String document, String anotherInfo) {
        this.name = name;
        this.document = document;
        this.anotherInfo = anotherInfo;
    }
}
