package com.tanibourne.blogserverhw;

import com.tanibourne.blogserverhw.models.Feed;
import com.tanibourne.blogserverhw.repository.FeedRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BlogServerHwApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogServerHwApplication.class, args);
    }
}

