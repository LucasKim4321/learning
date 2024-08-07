package com.spring.MyProject.controller;

import com.spring.MyProject.dto.MemberDTO;
import com.spring.MyProject.entity.Member;
import com.spring.MyProject.service.MemberService;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@Log4j2
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;
    private final PasswordEncoder passwordEncoder;

    // 회원 등록 : GET POST
    @GetMapping(value="/new")
    public String memberRegisterform(Model model) {

        // 데이터가 없는 memberDTO to 생성: form에 입력한 데이터와 1:1 맵핑
        model.addAttribute("memberDTO", new MemberDTO());

        // 포워딩 : 뷰리졸브
        return "members/memberForm";
    }

    // 회원 등록 : GET POST
    @PostMapping(value="/new")
    public String memberRegister(@Valid @ModelAttribute MemberDTO memberDTO,
                                 BindingResult bindingResult,
                                 Model model) {

        log.info("==> memberDTO: "+memberDTO);

        if (bindingResult.hasErrors()) {  // 유효성 검사 결과 1개 이상 에러가 있으면 처리
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
            model.addAttribute("errorMessage",e.getMessage());
            return "members/memberForm";  // 입력폼으로 포워딩
        }

        return "redirect:/board/list";
    }


}
