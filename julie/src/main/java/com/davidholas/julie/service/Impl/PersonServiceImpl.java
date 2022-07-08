package com.davidholas.julie.service.Impl;

import com.davidholas.julie.persistence.model.Person;
import com.davidholas.julie.persistence.repository.PersonRepository;
import com.davidholas.julie.service.PersonService;
import com.davidholas.julie.web.mapping.PersonMapper;
import com.davidholas.julie_api.models.PersonDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    private PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> getPersons() {
        return personRepository.findAll();
    }

    @Override
    public Person getPerson(Long personId) {
        return personRepository.getById(personId);
    }

    @Override
    public Person createPerson(Person person) {
        return personRepository.save(person);
    }

    @Override
    public void deletePerson(Long personId) {
        personRepository.deleteById(personId);
    }
}
