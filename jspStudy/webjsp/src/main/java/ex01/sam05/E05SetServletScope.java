package ex01.sam05;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/setServletScope")
public class E05SetServletScope extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter out = resp.getWriter();
		
		//------------------------------------//
		String context = req.getContextPath();
		String url = req.getRequestURI().toString();
		String mapping = req.getServletPath();
		String uri = req.getRequestURI();
		System.out.println("-> request 팬턴");
		//------------------------------------//
		
		
		String ctxMesg 	= "contex에 바인딩됩니다.";
		String sesMesg	= "session에 바인딩됩니다.";
		String reqMesg	= "request에 바인딩됩니다.";
		
		ServletContext ctx = getServletContext();
		HttpSession session = req.getSession();
		
		ctx.setAttribute("context", ctxMesg);  // 브라우저 관계없이 항상 공유됨
		session.setAttribute("session", sesMesg);  // 브라우저 별로 자원 공유, 브라우저가 바뀌면 공유안됨
		req.setAttribute("request", reqMesg);  // 요청관계에서만 자원 공유
		
		out.print("바인딩을 수행합니다.");
		
	}
	
}
