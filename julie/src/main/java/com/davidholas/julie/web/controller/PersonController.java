package com.davidholas.julie.web.controller;

import com.davidholas.julie.service.PersonService;
import com.davidholas.julie.web.mapping.PersonMapper;
import com.davidholas.julie_api.api.PersonsApi;
import com.davidholas.julie_api.models.PersonDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.ResponseEntity.noContent;
import static org.springframework.http.ResponseEntity.ok;

@RestController
public class PersonController implements PersonsApi {

    private PersonService personService;
    private PersonMapper personMapper;

    public PersonController(PersonService personService,
                            PersonMapper personMapper) {
        this.personService = personService;
        this.personMapper = personMapper;
    }


    @Override
    public ResponseEntity<PersonDto> createPerson(@Valid PersonDto personDto) {
        return ok(personMapper.mapToDto(personService.createPerson(personMapper.mapToEntity(personDto))));
    }

    @Override
    public ResponseEntity<Void> deletePerson(Long personId) {
        personService.deletePerson(personId);
        return (ResponseEntity<Void>) noContent();
    }

    @Override
    public ResponseEntity<PersonDto> getPerson(Long personId) {
        return ok(personMapper.mapToDto(personService.getPerson(personId)));
    }

    @Override
    public ResponseEntity<List<PersonDto>> getPersons(@Valid Integer offset, @Valid Integer limit) {
        return ok(personMapper.mapToDtoList(personService.getPersons()));
    }
}
