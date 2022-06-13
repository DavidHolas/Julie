package com.davidholas.julie.service.Impl;

import com.davidholas.julie.dto.PersonDto;
import com.davidholas.julie.persistence.model.Person;
import com.davidholas.julie.persistence.repository.PersonRepository;
import com.davidholas.julie.service.PersonService;
import com.davidholas.julie.web.mapping.PersonMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    private PersonRepository personRepository;
    private PersonMapper personMapper;

    public PersonServiceImpl(PersonRepository personRepository,
                             PersonMapper personMapper) {
        this.personRepository = personRepository;
        this.personMapper = personMapper;
    }

    public List<Person> getPersons() {
        return personRepository.findAll();
    }

    @Override
    public Person getPerson(Long personId) {
        return personRepository.getById(personId);
    }

    @Override
    public void createPerson(PersonDto personDto) {
        personRepository.save(personMapper.mapToEntity(personDto));
    }

    @Override
    public void deletePerson(Long personId) {
        personRepository.deleteById(personId);
    }
}
