package chap19.member.window;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import chap19.member.controller.MemberController;
import chap19.member.controller.MemberControllerImpl;

public class DelMemDialog {
	// 회원 정보 삭제 화면
	// 조회 후 추가로 삭제 화면 띄움
	
	// 회원 정보 삭제 요청 객체
	MemberController memberController;
	
	// 화면 구성 요소 객체
	JPanel jPanel;
	JLabel lId, lName, lPassword, lAddress, lPhoneNum; 
	JTextField tfId, tfName, tfPassword, tfAddress, tfPhoneNum;
	JButton btnReg;
	
	// 생성자
	public DelMemDialog(MemberController memberController, String str) {
		this.memberController = memberController;  // memberController == new MemberControllerImpl()
		
//		setTitle(str);
		init(); // 화면 요소 객체 생성 메서드 호출
	}

	private void init() {
		lId = new JLabel("삭제 할 아이디 입력: ");
		tfId = new JTextField(20);
		btnReg = new JButton("삭제하기");
//		btnReg.add
		
	}
	
	
}
