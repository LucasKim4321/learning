package com.spring.MyProject.service;

import com.spring.MyProject.dto.MemberDTO;
import com.spring.MyProject.entity.Member;
import com.spring.MyProject.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional // 여러개 한번에 작업시 필요
@RequiredArgsConstructor
@Log4j2
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    // entity -> 이메일 유무체크 -> save
    public Member saveMember(Member member) {

        // 회원 중복 체크(email기준)
        validateDuplicateMember(member);  // 중복체크. 중복 시 예외 발생하면서 프로그램 종료

        // 중복된 이메일이 없을 경우 저장(member값을 db에 반영)
        return memberRepository.save(member);
    }

    // dto -> 이메일 유무체크 -> save
    public Member saveMember2(MemberDTO memberDTO){

        // 1. dto -> entity: Member Entity createMember() 메서드 활용
        //Member member = Member.createMember(memberDTO, passwordEncoder);

        // 2. dto -> entity: MeberService 인터페이스 활용
        Member member = dtoToEntity(memberDTO, passwordEncoder );

        // 회원 중복 체크(email기준) 메서드 호출
        validateDuplicateMember(member);

        // 중복된 이메일 없을 경우 저장(반영)
        return memberRepository.save(member);
    }


    // 1-1. 회원 중복 체크(email기준) 메서드
    // entity -> 이메일 유무 체크
    private void validateDuplicateMember(Member member) {
        // Member Entity Email 기존에 Entity에 있는 유무 체크
        Member findMember = memberRepository.findByEmail(member.getEmail());
        // 중복 체크 후 예외 발생. 예외 발생시 프로그램 강제 중지
        if(findMember!=null) throw new IllegalStateException("이미 가입된 회원이다옹~");
    }
}
