package ex01.sam02;

import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void init(ServletConfig config) throws ServletException {
		System.out.println("LoginServlet init() 서블릿이 로딩 될 때 최초 한번 수행: 초기화 작업");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet() 방식 요청");
//		
//		request.setCharacterEncoding("utf-8");  // 전송된 데이터 utf-8 인코딩
//		
//		String user_id = request.getParameter("user_id");
//		String user_pw = request.getParameter("user_pw");
//		
//		System.out.println("아이디: "+user_id+" 비밀번호: "+user_pw);
		
		myDoHandler(request,response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost() 방식 요청");

		myDoHandler(request,response);
	}

	protected void myDoHandler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("myDoHandler()가 다 받아서 처리 :b");
		
		request.setCharacterEncoding("utf-8");  // 전송된 데이터 utf-8 인코딩
		
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		
		System.out.println("아이디: "+user_id+" 비밀번호: "+user_pw);

		
		System.out.println("------ 받은 파라미터들의 이름을 불러옴");
		Enumeration<String> enu = request.getParameterNames();  // 받은 파라미터들의 이름을 불러옴
		
		while (enu.hasMoreElements()) {
			String name = (String) enu.nextElement();
			System.out.println(name);
		}
		

		System.out.println("------ 하나의 매개 변수에 여러 개의 값을 전달 받을 경우");
		// 하나의 매개 변수에 여러 개의 값을 전달 받을 경우
		// parameter로 넘어올 때 채크 된 subject는 배열
		// 같은 parameter가 여러개면 배열
		String[] subject = request.getParameterValues("subject");
		
		
		System.out.println("--여러 개의 값 처리");
		Arrays.stream(subject).forEach( value -> {
			System.out.println(value);
		});
		

		System.out.println("------");
		String address = request.getParameter("address");
		System.out.println("거주지: "+address);
		

		
		System.out.println("------");
		String size = request.getParameter("size");  // 값이 여러개일 경우 첫번째 값만 표시
		System.out.println("사이즈: "+size);
		

		System.out.println("------");
		String[] size2 = request.getParameterValues("size");  // size 여러개의 셀렉트값
		Arrays.stream(size2).forEach(value -> {
			System.out.println("사이즈: "+value);
		});
		
		
	}

}
