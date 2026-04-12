package com.likelion.session.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

@Getter // getter 메서드 자동 생성
@Entity // 해당 클래스 DB 테이블로 인식하고 관리
@Table(name = "boards")//JPA(Java Persistence API) 에서 엔티티 클래스와 데이터베이스 테이블을 매핑할 때 사용
@NoArgsConstructor(access = AccessLevel.PROTECTED)//기본 생성자(파라미터 없는 생성자)를 자동 생성
@AllArgsConstructor//모든 필드를 매개변수로 받는 생성자를 자동 생성
public class Board {

    @Id//JPA에서 엔티티의 기본 키(Primary Key) 를 지정하는 어노테이션
    @GeneratedValue(strategy = GenerationType.IDENTITY)//JPA에서 기본 키(PK) 값을 자동으로 생성하는 전략을 지정
    private Long id;

    // 게시글 제목
    @Column(nullable = false, length = 100)//JPA에서 엔티티 필드와 DB 컬럼을 매핑하고 세부 속성을 설정
    private String title;

    // 게시글 내용
    @Column(nullable = false, columnDefinition = "TEXT")//JPA에서 엔티티 필드와 DB 컬럼을 매핑하고 세부 속성을 설정
    private String content;

    // 작성자
    @Column(nullable = false, length = 30)//JPA에서 엔티티 필드와 DB 컬럼을 매핑하고 세부 속성을 설정
    private String writer;

    // 생성 시간
    @Column(nullable = false)//JPA에서 엔티티 필드와 DB 컬럼을 매핑하고 세부 속성을 설정
    private LocalDateTime createdAt;

    // 수정 시간
    @Column(nullable = false)//JPA에서 엔티티 필드와 DB 컬럼을 매핑하고 세부 속성을 설정
    private LocalDateTime updatedAt;


    public Board(String title, String content, String writer) {
        this.title = title;
        this.content = content;
        this.writer = writer;
    }

    @PrePersist //JPA에서 엔티티가 최초로 저장(INSERT)되기 직전에 자동으로 실행되는 메서드를 지정
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate //엔티티가 수정(UPDATE)되기 직전에 자동으로 실행되는 메서드를 지정
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }


    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}