package com.example.demo.services;

import com.example.demo.entities.person.Person;
import com.example.demo.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    public Person createPerson(Person person) {
        return personRepository.save(person);
    }

    public Iterable<Person> createPersons(List<Person> persons)
    {
        return personRepository.saveAll(persons);
    }
}
