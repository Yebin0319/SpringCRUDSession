package com.likelion.session.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

@Getter // @Getter: 접근자(getter 메서드 자동 생성)
@Entity // @Entity: 객체 매핑(해당 클래스 DB 테이블로 인식하고 관리)
@Table(name = "boards") // @Table: 엔티티와 매핑할 테이블을 지정("boards"로 설정)
@NoArgsConstructor(access = AccessLevel.PROTECTED) // @NoArgsConstructor: 파라미터가 없는 디폴트 생성자 생성(접근 권한: protected)
@AllArgsConstructor // @AllArgsConstructor: 모든 변수 값을 파라미터로 받는 생성자를 생성
public class Board {

    @Id // @Id: 데이터베이스 테이블의 기본 키 매핑
    @GeneratedValue(strategy = GenerationType.IDENTITY) // @GeneratedValue: 기본 키를 애플리케이션에 직접 할당
    private Long id;

    // 게시글 제목
    @Column(nullable = false, length = 100) // @Column: 객체 필드(변수)를 테이블(데이터베이스)의 컬럼(열)에 매핑
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

    @PrePersist // @PrePersist: 객체가 저장되기 전에 필요한 초기화 작업을 수행
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate // @PreUpdate: 객체의 상태가 업데이트 되기 전에 실행되는 메소드(함수)
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }


    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}