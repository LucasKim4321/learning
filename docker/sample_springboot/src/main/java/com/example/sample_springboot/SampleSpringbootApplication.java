package com.example.sample_springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SampleSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SampleSpringbootApplication.class, args);
	}

}

//가상화 실무 실습
//
//1. Docker 이미지 생성하고, 컨테이너 실행, dockerhub 등록하시오
//1-1. sample springboot project작성(30)
//1-2. docker image : springboot-sample1(30)
//1-3. docker conatiner: springboot-app(30)
//1-4. dockerhub등록 및 run(10)
//ex) docker image list
//C:\Users\601>docker image ls
//REPOSITORY                    TAG      IMAGE ID      CREATED        SIZE
//~~
//simple-springboot-app1      latest    6ee961b41ab9  18 hours ago    346MB
//~~~
//ex) docker image로 생성된 container 실행중
//C:\Users\601>docker ps
//CONTAINER ID  IMAGE                    COMMAND                  CREATED        STATUS        PORTS                    NAMES
//f51781be1150  simple-springboot-app1  "java -jar -Dspring.…"  17 hours ago  Up 9 seconds  0.0.0.0:8077->8080/tcp  springboot_api_test

//---------------------------
//스프링 프로젝트 springboot_docker 생성
//
//프로젝트 내에 dockerfile 생성
//
//gradle -> build -> bootjar 실행
//
//docker build -t springboot-sample1 .
//
//docker run --name springboot-sample1_test -d -p 8082:8080 springboot-sample1
//
//웹페이지에 http://localhost:8082/api/v1/test/hello 입력하면 됨.
//		---------------------------
//
//도커 허브 리파짓토리 haribolu/testproject
//
//simplespringboot-app1를 태그한 haribolu/testproject 이미지 생성 simplespringboot-app1랑 같음
//docker tag springboot-sample1  haribolu/sample_springboot
//docker push haribolu/sample_springboot
//docker pull haribolu/sample_springboot
//
// docker run --name springboot-app -d -p 8088:8080 haribolu/sample_springboot:latest
