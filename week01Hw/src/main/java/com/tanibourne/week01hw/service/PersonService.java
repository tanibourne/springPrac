package com.tanibourne.week01hw.service;

import com.tanibourne.week01hw.domain.Person;
import com.tanibourne.week01hw.dto.PersonRequestDto;
import com.tanibourne.week01hw.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service

public class PersonService {

    //service에서 중요한거 한가지 메소드의 결과가 반드시 반영되어야한다.
    //
    private final PersonRepository personRepository;

    @Transactional
    public Long update(Long id, PersonRequestDto requestDto) {

       Person person = personRepository.findById(id).orElseThrow(
               () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
       );


       person.update(requestDto);
       return id;
    }


//                ()-> new IllegalArgumentException("아이디가 존재하지 않습니다.")
//        );
}
