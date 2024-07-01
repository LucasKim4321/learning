package ex01.sam06;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/loginListener")
public class E03LoginListenerTest extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter out = resp.getWriter();
		
		HttpSession session = req.getSession();
		String id = req.getParameter("user_id");
		String pw = req.getParameter("user_pw");
		
		// 이벤트 핸들러 생성 후 세션에 저장
		E02LoginBindingListenerImpl loginUser = new E02LoginBindingListenerImpl(id, pw);
		session.setAttribute("loginUser", loginUser);
		
		
		out.println("<html><head>");
		out.println("<script>");
		out.println("setTimeout('history.go(0);',5000");  // 5초 단위로 새로고침
		out.println("</script>");
		out.println("</head>");
		out.println("<body>");
		out.println("아이디"+loginUser.user_id+"<br>");
		out.println("총 접속자 수는"+E02LoginBindingListenerImpl.total_user+"<br>");
		out.println("</body></html>");
		
	}
}
