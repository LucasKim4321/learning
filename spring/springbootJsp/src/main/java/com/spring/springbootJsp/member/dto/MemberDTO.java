package com.spring.springbootJsp.member.dto;


import java.sql.Date;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberDTO {
	// 오라클인 경우 : rownum as recnum
	// 회원 리스트 조회시 적용되는 필드
	private int recnum;

	// 기본 입력 회원 정보 필드
	private String id;
	private String pwd;
	private String name;
	private String email;
	private Date joindate;
	
	// mybatis : localdate <-> sql date 형식 변환
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate joinLocalDate;
	
	private String uuid;
	
	
	public void toLocaleDate() {
		this.joinLocalDate = this.joindate.toLocalDate();
	}
	
	public void toSqlDate() {
	}
}
// DTO (Data Transfer Object)