package com.likelion.session.service;

import com.likelion.session.domain.Board;
import com.likelion.session.dto.BoardCreateRequest;
import com.likelion.session.dto.BoardResponse;
import com.likelion.session.dto.BoardUpdateRequest;
import com.likelion.session.repository.BoardRepository;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j // @Slf4j: 다양한 로깅 프레임 워크에 대한 추상화(인터페이스) 역할을 하는 라이브러리
@Service // @Service: 비즈니스 로직을 처리하는 클래스를 표시
@RequiredArgsConstructor // @RequiredArgsConstructor: 필수 인자를 가진 생성자를 자동 생성
@Transactional // @Transactional: 특정 메서드 또는 클래스에서 수행되는 ‘트랜잭션’과 관련되어 관리를 위해서 사용(트랜잭션: 데이터베이스 작업이 모두 성공하거나 모두 실패할 때까지 어떤 작업도 부분적으로 적용하지 않고 묶어서 처리)
public class BoardService {

    private final BoardRepository boardRepository;

    /*
        게시글 생성
        - Controller가 넘겨준 요청 DTO를 받아서
        - Entity로 바꾼 뒤
        - Repository를 통해 DB에 저장
        - 저장된 결과를 Response DTO로 변환해서 반환
     */
    public BoardResponse create(BoardCreateRequest request) {
        Board board = new Board(
                request.getTitle(),
                request.getContent(),
                request.getWriter()
        );

        Board savedBoard = boardRepository.save(board);

        return BoardResponse.builder()
                .id(savedBoard.getId())
                .title(savedBoard.getTitle())
                .content(savedBoard.getContent())
                .writer(savedBoard.getWriter())
                .createdAt(savedBoard.getCreatedAt())
                .updatedAt(savedBoard.getUpdatedAt())
                .build();
    }

    /*
        게시글 전체 조회
        - DB에 있는 모든 게시글을 가져옴
        - Entity 리스트를 Response DTO 리스트로 변환
     */
    @Transactional(readOnly = true) // @Transactional: 특정 메서드 또는 클래스에서 수행되는 ‘트랜잭션’과 관련되어 관리를 위해서 사용(읽기 전용)
    public List<BoardResponse> findAll() {
        return boardRepository.findAll()
                .stream()
                .map(board -> BoardResponse.builder()
                        .id(board.getId())
                        .title(board.getTitle())
                        .content(board.getContent())
                        .writer(board.getWriter())
                        .createdAt(board.getCreatedAt())
                        .updatedAt(board.getUpdatedAt())
                        .build())
                .toList();
    }

    /*
        게시글 단건 조회
        - id로 게시글 조회
        - 없으면 예외 발생
     */
    @Transactional(readOnly = true) // @Transactional: 특정 메서드 또는 클래스에서 수행되는 ‘트랜잭션’과 관련되어 관리를 위해서 사용(읽기 전용)
    public BoardResponse findById(Long id) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        return BoardResponse.builder()
                .id(board.getId())
                .title(board.getTitle())
                .content(board.getContent())
                .writer(board.getWriter())
                .createdAt(board.getCreatedAt())
                .updatedAt(board.getUpdatedAt())
                .build();
    }

    /*
        게시글 수정
        - 기존 게시글을 찾음
        - 엔티티의 update 메서드로 값 변경
        - JPA 변경 감지로 update 반영
     */
    public BoardResponse update(Long id, BoardUpdateRequest request) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        board.update(request.getTitle(), request.getContent());

        return BoardResponse.builder()
                .id(board.getId())
                .title(board.getTitle())
                .content(board.getContent())
                .writer(board.getWriter())
                .createdAt(board.getCreatedAt())
                .updatedAt(board.getUpdatedAt())
                .build();
    }

    /*
        게시글 삭제
        - id로 게시글을 찾고
        - 있으면 삭제
     */
    public void delete(Long id) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        boardRepository.delete(board);
    }
}