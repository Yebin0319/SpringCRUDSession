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

@RestController //JSON 형태로 응답을 내보내는 Controller
@RequestMapping("/boards") //이 Controller의 모든 URL에 /boards를 기본으로 붙여줌
@RequiredArgsConstructor //final이 붙은 필드(boardRepository)를 생성자로 자동 주입해줌
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
    @Operation(
            summary = "게시글 생성",
            description = "새로운 게시글을 생성합니다."
    )
    @PostMapping //데이터 수정
    public ResponseEntity<BoardResponse> create(@RequestBody BoardCreateRequest request) {
        BoardResponse response = boardService.create(request);
        return ResponseEntity.ok(response);
    }

    // 게시글 전체 조회
    @Operation(
            summary = "게시글 전체 조회",
            description = "등록된 모든 게시글을 조회합니다."
    )
    @GetMapping //데이터 조회
    public ResponseEntity<List<BoardResponse>> findAll() {
        List<BoardResponse> response = boardService.findAll();
        return ResponseEntity.ok(response);
    }

    // 게시글 단건 조회
    @Operation(
            summary = "게시글 단건 조회",
            description = "id로 특정 게시글을 조회합니다."
    )
    @GetMapping("/{id}")
    public ResponseEntity<BoardResponse> findById(@PathVariable Long id) {
        BoardResponse response = boardService.findById(id);
        return ResponseEntity.ok(response);
    }

    // 게시글 수정
    @Operation(
            summary = "게시글 수정",
            description = "id로 특정 게시글의 제목과 내용을 수정합니다."
    )
    @PutMapping("/{id}")
    public ResponseEntity<BoardResponse> update(@PathVariable Long id,
                                                @RequestBody BoardUpdateRequest request) {
        BoardResponse response = boardService.update(id, request);
        return ResponseEntity.ok(response);
    }

    // 게시글 삭제
    @Operation(
            summary = "게시글 삭제",
            description = "id로 특정 게시글을 삭제합니다."
    )
    @DeleteMapping("/{id}") //데이터 삭제
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        boardService.delete(id);
        return ResponseEntity.noContent().build();
    }
}