package com.example.demo.repositories;

import com.example.demo.entities.person.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    public List<Person> findByName(String lastName);

    @Query("Select p from Person p where lower(p.lastName) =lower(:lastName) ")
    public List<Person> findByLastName(@Param("lastName") String lastName );
}
