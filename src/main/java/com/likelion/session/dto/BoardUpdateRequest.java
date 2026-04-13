package com.likelion.session.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Getter // 데이터 조회를 위한 getter 메서드 자동 생성
@Setter // @Setter: setTitle(), setContent() 같은 메서드 자동 생성
@NoArgsConstructor // 파라미터가 없는 기본 생성자 자동 생성
public class BoardUpdateRequest {
    @NotBlank(message = "제목은 필수입니다.") // null, "", " " 모두 허용하지 않음
    @Size(max = 100, message = "제목은 100자 이하로 입력해주세요.") // 문자열 길이를 제한함
    private String title;

    @NotBlank(message = "내용은 필수입니다.") // null, "", " " 모두 허용하지 않음
    private String content;
}

