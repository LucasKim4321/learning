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
    public AuthMemberDTO(  // 생성자에 전달 받는 매개변수와 인자값 // customUserDetailsService에서 사용
            // 새로 추가하는 값
            String name,        // member.getName()
            String address,     // member.getAddress()
                          
            // 기본적으로 필요한 값
            String username,    // member.getEmail()
            String password,    // member.getPassword()
            Collection<? extends GrantedAuthority> authorities  // member.getRoleSet()
            ) {


        super(username, password, authorities);  // 부모 생성자 호출

        this.email = username;
        this.address = address;
        this.name = name;

    }

}
