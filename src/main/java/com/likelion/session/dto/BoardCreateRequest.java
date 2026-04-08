package com.likelion.session.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter // @Getter: 접근자(getter 메서드 자동 생성)
@Setter // @Setter: 설정자(setter 메서드 자동 생성)
@NoArgsConstructor // @NoArgsConstructor: 파라미터가 없는 디폴트 생성자 생성(접근 권한: protected)
@AllArgsConstructor // @AllArgsConstructor: 모든 변수 값을 파라미터로 받는 생성자를 생성
public class BoardCreateRequest {
    // 넘겨주고 싶은 정보: 제목(title), 내용(content), 작성자(writer)
    private String title;
    private String content;
    private String writer;
}