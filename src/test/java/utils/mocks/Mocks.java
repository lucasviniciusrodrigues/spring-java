package utils.mocks;

import adapter.infrastructure.entity.PersonEntity;

public class Mocks {

    public static PersonEntity getPersonEntity(){
        return new PersonEntity("12345678910", "Aquela Pessoa", "12/12/1912");
    }

}
