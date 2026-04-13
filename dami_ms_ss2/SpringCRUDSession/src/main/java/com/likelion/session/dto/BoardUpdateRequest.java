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
    @NotBlank(message = "제목은 필수입니다.") //문자열이 null이 아니고 공백이 아닌 값이어야 함을 검증하는 어노테이션
    @Size(max = 100, message = "제목은 100자 이하로 입력해주세요.") //문자열이나 컬렉션의 길이(크기)를 제한하는 검증 어노테이션
    private String title;

    @NotBlank(message = "내용은 필수입니다.")
    private String content;
}

