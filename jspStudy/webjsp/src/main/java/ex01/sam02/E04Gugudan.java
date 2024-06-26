package ex01.sam02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/gugudan")
public class E04Gugudan extends HttpServlet {
	@Override
	public void init() throws ServletException {
		System.out.println("E04Gugudan init()");
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
		System.out.println("doHandler가 다 처리!");
		req.setCharacterEncoding("utf-8");
		
		int dan = 0;
		if(req.getParameter("dan")!="") {
			dan = Integer.valueOf(req.getParameter("dan"));

			for (int i=1; i<=9; i++) {
				System.out.println(dan+" x "+i+" = "+dan*i);
			}

			resp.setCharacterEncoding("utf-8");
			resp.setContentType("text/html; charset=utf-8");
			PrintWriter out = resp.getWriter();
			

//			String 	result = "";
//					result += "<html>";
//					result += "	<body>";
//					result += "	<div>";
//					for (int i=1; i<=9; i++) {
//						result += "	<div>";
//						result += dan+" x "+i+" = "+dan*i;
//						result += "	</div>";
//					}
//					result += "	</div>";
//					result += "	</body>";
//					result += "</html>";
//
//			out.print(result);


			String 	result = "";
				 	result += """
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<!-- http://localhost:8080/webjsp/ex01/sam02/E04gugudan.jsp -->
	<div class=container>
		<div class=mybox>
			<form name="frmLogin" action="/webjsp/gugudan" method="get" class="d-flex">
				<div>
					<label for="dan">구구단</label>
					<input type="text" name="dan" placeholder="단수 입력 :b" id="dan" class="">
				</div>
				<div class="d-flex">
					<div class="ms-1"><input type="submit" value="실행" class="btn btn-outline-success"></div>
					<div class="ms-1"><input type="reset" value="다시입력" class="btn btn-outline-danger"></div>
				</div>
			</form>
		</div>
		""";

		for (int i=1; i<=9; i++) {
			result += "	<div>";
			result += dan+" x "+i+" = "+dan*i;
			result += "	</div>";
		};
			
					
		result +="""
	</div>

	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
	
</body>
</html>
					""";
					
			out.print(result);
		}
		
		
		
	}
}
