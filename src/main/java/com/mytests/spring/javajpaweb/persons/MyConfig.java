package com.mytests.spring.javajpaweb.persons;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {

    @Value("${my.props.greeting}")
    String greeting= "";

    @Bean
    public UtilsBean utilsBean() {
        return new UtilsBean(greeting);
    }
}
