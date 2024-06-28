package ex01.sam03.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ex01.sam03.service.MemberDAOServiceImpl;
import ex01.sam03.vo.MemberVO;

@SuppressWarnings("serial")
//@WebServlet("/member")  // member
//@WebServlet("/*")  // *모든값
@WebServlet("/member/*")  // /member/*(모든값)
public class MemberController extends HttpServlet {
	
	@Override
	public void init() throws ServletException {
		System.out.println("init() 시작시 처음 한번 실행 '.'");
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doGet() 호출!");
		doHandler(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doPost() 호출!");
		doHandler(req, resp);
	}
	protected void doHandler(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doHandler가 모두 처리 ~");
		System.out.println("==> MemberController Servlet");

		System.out.println("1-------------------------------------1");
		req.setCharacterEncoding("utf-8");
		String action = req.getPathInfo();  // 들어올때 입력한 주소가 뜸 // 경로를 이동해서 들어오면 null뜸
//		String action = req.getPathTranslated();  // 실제 컴퓨터상의 위치가 뜸 // 경로를 이동해서 들어오면 null뜸
//		String action = req.getContextPath();  // 현재 페이지의 context가 뜸  *무시
//		String action = req.getServletPath();  // 현재 페이지의 서블렛의 path가 뜸  *무시
		System.out.println("action: "+action);
		String command = req.getParameter("command");
		System.out.println("command: "+command);
		System.out.println("2-------------------------------------2");
		
		// controller -> service에게 요청 -> dao에게 요청
		MemberDAOServiceImpl memberDAOServiceImpl = new MemberDAOServiceImpl();
		

		if (command != null && command.equals("listMember.do")) {
			System.out.println("회원목록을 DAO에 요청하기");
			
			List<MemberVO> list = memberDAOServiceImpl.listMembers();
			// 회원목록 콘솔에 출력
//			list.stream().forEach(member-> {
//				System.out.println(member.getId());
//				System.out.println(member.getPwd());
//				System.out.println(member.getName());
//				System.out.println(member.getEmail());
//				System.out.println(member.getJoinDate());
//			});
			
			resp.setCharacterEncoding("utf-8");
			resp.setContentType("text/html; charset=utf-8");
			PrintWriter write = resp.getWriter();
			
//			write.print("<script>");
//			write.print("   location.href='/webjsp/ex01/sam03/MemberLogin.jsp';");
//			write.print("</script>");
			
			String str = "";
			str += """
					<!DOCTYPE html>
					<html>
					<head>
					<meta charset="UTF-8">
					<title>Insert title here</title>
					<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
					
					</head>
					<body>
					<div class="container border">
						<div class="border login mx-auto">
							<h3>회원 가입</h3>
							<hr>
							<form action="/webjsp/registerMember" method="get">  <!-- method="post"  요청 방식 변경   생략시 기본값 get-->
								<div>
									<label for="u_id">아이디:</label>
									<input type="text" name="user_id" id="u_id" class="form-control">
								</div>
								<div>
									<label for="u_pwd">비밀번호:</label>
									<input type="password" name="user_pwd" id="u_pwd" class="form-control">
								</div>
								<div>
									<label for="u_name">이름:</label>
									<input type="password" name="user_name" id="u_name" class="form-control">
								</div>
								<div>
									<label for="u_email">이메일:</label>
									<input type="password" name="user_email" id="u_email" class="form-control">
								</div>
								<hr>
								<div class="d-flex justify-content-center">
									<div><input type="submit" value="등록" class="btn btn-outline-success"/></div>
									<div class="ms-1"><input type="reset" value="다시입력" class="btn btn-outline-danger"/></div>
								</div>
							</form>
							<form action="/webjsp/member">
								<input type="submit" value="회원목록 조회" class="btn btn-outline-secondary">
							</form>
							<div>
							<table class="table table-warning table-striped">
							<thead>
								<tr>
								<th>아이디</th>
								<th>비밀번호</th>
								<th>이름</th>
								<th>이메일</th>
								<th>가입날짜</th>
								</tr>
							</thead>
							<tbody>
							""";
			
			for(MemberVO member : list) {
				str += "<tr>";
				str += "<td class='col'>"+member.getId()+"</td>";
				str += "<td class='col'>"+member.getPwd()+"</td>";
				str += "<td class='col'>"+member.getName()+"</td>";
				str += "<td class='col'>"+member.getEmail()+"</td>";
				str += "<td class='col'>"+member.getJoinDate()+"</td>";
				str += "</tr>";
			};		
			
			str += """
					</tbody>
					</table>
					</div>
				</div>
			</div>
			
			
			<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
			<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>

		</body>
		</html>
						""";
			
			write.print(str);
			
		} else if (action != null && action.equals("/addMember.do")) {
			System.out.println("회원가입하는 DAO요청하기");

			MemberVO vo = new MemberVO();
			vo.setId(req.getParameter("user_id"));
			vo.setPwd(req.getParameter("user_pwd"));
			vo.setName(req.getParameter("user_name"));
			vo.setEmail(req.getParameter("user_email"));

			int result = memberDAOServiceImpl.regMember(vo);
			
		} else if (action != null && action.equals("/delMember.do")) {
			System.out.println("회원탈퇴하는 DAO요청하기");
			
		} else if (action != null && action.equals("/modMember.do")) {
			System.out.println("회원수정하는 DAO요청하기");
		}
		
		
	}

}

// ServletConfig**