package com.likelion.session.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

@Getter // Getter 메서드 자동 생성
@Entity // JPA 엔티티 선언 (DB 테이블과 매핑)
@Table(name = "boards") // DB 테이블 이름 지정
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 기본 생성자 생성 (외부에서 new 방지)
@AllArgsConstructor // 전체 필드 생성자 생성
public class Board {

    @Id // 기본키(PK) 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // PK 자동 증가 (DB auto increment)
    private Long id;

    // 게시글 제목
    @Column(nullable = false, length = 100)
    // nullable=false : NOT NULL
    // length=100 : VARCHAR(100)
    private String title;

    // 게시글 내용
    @Column(nullable = false, columnDefinition = "TEXT")
    // columnDefinition="TEXT" : TEXT 타입으로 생성
    private String content;

    // 작성자
    @Column(nullable = false, length = 30)
    // NOT NULL + VARCHAR(30)
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

    @PrePersist
    // Entity 저장 전에 실행 (insert 전에 자동 실행)
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    // Entity 수정 전에 실행 (update 전에 자동 실행)
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }


    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}