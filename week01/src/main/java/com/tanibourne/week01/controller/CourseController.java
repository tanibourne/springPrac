package com.tanibourne.week01.controller;


import com.tanibourne.week01.Tutor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {
    @GetMapping("/tutors")
    public Tutor getTutors(){
        Tutor tutor = new Tutor();

        tutor.setName("정윤혁");
        tutor.setBio("NObio");

        return tutor;

    }
}
