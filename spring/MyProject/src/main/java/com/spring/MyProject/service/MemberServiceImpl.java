package com.spring.MyProject.service;

import com.spring.MyProject.dto.MemberDTO;
import com.spring.MyProject.entity.Member;
import com.spring.MyProject.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional // 여러개 한번에 작업시 필요
@RequiredArgsConstructor  // 여기선 autowired랑 비슷하게 작용
@Log4j2
// UserDetailsService 적용 방법 1-1: 정상작동
//public class MemberServiceImpl implements  MemberService,UserDetailsService {
public class MemberServiceImpl implements  MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

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

        // 회원 중복 체크(email기준) 메서드 호출  // 예외 발생시 종료
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

    /* // UserDetailsService 적용 방법 1-2: 정상 작동
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    log.info("=> loadUserByUsername: "+ username);

    // 더미 User객체 생성하기
    /*
    UserDetails userDetails = User.builder()
        .username("user1@test.com")
        .password(passwordEncoder.encode("1234")) // 패스워드 인코드 필요
        .authorities(Role.USER.toString())
        .build();
    */

   /*
    // Member Entity(DB)에 있는 정보를 기준으로 Authentication 처리
    Member member = memberRepository.findByEmail(username);

    if (member == null){ // 미가입 회원일 경우
      throw new UsernameNotFoundException(username);
    }

    UserDetails userDetails = User.builder()
        .username(member.getEmail())
        .password(member.getPassword())
        .authorities(member.getRole().toString())
        .build();

    return userDetails;

  }
  */
}
