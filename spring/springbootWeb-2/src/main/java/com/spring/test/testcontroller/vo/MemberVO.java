package com.spring.test.testcontroller.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberVO {
	private String id;
	private String pwd;
	private String name;
	private String email;
	private Date joindate;
	
	/*
	 * public String getId() { return id; } public void setId(String id) {
	 * this.id=id; }
	 * 
	 * public String getPwd() { return pwd; } public void setPwd(String pwd) {
	 * this.pwd=pwd; } public String getName() { return name; } public void
	 * setName(String name) { this.name=name; } public String getEmail() { return
	 * email; } public void setEmail(String email) { this.email=email; } public Date
	 * getJoindate() { return joindate; } public void setJoindate(Date joindate) {
	 * this.joindate=joindate; }
	 */
	
}