package com.davidholas.julie.web.controller;

import com.davidholas.julie.service.PersonService;
import com.davidholas.julie_api.api.PersonsApi;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;

@RestController
public class PersonController implements PersonsApi {

    private PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }


}
