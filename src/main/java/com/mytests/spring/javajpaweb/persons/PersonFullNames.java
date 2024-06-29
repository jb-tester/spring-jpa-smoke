package com.mytests.spring.javajpaweb.persons;

import org.springframework.beans.factory.annotation.Value;


public interface PersonFullNames {

    @Value("#{target.name + ' ' + target.surname}")
    String getFullName();
}
