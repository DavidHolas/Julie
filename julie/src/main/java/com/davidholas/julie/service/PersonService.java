package com.davidholas.julie.service;

import com.davidholas.julie.persistence.model.Person;
import com.davidholas.julie_api.models.PersonDto;

import java.util.List;

public interface PersonService {

    Person getPerson(Long personId);

    List<Person> getPersons();

    Person createPerson(Person person);

    void deletePerson(Long personId);
}
