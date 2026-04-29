package com.likelion.session.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

@Getter // getter 메서드 자동 생성
@Entity // 해당 클래스 DB 테이블로 인식하고 관리
@Table(name = "boards") //실제 DB에 생성될 테이블 이름 지정
@NoArgsConstructor(access = AccessLevel.PROTECTED) //파라미터 없는 기본 생성자를 만들어줌
@AllArgsConstructor //모든 필드를 파라미터로 받는 생성자를 자동 생성
public class Board {

    @Id //이 필드가 테이블의 기본키(Primary Key)임을 나타냄
    @GeneratedValue(strategy = GenerationType.IDENTITY) //id 값을 DB가 자동으로 1, 2, 3 순서대로 증가시켜 직접 1, 2, 3을 입력할 필요 없음
    private Long id;

    // 게시글 제목
    @Column(nullable = false, length = 100)
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

    @PrePersist //createdAt(생성 시간)을 현재 시간으로 자동으로 채워줌
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }

    @PreUpdate //updatedAt(수정 시간)을 갱신.
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }


    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}