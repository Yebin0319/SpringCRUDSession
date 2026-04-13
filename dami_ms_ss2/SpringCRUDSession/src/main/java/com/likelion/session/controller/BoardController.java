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

@RestController //요청 받으면 JSON 같은 데이터만 반환하는 클래스
@RequestMapping("/boards") //Spring Framework에서 “요청 URL 경로를 매핑(연결)하는 설정.
// /boards"로 들어오는 요청을 이 컨트롤러(또는 메서드)가 처리하겠다는 뜻
@RequiredArgsConstructor //필수 필드만 파라미터로 받는 생성자를 자동 생성

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
    @Operation( //이 API가 뭔지 설명해주는 주석
            summary = "게시글 생성",
            description = "새로운 게시글을 생성합니다."
    )
    @PostMapping //POST 요청을 받아서 데이터를 생성/처리하는 API 연결 어노테이션
    public ResponseEntity<BoardResponse> create(@RequestBody BoardCreateRequest request) {
        BoardResponse response = boardService.create(request);
        return ResponseEntity.ok(response);
    }

    // 게시글 전체 조회
    @Operation( //이 API가 뭔지 설명해주는 주석
            summary = "게시글 전체 조회",
            description = "등록된 모든 게시글을 조회합니다."
    )
    @GetMapping //GET 요청을 받아서 데이터를 조회하는 API 연결 어노테이션
    public ResponseEntity<List<BoardResponse>> findAll() {
        List<BoardResponse> response = boardService.findAll();
        return ResponseEntity.ok(response);
    }

    // 게시글 단건 조회
    @Operation( //이 API가 뭔지 설명해주는 주석
            summary = "게시글 단건 조회",
            description = "id로 특정 게시글을 조회합니다."
    )
    @GetMapping("/{id}") //URL 경로에 있는 id 값을 받아 해당 데이터를 조회하는 GET API 매핑
    public ResponseEntity<BoardResponse> findById(@PathVariable Long id) {
        BoardResponse response = boardService.findById(id);
        return ResponseEntity.ok(response);
    }

    // 게시글 수정
    @Operation( //이 API가 뭔지 설명해주는 주석
            summary = "게시글 수정",
            description = "id로 특정 게시글의 제목과 내용을 수정합니다."
    )
    @PutMapping("/{id}") //URL의 id에 해당하는 데이터를 수정하는 PUT API 매핑
    public ResponseEntity<BoardResponse> update(@PathVariable Long id,
                                                @RequestBody BoardUpdateRequest request) {
        BoardResponse response = boardService.update(id, request);
        return ResponseEntity.ok(response);
    }

    // 게시글 삭제
    @Operation( //이 API가 뭔지 설명해주는 주석
            summary = "게시글 삭제",
            description = "id로 특정 게시글을 삭제합니다."
    )
    @DeleteMapping("/{id}") //URL의 id에 해당하는 데이터를 삭제하는 DELETE API 매핑
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        boardService.delete(id);
        return ResponseEntity.noContent().build();
    }
}