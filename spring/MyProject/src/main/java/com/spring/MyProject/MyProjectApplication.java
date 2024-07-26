package com.spring.MyProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class MyProjectApplication {

	public static void main(String[] args) {

		SpringApplication.run(MyProjectApplication.class, args);
	}

}

/* 
 * JPA와 DB 설치(MariaDB, Oracle)
 * DB Test => Entity설계(DB설계), Repository설계(DB동작 저장 수정 삭제 조회), DB드라이브 설정
 * 
 * 
 */