package com.likelion.session.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

@Getter //필드 값을 읽는 getter 메서드를 자동으로 생성해줌
@Entity //자바 객체를 DB 테이블로 매핑하는 표시
@Table(name = "boards") //이 엔티티가 어떤 DB 테이블 이름과 매핑되는지 지정하는 역할. 이 클래스는 DB의 "boards" 테이블과 연결된다.
@NoArgsConstructor(access = AccessLevel.PROTECTED) //외부에서는 못 쓰고, 내부/상속/JPA만 쓸 수 있는 기본 생성자 생성
@AllArgsConstructor //모든 필드를 한 번에 초기화하는 생성자 생성
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }


    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}