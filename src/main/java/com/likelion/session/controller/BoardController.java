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

@RestController//REST API 컨트롤러
@RequestMapping("/boards")//Spring MVC에서 HTTP 요청을 특정 메서드나 클래스에 매핑
@RequiredArgsConstructor//final 또는 @NonNull 필드를 매개변수로 받는 생성자를 자동으로 생성
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
    @Operation(//API 문서에서 엔드포인트에 대한 설명을 작성할 때 사용
            summary = "게시글 생성",
            description = "새로운 게시글을 생성합니다."
    )
    @PostMapping//Spring MVC에서 HTTP POST 요청을 특정 메서드에 매핑 @RequestMapping의 축약형
    public ResponseEntity<BoardResponse> create(@RequestBody BoardCreateRequest request) {
        BoardResponse response = boardService.create(request);
        return ResponseEntity.ok(response);
    }

    // 게시글 전체 조회
    @Operation(//API 문서에서 엔드포인트에 대한 설명을 작성할 때 사용
            summary = "게시글 전체 조회",
            description = "등록된 모든 게시글을 조회합니다."
    )
    @GetMapping//GET 요청 매핑
    public ResponseEntity<List<BoardResponse>> findAll() {
        List<BoardResponse> response = boardService.findAll();
        return ResponseEntity.ok(response);
    }

    // 게시글 단건 조회
    @Operation(//API 문서에서 엔드포인트에 대한 설명을 작성할 때 사용
            summary = "게시글 단건 조회",
            description = "id로 특정 게시글을 조회합니다."
    )
    @GetMapping("/{id}")//GET 요청 매핑
    public ResponseEntity<BoardResponse> findById(@PathVariable Long id) {//URL 경로의 변수 값을 메서드 파라미터로 추출
        BoardResponse response = boardService.findById(id);
        return ResponseEntity.ok(response);
    }

    // 게시글 수정
    @Operation(//API 문서에서 엔드포인트에 대한 설명을 작성할 때 사용
            summary = "게시글 수정",
            description = "id로 특정 게시글의 제목과 내용을 수정합니다."
    )
    @PutMapping("/{id}")//HTTP PUT 요청을 매핑하며, 리소스를 전체 교체할 때 사용
    public ResponseEntity<BoardResponse> update(@PathVariable Long id,
                                                @RequestBody BoardUpdateRequest request) {
        BoardResponse response = boardService.update(id, request);
        return ResponseEntity.ok(response);
    }

    // 게시글 삭제
    @Operation(//API 문서에서 엔드포인트에 대한 설명을 작성할 때 사용
            summary = "게시글 삭제",
            description = "id로 특정 게시글을 삭제합니다."
    )
    @DeleteMapping("/{id}")//HTTP DELETE 요청을 매핑하며, 리소스를 삭제할 때 사용
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        boardService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
