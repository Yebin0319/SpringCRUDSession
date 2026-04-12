package com.likelion.session.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter //모든 필드의 get 메서드 자동 생성
@Setter //모든 필드의 set 메서드 자동 생성
@NoArgsConstructor //기본 생성자 자동 생성
@AllArgsConstructor //모든 필드를 매개변수로 받는 생성자 자동 생성
public class BoardCreateRequest {
    // 넘겨주고 싶은 정보: 제목(title), 내용(content), 작성자(writer)
    private String title;
    private String content;
    private String writer;
}