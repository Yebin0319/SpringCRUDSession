package com.likelion.session;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // @SpringBootApplication: 자동 설정을 해주기 위한 어노테이션(@SpringBootConfiguration, @EnableAutoConfiguration, @ComponentScan 포함)
public class SessionApplication {

	public static void main(String[] args) {
		SpringApplication.run(SessionApplication.class, args);
	}

}
