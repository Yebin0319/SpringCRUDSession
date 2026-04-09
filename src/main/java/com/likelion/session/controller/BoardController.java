package com.likelion.session.controller;

import com.likelion.session.dto.BoardCreateRequest;
import com.likelion.session.dto.BoardResponse;
import com.likelion.session.dto.BoardUpdateRequest;
import com.likelion.session.service.BoardService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // 외부 요청을 받아 데이터 반환하는 컨트롤러
@RequestMapping("/boards") // 클라이언트가 boards라는 주소로 접근하면 클래스로 연결해줌
@RequiredArgsConstructor // 객체를 이용할 때 필요한 생성자 자동으로 생성
public class BoardController {

    private final BoardService boardService;

    /*
        게시글 생성

        [요청 흐름]
        Client
        -> DispatcherServlet
        -> HandlerMapping
        -> BoardController의 create() 메서드 선택
        -> Service 호출
        -> Repository 호출
        -> DB 저장
        -> 결과 반환
        -> JSON 응답
     */
    @Operation // 메서드 기능에 대한 설명을 적는 곳
            (
            summary = "게시글 생성",
            description = "새로운 게시글을 생성합니다."
    )
    @PostMapping // 데이터를 새로 create 할 때 사용, 클라이언트가 post 요청하면 실행됨
    public ResponseEntity<BoardResponse> create(@RequestBody BoardCreateRequest request) {
        BoardResponse response = boardService.create(request);
        return ResponseEntity.ok(response); //@RequestBody: 클라이언트가 보내는 데이터를 자바 객체로 변환해서 받아줌
    }

    // 게시글 전체 조회
    @Operation //메서드 기능에 대한 설명을 적는 곳
            (
            summary = "게시글 전체 조회",
            description = "등록된 모든 게시글을 조회합니다."
    )
    @GetMapping //데이터 조회할 때 사용됨
    public ResponseEntity<List<BoardResponse>> findAll() {
        List<BoardResponse> response = boardService.findAll();
        return ResponseEntity.ok(response);
    }

    // 게시글 단건 조회
    @Operation //메서드 기능에 대한 설명을 적는 곳
            (
            summary = "게시글 단건 조회",
            description = "id로 특정 게시글을 조회합니다."
    )
    @GetMapping("/{id}") //데이터 조회할 때 사용됨
    public ResponseEntity<BoardResponse> findById(@PathVariable Long id) {
        BoardResponse response = boardService.findById(id);
        return ResponseEntity.ok(response); // @PathVariable: URL주소에 포함된 변수 값을 읽어옴
    }

    // 게시글 수정
    @Operation //메서드 기능에 대한 설명을 적는 곳
            (
            summary = "게시글 수정",
            description = "id로 특정 게시글의 제목과 내용을 수정합니다."
    )
    @PutMapping("/{id}") // 데이터를 update할 때 사용
    public ResponseEntity<BoardResponse> update(@PathVariable Long id,
                                                @RequestBody BoardUpdateRequest request) {
        BoardResponse response = boardService.update(id, request);
        return ResponseEntity.ok(response); //@RequestBody: 클라이언트가 보내는 데이터를 자바 객체로 변환해서 받아줌
    }

    // 게시글 삭제
    @Operation //메서드 기능에 대한 설명을 적는 곳
            (
            summary = "게시글 삭제",
            description = "id로 특정 게시글을 삭제합니다."
    )
    @DeleteMapping("/{id}") //데이터 delete 할 때 사용
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        boardService.delete(id);
     //@PathVariable: URL주소에 포함된 변수 값을 읽어옴
        return ResponseEntity.noContent().build();
    }
}