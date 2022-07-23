package com.tanibourne.week02.dto;
// Course 클래스의 데이터를 물고 다니는 역할을 한다.
//

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
public class CourseRequestDto {

    private final String title;
    private final String tutor;
}
