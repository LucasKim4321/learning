package com.spring.MyProject.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.validator.constraints.Length;

@Getter@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor  // 데이터가 없는 상태로 객체 생성함
@Builder
public class MemberDTO {

    @NotBlank(message = "이름은 필수 입력 값이다옹~")  // Null 체크 및 문자열의 경우 길이 0인지 및 빈문자열("") 검사
    private String name;
    @NotBlank(message = "이메일은 필수 입력 값이다옹~")  // Null 체크 및 문자열의 경우 길이 0인지 및 빈문자열("") 검사
    @Email(message = "이메일 형식으로 입력해라옹~")
    private String email;
    @NotBlank(message = "비밀번호는 필수 입력 값이다옹~")
    @Length(min=8, max=16, message = "비밀번호는 8자 이상 16자 이하로 입력해라옹~")
    private String password;
    @NotBlank(message = "주소는 필수 입력 값이다옹~")
    private String address;

}
