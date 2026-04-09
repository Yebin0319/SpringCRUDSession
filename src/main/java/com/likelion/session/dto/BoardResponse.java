package com.likelion.session.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter // 모든 필드의 getter 메서드를 자동 생성
@AllArgsConstructor // 모든 필드를 포함한 생성자 생성
@Builder // 객체를 builder 패턴으로 생성할 수 있게 해줌 (가독성 좋은 객체 생성)
public class BoardResponse {

    // 돌려주고 싶은 응답: id, title, content, writer, createdAt, updatedAt
    private Long id;
    private String title;
    private String content;
    private String writer;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
