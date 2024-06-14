package chap19.member.window;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import chap19.member.controller.MemberController;
import chap19.member.vo.MemberVO;
import chap19.member.window.ModMemDialog1.MemberBtnHandler;

public class ModMemDialog extends JDialog {
	// 회원 정보 등록 화면
	
	// 회원 정보 등록 요청 객체
	MemberController memberController;
	
	// 화면 구성 요소 객체
	JPanel jPanel, panelSearch;
	JLabel lSearchId, lId, lName, lPassword, lAddress, lPhoneNum;
	JTextField tfSearch, tfId, tfName, tfPassword, tfAddress, tfPhoneNum;
	JButton btnSearch, btnModify ;

	// 생성자	
	public ModMemDialog(MemberController memberController, MemberVO memberVO, String str) {
		System.out.println("2. membercotrollor: "+memberController);
		
		this.memberController = memberController;
		
		System.out.println("3. membercotrollor: "+memberController);
		
		setTitle(str);
		init(memberVO); // 화면 요소 객체 생성 메서드 호출
	}

	private void init(MemberVO memberVO) {

		panelSearch = new JPanel();
		lSearchId	= new JLabel("아이디 입력");
		tfSearch	= new JTextField("");
		btnSearch   = new JButton("조회");
		
		lId 		= new JLabel("아이디");
		lPassword 	= new JLabel("비밀번호");
		lName 		= new JLabel("이름");
		lAddress 	= new JLabel("주소");
		lPhoneNum 	= new JLabel("전화번호");
		
		tfId		= new JTextField(20);
		tfPassword 	= new JTextField(20);
		tfName 		= new JTextField(20);
		tfAddress 	= new JTextField(20);
		tfPhoneNum 	= new JTextField(20);
		

		// 검색에 관련 UI Panel
		panelSearch.add(lSearchId);
		panelSearch.add(tfSearch);
		panelSearch.add(btnSearch);
		
		tfId.setText(memberVO.getMemId());
		tfPassword.setText(memberVO.getMemPassword());
		tfName.setText(memberVO.getMemName());
		tfAddress.setText(memberVO.getMemAddress());
		tfPhoneNum.setText(memberVO.getMemPhoneNum());
			
		
		btnModify = new JButton("수정하기");
		btnSearch.addActionListener(new MemberBtnHandler());
		btnModify.addActionListener(new MemberBtnHandler());   // 이벤트 리스너 추가

		
		jPanel = new JPanel(new GridLayout(0,2));
		
		jPanel.add(lId);
		jPanel.add(tfId);

		jPanel.add(lPassword);
		jPanel.add(tfPassword);

		jPanel.add(lName);
		jPanel.add(tfName);

		jPanel.add(lAddress);
		jPanel.add(tfAddress);

		jPanel.add(lPhoneNum);
		jPanel.add(tfPhoneNum);
		
		add(jPanel, BorderLayout.NORTH);
		add(btnModify, BorderLayout.SOUTH);
		
		setLocation(400,200);
		setSize(400,400);
		setModal(true);
		setVisible(true);
	}
	class MemberBtnHandler implements ActionListener {

		// 화면에 있는 값을 변수로 저장
		String id 		= tfId.getText().trim();
		String password = tfPassword.getText().trim();
		String name 	= tfName.getText().trim();
		String address 	= tfAddress.getText().trim();
		String phoneNum = tfPhoneNum.getText().trim();
		
		MemberVO vo = new MemberVO(id, password, name, address, phoneNum);

		@Override
		public void actionPerformed(ActionEvent e) {
			// 회원 정보 DB수정 요청
			int result = memberController.modMember(vo);  // 애초에 id가 서버에서 primary 설정이라 중복이면 안만들어지긴 함
			System.out.println("result: "+result);  // 만들기 성공하면 1 실패하면 0
			
			if (result > 0) {
				showMessage("새 회원을 수정했습니다.",result);
			
			} else {
				showMessage("회원 수정 실패",result);
			}
			
		}
	}

	// 메시지 전달 창
	private void showMessage(String msg, int result) {

		if (result > 0) {
			JOptionPane.showMessageDialog(this,msg,"메시지박스",JOptionPane.INFORMATION_MESSAGE);

		} else {
			JOptionPane.showMessageDialog(this,msg,"메시지박스",JOptionPane.WARNING_MESSAGE);
			
		}
		
	}

}
