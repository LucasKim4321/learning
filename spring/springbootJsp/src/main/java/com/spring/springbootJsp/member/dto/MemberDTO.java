package com.spring.springbootJsp.member.dto;


import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberDTO {
	private String id;
	private String pwd;
	private String name;
	private String email;
//	private Date joindate;
	
	// mybatis : localdate <-> sql date 형식 변환
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate joindate;
	
	private String uuid;
	
}
// DTO (Data Transfer Object)