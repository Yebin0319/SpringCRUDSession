package com.likelion.session.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Getter // getter 메서드 자동 생성
@Setter // setter 메서드 자동 생성
@NoArgsConstructor // 기본 생성자 생성 (JSON → 객체 변환 시 필요)
public class BoardUpdateRequest {
    @NotBlank(message = "제목은 필수입니다.")
    // null, "", 공백(" ") 모두 허용 안함
    @Size(max = 100, message = "제목은 100자 이하로 입력해주세요.")
    // 문자열 길이 100자 이하 제한
    private String title;

    @NotBlank(message = "내용은 필수입니다.")
    private String content;
}

