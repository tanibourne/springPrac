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


    @Bean
    public CommandLineRunner demo(FeedRepository feedRepository) {
        return (args) -> {
            //jpa 사용법
            //저장할때 쓰는거 CREATE
//            String name, String address, String job, int age
            feedRepository.save(new Feed("titleTest", "author", "password", "commentTEST"));
            //bean

            // 조회할때 쓰는거 READ 전부 READ
        };

}
}
