package com.likelion.session.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter //필드 값을 읽는 getter 메서드를 자동으로 생성해줌
@Setter //setter 메서드를 자동 생성해줌
@NoArgsConstructor //매개변수가 없는 기본 생성자를 자동으로 만들어 줌
@AllArgsConstructor //모든 필드를 매개변수로 받는 생성자를 자동으로 만들어줌
public class BoardCreateRequest {
    private String title;
    private String content;
    private String writer;
}