package com.davidholas.julie.service;

import com.davidholas.julie.dto.PersonDto;
import com.davidholas.julie.persistence.model.Person;

import java.util.List;

public interface PersonService {

    Person getPerson(Long personId);

    List<Person> getPersons();

    void createPerson(PersonDto personDto);

    void deletePerson(Long personId);
}
