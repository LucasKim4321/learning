package com.spring.MyProject;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest  // 테스트용 애플리케이션 컨텍스트 생성
@Log4j2
@TestPropertySource(locations="classpath:application-test.properties")  // 환경설정파일 따로 지정
public class JunitCycleTest {

    @Test@DisplayName("TestCase1")
    public void TestCase1() { log.info("==> TestCase1"); }

    @Test@DisplayName("TestCase2")
    public void TestCase2() { log.info("==> TestCase2"); }

    // 전체 테스트를 시작하기 전에 1회 실행, static 선언
    // 주로 DB를 연결하거나, 테스트 환경 초기화를 하기 위해 사용
    @BeforeAll  // 반드시 static을 사용해야함
    static void beforeAll() {
        log.info("==> @BeforeAll()호출: 전체 테스트 시작 전 실행 주기에서 한번만 호출");
        
    }

    // 전체 테스트를 종료하기 전에 1회 실행, static 선언
    // 주로 DB연결 종료, 공통으로 사용하는 자원 해제 하기 위해 사용
    @AfterAll  // 반드시 static을 사용해야함
    static void afterAll() {
        log.info("==> @AfterAll()호출: 전체 테스트 종료 전 실행 주기에서 한번만 호출");
        
    }

    // 테스트 케이스 시작 전 매번 실행
    // 객체를 초기화 하거나 텍스트에 필요한 값을 미리 설정 할 경우
    @BeforeEach
    public void beforeEach() {
        log.info("==> @BeforeEach(): 테스트 케이스 시작 전 매번 실행");

    }

    // 테스트 케이스 종료 전 매번 실행
    // 특정 데이터 삭제 용도
    @AfterEach
    public void afterEach() {
        log.info("==> @afterEach(): 테스트 케이스 종료 전 매번 실행");

    }


}
