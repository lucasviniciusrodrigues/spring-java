package com.lab.person.onboarding.infrastructure.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Data
@Document
public class PersonEntity {

    @Id
    String document;
    String name;
    String birthday;

    public PersonEntity(){}

    public PersonEntity(String name, String birthday) {
        this.name = name;
        this.birthday = birthday;
    }
}
