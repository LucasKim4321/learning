package ex01.sam04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/first")
public class E01FirstServlet extends HttpServlet {
	
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
		System.out.println("doHandler()가 모두 처리~");
		req.setCharacterEncoding("utf-8");
		
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter writer = resp.getWriter();
		
		resp.sendRedirect("second");
	}

}

/* 
 * 포워드 (forward) 기능
 * : 하나의 서블릿에서 다른 서블릿이나 JSP와 연동하는 방식
 * 
 * - redirect  **
 * 	: HttpServeltResponse객체의 sendRedirect()메서드
 * 
 * - Refresh
 * 	: HttpServeltResponse객체의 addHeader()메서드
 * 
 * - location
 * 	: 자바스크립트 location객체의 href속성
 * 
 * - dispatch  **
 * 	: 일반적으로 포워딩 기능을 지칭
 * 
 */