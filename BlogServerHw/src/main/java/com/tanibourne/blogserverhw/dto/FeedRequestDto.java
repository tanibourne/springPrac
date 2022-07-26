package com.tanibourne.blogserverhw.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Getter
@Setter
@RequiredArgsConstructor
public class FeedRequestDto{
    // 제목 ,작성자명 , 비밀번호,작성내용 입력하나
    private String title;

    private String author;

    private String password;

    private String comment;


}


