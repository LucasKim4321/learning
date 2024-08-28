package com.spring.MyProject.controller;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

// 테스트용 애플리케이션 컨텍스트 생성
@SpringBootTest
@Log4j2
@AutoConfigureMockMvc  // 테스트용
//@ExtendWith(MockitoExtension.class)
//@TestPropertySource(locations="classpath:application-test.properties")  // 환경설정파일 따로 지정
class ReplyControllerTest {

    @Test
    void register() {
    }

    @Test
    void getList() {
    }

    @Test
    void modify() {
    }

    @Test
    void remove() {
    }

    @Test
    void getReplyDTO() {
    }
}