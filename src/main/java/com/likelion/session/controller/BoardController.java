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

/**
 * BoardController
 * 게시글 관련 요청을 처리하는 컨트롤러
 */
@RestController // REST API 요청을 처리하는 컨트롤러로 선언
@RequestMapping("/boards") // 공통 URL 경로 설정
@RequiredArgsConstructor // final 필드를 자동으로 생성자 주입
public class BoardController {

    private final BoardService boardService; // 게시글 비즈니스 로직 처리 서비스

    @Operation( // Swagger에서 API 문서 설명을 위한 어노테이션
            summary = "게시글 생성", // API 한 줄 요약 설명
            description = "새로운 게시글을 생성합니다." // API 상세 설명
    )
    @PostMapping // HTTP POST 요청을 처리하는 매핑
    public ResponseEntity<BoardResponse> create(
            @RequestBody BoardCreateRequest request // 요청 JSON 데이터를 객체로 변환
    ) {
        BoardResponse response = boardService.create(request);
        return ResponseEntity.ok(response);
    }

    @Operation( // Swagger 문서용 설명
            summary = "게시글 전체 조회",
            description = "등록된 모든 게시글을 조회합니다."
    )
    @GetMapping // HTTP GET 요청 처리
    public ResponseEntity<List<BoardResponse>> findAll() {
        List<BoardResponse> response = boardService.findAll();
        return ResponseEntity.ok(response);
    }

    @Operation( // Swagger 문서용 설명
            summary = "게시글 단건 조회",
            description = "id로 특정 게시글을 조회합니다."
    )
    @GetMapping("/{id}") // URL 경로 변수를 포함한 GET 요청 처리
    public ResponseEntity<BoardResponse> findById(
            @PathVariable Long id // URL 경로의 값을 변수로 받음
    ) {
        BoardResponse response = boardService.findById(id);
        return ResponseEntity.ok(response);
    }

    @Operation( // Swagger 문서용 설명
            summary = "게시글 수정",
            description = "id로 특정 게시글의 제목과 내용을 수정합니다."
    )
    @PutMapping("/{id}") // HTTP PUT 요청 처리
    public ResponseEntity<BoardResponse> update(
            @PathVariable Long id, // URL에서 id 값 추출
            @RequestBody BoardUpdateRequest request // 요청 JSON을 객체로 변환
    ) {
        BoardResponse response = boardService.update(id, request);
        return ResponseEntity.ok(response);
    }

    @Operation( // Swagger 문서용 설명
            summary = "게시글 삭제",
            description = "id로 특정 게시글을 삭제합니다."
    )
    @DeleteMapping("/{id}") // HTTP DELETE 요청 처리
    public ResponseEntity<Void> delete(
            @PathVariable Long id // URL에서 id 값 추출
    ) {
        boardService.delete(id);
        return ResponseEntity.noContent().build(); // HTTP 204 No Content 반환
    }
}