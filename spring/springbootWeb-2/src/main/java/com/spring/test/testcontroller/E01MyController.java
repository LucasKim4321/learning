package com.spring.test.testcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class E01MyController {

	@GetMapping("/jspview")
	public String jspview() {
		return "jspview/test";
	}
	
	@GetMapping("/json")
	public @ResponseBody String json() {
		return "문자열";
	}


}
