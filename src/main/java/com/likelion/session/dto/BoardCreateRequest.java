package com.likelion.session.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter//Getter 메서드 자동 생성
@Setter // 모든 필드에 대한 setter 메서드를 자동 생성
@NoArgsConstructor // 파라미터가 없는 기본 생성자 생성
@AllArgsConstructor // 모든 필드를 매개변수로 가지는 생성자 생성
public class BoardCreateRequest {
    private String title;
    private String content;
    private String writer;
}