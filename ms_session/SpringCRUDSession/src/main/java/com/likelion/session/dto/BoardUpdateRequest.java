package com.likelion.session.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Getter //필드 값을 읽는 getter 메서드를 자동으로 생성해줌
@Setter //setter 메서드를 자동 생성해줌
@NoArgsConstructor //매개변수가 없는 기본 생성자를 자동으로 만들어 줌
public class BoardUpdateRequest {
    @NotBlank(message = "제목은 필수입니다.")
    @Size(max = 100, message = "제목은 100자 이하로 입력해주세요.")
    private String title;

    @NotBlank(message = "내용은 필수입니다.")
    private String content;
}


