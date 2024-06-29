package com.mytests.spring.javajpaweb.persons;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("my.props")
public class MyConfigProps {
    String greeting;

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }
}
