package ex01.sam02;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/login2")
public class E01LoginServletResponse extends HttpServlet {
	
	@Override
	public void init() throws ServletException {
		System.out.println("E01LoginServletResponse init()");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doGet()방식으로 요청 받음");
		doHandler(req,resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doPost()방식으로 요청 받음");
		doHandler(req,resp);
	}

	protected void doHandler(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doHandler()가 모두 처리 ;D");
		
		// 서버 -> 클라이언트에게 정보 전달 (html구조)
		// HTML전송: text/html, 텍스트파일: text/plain, XML데이터: application/xml
		
		req.setCharacterEncoding("utf-8");
		String id = req.getParameter("user_id");
		String pw = req.getParameter("user_pw");
		
		// 응답: Response 처리
		resp.setContentType("text/html; charset=utf-8");
		String data = "";
		data += "<html>";
		data += "</html>";
	}
}
