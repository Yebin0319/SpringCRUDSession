package com.likelion.session.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter // 모든 필드에 대한 getter 메서드를 자동 생성
@AllArgsConstructor // 모든 필드를 매개변수로 가지는 생성자 생성
@Builder // 빌더 패턴을 사용하여 객체를 생성할 수 있도록 해줌
public class BoardResponse {

    // 돌려주고 싶은 응답: id, title, content, writer, createdAt, updatedAt
    private Long id;
    private String title;
    private String content;
    private String writer;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}