package ex01.sam04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
		urlPatterns = { 
				"/sInit",  // url이 2개 이상
				"/sInit2"
		}, 
		initParams = { 
				@WebInitParam(name = "email", value = "hong@gmail.com"), // 
				@WebInitParam(name = "tel", value = "010-1234-1234")
		})
public class E03InitParamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter writer = resp.getWriter();
		
		String email = getInitParameter("email");
		String tel = getInitParameter("tel");

		writer.print("<html><body><p>");
		writer.print("sInit, sInit2<hr/>");
		writer.print("ServletConfig ServletContext객체 매개변수 데이터 가져오기<hr/>");
		writer.print(email+"<br/>"+tel);
		writer.print("</p></body></html>");
	}

}
