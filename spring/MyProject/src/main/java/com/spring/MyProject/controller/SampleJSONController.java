package com.spring.MyProject.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController  // controller + JSON구조 데이터 반환
@Log4j2
public class SampleJSONController {

    @GetMapping("/helloArr")
    public String[] helloArr() {
        log.info("RestConroller => helloArr => 배열구조 자료 반환(전송)...");

        return new String[] {"홍길동","홍길순","동길이"};

    }

}

