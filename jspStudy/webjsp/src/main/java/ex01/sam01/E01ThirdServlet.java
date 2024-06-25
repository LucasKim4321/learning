package ex01.sam01;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// web.xml에 servlet 쓰는걸 대신 해줌
// localhost:8080/webjsp/third 으로 바로 접속 가능
@WebServlet("/third")
public class E01ThirdServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;  //E01ThirdServlet 노란 밑줄 제거   안해도됨
	
	@Override
	public void init() throws ServletException {
		// 서블릿 요청시 맨 처음 한번만 호출
		System.out.println("E01ThirdServlet init() 메서드 호출");
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 서블릿 요청시 매번 호출 : get방식으로 요청시
//		System.out.println("E01ThirdServlet doGet() 메서드 호출");
		doHandler(req,resp);  // 어느 방식으로 들어오든 doHandler가 받아서 처리
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 서블릿 요청시 매번 호출 : post식으로 요청시
//		System.out.println("E01ThirdServlet doPost() 메서드 호출");
		doHandler(req,resp);  // 어느 방식으로 들어오든 doHandler가 받아서 처리
	}
	@Override
	public void destroy() {
		// 서블릿이 기능을 수행하고 메모리에서 소멸될 때 호출
		System.out.println("E01ThirdServlet destroy() 메서드 호출");
	}

	protected void doHandler(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 서블릿 요청시 매번 호출 : doGet doPost 동시 처리
		System.out.println("E01ThirdServlet doHandler() 메서드 호출");
	}
}
