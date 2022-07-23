package com.tanibourne.week01hw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Week01HwApplication {

    public static void main(String[] args) {
        SpringApplication.run(Week01HwApplication.class, args);
    }

}
