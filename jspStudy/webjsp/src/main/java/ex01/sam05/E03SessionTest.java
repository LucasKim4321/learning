package ex01.sam05;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/SessionTest")
public class E03SessionTest extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter out = resp.getWriter();

		// 세션 객체 생성
		HttpSession session = req.getSession();
		out.println("세션 id: "+session.getId()+"<br>");
		out.println("최초 세션 생성 시간: "+session.getCreationTime()+"<br>");
		out.println("최근 세션 접근 시간: "+session.getLastAccessedTime()+"<br>");
		
		session.setMaxInactiveInterval(5); // 세션 유지 시간 5초
		out.println("세션 유효 시간: "+session.getMaxInactiveInterval()+"<br>");
		
		
		if(session.isNew()) {  // 세션 존재여부 체크
			out.println("새 세션이 만들어졌습니다.");	
		} else {
			out.println("세션이 존재합니다.");
		}
		
		// 세션 정보 강제 삭제
//		session.invalidate();  // 세션을 항상 삭제해서 이 웹페이지에서는 불러올때마다 새로 만듬
	}

}


/* 
 * 세션
 * - 정보가 서버의 메모리에 저장
 * - 브라우저의 세션 연동은 세션 쿠키를 이용
 * - 서버에 부하를 줄 수 있음.
 * - 브라우저(사용자)당 한 개의 세션(세션=id)을 생성
 * - 세션 유효 시간 설정 가능
 * - 로그인 상태 유지 기능, 쇼핑몰 장바구니 담기 기능 등에 주로 사용
 * 
 * 
 * HttpSession의 getSession()메서드 호출해서 생성
 * 
 * getSession() or getSession(true): 기존의 세션 객체가 존재하면 반환, 없으면 새로 생성
 * getSession(false): 기존의 세션 객체가 존재하면 반환, 없으면 null
 * 
 * 
 */
