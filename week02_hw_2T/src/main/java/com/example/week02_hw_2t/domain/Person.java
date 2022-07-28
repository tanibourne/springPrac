package com.example.week02_hw_2t.domain;


import com.example.week02_hw_2t.dto.PersonRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Person {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private  String job;

    @Column(nullable = false)
    private  int age;


    public Person(PersonRequestDto requestDto){

        this.name = requestDto.getName();
        this.job = requestDto.getJob();
        this.age = requestDto.getAge();
    }

    public void  update(PersonRequestDto requestDto){
        this.name = requestDto.getName();
        this.job = requestDto.getJob();
        this.age = requestDto.getAge();

    }


}
