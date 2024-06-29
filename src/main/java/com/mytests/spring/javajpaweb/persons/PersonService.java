package com.mytests.spring.javajpaweb.persons;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {
    private final PersonRepository personRepository;
    private final UtilsBean utilsBean;

    public PersonService(PersonRepository personRepository, UtilsBean utilsBean) {
        this.personRepository = personRepository;
        this.utilsBean = utilsBean;
    }

    public List<String> getAllPersonNames(){
        List<String> names = new ArrayList<>();
        names.add(utilsBean.getGreeting());
        for (PersonFullNames personFullNames : personRepository.findAllBy()) {
            names.add(personFullNames.getFullName());
        }
        return names;
    }

    public List<String> testEntityNameSpEL() {
        List<String> entries = new ArrayList<>();
        personRepository.someQustomQuery("maria").iterator().forEachRemaining(person -> {entries.add(person.toString());});
        return entries;
    }
}
