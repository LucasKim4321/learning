package com.spring.springbootJsp.testcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.spring.springbootJsp.member.dao.MemberJDBCTemplate;

@Controller
public class MemberJDBCTemplateController {
	
	@Autowired
	private MemberJDBCTemplate memberDAO;
	
	// 회원 리스트
	@GetMapping("/jdbcMembers")
	public String jdbcMemberList(Model model) {
		model.addAttribute("jdbcMembers", memberDAO.jdbcMemberList());

		System.out.println("=============");
		System.out.println("list=>"+memberDAO.jdbcMemberList());
		System.out.println("=============");
		return "jdbcView/jdbcMembers";
	}
	
	
	// 회원조회
	@GetMapping("/jdbcMemberView")
	public String jdbcMemberView() {
		return "jdbcView/jdbcMemberView";
	}
	
	
	// 회원삭제
	@GetMapping("/jdbcMemberDelete")
	public String jdbcMemberDelete() {
		return "jdbcView/jdbcMemberDelete";
	}
	
	
	// 회원수정
	@GetMapping("/jdbcMemberModify")
	public String jdbcMemberModify() {
		return "jdbcView/jdbcMemberModify";
	}
	
	
	// 회원등록
	@GetMapping("/jdbcMemberRegister")
	public String jdbcMemberRegister() {
		return "jdbcView/jdbcMemberRegister";
	}
	
}
