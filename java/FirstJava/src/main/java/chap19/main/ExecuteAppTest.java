package chap19.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import chap19.member.controller.MemberController;
import chap19.member.controller.MemberControllerImpl;
import chap19.member.vo.MemberVO;
import chap19.member.window.RegMemDialog;

public class ExecuteAppTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		MemberControllerImpl controller = new MemberControllerImpl();
		List<MemberVO> listMembers = new ArrayList<MemberVO>();
		
		System.out.print("이름: ");
		String name = sc.nextLine().trim();
		
//		MemberVO vo = MemberVO.builder()
//								.memName(name)
//								.build();
		
		MemberVO vo = new MemberVO();
		vo.setMemName(name);
		
		listMembers =  controller.listMember(vo);
		
		System.out.println("-- 회원 정보 조회 --");
		listMembers.stream().forEach( m -> {
			System.out.println(m);
		});
		
//		// 회원 정보 입력(추가)
//		System.out.println("-- 회원 정보 입력");
//		MemberVO insertVO = new MemberVO("HONG100", "1234", "홍길동", "서울", "010-1234-4444");
//		
//		int result = controller.regMember(insertVO);
//		
//		System.out.println("result: "+result);
//		if (result > 0) {
//			System.out.println("회원 정보 등록 완료");
//		} else {
//			System.out.println("회원 정보 등록 실패");
//		}
		
//		// 회원 정보 수정
//		System.out.println("-- 회원 정보 수정");
//		MemberVO modifyVO =  MemberVO.builder()
//				.memId("HONG200")
//				.memName("홍길동200")
//				.memPassword("3333")
//				.memPhoneNum("010-3333-3333")
//				.memAddress("대구")
//				.build();
//		
//		int result = controller.modMember(modifyVO);
//		
//		System.out.println("result: "+result);
//		if (result > 0) {
//			System.out.println("회원 정보 수정 완료");
//		} else {
//			System.out.println("회원 정보 수정 실패");
//		}
		
		// 회원 정보 삭제
		System.out.println("-- 회원 정보 삭제");
		MemberVO delVO = MemberVO.builder().memId("HONG500").build();  // 삭제할 정보를 가진 VO객체 생성
		
		int result = controller.removeMember(delVO);  // 정보를 컨트롤러로 보냄
		if (result > 0) {
			System.out.println("회원 정보 삭제 완료");
		} else {
			System.out.println("회원 정보 삭제 실패");
		}		

		
		
		// 다이얼로그 창 이용
		
		// 회원 등록
//		MemberControllerImpl controller = new MemberControllerImpl();
//		
//		System.out.println("1. membercotrollor: "+controller);
//		new RegMemDialog(controller, "회원 등록");

	}

}



//package chap19.main;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//import chap19.member.controller.MemberControllerImpl;
//import chap19.member.vo.MemberVO;
//
//public class ExecuteAppTest {
//
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		
//		MemberControllerImpl controller = new MemberControllerImpl();
//		
//		List<MemberVO> listMembers = new ArrayList<MemberVO>();
//		
//		String name = "";
//		System.out.print("이름: ");
//		name = sc.next().trim();  // trim 공백제거
////		MemberVO vo = MemberVO.builder()
////							.memName("홍길동")
////							.build();
//		MemberVO vo = new MemberVO();
//		vo.setMemName(name);  // 입력한 값으로 vo객체 생성
//		
//		//넘겨받은 데이터로 List를 생성해 listMembers 변수 생성
//		listMembers = controller.listMember(vo);  // 생성한 vo객체 넘겨줌  
//		
//		System.out.println("-- 회원 정보 조회 --");
//		listMembers.stream().forEach( m-> {  // 받은 List객체를 forEach로 풀어서 표시
//			System.out.println(m);
//		});
//	}
//
//}
