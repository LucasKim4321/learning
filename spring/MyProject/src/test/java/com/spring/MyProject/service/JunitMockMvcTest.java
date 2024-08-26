package com.spring.MyProject.service;

import com.spring.MyProject.entity.Member;
import com.spring.MyProject.repository.MemberRepository;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

// 테스트용 애플리케이션 컨텍스트 생성
@SpringBootTest
@Log4j2
@TestPropertySource(locations="classpath:application-test.properties")  // 환경설정파일 따로 지정
public class JunitMockMvcTest {

    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private MemberRepository memberRepository;

    // 각각의 테스트 케이스 실행 전에 수행되는 메서드
    @BeforeEach
    public void mockMvcSetup() {
        this.mockMvc =
                MockMvcBuilders
                        .webAppContextSetup(context).build();
    }

    // TestCase1 : getMembers()
    @DisplayName("getAllMembers: 회원 조회 테스트")
    @Test
    public void getMembers() throws Exception {
        // given
        final String url = "/test/member";
        Member savedMember = memberRepository.save(
                Member.builder()
                        .email("test@test.com")
                        .name("나무")
                        .address("풀숲")
                        .password("1234")
                        .build()
        );
//        // when
//        final ResultActions result =
//                mockMvc.perform(get(url)).accept();
//        // then

    }

    // 각각의 테스트 케이스 종료 전에 수행되는 메서드
    @AfterEach
    public void cleanUp() {
        memberRepository.deleteAll();
        
    }

}
