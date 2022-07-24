package com.example.week02_hw_2t;

import com.example.week02_hw_2t.domain.Person;
import com.example.week02_hw_2t.domain.PersonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Week02Hw2TApplication {

    public static void main(String[] args) {
        SpringApplication.run(Week02Hw2TApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(PersonRepository persoRepository) {
        return (args) -> {
            //jpa 사용법
            //저장할때 쓰는거 CREATE
//            String name, String address, String job, int age
            persoRepository.save(new Person("윤봉", "부천", "우리집기둥", 5));

            // 조회할때 쓰는거 READ 전부 READ
        };

    }
}
