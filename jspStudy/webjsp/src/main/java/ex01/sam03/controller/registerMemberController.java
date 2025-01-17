package ex01.sam03.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ex01.sam03.service.MemberDAOServiceImpl;
import ex01.sam03.vo.MemberVO;

@SuppressWarnings("serial")
@WebServlet("/registerMember")
public class registerMemberController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doGet() 호출!");
		doHandler(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doPost() 호출!");
		doHandler(req, resp);
	}
	protected void doHandler(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doHandler가 모두 처리 ~");
		System.out.println("==> MemberController Servlet");
		
		req.setCharacterEncoding("utf-8");
		
		String id = req.getParameter("user_id");
		String pwd = req.getParameter("user_pwd");
		String name = req.getParameter("user_name");
		String email = req.getParameter("user_email");
		
		System.out.println("id: "+id);
		
		MemberVO vo = new MemberVO(id, pwd, name, email, null);
		MemberDAOServiceImpl memberDAOServiceImpl = new MemberDAOServiceImpl();

		int result = memberDAOServiceImpl.regMember(vo);
		
		// Response객체 : 클라이언트에게 응답
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter write = resp.getWriter();
		
		if (result>0) {
			System.out.println("회원 등록 완료");
			write.print("<script>");
			write.print("	alert('회원 가입을 축하합니다!!');");
			write.print("   location.href='/webjsp/ex01/sam03/MemberLogin.jsp';");
			write.print("</script>");
		} else {
			System.out.println("회원 등록 실패");
			write.print("<script>");
			write.print("	alert('회원 가입을 실패했습니다!!');");
			write.print("   location.href='/webjsp/ex01/sam03/MemberLogin.jsp';");
			write.print("</script>");
		}
		
		
	}
}
