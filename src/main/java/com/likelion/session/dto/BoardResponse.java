package com.likelion.session.dto;

import lombok.AllArgsConstructor;//모든 필드를 매개변수로 받는 생성자 자동 생성
import lombok.Builder;//빌더 패턴으로 객체 생성 가능하게 해주는 Lombok 어노테이션
import lombok.Getter;//모든 필드의 get 메서드 자동 생성

import java.time.LocalDateTime;

@Getter//모든 필드의 get 메서드 자동 생성
@AllArgsConstructor//모든 필드를 매개변수로 받는 생성자 자동 생성
@Builder//빌더 패턴으로 객체 생성 가능하게 해주는 Lombok 어노테이션
public class BoardResponse {

    // 돌려주고 싶은 응답: id, title, content, writer, createdAt, updatedAt
    private Long id;
    private String title;
    private String content;
    private String writer;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}