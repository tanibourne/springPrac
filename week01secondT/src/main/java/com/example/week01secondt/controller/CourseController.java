package com.example.week01secondt.controller;


import com.example.week01secondt.CourseRequestDto;
import com.example.week01secondt.domain.Course;
import com.example.week01secondt.domain.CourseRepository;
import com.example.week01secondt.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.LifecycleState;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CourseController {

    private final CourseRepository courseRepository;
    private final CourseService courseService;

    @GetMapping("/api/courses")
    public List<Course> getCourse(){
        return courseRepository.findAll();
    }

    @PostMapping("/api/courses")
    public Course createCourse(@RequestBody CourseRequestDto requestDto){
        Course course = new Course(requestDto);

        return courseRepository.save(course);

    }

    @PutMapping("/api/courses/{id}")
    public Long updateCourse(@PathVariable Long id,@RequestBody CourseRequestDto requestDto){
        return courseService.update(id,requestDto);
    }

    @DeleteMapping("/api/courses/{id}")
    public Long deleteCourse(@PathVariable Long id){
        courseRepository.deleteById(id);
        return id;
    }




}
