package com.tanibourne.blogserverhw.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tanibourne.blogserverhw.dto.FeedRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
public class Feed extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String author;

    @JsonIgnore
    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String comment;

    public Feed(FeedRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.author = requestDto.getAuthor();
        this.password = requestDto.getPassword();
        this.comment = requestDto.getComment();
    }


    public void update(FeedRequestDto requestDto){
        this.title = requestDto.getTitle();
        this.author = requestDto.getAuthor();
        this.password = requestDto.getPassword();
        this.comment = requestDto.getComment();

    }





    public Feed(String title, String author, String password, String comment) {
        this.title = title;
        this.author = author;
        this.password = password;
        this.comment = comment;
    }//@BEAN
}
