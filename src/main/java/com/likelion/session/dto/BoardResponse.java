package com.likelion.session.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter // @Getter: 접근자(getter 메서드 자동 생성)
@AllArgsConstructor // @AllArgsConstructor: 모든 변수 값을 파라미터로 받는 생성자를 생성
@Builder // @Builder: 생성자 인자를 메서드 체인을 통해 명시적으로 대입하여 생성자를 호출할 수 있게 클래스 생성
public class BoardResponse {

    // 돌려주고 싶은 응답: id, title, content, writer, createdAt, updatedAt
    private Long id;
    private String title;
    private String content;
    private String writer;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}