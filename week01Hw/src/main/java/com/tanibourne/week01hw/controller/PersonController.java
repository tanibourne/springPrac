package com.tanibourne.week01hw.controller;

import com.tanibourne.week01hw.domain.Person;
import com.tanibourne.week01hw.dto.PersonRequestDto;
import com.tanibourne.week01hw.repository.PersonRepository;
import com.tanibourne.week01hw.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController // CRUD 구현
public class PersonController {
    public final PersonService personService;
    public final PersonRepository personRepository;

    @PostMapping("/api/persons")
    public Person createPerson(@RequestBody PersonRequestDto requestDto) {
        Person person = new Person(requestDto);

        return personRepository.save(person);

    }

    @GetMapping("/api/persons")
    public List<Person> readPerson(){
        return personRepository.findAll();
    }

    @PutMapping("/api/persons/{id}")
    public Long updatePerson(@PathVariable Long id,@RequestBody PersonRequestDto requestDto){
       //1.id가 있으면 id와 같은 person을 찾는다.
        //2. 찾았다면 그것을 업데이트 시킨다.
        // 이것 자체가 service로 들어가야 한다.
//
      return   personService.update(id, requestDto);

    }

    @DeleteMapping("/api/persons/{id}")
    public  Long deletePerson(@PathVariable Long id){

        personRepository.deleteById(id);

        return id;
    }


}
