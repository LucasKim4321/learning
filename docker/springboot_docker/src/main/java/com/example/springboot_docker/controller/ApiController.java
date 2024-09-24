package com.example.springboot_docker.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // 컨트롤러의 @ResponseBody가 기본값
@RequestMapping("/api/v1/test")
public class ApiController {

    @GetMapping("/hello")
    public ResponseEntity<Object> testApi() {
        String result = "API 통신 성공!!!";
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
