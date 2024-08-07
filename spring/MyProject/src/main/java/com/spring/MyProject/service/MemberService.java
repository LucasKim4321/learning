package com.spring.MyProject.service;

import com.spring.MyProject.entity.Member;
import com.spring.MyProject.entity.Reply;
import com.spring.MyProject.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional // 여러개 한번에 작업시 필요
@RequiredArgsConstructor
public interface MemberService {

//    private final MemberRepository memberRepository = new MemberRepository; // 수작업 할 시
    private final MemberRepository memberRepository;  // 생략시 알아서 해줌

    public Member saveMember(Member member) {
        // 회원 중복 체크(email기준)
        validateDuplicateMember(member);  // 중복체크. 중복 시 예외 발생하면서 프로그램 종료
        return memberRepository.save(member);  // 중복된 이메일이 없을 경우 저장(member값을 db에 반영)
    }

    private void validateDuplicateMember(Member member) {
        // Member Entity Email 기존에 Entity에 있는 유무 체크
        Member findMember = memberRepository.findByEmail(member.getEmail());

        // 중복 체크 후 예외 발생
        // 예외 발생시 프로그램 강제 중지
        if(findMember!=null) throw new IllegalStateException("이미 가입된 회원 입니다.");
    }
//    Reply reply = Reply.builder()
//            .rno(replyDTO.getRno())
//            .replyText(replyDTO.getReplyText())
//            .replyer(replyDTO.getReplyer())
//            .board(board)
//            .build();
}
