package com.likelion.session.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// @Getter와 @Setter가 둘 다 붙어 있음.
@Getter
@Setter
// Request DTO는 클라이언트가 보낸 JSON 값을 객체에 넣어주는 과정에서 @Setter가 필요함.
// @Setter: setTitle(), setContent() 같은 메서드 자동 생성
@NoArgsConstructor // 파라미터가 없는 기본 생성자 자동 생성
@AllArgsConstructor // 모든 필드를 파라미터로 받는 생성자 자동 생성
public class BoardCreateRequest {
    // 넘겨주고 싶은 정보: 제목(title), 내용(content), 작성자(writer)
    private String title;
    private String content;
    private String writer;
}