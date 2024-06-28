package ex01.sam04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/firstServlet")
public class E01FirstServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("first doGet()호출");
		doHandler(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("first doPost()호출");
		doHandler(req, resp);
	}
	
	protected void doHandler(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("first doHandler()가 모두 처리~");

		resp.setContentType("text/html; charset=utf-8");
		
		PrintWriter writer = resp.getWriter();
		
		// 주소 쓸 때 입력한 주소랑 일치되는 주소를 찾는 순간 엔터를 안눌러도 내부적으로 전부 처리함.
		// 예 refresh를 이용해서 3초 후 작동하는 페이지를 입력할때 주소가 일치되는 순간 처리함. 엔터 안누르고 기다렸다가 3초후 엔터 누르면 바로 작동
		
		// 1. redirect 방식
		// 1-1 sendRedirect 이용
//		 웹브라우저에서 재요청하는 방식 (http://localhost:8080/webjsp/secondServlet) 
//		resp.sendRedirect("secondServlet");
		
		// 1-2 refresh 이용 (redirect)
		// : 웹브라우저에 3초 후 서블릿 second로 재요청
//		resp.addHeader("Refresh", "3; url=secondServlet");
		
		// 1-3. location 이용 (redirect)
//		writer.print("<script type='text/javascript'>");
//		writer.print("		location.href='secondServlet'");
//		writer.print("</script>");
		
		
		// 1-4. redirect 방식으로 데이터 전달하기
//		resp.sendRedirect("thirdServlet?name=lee");
		
		// 2. dispatch 방식 (포워딩)(forward방식)
		// redirect방법과 다른 점은 클라이언트의 웹브라우저를 거치지 않고
		// 서버에 포워딩이 진행
//		RequestDispatcher dispatcher = req.getRequestDispatcher("secondServlet");
//		dispatcher.forward(req, resp);
		
		// 서블릿에서 다른 서블릿(JSP...)으로 포워딩 할 때 데이터 전달 방식
		// GET: 데이터 양이 적을 때 사용
		// binding(바인딩) : 데이터를 하나로 묶는 기능, 대량의 데이터를 공유할 때 사용 
		// 서블릿 관련 객체에 저장방법 : HttpServletRequest, HttpSession, ServletContext
		//						 : 저장된 자원(데이터)은 서블릿, JSP공유
		// HttpServletRequest: 
		// HttpSession: Session에서 공유  (로그인,로그아웃,장바구니 등 기능에 이용)
		// ServletContext: 프로젝트 내에 공유 (현재 webjsp)
		
		
		// 클라이언트에 요청했을 경우
		// sendRedirect방식 : 다른 서블렛으로 데이터를 전송 할 수 없음
//		req.setAttribute("address", "부산시");  // 구조가 HashMap방식  데이터 구조 HashMap방식 많이 씀
//		resp.sendRedirect("forthServlet");
		
		// 서버에 요청했을 경우
		req.setAttribute("address", "부산시");
		req.setAttribute("age", "10");
		RequestDispatcher dispatcher = req.getRequestDispatcher("forthServlet");
		dispatcher.forward(req, resp);
	}

}


/*
1. Redirect 방식 

Redirect 방식에 관해서 살펴 보기전에 Redirect를 잘 설명해주는 적절한 비유가 있어 이를 소개하고 본격적으로 살펴보겠습니다. (이 글에 대한 참고는 밑에 표시해 두었습니다.) 고객을 클라이언트, 상담원을 서버, URL을 통해서 서버의 자원에 접근한다고 생각하시면 됩니다.

고객이 고객센터로 상담원에게 100번으로 전화를 건다. 
상담원은 고객에게 다음과 같이 이야기한다. "고객님 해당 문의 사항은 200번으로 다시 문의해주세요"
고객은 다시 200번으로 문의해 일을 처리한다.

리다이렉트 방식으로 페이지 이동 요청을 보내면, url을 해당 url로 바꿔서 이동한다. 즉, url의 변경이 일어난다.
 
따라서 req, res 객체도 새롭게 생성된다. 처음 요청을 보낸 req, res 객체와 완전히 다른 것이다. 이 점이 포워딩 방식과 가장 큰 차이점이다. 따라서 리다이렉트 방식을 사용하면 request scope에 등록된 데이터를 사용할 수 없다.

2. Forward 방식
Forward 방식 또한 적절한 비유를 통해서 간단하게나마 이해해보자. 

고객이 고객센터로 상담원에게 100번으로 전화를 건다.
상담원은 해당문의 사항에 대해서 전문적인 지식을 갖춘 상담원에게 문의해 답을 얻는다.
상담원은 고객에게 문의사항을 처리해준다.

포워딩은 응답을 만들어 낼 웹컴포넌트에 요청을 위임하는 방식이다.
여기서 웹 컴포넌트는 서블릿이 될 수도 있고, JSP가 될 수도 있고, 웹 컴포넌트라면 포워딩할 수 있다.

포워딩방식의 가장 큰 특징은 원래의 url을 변경하지 않는다는 점이다.
응답이 끝날 때 까지 요청정보를 그대로 가지고 있는다. 따라서 Request Scope에 올려놓은 데이터를 공유할 수 있다.
*/

/* 
 * 포워드 (forward) 기능
 * : 하나의 서블릿에서 다른 서블릿이나 JSP와 연동하는 방식
 * : 요청(request)에 포함된 정보를 다른 서블릿이나 JSP와 공유
 * : 요청(request)에 정보를 포함시켜 다른 서블릿에 전달
 * : 모델 2 **
 * 
 * 
 * - redirect  **
 * 	: HttpServeltResponse객체의 sendRedirect()메서드
 * 
 * - Refresh
 * 	: HttpServeltResponse객체의 addHeader()메서드
 * 
 * - location
 * 	: 자바스크립트 location객체의 href속성
 * 
 * - dispatch  **
 * 	: 일반적인 포워딩 기능을 지칭
 * 
 */