package com.example.week02_hw_2t.service;

import com.example.week02_hw_2t.domain.Person;
import com.example.week02_hw_2t.domain.PersonRepository;
import com.example.week02_hw_2t.dto.PersonRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PersonService {

    private final PersonRepository personRepository;

    @Transactional
    public Long updatePerson(Long id, PersonRequestDto requestDto){
        Person personOld = personRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당아이디가 없습니다.")
        );

        personOld.update(requestDto);

        return personOld.getId();
    }




}
