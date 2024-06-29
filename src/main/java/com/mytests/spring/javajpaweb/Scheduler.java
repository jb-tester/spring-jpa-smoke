package com.mytests.spring.javajpaweb;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class Scheduler {

    @Scheduled(cron = "0 0 8-18 * * *")
    public void method1() {

        System.out.println("!!!!!!!!!!!!!!!!!");
        System.out.println("!!!!!!!!!!!!!!!!!");
        System.out.println("!!!!!!!!!!!!!!!!!");
        System.out.println("!!!!!!!!!!!!!!!!!");
    }

    
}
