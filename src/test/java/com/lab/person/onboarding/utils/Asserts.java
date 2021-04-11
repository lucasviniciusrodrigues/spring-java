package com.lab.person.onboarding.utils;

import com.lab.person.onboarding.infrastructure.entity.PersonEntity;

import static org.junit.Assert.assertEquals;
import static com.lab.person.onboarding.utils.Mocks.getPersonEntity;

public class Asserts {

    public static void assertPersonEntity(PersonEntity personEntity){
        PersonEntity basePersonEntity = getPersonEntity();

        assertEquals(basePersonEntity.getDocument(), personEntity.getDocument());
        assertEquals(basePersonEntity.getName(), personEntity.getName());
        assertEquals(basePersonEntity.getBirthday(), personEntity.getBirthday());
    }

}
