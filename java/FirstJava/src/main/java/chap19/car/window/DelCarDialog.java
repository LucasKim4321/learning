package chap19.car.window;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import chap19.member.controller.MemberController;
import chap19.member.vo.MemberVO;

public class DelCarDialog extends JDialog {
	// 회원 정보 등록 화면
	
	// 회원 정보 등록 요청 객체
	MemberController memberController;
	
	// 화면 구성 요소 객체
	JPanel jPanel, searchPanel, btnPanel;
	JLabel lSearchId, lId, lName, lPassword, lAddress, lPhoneNum;
	JTextField tfId, tfName, tfPassword, tfAddress, tfPhoneNum;
	JTextField tfSearch;
	JButton btnSearch, btnDelete, btnCancel;

	// 생성자	
	public DelCarDialog(MemberController memberController, String str) {
		
		this.memberController = memberController;
				
		setTitle(str);
		init(); // 화면 요소 객체 생성 메서드 호출
	}

	private void init() {

		searchPanel = new JPanel();
		lSearchId	= new JLabel("아이디 입력");
		tfSearch	= new JTextField(20);
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
		searchPanel.add(lSearchId);
		searchPanel.add(tfSearch);
		searchPanel.add(btnSearch);
		
		btnPanel = new JPanel();
		btnDelete = new JButton("삭제");
		btnCancel = new JButton("취소");
		
		btnPanel.add(btnDelete);
		btnPanel.add(btnCancel);
		btnSearch.addActionListener(new MemberBtnHandler());   // 이벤트 리스너 추가
		btnDelete.addActionListener(new MemberBtnHandler());
		btnCancel.addActionListener(new MemberBtnHandler());

		
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

		tfId. setEnabled(false);
		tfPassword. setEnabled(false);
		tfName. setEnabled(false);
		tfAddress. setEnabled(false);
		tfPhoneNum. setEnabled(false);
		
		add(searchPanel, BorderLayout.NORTH);
		add(jPanel, BorderLayout.CENTER);
		add(btnPanel, BorderLayout.SOUTH);
		
		setLocation(400,200);
		setSize(400,400);
		pack();  // 창 크기를 알맞게 조정
		setModal(true);
		setVisible(true);
	}
	class MemberBtnHandler implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			if (e.getSource() == btnSearch) {  // 조회 버튼 동작
				String searchId = tfSearch.getText().trim();
				
				if (searchId != null && searchId.length() != 0) {
					
					// 조회 요청
					MemberVO searchedVO = memberController.checkId(searchId);
					
					if(searchedVO.getMemId() != null) {  // 검색결과 값이 있을 경우
						
						tfId.setText(searchedVO.getMemId());
						tfPassword.setText(searchedVO.getMemPassword());
						tfName.setText(searchedVO.getMemName());
						tfAddress.setText(searchedVO.getMemAddress());
						tfPhoneNum.setText(searchedVO.getMemPhoneNum());
						
					} else {  // 없을 경우
						showMessage("아이디가 존재하지 않습니다.", -1);
					}
					
				} else {
					showMessage("검색 할 아이디를 입력해주세요.", -1);
				}
				tfSearch.setText("");  // 클리어 안하면 화면에 찌거기 데이터가 남음
				
			} else if(e.getSource() == btnDelete) {
				// 화면에 있는 값을 변수로 저장
				String id 		= tfId.getText().trim();
				String password = tfPassword.getText().trim();
				String name 	= tfName.getText().trim();
				String address 	= tfAddress.getText().trim();
				String phoneNum = tfPhoneNum.getText().trim();
				
				MemberVO vo = MemberVO.builder().memId(id).memPassword(password).memName(name).memAddress(address).memPhoneNum(phoneNum).build();
				System.out.println("delete memberVO:"+vo);
				
				// 회원 정보 DB수정 요청
				int result = memberController.removeMember(vo);  // 애초에 id가 서버에서 primary 설정이라 중복이면 안만들어지긴 함
				System.out.println("result: "+result);  // 만들기 성공하면 1 실패하면 0
				
				if (result > 0) {
					showMessage("회원을 삭제했습니다.",result);
				
				} else {
					showMessage("회원 삭제 실패",result);
				}
				
			} else if (e.getSource()==btnCancel){//삭제 
				dispose();
				return;
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
