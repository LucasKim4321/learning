package com.spring.MyProject.entity;

import com.spring.MyProject.constant.Role;
import com.spring.MyProject.dto.MemberDTO;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="member")  // 생략시 클래스명과 동일
@Getter@Setter
@ToString(exclude = "roleSet")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Member {

    @Id  // 기본키로 지정
    @Column(name="member_id")  // 테이블 이름(필드명) 사용자 지정  없으면 그냥 동일하게 설정
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @Column(unique = true)  //  중복 허용 x
    private String email;
    private String password;
    private String address;

    // security 자체적으로 제공하는 User객체 사용
//    @Enumerated(EnumType.STRING)  // enum 사용시
//    private Role role;


    // 사용자 정의 User 객체(AuthMemberDTO) 생성해서 사용
    // User 객체 및 Authentication 기능
    // @OneToMany(mappedBy = "member", cascade = {CascadeType.ALL})
    @ElementCollection(fetch = FetchType.LAZY)
    @Builder.Default
    private Set<Role> roleSet = new HashSet<>();

    public void changePassword(String password) {
        this.password = password;
    }
    public void changeEmail(String email) {
        this.email = email;
    }
    public void addRole(Role role) {
        this.roleSet.add(role);
    }
    public void clearRoles() {
        this.roleSet.clear();
    }


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
        //member.setRole(Role.USER);    // Set<Role> 사용전  (사용자 정의 User객체 만들기 전)
        member.addRole(Role.USER);      // Set<Role> 사용후

        return member;
    }


}
