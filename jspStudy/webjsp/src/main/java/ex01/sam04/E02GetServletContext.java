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
@WebServlet("/cget")
public class E02GetServletContext extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter writer = resp.getWriter();
		
		// 애플리케이션 전체에서 사용될 공통 저장소
		ServletContext ctx = getServletContext();
		
		List list = (ArrayList)ctx.getAttribute("memberInfo");
		
		String name = (String) list.get(0);
		int age = (Integer)list.get(1);
				
		// Servletcontext에 바인딩된 데이터는 모든 서블릿들(사용자)에 접근 가능
		// 웹애플리케이션에서 모든 상요자가 공통으로 사용하는 데이터
		ctx.setAttribute("memberInfo", list);
		
		writer.print("<html><body><p>");
		writer.print("ServeltContext객체에 있는 데이터 가져오기<hr/>");
		writer.print(name+"<br/>"+age);
		writer.print("</p></body></html>");
	}
}
