package com.spring.MyProject.service;

import com.spring.MyProject.dto.MemberDTO;
import com.spring.MyProject.entity.Member;
import lombok.extern.log4j.Log4j2;
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
//@TestPropertySource(locations="classpath:application-test.properties")  // 환경설정파일 따로 지정
@Log4j2
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

        // --------------------------//
        // dto -> 암호화 작업 -> entity
        // --------------------------//

        // 1. dto -> entity : Member클래스 createMember 메서드 활용
        // return Member.createMember(memberDTO,passwordEncoder);

        // 2. dto -> entity : 인터페이스에서 정의한 메서드 활용
        return memberService.dtoToEntity(memberDTO, passwordEncoder);

    }

    @Test
    @DisplayName("회원 가입 서비스 테스트")
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

    // 회원 정보 DTO, Entity생성하기
    public MemberDTO createMember2(){
        // 클라이언트로부터 전달받은
        // 더미 data MemberDTO 생성
        MemberDTO memberDTO = MemberDTO.builder()
                .email("test@email.com")
                .name("홍길동")
                .address("부산시 진구")
                .password("1234")
                .build();

        //----------------------------------//
        // dto -> 암호화 작업 -> entity
        //----------------------------------//

        // 1. dto->entity : Member클래스 createMember메서드 활용
        //return Member.createMember(memberDTO, passwordEncoder);

        // 2. dto->entity :인터페이스에서 정의한 메서드 활용
        //return memberService.dtoToEntity(memberDTO, passwordEncoder);
        return memberDTO;
    }

    @Test
    @DisplayName("회원 가입 서비스 테스트")
    public void saveDuplicateMemberTest2(){

        // 회원1
        MemberDTO memberDTO = createMember2();

        // 1. dto -> entity: Member Entity createMember() 메서드 활용
        //Member member = Member.createMember(memberDTO, passwordEncoder);

        // 2. dto -> entity: MeberService 인터페이스 활용
        // save전 entity
        Member member = memberService.dtoToEntity(memberDTO, passwordEncoder );
        // save후 entity
        Member savedMember = memberService.saveMember2(memberDTO);

        // 회원 등록 테스트 결과 체크: assertEquals(기대값, 실제값)
        assertEquals(member.getEmail(),     savedMember.getEmail());
        assertEquals(member.getEmail(),     savedMember.getEmail());
        assertEquals(member.getAddress(),   savedMember.getAddress());
        assertEquals(member.getPassword(),  savedMember.getPassword());
        assertEquals(member.getRole(),      savedMember.getRole());

    }

    @Test
    @DisplayName("중복 회원 가입 테스트")
    public void saveMemberTest2(){

        // 회원1
        MemberDTO memberDTO1 = createMember2();
        memberService.saveMember2(memberDTO1 );

        // 회원2
        MemberDTO memberDTO2 = createMember2();

        // assertThrows(예외 발생 타입, 실제 예외발생) 메서드: 예외 처리 테스트 메서드
        // 중복된 이메일 회원등록시 예외발생시 객체 생성
        Throwable e = assertThrows(
                // 예외 발생 타입, 실제 예외발생
                IllegalStateException.class, () ->{  memberService.saveMember2(memberDTO2);; }
        );

        // 예외 발생 메시지 동일 여부 확인
        assertEquals("이미 가입된 회원 입니다.",      e.getMessage());
        log.info("=> e.getMessage():"+e.getMessage());
    }
}
