package com.tanibourne.blogserverhw.dto;

import com.tanibourne.blogserverhw.models.Feed;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter


public class ResponseDto <T> {
    // 제목 ,작성자명 , 비밀번호,작성내용 입력하나
    private boolean success;

    private T  data;

    private String  error;

    public ResponseDto(boolean success, T data, String error){
        this.success = success;
        this.data = data;
        this.error = error;
    }



}
