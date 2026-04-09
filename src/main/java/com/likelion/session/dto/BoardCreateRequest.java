package com.likelion.session.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter //클래스 안의 변수 값을 외부에서 꺼내올 수 있게 메서드 자동 생성
@Setter //클래스 내부의 변수값을 변경할 수 있는 메서드 자동 생성
@NoArgsConstructor //파라미터가 하나도 없는 빈 생성자 만들어줌
@AllArgsConstructor //모든 변수를 파라미터로 받는 생성자 자동 생성
public class BoardCreateRequest {
    // 넘겨주고 싶은 정보: 제목(title), 내용(content), 작성자(writer)
    private String title;
    private String content;
    private String writer;
}