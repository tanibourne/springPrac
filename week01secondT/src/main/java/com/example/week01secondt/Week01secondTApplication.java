package com.example.week01secondt;

import com.example.week01secondt.domain.Course;
import com.example.week01secondt.domain.CourseRepository;
import com.example.week01secondt.service.CourseService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.ArrayList;
import java.util.List;

@EnableJpaAuditing
@SpringBootApplication
public class Week01secondTApplication {

    public static void main(String[] args) {
        SpringApplication.run(Week01secondTApplication.class, args);
    }

    // Week02Application.java 의 main 함수 아래에 붙여주세요.
    @Bean
    public CommandLineRunner demo(CourseRepository courserepository) {
        return (args) -> {
            //jpa 사용법
            //저장할때 쓰는거 CREATE
            courserepository.save(new Course("frontendClasss","Lim"));

            // 조회할때 쓰는거 READ 전부 READ
        };
    }
}
