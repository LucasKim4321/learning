package com.spring.springbootJsp.member.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.springbootJsp.member.dao.E02MemberDAOMybatis;
import com.spring.springbootJsp.member.vo.MemberVO;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/member")
public class MemberController {
	static Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private E02MemberDAOMybatis memberDAO;
	// 서비스 객체 선언
	
	// sysdate
	// http://localhost:8099/member/now
	@GetMapping("/now")
	public String getDBGetTime(Model model ) {
		
		String getTime = memberDAO.getTime();
		logger.info("==> xml로 작성한 sql getTime(); "+getTime);
		
		model.addAttribute("now", getTime) ;
		
		
		return "member/mybatisViewTest";
	}
	
	// 회원 목록
	// http://localhost:8099/member/list
	@GetMapping("/list")
	public String getList(Model model) {
		List<MemberVO> list = memberDAO.getMemberList();
		logger.info("=> member list: "+list);
		
		model.addAttribute("members", list);
		
		return "member/memberList";
	}
	
	// 회원 조회
	// http://localhost:8099/member/view?id=hong2
	@GetMapping("/view")
	public String getView(Model model, HttpServletRequest req) {
		String id = req.getParameter("id");
		logger.info("=> member/view id: "+id);
		
		model.addAttribute("member",memberDAO.getMemberView(id));
		
		return "member/memberView";
	}
	
	// 회원 등록
	// http://localhost:8099/member/insert?id=hong99&pwd=2222&name=홍홍홍&email=honghong@gmail.com
	@GetMapping("/insert")
	public String memberRegister(HttpServletRequest req) {
		MemberVO vo = MemberVO.builder()
				.id(req.getParameter("id"))
				.pwd(req.getParameter("pwd"))
				.name(req.getParameter("name"))
				.email(req.getParameter("email"))
				.build();
		
		logger.info("=> member/insert: "+vo);
		
		memberDAO.insertMember(vo);
		
		return "member/memberRegister";
	}
	
	
}