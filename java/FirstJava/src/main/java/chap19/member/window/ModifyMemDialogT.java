package chap19.member.window;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.attribute.AclFileAttributeView;
import java.util.Optional;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import chap19.member.controller.MemberController;
import chap19.member.vo.MemberVO;

public class ModifyMemDialogT extends JDialog{
	JPanel panelSearch, panelBtn;
	JLabel lMemName;
	JTextField tf;
	
	// 특정 아이디에 해당되는 회원 정보 UI객체
	JPanel panelMember;
	JLabel lId, LName, lPassword, lAdddress, lPhoneNum;
	JTextField tfId, tfName, tfPassword, tfAddress, tfPhoneNum;
	
	
	JButton btnSearch;
	JButton btnSave;
	JButton btnCancel;
	
	MemberController memberController;
	
	public ModifyMemDialogT(MemberController memberController, String title ) {
		this.memberController = memberController;
		
		setTitle(title);
		init();
	}
	
	public void init() {
		panelSearch = new JPanel();
		panelBtn = new JPanel();
		
		lMemName = new JLabel("아이디");
		tf = new JTextField(15);
		btnSearch = new JButton("조회하기");
		
		// 검색에 관련 UI Panel
		panelSearch.add(lMemName);
		panelSearch.add(tf);
		panelSearch.add(btnSearch);
		
		btnSave 	= new JButton("저장");
		btnCancel 	= new JButton("취소");
		
		// 버튼에 관련 UI Panel
		panelBtn.add(btnSave);
		panelBtn.add(btnCancel);
		
		
		// 회원정보 UI객체 생성
		lId = new JLabel("아이디");
		LName = new JLabel("비밀번호");
		lPassword = new JLabel("이름");
		lAdddress = new JLabel("주소");
		lPhoneNum = new JLabel("전화번호");
		
		tfId = new JTextField(20);
		tfName = new JTextField(20);
		tfPassword = new JTextField(20);
		tfAddress = new JTextField(20);
		tfPhoneNum = new JTextField(20);
		
		panelMember = new JPanel(new GridLayout(0, 2));
		
		panelMember.add(lId);
		panelMember.add(tfId);
		
		panelMember.add(lPassword);
		panelMember.add(tfPassword);
		
		panelMember.add(LName);
		panelMember.add(tfName);
		
		panelMember.add(lAdddress);
		panelMember.add(tfAddress);
		
		panelMember.add(lPhoneNum);
		panelMember.add(tfPhoneNum);
		
		
		// 버튼 이벤트 리스너 등록
		btnSearch.addActionListener(new MemberBtnHandler());
		btnSave.addActionListener(new MemberBtnHandler());
		btnCancel.addActionListener(new MemberBtnHandler());
		
		// 각 panel을 대화창(JDialog)에 배치
		add(panelSearch, BorderLayout.NORTH);
		add(panelMember, BorderLayout.CENTER);
		add(panelBtn, BorderLayout.SOUTH);
		
		setLocation(300,100);	// 다이얼로그 출력 위치
		setSize(600,300); 		// 창의 크기
		setModal(true); 		// 항상 부모창 위에 표시
		setVisible(true);		// 대화창을 화면에 표시
		
		
		
	}
	
	// 버튼에 대한 이벤트 핸들러 구현
	class MemberBtnHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if (e.getSource()==btnSearch) {// 조회버튼
				System.out.println("조회버튼");
				
				String id = tf.getText().trim();
				MemberVO vo = MemberVO.builder().memId(id).build();
				
				MemberVO memVO = memberController.checkId(vo.getMemId());

				if (memVO.getMemId() != null ) {
					//System.out.println(memVO);
					tfId.setText(memVO.getMemId()); 
					tfName.setText(memVO.getMemName());
					tfPassword.setText(memVO.getMemPassword());
					tfAddress.setText(memVO.getMemAddress());
					tfPhoneNum.setText(memVO.getMemPassword());
			
					
				} else if (memVO.getMemId() == null){
					messge("등록되지 않은 아이디 입니다.");
				}
				
			} else if (e.getSource()==btnSave){// 저장, 
				//System.out.println("저장버튼");
				// 화면에 있는 값을 객체로 저장
				String id 		= tfId.getText().trim();
				String password = tfPassword.getText().trim();
				String name 	= tfName.getText().trim();
				String address 	= tfAddress.getText().trim();
				String phoneNum = tfPhoneNum.getText().trim();
				
				MemberVO vo = MemberVO.builder()
						.memPassword(password)
						.memId(id)
						.memName(name)
						.memAddress(address)
						.memPhoneNum(phoneNum)
						.build();
				System.out.println("modify memberVO:"+vo);
				
				// ID중복체크: 객체에 널(null) 허용하는 타입

				memberController.modMember(vo);

				
			} else if (e.getSource()==btnCancel){//삭제 
				dispose();
				return;
			}
		} // end 
		
	} // end inner class
	
	// 메시지 전달한 메서드
	private void messge(String msg) {
		JOptionPane.showMessageDialog(this, msg, "메시지 박스", JOptionPane.INFORMATION_MESSAGE);
	}

}
