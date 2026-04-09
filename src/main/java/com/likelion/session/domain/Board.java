package com.likelion.session.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

@Getter // getter 메서드 자동 생성
@Entity // 해당 클래스 DB 테이블로 인식하고 관리
@Table(name = "boards") //DB에 생성될 테이블 이름 지정
@NoArgsConstructor(access = AccessLevel.PROTECTED) //파라미터가 없는 기본 생성자 만드는데, 보안상 외부 패키지에서 Board()못하게 막아줌
@AllArgsConstructor //모든 필드를 다 넣어서 객체를 만드는 생성자 자동 생성
public class Board {

    @Id //이 필드가 테이블의 PK임을 나타냄
    @GeneratedValue(strategy = GenerationType.IDENTITY) //ID값을 DB가 알아서 순서대로 넣어주도록 설정
    private Long id;

    // 게시글 제목
    @Column(nullable = false, length = 100) //변수를 DB 칼럼과 연결
    private String title;

    // 게시글 내용
    @Column(nullable = false, columnDefinition = "TEXT") //변수를 DB 칼럼과 연결
    private String content;

    // 작성자
    @Column(nullable = false, length = 30) //변수를 DB 칼럼과 연결
    private String writer;

    // 생성 시간
    @Column(nullable = false) //변수를 DB 칼럼과 연결
    private LocalDateTime createdAt;

    // 수정 시간
    @Column(nullable = false) //변수를 DB 칼럼과 연결
    private LocalDateTime updatedAt;


    public Board(String title, String content, String writer) {
        this.title = title;
        this.content = content;
        this.writer = writer;
    }

    @PrePersist //데이터를DB에 처음 저장하기 전에 이 메서드 실행
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate //데이터 Update 전에 이 메서드 실행 수정될때마다 updateAt만 최신 시간으로 갱신
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }


    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}