package ex01.sam04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/cfile")
public class E02ContextFileServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html; charset=utf-8");
		PrintWriter writer = resp.getWriter();
		
		// 애플리케이션 전체에서 사용될 공통 저장소
		ServletContext ctx = getServletContext();
		
		InputStream is = ctx.getResourceAsStream("/WEB-INF/txt/init.txt");
		BufferedReader buffer = new BufferedReader(new InputStreamReader(is));
		
		String menu = null;
		String menu_member = ctx.getInitParameter("menu_member");
		String menu_order = ctx.getInitParameter("menu_order");
		String menu_goods = ctx.getInitParameter("menu_goods");
		
		while( (menu = buffer.readLine()) != null ) {
			StringTokenizer tokens = new StringTokenizer(menu,",");  // ,를 기준으로
			
			menu_member = tokens.nextToken();
			menu_order = tokens.nextToken();
			menu_goods = tokens.nextToken();
		}
		
		writer.print("<html><body><p>");
		writer.print("txt 파일에 있는 데이터 가져오기<hr/>");
		writer.print(menu_member+"<br/>"+menu_order+"<br/>"+menu_goods);
		writer.print("</p></body></html>");
	}
}
