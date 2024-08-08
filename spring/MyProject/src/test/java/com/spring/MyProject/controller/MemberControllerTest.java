package com.spring.MyProject.controller;

import com.spring.MyProject.dto.MemberDTO;
import com.spring.MyProject.entity.Member;
import com.spring.MyProject.service.MemberService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers;
import org.springframework.test.annotation.Commit;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

//import static org.springframework.test.web.servlet.result.

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
//@Commit // Test에서 DB반영하고자 할 경우 적용
@AutoConfigureMockMvc
//@TestPropertySource(locations="classpath:application-test.properties")  // 환경설정파일 따로 지정
class MemberControllerTest {

    @Autowired
    private MemberService memberService;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public Member createMember (String email, String password) {
        MemberDTO memberDTO = MemberDTO.builder()
                .email(email).name("복숭아1").address("복숭아나무1").password(password)
                .build();

        Member member = memberService.saveMember2(memberDTO);

        return member;
    }

    @Test@DisplayName("로그인 성공 테스트")
    public void loginSuccessTest() throws Exception {

        String email = "test1000@gmail.com";
        String password = "1234";

        // table에 data 저장
        this.createMember(email, password);

        mockMvc.perform(
                    formLogin()
                    .userParameter("email")  // 이메일을 아이디로 세팅하고 로그인 url요청
                    .loginProcessingUrl("/members/login")
                    .user(email)
                    .password(password)
                )
                .andDo(print()) // 출력
                .andExpect(SecurityMockMvcResultMatchers.authenticated());  // 로그인이 성공하여 인증되었다면 테스트 코드 통과

    }

    @Test
    @DisplayName("로그인 실패 테스트")
    public void loginFailTest() throws Exception {
        String email = "test1000@gmail.com";
        String password = "1234";

        // table에 data 저장
        this.createMember(email, password);

        mockMvc.perform(
                    formLogin()
                    .userParameter("email")  // 이메일을 아이디로 세팅하고 로그인 url요청
                    .loginProcessingUrl("/members/login")
                    .user(email)
                    .password(password)
                )
                .andDo(print()) // 출력
                .andExpect(SecurityMockMvcResultMatchers.authenticated());  // 로그인이 성공하여 인증되었다면 테스트 코드 통과
    }

}