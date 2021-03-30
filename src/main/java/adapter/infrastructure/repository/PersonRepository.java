package adapter.infrastructure.repository;

import adapter.infrastructure.entity.PersonEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonRepository extends MongoRepository<PersonEntity, String> {



}
