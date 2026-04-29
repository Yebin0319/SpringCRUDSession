package com.likelion.session.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor //모든 필드를 파라미터로 받는 생성자를 자동 생성
@Builder
public class BoardResponse {

    // 돌려주고 싶은 응답: id, title, content, writer, createdAt, updatedAt
    private Long id;
    private String title;
    private String content;
    private String writer;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}