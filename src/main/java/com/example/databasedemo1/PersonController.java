package com.example.databasedemo1;

import com.example.databasedemo1.dtos.PersonDto;
import com.example.databasedemo1.entities.Person;
import com.example.databasedemo1.mappers.PersonMapper;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PersonController {

    private final PersonsRepository personsRepository;
    private final ModelMapper mapper;

    public PersonController(PersonsRepository personsRepository,ModelMapper mapper) {
        this.personsRepository = personsRepository;
        this.mapper = mapper;
    }

    @GetMapping("/persons")
    List<Person> getAllPersons(){
         return personsRepository.findAll();
    }

    @GetMapping("/persons/{id}")
    Optional<Person> getOnePerson(@PathVariable("id") Long id){
        return personsRepository.findById(id);
    }

    @GetMapping("/search")
    Person findAPerson(String name){
       return personsRepository.findPersonByName(name);
    }

    @PostMapping("/persons")
    Person saveAPerson(@RequestBody PersonDto personDto){
        return PersonMapper.entityToDto(personsRepository.save(mapper.map(personDto,Person.class)));
    }
}
