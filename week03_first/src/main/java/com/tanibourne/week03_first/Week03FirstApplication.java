package com.tanibourne.week03_first;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Week03FirstApplication {

    public static void main(String[] args) {
        SpringApplication.run(Week03FirstApplication.class, args);
    }

}
