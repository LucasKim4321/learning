package ex05.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import ex05.vo.JsonVO;






@SuppressWarnings("serial")
@WebServlet("/json2")
public class AjaxTest3 extends HttpServlet{
	
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
		System.out.println("/ajaxTest 요청 받았음!");
		
		// 문자형 숫자 -> 숫자: Integer.parse("문자열값")
		// json형식 문자열을 받음 -> json 객체로 전환
		
		String jsonInfoArray = req.getParameter("jsonInfoArray");
		
//		System.out.println("jsonInfo: "+jsonInfo);
		
//		out.print("안녕하세요!... 서버입니다."+jsonInfo+"데이터 잘 받았습니다.");
		
		
		List<JsonVO> list = new ArrayList<JsonVO>();
		
		try {
			
			JSONParser jsonParser = new JSONParser();
//			System.out.println(jsonParse);
			
			// 1.  배열 구조 일 경우: JSON객체 배열 생성
			//JSONArray jsonArray  = (JSONArray) jsonParser.parse(jsonInfoArray);// 문자열 -> JSON객체로 전환

			// 2. 배열 구조가 아닌 단일 객체 일 경우 : JSON객체 생성
			JSONObject jsonObject = (JSONObject) jsonParser.parse(jsonInfoArray);
			
			System.out.println("--------------");
			System.out.println("받은 JSON데이터");
			System.out.println(jsonObject.toJSONString());
			
			System.out.println("--- 회원 정보");
			System.out.println(jsonObject.get("member"));
			
			
			JSONArray jsonArray = new JSONArray();
			jsonArray = (JSONArray) jsonObject.get("member");	
//			JSONArray jsonArray = (JSONArray) jsonObject.get("member");	 // 이렇게 해도 같음
			
			System.out.println("member 값: 배열구조");
			
			for (int i=0; i<jsonArray.size(); i++) {
				JSONObject memberInfo = (JSONObject) jsonArray.get(i);
				
//				System.out.println((i+1)+":------------");
//				System.out.println(memberInfo.get("name"));
//				System.out.println(memberInfo.get("age"));
//				System.out.println(memberInfo.get("gender"));
//				System.out.println(memberInfo.get("nickname"));
				
				System.out.println("JSON 속성값 String -> VO에 전달");
				
				String	name 		= memberInfo.get("name").toString();
				int 	age 		= Integer.valueOf(memberInfo.get("age").toString());
				String 	gender 		= memberInfo.get("gender").toString();
				String 	nickname 	= memberInfo.get("nickname").toString();
				//(Integer)(String)이런식으로 형 전환 하는게 만능은 아님
				
				JsonVO vo = new JsonVO(name, age, gender, nickname);
//				System.out.println("vo: "+vo);
//				System.out.println("vo values: "+vo.getName()+vo.getAge()+vo.getGender()+vo.getNickname());
//				System.out.println("JsonVO: "+vo.toString());
				
				list.add(vo);  // 리스트 구조에 vo객체 추가
			}
			
			
			System.out.println("== json data array => list");
			System.out.println(list);
			
			System.out.println("========================end");
			
		} catch (Exception e) {System.out.println(e.getMessage());}
		
		

		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter out = resp.getWriter();
		
		System.out.println("---------");
		System.out.println("자바객체data -> JSON -> String -> 전송");
		
		JSONObject members = new JSONObject();
		JSONArray valueArray = new JSONArray();
		
		for (JsonVO vo : list) {	
			JSONObject memberInfo = new JSONObject();
			
			memberInfo.put("name", vo.getName());
			memberInfo.put("age", vo.getAge());
			memberInfo.put("gender", vo.getGender());
			memberInfo.put("nickname", vo.getNickname());
			
//			System.out.println(memberInfo.toJSONString());
			
			valueArray.add(memberInfo);
		}
		members.put("members", valueArray);
		String jsonMembers = members.toJSONString();  // JSON객체 -> JSON형식 문자열
		System.out.println("jsonMembers: "+jsonMembers);
		
		out.print(jsonMembers);
		
		
	}
	
	
}
