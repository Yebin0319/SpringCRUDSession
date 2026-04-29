package com.likelion.session.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter //getter 메서드를 자동 생성
@Setter
@NoArgsConstructor //파라미터 없는 기본 생성자를 만들어줌
@AllArgsConstructor //모든 필드를 파라미터로 받는 생성자를 자동 생성
public class BoardCreateRequest {

    // 넘겨주고 싶은 정보: 제목(title), 내용(content), 작성자(writer)
    private String title;
    private String content;
    private String writer;
}