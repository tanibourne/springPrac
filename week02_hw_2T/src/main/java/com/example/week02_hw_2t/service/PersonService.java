package com.example.week02_hw_2t.service;

import com.example.week02_hw_2t.domain.Person;
import com.example.week02_hw_2t.domain.PersonRepository;
import com.example.week02_hw_2t.dto.PersonRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import javax.transaction.Transactional;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PersonService {

    private  final PersonRepository personRepository;

    @Transactional
    public Long updatePersonService(Long id, PersonRequestDto personRequestDto){
        long start = System.currentTimeMillis();
try {
    Optional<Person> person = personRepository.findById(id);
    person.update(personRequestDto);
    return id;
}
finally {


    long finish = System.currentTimeMillis();
    long timeMs = finish - start;

    System.out.println("updateperson" + timeMs + "ms");


}




    }

}
