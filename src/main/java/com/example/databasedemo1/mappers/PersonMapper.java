package com.example.databasedemo1.mappers;

import com.example.databasedemo1.dtos.PersonDto;
import com.example.databasedemo1.entities.Person;

public class PersonMapper {

    public static Person dtoToEntity(PersonDto personDto){
       return new Person(personDto.id, personDto.name);
    }

    public static Person entityToDto(Person person){
        return new Person(person.getId(),person.getName());
    }


}
