package com.mytests.spring.javajpaweb.persons;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/test1")
    public List<String> test1() {
        return personService.getAllPersonNames();
    }

    @GetMapping("/test3")
    public List<String> test2() {
        return personService.testEntityNameSpEL();
    }

}
