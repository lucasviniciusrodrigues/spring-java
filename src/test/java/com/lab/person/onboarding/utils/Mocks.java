package com.lab.person.onboarding.utils;

import com.lab.person.onboarding.infrastructure.entity.PersonEntity;

public class Mocks {

    public static PersonEntity getPersonEntity(){
        return new PersonEntity("Aquela Pessoa", "123", "Outra coisa ai");
    }

}
