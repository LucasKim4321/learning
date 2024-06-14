package chap19.member.window;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import chap19.member.controller.MemberController;
import chap19.member.vo.MemberVO;

public class RegMemDialog extends JDialog {
	// 회원 정보 등록 화면
	
	// 회원 정보 등록 요청 객체
	MemberController memberController;
	
	// 화면 구성 요소 객체
	JPanel jPanel;
	JLabel lId, lName, lPassword, lAddress, lPhoneNum;
	JTextField tfId, tfName, tfPassword, tfAddress, tfPhoneNum;
	JButton btnReg;

	// 생성자	
	public RegMemDialog(MemberController memberController, String str) {
		System.out.println("2. membercotrollor: "+memberController);
		
		this.memberController = memberController;
		
		System.out.println("3. membercotrollor: "+memberController);
		
		setTitle(str);
		init(); // 화면 요소 객체 생성 메서드 호출
	}

	private void init() {
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
		
		btnReg = new JButton("회원등록하기");
		btnReg.addActionListener(new ActionListener() {  // 이벤트 리스너 추가
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 화면에 있는 값을 변수로 저장
				String id 		= tfId.getText().trim();
				String password = tfPassword.getText().trim();
				String name 	= tfName.getText().trim();
				String address 	= tfAddress.getText().trim();
				String phoneNum = tfPhoneNum.getText().trim();
				
				MemberVO vo = new MemberVO(id, password, name, address, phoneNum);
				
				// optional**
				// ID중복체크: 객체에 널(null) 허용하는 타입
//				Optional<MemberVO> checkIdVO =  Optional.ofNullable(memberController.checkId(id));
				
				// ID중복체크
				MemberVO checkIdVO = memberController.checkId(id);  // id가 중복이 아니면 null(검색이 안되서) 중복이면 Id값이 들어있음(검색이 됬으니까)
				System.out.println("checkIdVO.getMemId(): "+checkIdVO.getMemId());

				if (checkIdVO.getMemId() == null) {  // 중복이 아닐시: null이면 중복아님
					// 회원 정보 DB등록 요청
					int result = memberController.regMember(vo);  // 애초에 id가 서버에서 primary 설정이라 중복이면 안만들어지긴 함
					System.out.println("result: "+result);  // 만들기 성공하면 1 실패하면 0
					
					if (result > 0) {
						showMessage("새 회원을 등록했습니다.",result);
					
					} else {
						showMessage("회원 등록 실패",result);
					}
				} else {  // id가 중복일 경우
					showMessage("사용중인 id입니다.",-1);
				}
				
			}  // end actionPerformed()
		});  // end ActionListener()
		
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
		add(btnReg, BorderLayout.SOUTH);
		
		setLocation(400,200);
		setSize(400,400);
		setModal(true);
		setVisible(true);
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
