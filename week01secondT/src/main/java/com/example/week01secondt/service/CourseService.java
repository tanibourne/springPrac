package com.example.week01secondt.service;

import com.example.week01secondt.CourseRequestDto;
import com.example.week01secondt.domain.Course;
import com.example.week01secondt.domain.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;




    @Transactional
    public Long update(Long id, CourseRequestDto courseNewDto){
        Course courseOld = courseRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 아이디가 없어서 update 불가")
        );
        courseOld.update(courseNewDto);

        //

        return courseOld.getId();
    }


}
