package ex01.sam04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/* 
 * load-on-start기능
 * 톰캣 컨테이너가 실행되면서 미리 서브릿을 실행
 * 지정한 숫자가 0보다 크면 톰캣 컨테이너가 실행되면서 서블릿이 초기화 (loadOnStartup=1)
 * 지정한 숫자는 우선순위를 의미, 작은 숫자부터 먼저 초기화
 * 
 */

// 어노테이션 방식으로 초기값 설정
//@WebServlet(name="loadconfig", urlPatterns= "/LoadConfig", loadOnStartup = 1)  //urlPatterns= "/LoadConfig" 두개이상{}
public class E04LoadAppConfig extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ServletContext ctx;  // 공동으로 쓰는 변수
	
	public void init(ServletConfig config) throws ServletException {
		System.out.println("LoadAppConfig init() :b");
		
		ctx = config.getServletContext();
		
		String menu_member = ctx.getInitParameter("menu_member");
		String menu_order  = ctx.getInitParameter("menu_order");
		String menu_goods  = ctx.getInitParameter("menu_goods");
		
		ctx.setAttribute("menu_member", menu_member);
		ctx.setAttribute("menu_order" , menu_order);
		ctx.setAttribute("menu_goods" , menu_goods);
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 서블릿 요청시 매번 호출
		System.out.println("doGet() 호출 ~");
		
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter writer = resp.getWriter();
		
		String menu_member = (String) ctx.getAttribute("menu_member");
		String menu_order  = (String) ctx.getAttribute("menu_order");
		String menu_goods  = (String) ctx.getAttribute("menu_goods");

		writer.print("<html><body><p>");
		writer.print("LoadConfig<hr/>");
		writer.print("LoadOnStartup 기능: ServletConfig web.xml 구조: 매개변수 데이터<hr/>");
		writer.print(menu_member+"<br/>"+menu_order+"<br/>"+menu_goods+"<br/>");
		writer.print("</p></body></html>");
	}

}
