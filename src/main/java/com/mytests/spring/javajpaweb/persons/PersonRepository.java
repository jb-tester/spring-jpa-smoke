package com.mytests.spring.javajpaweb.persons;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface PersonRepository extends CrudRepository<Person, Integer> {

    @Override
    long count();
    @Override List<Person> findAll();
    List<PersonFullNames> findAllBy();
    List<PersonNameOnly> findPeopleBy();
    List<Person> personByName(String name);
    @Query("select e from #{#entityName} e where e.name not like :name")
    List<Person> someQustomQuery(String name);
    Person findFirstByNameAndSurnameOrIdAfter(String name, String surname, Integer idAfter);
}
