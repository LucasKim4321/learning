package ex05.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.json.JSONParser;



@SuppressWarnings("serial")
@WebServlet("/json")
public class AjaxTest2 extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doGet()호출");
		doHandler(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doPost()호출");
		doHandler(req, resp);
	}
	protected void doHandler(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/ajaxTest 요청 받았음!");
		
		// 문자형 숫자 -> 숫자: Integer.parse("문자열값")
		// json형식 문자열을 받음 -> json 객체로 전환
		
		String jsonInfo = req.getParameter("jsonInfo");
//		System.out.println("jsonInfo: "+jsonInfo);

		
//		out.print("안녕하세요!... 서버입니다."+jsonInfo+"데이터 잘 받았습니다.");
		try {
			JSONParser jsonParse = new JSONParser(jsonInfo);
			System.out.println(jsonParse);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		

		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter out = resp.getWriter();
		
		out.print("안녕하세요!... 서버입니다."+jsonInfo+"데이터 잘 받았습니다.");
		
	}
	
	
}
