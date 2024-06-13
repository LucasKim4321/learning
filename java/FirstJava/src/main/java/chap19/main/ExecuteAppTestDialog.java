package chap19.main;

import chap19.member.controller.MemberControllerImpl;
import chap19.member.window.DelMemDialog;
import chap19.member.window.RegMemDialog;

public class ExecuteAppTestDialog {

	public static void main(String[] args) {
		// 다이얼로그 창 이용
		MemberControllerImpl controller = new MemberControllerImpl();
		System.out.println("1. membercotrollor: "+controller);
		
		// 메인 창
		
		// 회원 조회
		
		// 회원 등록
		new RegMemDialog(controller, "회원 등록");
		
		// 회원 수정

		// 회원 삭제
		new DelMemDialog(controller, "회원 삭제");
		
	}
}
