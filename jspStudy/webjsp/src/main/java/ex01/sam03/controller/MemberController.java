package ex01.sam03.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ex01.sam03.dao.MemberDAO;

@SuppressWarnings("serial")
@WebServlet("/member")
public class MemberController extends HttpServlet{
	
	@Override
	public void init() throws ServletException {
		System.out.println("init() 시작시 처음 한번 실행 '.'");
	}
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
		
		MemberDAO dao = new MemberDAO();
		
	}

}
