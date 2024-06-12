package chap19.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import chap19.member.controller.MemberControllerImpl;
import chap19.member.vo.MemberVO;

public class ExecuteAppTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		MemberControllerImpl controller = new MemberControllerImpl();
		
		List<MemberVO> listMembers = new ArrayList<MemberVO>();
		
		String name = "";
		System.out.print("이름: ");
		name = sc.next().trim();  // trim 공백제거
//		MemberVO vo = MemberVO.builder()
//							.memName("홍길동")
//							.build();
		MemberVO vo = new MemberVO();
		vo.setMemName(name);
		
		listMembers = controller.listMember(vo);
		
		System.out.println("-- 회원 정보 조회 --");
		listMembers.stream().forEach( m-> {
			System.out.println(m);
		});
	}

}
