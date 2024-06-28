package ex01.sam04;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/cset")
public class E02SetServletContext extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter writer = resp.getWriter();
		
		// 애플리케이션 전체에서 사용될 공통 저장소
		ServletContext ctx = getServletContext();
		
		List list = new ArrayList();
		list.add("이순신");
		list.add(10);
		
		ctx.setAttribute("memberInfo", list);
	
		writer.print("<html><body><p>");
		writer.print("ServeltContext객체에 데이터 저장하기");
		writer.print("</p></body></html>");
	}
}

/* 
 * ServletContext:
 * 
 * 톰켓 컨테이너 실행 시 각 컨텍스트(웹 애플리케이션)마다 한 개의 객체 생성
 * 애플리케이션 전체의 공통 자원이나 정보를 미리 바인딩해서 서블릿들이 공유하여 사용 (전역변수같은 개념)
 * 
 * - 서블릿(클래스)에서 파일 접근 기능
 * - 자원 바인딩 기능(많이씀)(자원을 묶는 기능)
 * - 로그 파일 기능
 * - 컨텍스트에서 제공하는 설정 정보 제공 기능
 */
