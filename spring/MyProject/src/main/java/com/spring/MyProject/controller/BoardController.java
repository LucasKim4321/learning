package com.spring.MyProject.controller;

import com.spring.MyProject.dto.PageRequestDTO;
import com.spring.MyProject.dto.PageResponseDTO;
import com.spring.MyProject.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
@Log4j2
public class BoardController {

    private final BoardService boardService;
//    <link href="css/bootstrap.min.css" th:href="@{css/bootstrap.min.css}" 여기선 잘됨
    @GetMapping("")
    public String root2() {
        return "index";
    }

//    <link href="css/bootstrap.min.css" th:href="@{css/bootstrap.min.css}" 여기선 안됨
//    <link href="/css/bootstrap.min.css" th:href="@{/css/bootstrap.min.css}" 절대경로로 바꿔줘야함
    @GetMapping("/root")
    public String root() {
        return "index";
    }



    @GetMapping("/list")
    public String list(PageRequestDTO pageRequestDTO, Model model){
        // PageRequestDTO 객체 생성만 했을 경우 기본값 설정

        PageResponseDTO responseDTO = boardService.list(pageRequestDTO);
        log.info("=> "+responseDTO);

        model.addAttribute("responseDTO", responseDTO);
        return "board/list";
    }

}
