package com.example.week02_hw_2t.dto;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class PersonRequestDto {

    private String name;
    private String address;
    private String job;
    private int age;

}
