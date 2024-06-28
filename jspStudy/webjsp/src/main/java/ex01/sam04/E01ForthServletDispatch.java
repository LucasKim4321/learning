package ex01.sam04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/forthServlet")
public class E01ForthServletDispatch extends HttpServlet {
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("forth doGet()호출");
		doHandler(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("forth doPost()호출");
		doHandler(req, resp);
	}
	
	protected void doHandler(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("forth doHandler()가 모두 처리~");
		
		req.setCharacterEncoding("utf-8");
		
		String address = (String)req.getAttribute("address");
		int age = Integer.valueOf((String)req.getAttribute("age"));

		resp.setContentType("text/html; charset=utf-8");
		PrintWriter writer = resp.getWriter();
		
		writer.println("<html><body><p>");
		writer.println("전송받은 데이터(주소): "+address);
		writer.println("</p><p>전송받은 데이터(나이): "+(age+1));
		writer.println("</p></body></html>");
		
	}

}
