package com.spring.MyProject.service;

import com.spring.MyProject.dto.MemberDTO;
import com.spring.MyProject.entity.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
@TestPropertySource(locations="classpath:application-test.properties")  // 환경설정파일 따로 지정
public class MemberServiceTest {

    @Autowired
    MemberService memberService;
    @Autowired
    PasswordEncoder passwordEncoder;

    // 회원 정보 DTO, Entity 생성하기
    public Member createMember() {
        // 더미 data MemberDTO 생성
        MemberDTO memberDTO = MemberDTO.builder()
                .email("test@email")
                .name("홍길동")
                .address("부산시 진구")
                .password("1234")
                .build();

        // dto -> 암호화 작업 -> entity
        return Member.createMember(memberDTO,passwordEncoder);
    }

    @Test
    @DisplayName("회원 등록 서비스 테스트")
    public void saveMemberTest() {
        // DB 반영하기 전 entity
        Member member = createMember();

        // DB에 저장된 entity
        Member savedMember = memberService.saveMember(member);

        // 회원 등록 테스트 결과 체크: asserEquals(기대값, 실제값);
        assertEquals(member.getEmail(), savedMember.getEmail());
        assertEquals(member.getName(), savedMember.getName());
        assertEquals(member.getAddress(), savedMember.getAddress());
        assertEquals(member.getPassword(), savedMember.getPassword());
        assertEquals(member.getRole(), savedMember.getRole());
//        assertEquals(member.getRole(), "1234");  // 에러 유도
    }

    @Test
    @DisplayName("중복 회원 가입 테스트")
    public void saveDuplicateMemberTest() {

        // 회원1
        Member member1 = createMember();
        memberService.saveMember(member1);

        // 회원2
        Member member2 = createMember();

        Throwable e = assertThrows(IllegalStateException.class, ()-> {
            memberService.saveMember(member2);  // 이메일 유무 체크에 걸려서 에러 발생
        });

        assertEquals("이미 가입된 회원입니다.", e.getMessage());

    }
}
