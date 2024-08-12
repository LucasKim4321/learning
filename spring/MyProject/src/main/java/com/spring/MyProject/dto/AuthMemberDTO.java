package com.spring.MyProject.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

@Getter
@Setter
@ToString
// 사용자 정의 User객체 생성
public class AuthMemberDTO extends User {

    private String name;
    private String email;
//    private String password;  // 부모 요소에 있는 password필드는 그대로 사용
    private String address;

    // <? extends GrantedAuthority>  GrantedAuthority를 상속받은 모은 하위요소
    public AuthMemberDTO(
            String name,
            String address,
            String username,
            String password,
            Collection<? extends GrantedAuthority> authorities
            ) {


        super(username, password, authorities);  // 부모 생성자 호출

        this.email = username;
        this.address = address;
        this.name = name;

    }

}
