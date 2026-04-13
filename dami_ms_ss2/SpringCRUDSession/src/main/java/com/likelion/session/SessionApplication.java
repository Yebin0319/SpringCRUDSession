package com.likelion.session;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //Spring Boot 애플리케이션의 시작점이며 설정·컴포넌트 스캔을 한 번에 처리하는 핵심 어노테이션
public class SessionApplication {

	public static void main(String[] args) {
		SpringApplication.run(SessionApplication.class, args);
	}

}
