package com.likelion.session.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

@Getter // 모든 필드에 대한 getter 메서드를 자동 생성
@Entity // JPA에서 해당 클래스를 DB 테이블로 매핑
@Table(name = "boards") // DB에서 사용할 테이블 이름을 boards로 지정
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 기본 생성자를 protected로 생성
@AllArgsConstructor // 모든 필드를 포함한 생성자 자동 생성
public class Board {

    @Id // 해당 필드를 기본 키(PK)로 설정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // DB의 auto increment 전략 사용
    private Long id ;

    // 게시글 제목
    @Column(nullable = false, length = 100) // null 불가 + 최대 길이 100 제한
    private String title;

    // 게시글 내용
    @Column(nullable = false, columnDefinition = "TEXT") // null 불가 + TEXT 타입으로 저장
    private String content;

    // 작성자
    @Column(nullable = false, length = 30) // null 불가 + 최대 길이 30 제한
    private String writer;

    // 생성 시간
    @Column(nullable = false) // null 불가
    private LocalDateTime createdAt;

    // 수정 시간
    @Column(nullable = false) // null 불가
    private LocalDateTime updatedAt;


    public Board(String title, String content, String writer) {
        this.title = title;
        this.content = content;
        this.writer = writer;
    }

    @PrePersist // 엔티티가 처음 DB에 저장되기 직전에 실행되는 메서드
    public void prePersist() {
        this.createdAt = LocalDateTime.now(); // 생성 시간 자동 설정
        this.updatedAt = LocalDateTime.now(); // 수정 시간도 함께 초기화
    }

    @PreUpdate // 엔티티가 수정되기 직전에 실행되는 메서드
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now(); // 수정 시간 자동 갱신
    }


    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}