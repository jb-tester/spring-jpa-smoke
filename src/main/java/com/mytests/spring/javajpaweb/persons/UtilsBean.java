package com.mytests.spring.javajpaweb.persons;


public class UtilsBean {
    public String getGreeting() {
        return greeting;
    }

    private final String greeting;

    public UtilsBean(String s) {
        this.greeting = s;
    }
}
