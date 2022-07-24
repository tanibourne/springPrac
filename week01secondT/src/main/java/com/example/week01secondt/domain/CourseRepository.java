package com.example.week01secondt.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,Long> {
//courseRepository에다가 jpaRepository 기능을 상속
    //SQL 쿼리 날리는 기능
}
