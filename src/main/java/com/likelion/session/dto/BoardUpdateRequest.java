package com.likelion.session.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Getter // @Getter: 접근자(getter 메서드 자동 생성)
@Setter // @Setter: 설정자(setter 메서드 자동 생성)
@NoArgsConstructor // @NoArgsConstructor: 파라미터가 없는 디폴트 생성자 생성(접근 권한: protected)
public class BoardUpdateRequest {
    @NotBlank(message = "제목은 필수입니다.") // @NotBlank: null과 초기화된 String, 공백 모두 허용 X
    @Size(max = 100, message = "제목은 100자 이하로 입력해주세요.") // @Size: 필드 크기가 min과 max 사이여야 값을 저장할 수 있도록 유효성 검사
    private String title;

    @NotBlank(message = "내용은 필수입니다.") // @NotBlank: null과 초기화된 String, 공백 모두 허용 X
    private String content;
}

