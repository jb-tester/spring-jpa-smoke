package com.mytests.spring.javajpaweb.teams;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * *
 * <p>Created by Irina on 6/17/2024.</p>
 * <p>Project: spring-jpa-smoke</p>
 * *
 */
@RestController
@RequestMapping("/team")
public class TeamController {

    private final TeamRepository teamRepository;

    public TeamController(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @GetMapping("/test1")
    public List<String> test1() {

        return teamRepository.customQueryWithSpEL(1);
    }

    @GetMapping("/test2")
    public List<ConcreteEntity> test2() {
        return teamRepository.findByTitles("team1");
    }

    @GetMapping("/test3")
    public List<ConcreteEntity> test3() {
        return teamRepository.customNativeQueryAnnotation(8);
    }
}
