package com.example.week02_hw_2t.controller;

import com.example.week02_hw_2t.domain.Person;
import com.example.week02_hw_2t.domain.PersonRepository;
import com.example.week02_hw_2t.dto.PersonRequestDto;
import com.example.week02_hw_2t.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
public class PersonController {
    private final PersonRepository personRepository;
    private final PersonService personService;

    @GetMapping("/api/persons")
    public List<Person> getPerson(){
        return personRepository.findAll();

    }

    @DeleteMapping("/api/persons/{id}")
    public Long deletePerson(@PathVariable Long id){

        personRepository.deleteById(id);

        return id;
    }

    @PostMapping("/api/persons")
    public Person createPerson(@RequestBody PersonRequestDto requestDto){
        Person person = new Person(requestDto);

        return personRepository.save(person);

    }
    @PutMapping("/api/persons/{id}")
    public Long updatePerson(@PathVariable Long id, @RequestBody PersonRequestDto requestDto){
        return personService.updatePersonService(id, requestDto);

    }


}
