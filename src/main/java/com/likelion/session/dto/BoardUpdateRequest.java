package com.likelion.session.dto;

import lombok.Getter;//모든 필드의 get 메서드 자동 생성
import lombok.NoArgsConstructor;//기본 생성자 자동 생성
import lombok.Setter;//모든 필드의 set 메서드 자동 생성

import jakarta.validation.constraints.NotBlank;//null, 빈 문자열, 공백 문자열 모두 허용하지 않는 유효성 검사 어노테이션
import jakarta.validation.constraints.Size;//문자열 길이 또는 컬렉션 크기의 범위를 제한

@Getter//모든 필드의 get 메서드 자동 생성
@Setter//모든 필드의 set 메서드 자동 생성
@NoArgsConstructor//기본 생성자 자동 생성
public class BoardUpdateRequest {
    @NotBlank(message = "제목은 필수입니다.")//null, 빈 문자열, 공백 문자열 모두 허용하지 않는 유효성 검사 어노테이션
    @Size(max = 100, message = "제목은 100자 이하로 입력해주세요.")//문자열 길이 또는 컬렉션 크기의 범위를 제한
    private String title;

    @NotBlank(message = "내용은 필수입니다.")//null, 빈 문자열, 공백 문자열 모두 허용하지 않는 유효성 검사 어노테이션
    private String content;
}

