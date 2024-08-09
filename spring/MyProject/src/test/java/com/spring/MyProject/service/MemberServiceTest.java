package com.spring.MyProject.service;

import com.spring.MyProject.constant.Role;
import com.spring.MyProject.dto.MemberDTO;
import com.spring.MyProject.entity.Member;
import com.spring.MyProject.repository.MemberRepository;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.IntStream;

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
    @Autowired
    MemberRepository memberRepository;

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

        // Set<Role> 사용전  (사용자 정의 User객체 만들기 전)
//        assertEquals(member.getRole(), savedMember.getRole());
//        assertEquals(member.getRole(), "1234");  // 에러 유도

        // Set<Role> 사용후
        assertEquals(member.getRoleSet(), savedMember.getRoleSet());

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
                .role(Role.USER)  // 변경후 추가 변경전엔 없어도 됨
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

    // 사용자 정의 User 객체(AuthMemberDTO) 생성해서 사용
    @Test
    @DisplayName("Member Entity 생성 테스트")
    public void createMember3() {
        // 클라이언트로부터 전달받은
        // 더미 data MemberDTO 생성
        IntStream.rangeClosed(1, 10).forEach(i -> {
            Member member = Member.builder()
                    .email("test"+i+"@email.com")
                    .name("홍길동"+i)
                    .address("부산시 진구")
                    .password(passwordEncoder.encode("1234"))
                    .build();

            if (i < 6) {
                member.addRole(Role.USER);
            } else {
                member.addRole(Role.ADMIN);
            }

            log.info("==> member.getRoleSet: "+member.getRoleSet());

            // Member savedMember = memberRepository.save(member);

        });

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
        assertEquals(member.getName(),     savedMember.getName());
        assertEquals(member.getAddress(),   savedMember.getAddress());
        // 거의 동일한 로직이 적용 됬음에도 비밀번호 비교시 에러.
        // 패스워드 인코더가 같은 숫자라도 그때 그때 다르게 인코딩하는듯.
//        assertEquals(member.getPassword(),  savedMember.getPassword());  // 인코딩 후 값을 놓고 비교해서 에러 걸림
        assertEquals(member.getPassword(),  savedMember.getPassword());

        // Set<Role> 사용전  (사용자 정의 User객체 만들기 전)
//        assertEquals(member.getRole(),      savedMember.getRole());
        // Set<Role> 사용후
        assertEquals(member.getRoleSet(),      savedMember.getRoleSet());
//

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
                IllegalStateException.class, () ->{  memberService.saveMember2(memberDTO2); }
        );

        // 예외 발생 메시지 동일 여부 확인
//        assertEquals("이미 가입된 회원 입니다.",      e.getMessage());  // 틀린값으로 비교
        assertEquals("이미 가입된 회원이다옹~",      e.getMessage());  // 맞는값으로 비교
        log.info("=> e.getMessage():"+e.getMessage());
    }
}
