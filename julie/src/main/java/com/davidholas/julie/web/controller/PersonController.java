package com.davidholas.julie.web.controller;

import com.davidholas.julie.service.PersonService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    private PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }
}
