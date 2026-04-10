package com.likelion.session.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
public class BoardUpdateRequest {
    @NotBlank(message = "제목은 필수입니다.")//값 반드시 있어햐함(공백도 금지)
    @Size(max = 100, message = "제목은 100자 이하로 입력해주세요.")//문자 길이 제한
    private String title;

    @NotBlank(message = "내용은 필수입니다.")
    private String content;
}

