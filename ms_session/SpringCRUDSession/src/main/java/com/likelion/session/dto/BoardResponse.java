package com.likelion.session.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter //필드 값을 읽는 getter 메서드를 자동으로 생성해줌
@AllArgsConstructor //모든 필드를 매개변수로 받는 생성자를 자동으로 만들어줌
@Builder //객체를 빌더 패턴으로 생성할 수 있게 해주는 기능
        //빌더 패턴: 복잡한 객체를 단계적으로 생성하는 디자인 패턴
public class BoardResponse {

    private Long id;
    private String title;
    private String content;
    private String writer;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}