package com.example.week02_hw_2t.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String job;

    @Column(nullable = false)
    private int age;


    public Person(String name, String address, String job, int age) {
        this.name = name;
        this.address = address;
        this.job = job;
        this.age = age;
    }// @Bean 전용
}
