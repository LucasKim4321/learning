package ex01.sam06;

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
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/loginSessionLogout")
public class E04LogoutSessionTest extends HttpServlet {
	ServletContext context = null;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doHandler(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doHandler(req, resp);
	}
	
	protected void doHandler(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter out = resp.getWriter();
		
		context = getServletContext();
		HttpSession session = req.getSession();
		String id = req.getParameter("user_id");
		out.print("id: "+id);
		
		session.invalidate();  // 세션 제거

		List list = (ArrayList)context.getAttribute("user_list");
		list.remove(id);  // 로그아웃시 => 리스트에서 아이디값 제거
		
//		context.removeAttribute("user_list");  // 기존에 context값 삭제 후  // context값 "user_list" 삭제
		context.setAttribute("user_list", list);  // 변경된 context값 저장  // context값 "user_list"에 list 추가
		
		out.println("<br>로그아웃했습니다.");
		out.println("<a href='/webjsp/ex01/sam06/LoginSessionLogout.jsp'>다시 로그인하기</a>");		
		

	}
}
