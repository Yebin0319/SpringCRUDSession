package com.likelion.session.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Getter //클래스 안의 변수들의 값을 외부에서 꺼내올 수 있게 메서드 자동 생성
@Setter //클래스 내부의 변수값을 변경할 수 있는 메서드 자동 생성
@NoArgsConstructor //파라미터가 하나도 없는 빈 생성자 생성
public class BoardUpdateRequest {
    @NotBlank(message = "제목은 필수입니다.") //공백만 있거나 비어있는 경우 막아줌
    @Size(max = 100, message = "제목은 100자 이하로 입력해주세요.") //글자수 제한
    private String title;

    @NotBlank(message = "내용은 필수입니다.") //공백만 있거나 비어있는 경우 막아줌
    private String content;
}

