package com.spring.MyProject.repository;

import com.spring.MyProject.dto.MemberDTO;
import com.spring.MyProject.entity.Cart;
import com.spring.MyProject.entity.Member;
import com.spring.MyProject.service.MemberService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional  // 기본설정 Test 후 Rollback 처리됨.  필요시 @Commit
@Log4j2
@TestPropertySource(locations="classpath:application-test.properties")  // 환경설정파일 따로 지정
public class CartRepositoryTest {

    @Autowired
    CartRepository cartRepository;
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    MemberService memberService;
    @Autowired
    PasswordEncoder passwordEncoder;

    @PersistenceContext
    EntityManager em;

    // 회원 등록 메서드
    public Member createMember() {

        // dto 생성
        MemberDTO memberDTO = MemberDTO.builder()
                .email("test@gmail.com")
                .name("바다물고기")
                .address("호주 그레이트 베리어 리프")
                .password("1234")
                .build();

        // dto -> entity
        return memberService.dtoToEntity(memberDTO, passwordEncoder);  //  Member엔티티 리턴

    }
    
    @Test
    @DisplayName("장바구니와 회원 엔티티 멥핑 조회")
    public void findCartAndMemberTest() {

        Member member = createMember();  // member entity를 생성하는 메서드 호출
        memberRepository.save(member);

        Cart cart = new Cart();  // cart 객체 생성
        cart.setMember(member);  // cart에 member를 객체 설정

        cartRepository.save(cart);

        em.flush();  // DB에 반영
        em.clear();  // 영속성 컨텍스트 비우기

        Cart savedCart = cartRepository
                .findById(cart.getId())
                .orElseThrow(EntityNotFoundException::new);

        assertEquals(savedCart.getMember().getId(), member.getId());

    }

}
