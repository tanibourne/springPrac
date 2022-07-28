package com.example.week02_hw_2t.service;

import com.example.week02_hw_2t.domain.Person;
import com.example.week02_hw_2t.domain.PersonRepository;
import com.example.week02_hw_2t.dto.PersonRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PersonService {

    private  final PersonRepository personRepository;

    @Transactional
    public Long updatePersonService(Long id, PersonRequestDto personRequestDto){

        Person person = personRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 아이디가 존재하지 않다.")
        );

        person.update(personRequestDto);


        return id;
    }

}
