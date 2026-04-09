package com.likelion.session.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

@Getter // getter 메서드 자동 생성
@Entity // 해당 클래스 DB 테이블로 인식하고 관리
@Table(name = "boards") // DB 테이블 이름을 boards로 지정
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 기본 생성자를 protected로 생성 (JPA에서 사용)
@AllArgsConstructor // 모든 필드를 포함한 생성자 생성
public class Board {

    @Id // 기본 키(primary key) 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // DB가 자동으로 id 값 생성
    private Long ;

    // 게시글 제목
    @Column(nullable = false, length = 100) // null 불가, 최대 길이 100
    private String ;

    // 게시글 내용
    @Column(nullable = false, columnDefinition = "TEXT") // 긴 문자열(TEXT 타입), null 불가
    private String ;

    // 작성자
    @Column(nullable = false, length = 30) // null 불가, 최대 길이 30
    private String ;

    // 생성 시간
    @Column(nullable = false) // null 불가
    private LocalDateTime ;

    // 수정 시간
    @Column(nullable = false) // null 불가
    private LocalDateTime ;


    public Board(String title, String content, String writer) {
        this.title = title;
        this.content = content;
        this.writer = writer;
    }

    @PrePersist // 엔티티가 DB에 저장되기 전에 실행되는 메서드
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate // 엔티티가 수정되기 전에 실행되는 메서드
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }


    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
