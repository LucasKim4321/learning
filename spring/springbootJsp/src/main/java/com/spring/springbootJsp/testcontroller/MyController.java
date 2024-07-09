package com.spring.springbootJsp.testcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {
	// 1. jsp view 연결하기
	
	// context는 '/'
	// http://localhost:8099/jsptest1
	@RequestMapping("/jsptest1")  // survlet 설정
	public String test1() {
		/*  '/WEB-INF/views/' + return "문자열"+".jsp"*/
		return "indexjsp";  // => /WEB-INF/views/indexjsp.jsp
	}
	
	// http://localhost:8099/jsptest2
	@RequestMapping("/jsptest2")
	public String test2() {
		/*  '/WEB-INF/views/' + return "문자열"+".jsp"*/
		return "testsub/test";  // => /WEB-INF/views/testsub/test.jsp
	}
	
	
	// 2. 정적 페이지(html)
	@RequestMapping("/html")
	public String hello() {
		return "redirect:/html/hello.html";
	}
	
	@RequestMapping("/images")
	public String image() {
		return "redirect:images/frog (1).jpg";
	}
	
	
	// 3. Model and View JSON
	@RequestMapping("/")
	public @ResponseBody String root() {
		return "model & and View";
	}
	
	
	
}
