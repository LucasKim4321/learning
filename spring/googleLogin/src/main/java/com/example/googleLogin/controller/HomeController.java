package com.example.googleLogin.controller;

import com.example.googleLogin.dto.SessionUser;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.awt.print.Pageable;

@Controller
@RequiredArgsConstructor
public class HomeController {

//    private final PostService postService;
    private final HttpSession httpSession;

    // 메인 화면 - 게시판 목록
    @GetMapping("/")
    public String postList(Model model) {// 세션에서 사용자 정보 꺼내기
        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        if (user != null) {
            model.addAttribute("userName", user.getName());
        }
        return "index";
    }
    @GetMapping("/mylogin")
    public String login() {
        return "login";
    }
    @GetMapping("/list")
    public String List() {
        return "list";
    }
}