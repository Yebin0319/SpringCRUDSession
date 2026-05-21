package com.likelion.session.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter // 데이터 조회를 위한 getter 메서드 자동 생성
@AllArgsConstructor // 모든 필드(id, title 등)를 포함한 생성자 자동 생성
@Builder // Service에서 .builder().id(xxx).title(xxx)...build() 식으로 필드를 선택적으로 세팅할 수 있음.
public class BoardResponse {

    // BoardResponse에는 @Setter 없이 @Builder만 있음
    // 돌려주고 싶은 응답: id, title, content, writer, createdAt, updatedAt
    private Long id;
    private String title;
    private String content;
    private String writer;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}