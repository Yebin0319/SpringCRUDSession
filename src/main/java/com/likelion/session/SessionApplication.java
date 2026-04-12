package com.likelion.session;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication//Spring Boot의 핵심 설정 어노테이션 (안에 Configuration,EnableAutoConfiguration,ComponentScan포함)
public class SessionApplication {

	public static void main(String[] args) {
		SpringApplication.run(SessionApplication.class, args);
	}

}
