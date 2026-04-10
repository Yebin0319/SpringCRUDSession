package com.likelion.session.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

@Getter // getter 메서드 자동 생성
@Entity // 해당 클래스 DB 테이블로 인식하고 관리
@Table(name = "boards")//테이블 이름 지정
@NoArgsConstructor(access = AccessLevel.PROTECTED)//파라미터 없는 기본 생성자 자동 생성
@AllArgsConstructor//모든 필드를 파라미터로 받는 생성자 생성
public class Board {

    @Id//기본키(데이터 하나를 구분하는 기준)
    @GeneratedValue(strategy = GenerationType.IDENTITY)//ID 자동 생성
    private Long id;

    // 게시글 제목
    @Column(nullable = false, length = 100)//DB 컬럼 제약조건 설정
    private String title;

    // 게시글 내용
    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    // 작성자
    @Column(nullable = false, length = 30)
    private String writer;

    // 생성 시간
    @Column(nullable = false)
    private LocalDateTime createdAt;

    // 수정 시간
    @Column(nullable = false)
    private LocalDateTime updatedAt;


    public Board(String title, String content, String writer) {
        this.title = title;
        this.content = content;
        this.writer = writer;
    }

    @PrePersist//DB 저장 직전에 실행(save()처음할 때)
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate//DB 수정 직전에 실행(update(save 재호출 시))
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }


    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}