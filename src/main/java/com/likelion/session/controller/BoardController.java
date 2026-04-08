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

@RestController // @RestController: RESTful API를 위한 컨트롤러(HTTP 요청에 대한 응답을 직접 본문에 담아 전달)
@RequestMapping("/boards") // @RequestMapping: 클라이언트의 요청 URL을 컨트롤러의 클래스나 메서드에 매핑(/boards로 시작하는 주소로 매핑)
@RequiredArgsConstructor // @RequiredArgsConstructor: 필수 인자를 가진 생성자를 자동 생성
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
    @Operation( // @Operation: API 엔드포인트의 작업에 대한 설명을 추가하고 세부 정보를 제공
            summary = "게시글 생성",
            description = "새로운 게시글을 생성합니다."
    )
    @PostMapping // @PostMapping: 클라이언트가 POST(데이터 생성) 요청을 보내면 이 코드가 실행
    public ResponseEntity<BoardResponse> create(@RequestBody BoardCreateRequest request) { // @RequestBody: 클라이언트에서 보낸 HTTP 요청 Body를 자바 객체로 변경
        BoardResponse response = boardService.create(request);
        return ResponseEntity.ok(response);
    }

    // 게시글 전체 조회
    @Operation( // @Operation: API 엔드포인트의 작업에 대한 설명을 추가하고 세부 정보를 제공
            summary = "게시글 전체 조회",
            description = "등록된 모든 게시글을 조회합니다."
    )
    @GetMapping // @GetMapping: 클라이언트가 GET(데이터 조회) 요청을 보내면 이 코드가 실행
    public ResponseEntity<List<BoardResponse>> findAll() {
        List<BoardResponse> response = boardService.findAll();
        return ResponseEntity.ok(response);
    }

    // 게시글 단건 조회
    @Operation( // @Operation: API 엔드포인트의 작업에 대한 설명을 추가하고 세부 정보를 제공
            summary = "게시글 단건 조회",
            description = "id로 특정 게시글을 조회합니다."
    )
    @GetMapping("/{id}") // @GetMapping: 클라이언트가 GET(데이터 조회) 요청을 보내면 이 코드가 실행(주소 맨 마지막 / 뒤에 오는 수를 id로 설정)
    public ResponseEntity<BoardResponse> findById(@PathVariable Long id) { // @PathVariable: 리소스 경로에 식별자를 넣어서 동적으로 URL에 정보 담기 가능
        BoardResponse response = boardService.findById(id);
        return ResponseEntity.ok(response);
    }

    // 게시글 수정
    @Operation( // @Operation: API 엔드포인트의 작업에 대한 설명을 추가하고 세부 정보를 제공
            summary = "게시글 수정",
            description = "id로 특정 게시글의 제목과 내용을 수정합니다."
    )
    @PutMapping("/{id}") // @PutMapping: 클라이언트가 PUT(데이터 수정) 요청을 보내면 이 코드가 실행(주소 맨 마지막 / 뒤에 오는 수를 id로 설정)
    public ResponseEntity<BoardResponse> update(@PathVariable Long id, // @PathVariable: 리소스 경로에 식별자를 넣어서 동적으로 URL에 정보 담기 가능
                                                @RequestBody BoardUpdateRequest request) { // @RequestBody: 클라이언트에서 보낸 HTTP 요청 Body를 자바 객체로 변경
        BoardResponse response = boardService.update(id, request);
        return ResponseEntity.ok(response);
    }

    // 게시글 삭제
    @Operation( // @Operation: API 엔드포인트의 작업에 대한 설명을 추가하고 세부 정보를 제공
            summary = "게시글 삭제",
            description = "id로 특정 게시글을 삭제합니다."
    )
    @DeleteMapping("/{id}") // @DeleteMapping: 클라이언트가 DELETE(데이터 삭제) 요청을 보내면 이 코드가 실행(주소 맨 마지막 / 뒤에 오는 수를 id로 설정)
    public ResponseEntity<Void> delete(@PathVariable Long id) { // @PathVariable: 리소스 경로에 식별자를 넣어서 동적으로 URL에 정보 담기 가능
        boardService.delete(id);
        return ResponseEntity.noContent().build();
    }
}