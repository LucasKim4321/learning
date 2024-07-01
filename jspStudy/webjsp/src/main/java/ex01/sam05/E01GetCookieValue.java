package ex01.sam05;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/getCookie")
public class E01GetCookieValue extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter out = resp.getWriter();
		
		Cookie[] allValues = req.getCookies();
		for (int i=0; i < allValues.length; i++) {
			
			if(allValues[i].getName().equals("cookieTest")) {
				out.print("<h2>Cookie값 가져오기: " + URLDecoder.decode(allValues[i].getValue(), "utf-8"));
			}
		}
	}
	
	

}
