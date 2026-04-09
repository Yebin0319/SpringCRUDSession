package com.likelion.session.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter //클래스 안의 변수를 위부에서 꺼낼 수 있게 메서드 자동 생성
@AllArgsConstructor //모든 변수를 파라미터로 받는 생성자 자동 생성
@Builder //빌더 패턴을 사용할 수 있게함 내가 넣고싶은 데이터만 골라 만들 수 있음
public class BoardResponse {

    // 돌려주고 싶은 응답: id, title, content, writer, createdAt, updatedAt
    private Long id;
    private String title;
    private String content;
    private String writer;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}