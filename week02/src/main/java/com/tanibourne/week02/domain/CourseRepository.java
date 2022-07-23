//SQL의 기능을 하는곳

package com.tanibourne.week02.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
    //Course 클래스(테이블)을 쓸거고 id는 long이다.


}