package com.example.week02_hw_2t.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter

@NoArgsConstructor
public class PersonRequestDto {
    private String name;
    private String job;
    private int age;
}
