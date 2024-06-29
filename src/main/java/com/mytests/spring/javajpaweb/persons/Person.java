package com.mytests.spring.javajpaweb.persons;

import jakarta.persistence.*;

@Entity
@Table(name = "person", schema = "foo")
@NamedQuery(name = "Person.personByName", query = "select p.id, p.surname from Person p where p.name = ?1")
public class Person {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(name = "firstname")
    private String name;
    @Column(name = "lastname")
    private String surname;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Person{" +
               "id=" + id +
               ", name='" + name + '\'' +
               ", surname='" + surname + '\'' +
               '}';
    }
}
