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
    @NotBlank(message = "제목은 필수입니다.") //값이 비어있거나 공백이면 제목은 필수입니다.라는 메시지로 검증 실패를 발생시키는 어노테이션
    @Size(max = 100, message = "제목은 100자 이하로 입력해주세요.") //값의 길이를 100자 이하로 제한하고 초과 시 해당 메시지로 검증 실패를 발생시키는 어노테이션
    private String title;

    @NotBlank(message = "내용은 필수입니다.") //값이 비어있거나 공백이면 내용은 필수입니다.라는 메시지로 검증 실패를 발생시키는 어노테이션
    private String content;
}


