package com.tanibourne.week03_first.Dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class MemoRequestDto {
    private String username;
    private String contents;
}
