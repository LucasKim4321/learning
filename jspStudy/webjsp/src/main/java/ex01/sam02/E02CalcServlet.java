package ex01.sam02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ex01.sam02.dto.AddCalc;

@SuppressWarnings("serial")
@WebServlet("/calc")
public class E02CalcServlet extends HttpServlet{
	@Override
	public void init() throws ServletException {
		System.out.println("E02CalcServlet init()");
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doGet()호출");
		doHandler(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doPost()호출");
		doHandler(req, resp);
	}
	protected void doHandler(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doHandler() 모두 처리");
		
		req.setCharacterEncoding("utf-8");
		// String -> int  밑에 둘다 같은 기능
		int num1 = Integer.parseInt(req.getParameter("num1"));
		int num2 = Integer.valueOf(req.getParameter("num2"));
		
//		System.out.println("1. "+num1+" + "+num2+" = "+(num1+num2));

		
		

		// 덧셈 계산기 객체 호출하여 실행
		AddCalc addCalc = AddCalc.builder()
						.num1(num1).num2(num2)
						.build();
		
		System.out.println("2. "+num1+" + "+num2+" = "+addCalc.result());
		
		int addResult = addCalc.result();
		
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter out = resp.getWriter();
		
		String	result = "";
				result += "<html>";
				result += "	<body>";
				result += "		"+num1+" + "+num2+" = "+addResult;
				result += "	</body>";
				result += "</html>";
				
		out.print(result);
	}
	

}
