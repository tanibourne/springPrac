package com.example.week02_hw_2t;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Week02Hw2TApplication {

    public static void main(String[] args) {
        SpringApplication.run(Week02Hw2TApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo() {
        return (args) -> {
            //jpa 사용법
            //저장할때 쓰는거 CREATE
//            String name, String address, String job, int age


            // 조회할때 쓰는거 READ 전부 READ
        };

    }
}
