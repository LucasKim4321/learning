package ex01.sam05;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/setCookie")
public class E02SetCookieValue extends HttpServlet {  
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter out = resp.getWriter();
		
		// 날짜 객체
		Date d = new Date();
		
		// 쿠키 Cookie c = new Cookie(키, 값)
		
		Cookie c = new Cookie("cookieTest", URLEncoder.encode("JSP프로그래밍!!!","utf-8"));
//		c.setMaxAge(60*60*24);  // 유효시간 설정
		c.setMaxAge(5);
//		c.setMaxAge(-1);  // 유효시간 Session쿠키  시간제한 없음
		
		resp.addCookie(c);
		out.print("현재시간: "+d);
		out.println("<br>문자열을 Cookie에 저장합니다.");
		
		
	}

}


/* 
 * 세션 트래킹 : 웹 페이지 사이의 상태나 정보를 공유하려면 웹페이지 연결기능을 구현
 * 
 * - HTTP프로토콜 방식으로 통신하는 웹페이지들은 서로 어떠한 정보도 공유하지 않음
 * 
 * <hidden>태그 : 웹페이지 사이의 정보를 공유
 * URL Rewriting: GET방식으로 URL뒤에 정보를 붙여서 다른 페이지로 전송
 * 
 * 쿠키: 클라이언트 PC의 Cookie파일에 정보를 저장한 후 웹페이지들이 정보를 공유
 * 세션: 서버 메모리에 정보를 저장한 후 웹페이지들이 공유
 * 
 * 쿠키:
 * - 정보를 클라이언트 PC에 저장
 * - 정보 용량에 제한(4kb)
 * - 클라이언트 브라우저에 사용 유무를 설정
 * - 도메인당 쿠키가 생성(웹사이트당 하나의 쿠키가 생성)
 * - 보안 취약
 * 
 * 1. 사이트 접속
 * 2. 서버는 정보를 저장한 쿠키 생성
 * 3. 생성된 쿠키를 브라우저로 전송
 * 4. 클라이언트(브라우저) 서버로부터 받은 쿠키 정보를 쿠키 파일에 저장
 * 5. 클라이언트가 다시 접속해 서버가 라우저에 쿠키 전송을 요청하면 브라우저는
 *    쿠키 정보를 서버에 넘기고 서버는 쿠키 정보를 이용해 작업 처리
 * 6. 
 */
