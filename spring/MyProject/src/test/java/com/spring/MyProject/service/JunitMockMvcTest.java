package com.spring.MyProject.service;


import com.google.gson.Gson;
import com.spring.MyProject.dto.MemberDTO;
import com.spring.MyProject.entity.Member;
import com.spring.MyProject.repository.MemberRepository;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

// 테스트용 애플리케이션 컨텍스트 생성
@SpringBootTest
@Log4j2
@AutoConfigureMockMvc // 테스트용 MVC환경에서 요청 및 전송,응답 기능을 제공, 컨트롤러 테스트 할 때 사용
//@ExtendWith(MockitoExtension.class)
@TestPropertySource(locations="classpath:application-test.properties")  // 환경설정파일 따로 지정
public class JunitMockMvcTest {

    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private MemberService memberService;

    @Autowired
    private Gson gson;

    // 각각의 테스트 케이스 실행 전에 수행되는 메서드
    @BeforeEach
    public void mockMvcSetup() {
        this.mockMvc =
                MockMvcBuilders
                        .webAppContextSetup(context).build();
        log.info("======");
    }

    // TestCase1 : getMembers()
    @DisplayName("getAllMembers: 회원 조회 테스트")
    @Test
    public void myGetMember() throws Exception {
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

    } // end test


    @DisplayName("getMember: json전송-json수신->json전송")
    @Test
    public void getMember() throws Exception{
        // given
        final String url = "/test/test";
        MemberDTO memberDTO = MemberDTO.builder()
                .email("test@gmail.com").name("홍길동").address("부산시").password("1234")
                .build();

        String content = gson.toJson(memberDTO);
        log.info("\n=> gson:"+content);


        /*
        perform(MockMvcRequestBuilders
                        .post(url설정) : 요청을 전송하는 역할
                        .accept() : 요청을 보낼 데이터 타입 => JSON, XML 등 타입
                        .andExpect() : 응답을 검증 => OK(200)코드 반환(응답) => isOK통행 확인
                        .jsonPath("$.필드(속성)이름) : JSON응답값의 값을 가져오는 역할
                           ex) memberDTO 객체 형식 JSON객체 응답 => $.속성
                               List<MemberDTO> memberList => JSON객체 응답 => $[인덱스번호].속성
                               Board 객체네에 다른 객체를 포함 => $.상위객체.하위객체.속성
                        );
        */
        // @ModelAttribute: 다양한 소스의 데이터를 모델 특성으로 바인딩하는 데 사용
        // @RequestBody: HTTP request body를 메소드에 매핑하는데 사용(json,xml형식)
        // when
        final ResultActions result =
                mockMvc.perform(MockMvcRequestBuilders
                                .post(url)
                                .accept(MediaType.APPLICATION_JSON) // 요청을 보낼 데이터 타입
                                .contentType(MediaType.APPLICATION_JSON) // 응답할 데이터 타입
                                .content(content))  // 데이터
                        .andDo(print());

        // json응답 값을 가져올 속성(필드)
        result.andExpect(status().isCreated())
              .andExpect(jsonPath("$.email").value(memberDTO.getEmail()))
              .andExpect(jsonPath("$.name").value(memberDTO.getName()));

    } // end test


    @DisplayName("getAllMember List구조 : json전송-json수신->json전송")
    @Test
    public void getMembers() throws Exception{
        // given
        final String url = "/test/test2";

        List<MemberDTO> list = new ArrayList<>();

        IntStream.rangeClosed(1,5).forEach( i-> {
            MemberDTO memberDTO = MemberDTO.builder()
                    .email("test@gmail.com").name("홍길동").address("부산시").password("1234")
                    .build();

            list.add(memberDTO);
        });

        String content = gson.toJson(list);
        log.info("\n=> gson:"+content);

        // @ModelAttribute: 다양한 소스의 데이터를 모델 특성으로 바인딩하는 데 사용
        // @RequestBody: HTTP request body를 메소드에 매핑하는데 사용(json,xml형식)
        // when
        final ResultActions result =
                mockMvc.perform(MockMvcRequestBuilders
                                .post(url)
                                .accept(MediaType.APPLICATION_JSON) // 요청을 보낼 데이터 타입
                                .contentType(MediaType.APPLICATION_JSON) // 응답할 데이터 타입
                                .content(content))
                        .andDo(print());

        // json응답 값을 가져올 속성(필드)
//    result.andExpect(status().isCreated())
//          .andExpect(jsonPath("$.email").value(memberDTO.getEmail()))
//          .andExpect(jsonPath("$.name").value(memberDTO.getName()));

        result.andExpect(status().isCreated())
                .andExpect(jsonPath("$[0].email").value(list.get(0).getEmail()))
                .andExpect(jsonPath("$[0].name").value(list.get(0).getName()));

    } // end test



    @DisplayName("getParams : parameter data전송-json수신->json전송")
    @Test
    public void getParmas() throws Exception{
        // given
        final String url = "/test/test3";

        String email ="test@gmail.com";
        String password = "testpw";
        String name = "testName";
        String address = "testAddress";

        //Controller에서 파라미터를 ModelAttribute 사용시, 즉 DTO로 받고 있기 때문에 Map으로 묶어서 전송
        MultiValueMap<String, String> query_param = new LinkedMultiValueMap<>();
        query_param.add("email",email);
        query_param.add("password",password);
        query_param.add("address", address);
        query_param.add("name", name);


//        String content = gson.toJson(list);
//        log.info("\n=> gson:"+content);

        // @ModelAttribute: 다양한 소스의 데이터를 모델 특성으로 바인딩하는 데 사용
        // @RequestBody: HTTP request body를 메소드에 매핑하는데 사용(json,xml형식)
        // when
        final ResultActions result =
                mockMvc.perform(MockMvcRequestBuilders
                                .post(url)
                                .accept(MediaType.APPLICATION_JSON) // 요청을 보낼 데이터 타입
                                .contentType(MediaType.APPLICATION_JSON) // 응답할 데이터 타입
                                .params(query_param)) // query string parammeter
                        .andDo(print());

        // json응답 값을 가져올 속성(필드)
        result.andExpect(status().isCreated())
                .andExpect(jsonPath("$.email").value(email))
                .andExpect(jsonPath("$.password").value(password))
                .andExpect(jsonPath("$.name").value(name))
                .andExpect(jsonPath("$.address").value(address));

    } // end test

    @DisplayName("setMember: 회원 가입 테스트")
    @Test
    public void setMember() throws Exception{
        // given
        final String url = "/members/new";

        String email ="test@gmail.com";
        String password = "testpw";
        String name = "testName";
        String address = "testAddress";
        //Controller에서 파라미터를 ModelAttribute 사용시, 즉 DTO로 받고 있기 때문에 Map으로 묶어서 전송
        MultiValueMap<String, String> query_param = new LinkedMultiValueMap<>();
        query_param.add("email",email);
        query_param.add("password",password);
        query_param.add("address", address);
        query_param.add("name", name);


        // @ModelAttribute: 다양한 소스의 데이터를 모델 특성으로 바인딩하는 데 사용
        // @RequestBody: HTTP request body를 메소드에 매핑하는데 사용(json, xml형식)
        // when
        final ResultActions result =
                mockMvc.perform(MockMvcRequestBuilders
                        .post(url)
                        .params(query_param)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON_VALUE) );

//    String location = result.andReturn().getResponse().getHeader("Location");

        // 리다이렉트가 되면 302오류가 발생한다.
        // .andExpect(status().isOK()) => .andExpect(redirectedUrl("/")) 형식으로 전환
        result
                .andDo(print())
                .andExpect(redirectedUrl("/"));
//         response data가 있을 경우 처리`
//        .andExpect(jsonPath("$.email").value(query_param.get("email")))
//        .andExpect(jsonPath("$.name").value(query_param.get("name")));


    } // end test


    @BeforeEach
    public void beforeCleanUp() {
        memberRepository.deleteAll();
    }

    // 각각의 테스트 케이스 종료 전에 수행되는 메서드
    @AfterEach
    public void cleanUp() {
        memberRepository.deleteAll();
        
    }

}
