package com.lab.person.onboarding.config;
import com.lab.person.onboarding.infrastructure.entity.PersonEntity;
import com.lab.person.onboarding.infrastructure.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

@Component
public class DatabaseLoader implements ApplicationRunner {

    private PersonService personService;
    private static final Logger LOGGER = LoggerFactory.getLogger(DatabaseLoader.class);

    public DatabaseLoader(PersonService personService){
        this.personService = personService;
    }

    private Path getFilePath() throws URISyntaxException {
        return Paths.get(getClass().getClassLoader().getResource("lista_alunos.txt").toURI());
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        LOGGER.info("Registering pre registers into database");

        try(Stream<String> lines = Files.lines(getFilePath())){
            lines
                .filter(line -> !line.startsWith("-"))
                .filter(line -> !line.isBlank())
                .filter(line -> line.length() == 55)
                .forEach(line -> {
                    PersonEntity preRegister = new PersonEntity(
                            line.substring(0, 40).replaceAll("\\s+$", ""),
                            line.substring(41, 48),
                            line.substring(50, 55)
                    );
                    personService.insertPerson(preRegister);
                });

            LOGGER.info("All pre registers already inserted into database");

        } catch (Exception e){
            LOGGER.error("Could not load file into database: " + e.getMessage());
            e.printStackTrace();
        }

    }
}
