package ex01.sam06;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loginFilter")
public class E01LoginFilterTest extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		응답(response)를 할 때 utf-8를 안해주면 브라우저에서 한글을 못 읽어냄
//		resp.setCharacterEncoding("utf-8");
//		resp.setContentType("text/html; charset=utf-8");
//		위에 것으로 해도 되고 전용 필터를 만들 수도 있음
		
		PrintWriter out = resp.getWriter();
		
		String id = req.getParameter("user_id");
		String pw = req.getParameter("user_pw");
		
		System.out.println("id: "+id+", pw: "+pw);
		
		out.println("id: "+id);
		out.println("pw: "+pw);
		
		
	}
	
}


/* 
 * 
 * Filter API
 * : 브라우저에서 서블릿에 요청하거나 응답할 때 미리 요청이나 응답과 관련해
 *   여러 가지 작업을 처리하는 기능
 *   - 각 서블릿에서 반복적으로 처리해야 하는 작업
 * 
 * 클라이언트 -> 필터1 -> 필터2 -> ... -> 서블릿
 * 
 * 요청 필터:
 * - 사용자 인증 및 권한 검사
 * - 요청시 요청관련 로그 작업
 * - 인코딩 기능
 * 
 * 응답 필터
 * - 응답 결과에 대한 암호화 작업
 * - 서비스 시간 측정
 * 
 * javax.servlet.Filter
 * javax.servlet.FilterChain
 * javax.servlet.FilterConfig
 * 
 */
 