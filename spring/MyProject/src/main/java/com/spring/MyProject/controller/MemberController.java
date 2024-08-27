package com.spring.MyProject.controller;

import com.spring.MyProject.dto.MemberDTO;
import com.spring.MyProject.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@Log4j2
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;
    private final PasswordEncoder passwordEncoder;


    // 회원 등록 : GET POST
    @GetMapping(value="/new")
    public String memberRegisterForm(Model model) {

        // 데이터가 없는 memberDTO to 생성: form에 입력한 데이터와 1:1 맵핑
        model.addAttribute("memberDTO", new MemberDTO());

        // 포워딩 : 뷰리졸브
        return "members/memberForm";
    }

    // @ModelAttribute: 다양한 소스의 데이터를 모델 특성으로 바인딩하는 데 사용
    // @RequestBody: HTTP request body를 메소드에 매핑하는데 사용

    // 회원 등록 : GET POST
    @PostMapping(value="/new")
    public String memberRegister(@Valid @ModelAttribute MemberDTO memberDTO,
                                 BindingResult bindingResult,
                                 Model model) {

        log.info("==> memberDTO: "+memberDTO);

        if (bindingResult.hasErrors()) {  // 유효성 검사결과 1개이상 에러가 있으면 처리
            log.info("\n에러다옹!!!\n==> bindingResult.toString: "+bindingResult.toString());

            return "members/memberForm";
        }

        // ** 수정 필요
        // 1. dto -> entity
        // Member member = Member.createMember(memberDTO, passwordEncoder);

        // 2.
        try {
            // dto -> entity -> email 중복 체크 -> save
            memberService.saveMember2(memberDTO);

        } catch (Exception e) {  // 중복된 이메일 등록시 예외 발생되는 Exception 처리
            // validateDuplicateMember(Member member)에서 발생한 에러 메시지를 보내줌
            model.addAttribute("errorMessage",e.getMessage());
            return "members/memberForm";  // 입력폼으로 포워딩
        }

        return "redirect:/board/list";
    }

    //----------------------- //
    // 로그인, 로그아웃 처리
    //----------------------- //

    // 1. 로그인 처리
    @GetMapping(value="/login")
    public String loginMember(String error, String logout) {
        log.info("==> login ");

        // 로그인 페이지로 포워딩
        return "/members/loginForm";
    }

    // 1-1. 로그인 실패시 처리할 url
    @GetMapping("/login/error")
    public String loginError(Model model) {
        log.info("==> loginError");

        model.addAttribute("loginErrorMsg", "아이디 또는 비밀번호를 확인해라옹~");

        return "/members/loginForm";
    }

    // 로그아웃 처리 CustomSecurityConfig에서 설정함




}
