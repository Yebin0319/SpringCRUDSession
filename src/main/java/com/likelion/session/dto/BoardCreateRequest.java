package com.likelion.session.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter//객체의 값을 바꾸는 메서드
@NoArgsConstructor
@AllArgsConstructor
public class BoardCreateRequest {
    private String title;
    private String content;
    private String writer;
}