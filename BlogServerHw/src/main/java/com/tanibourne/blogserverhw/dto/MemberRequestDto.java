package com.tanibourne.blogserverhw.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class MemberRequestDto {

    private String nickname;
    private String password;
}
