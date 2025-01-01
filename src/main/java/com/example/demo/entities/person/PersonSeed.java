package com.example.demo.entities.person;

import com.example.demo.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Component
public class PersonSeed implements CommandLineRunner {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public void run(String... args) throws Exception {
        //createPerson();
        createPersons();
    }

    private void createPerson() {
        Person person = new Person("Mostafa","Gharali","mgh.ict@gmail.com",new Date());
        personRepository.save(person);
    }

    private void createPersons()
    {
        List<Person> personsList= Arrays.asList(
                new Person("Mostafa","Gharali","mgh.ict@gmail.com",new Date()),
                new Person("Zohreh","Hosseini","zhm2.ict@gmail.com",new Date())
        );

        personRepository.saveAll(personsList);
    }
}
