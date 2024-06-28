package ex01.sam04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// sInit3
public class E03initParamServlet2  extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter writer = resp.getWriter();
		
		String email = getInitParameter("email");
		String tel = getInitParameter("tel");

		writer.print("<html><body><p>");
		writer.print("sInit3<hr/>");
		writer.print("ServletConfig ServletContext객체 매개변수 데이터 가져오기<hr/>");
		writer.print(email+"<br/>"+tel);
		writer.print("</p></body></html>");
	}

}