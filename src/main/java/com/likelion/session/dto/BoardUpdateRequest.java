package com.likelion.session.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Getter // 모든 필드의 getter 메서드를 자동 생성
@Setter // 모든 필드의 setter 메서드를 자동 생성
@NoArgsConstructor // 기본 생성자 생성
public class BoardUpdateRequest {
    @NotBlank(message = "제목은 필수입니다.") // null 또는 공백 문자열을 허용하지 않음 (필수값)
    @Size(max = 100, message = "제목은 100자 이하로 입력해주세요.") // 문자열 길이를 100자 이하로 제한
    private String title;

    @NotBlank(message = "내용은 필수입니다.") // null 또는 공백을 허용하지 않음 (필수값)
    private String content;
}

