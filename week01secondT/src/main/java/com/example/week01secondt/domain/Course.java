package com.example.week01secondt.domain;


import com.example.week01secondt.CourseRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@NoArgsConstructor
@Entity
@Getter
public class Course extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String tutor;


    public Course(String title, String tutor){
        this.title = title;
        this.tutor = tutor;
    }

    public Course(CourseRequestDto requestDto){
        this.title = requestDto.getTitle();
        this.tutor = requestDto.getTutor();
    }

    public void update(CourseRequestDto courseDto){
        this.title = courseDto.getTitle();
        this.tutor = courseDto.getTutor();
    }

}
