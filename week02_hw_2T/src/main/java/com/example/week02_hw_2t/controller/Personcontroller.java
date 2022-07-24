package com.example.week02_hw_2t.controller;

import com.example.week02_hw_2t.domain.Person;
import com.example.week02_hw_2t.domain.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class Personcontroller {
    private final PersonRepository personRepository;
    @GetMapping("/api/persons")
    public List<Person> getPerson(){

        return personRepository.findAll();

    }

}
