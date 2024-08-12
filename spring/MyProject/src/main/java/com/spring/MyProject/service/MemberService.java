package com.spring.MyProject.service;

import com.spring.MyProject.constant.Role;
import com.spring.MyProject.dto.MemberDTO;
import com.spring.MyProject.entity.Member;
import org.springframework.security.crypto.password.PasswordEncoder;

public interface MemberService {

    public Member saveMember(Member member);
    public Member saveMember2(MemberDTO memberDTO);

    // 1. 방법 : dtoToEntity : MemberDTO -> 암호화 -> Entity
    default Member dtoToEntity(MemberDTO memberDTO, PasswordEncoder passwordEncoder){
        Member member = new Member();

        member.setName(memberDTO.getName());
        member.setEmail(memberDTO.getEmail());
        member.setAddress(memberDTO.getAddress());

        // 비밀번호 -> 암화화 작업
        String password = passwordEncoder.encode(memberDTO.getPassword());
        member.setPassword(password);

        // 1. 권한 설정이 1개 일 경우
        // 가입된 회원 권한 설정
        // Set<Role> 사용 전  (사용자 정의 User객체 만들기 전)
//        member.setRole(Role.USER);
        //member.setRole(Role.ADMIN);
//        member.setRole("ROLE_ADMIN");

        // 2. 권한설정이 여러개 일 경우
        // Set<Role> 사용 후  (사용자 정의 User객체 만들기 전)
        member.addRole(Role.USER);

        return member;
    }
}
//
////    private final MemberRepository memberRepository = new MemberRepository; // 수작업 할 시
//    private final MemberRepository memberRepository;  // 생략시 알아서 해줌
//
//    public Member saveMember(Member member) {
//        // 회원 중복 체크(email기준)
//        validateDuplicateMember(member);  // 중복체크. 중복 시 예외 발생하면서 프로그램 종료
//        return memberRepository.save(member);  // 중복된 이메일이 없을 경우 저장(member값을 db에 반영)
//    }
//
//    private void validateDuplicateMember(Member member) {
//        // Member Entity Email 기존에 Entity에 있는 유무 체크
//        Member findMember = memberRepository.findByEmail(member.getEmail());
//
//        // 중복 체크 후 예외 발생
//        // 예외 발생시 프로그램 강제 중지
//        if(findMember!=null) throw new IllegalStateException("이미 가입된 회원 입니다.");
//    });
//}
