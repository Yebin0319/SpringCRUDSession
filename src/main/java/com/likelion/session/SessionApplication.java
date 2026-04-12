package com.likelion.session;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;//스프링 부트 애플리케이션의 시작점(진입점) 을 나타내는 어노테이션

@SpringBootApplication
//스프링 부트 애플리케이션의 시작점(진입점) 을 나타내는 어노테이션(3개가 합쳐진 것)
//@SpringBootConfiguration  설정 클래스로 등록 (@Configuration과 동일)
//+ @EnableAutoConfiguration  스프링 부트 자동 설정 활성화
//+ @ComponentScan            현재 패키지 하위의 빈 자동 스캔
public class SessionApplication {

	public static void main(String[] args) {
		SpringApplication.run(SessionApplication.class, args);
	}

}
