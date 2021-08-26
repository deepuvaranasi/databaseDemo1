package com.example.databasedemo1;

import com.example.databasedemo1.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonsRepository extends JpaRepository<Person,Long> {

    List<Person> findByName(String name);

    Person findAllByNameAndId(String name,Long id);

    Person findPersonByName(String name);
}
