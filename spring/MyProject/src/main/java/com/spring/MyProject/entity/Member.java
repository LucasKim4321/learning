package com.spring.MyProject.entity;

import com.spring.MyProject.constant.Role;
import com.spring.MyProject.dto.MemberDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.crypto.password.PasswordEncoder;

@Entity
@Table(name="member")  // 생략시 클래스명과 동일
@Getter@Setter@ToString
public class Member {

    @Id
    @Column(name="member_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @Column(unique = true)  //  중복 허용 x
    private String email;
    private String password;
    private String address;
    @Enumerated(EnumType.STRING)  // enum 사용시
    private Role role;

    // Member Entity 생성자
    // 1.방법 : createMember():  dto -> entity
    public static Member createMember(MemberDTO memberDTO,
                                      PasswordEncoder passwordEncoder) {  // PasswordEncoder 페스워드 인코더 처리가능한 객체
        Member member = new Member();

        member.setName(memberDTO.getName());
        member.setEmail(memberDTO.getEmail());
        member.setAddress((memberDTO.getAddress()));

        // 비밀번호 -> 암호화 작업
        String password = passwordEncoder.encode(memberDTO.getPassword());
        member.setPassword(password);
        member.setRole(Role.USER);

        return member;
    }
}
