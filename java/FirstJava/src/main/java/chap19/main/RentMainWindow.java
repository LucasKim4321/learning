package chap19.main;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

import chap19.common.base.AbstractBaseWindow;
import chap19.member.controller.MemberController;
import chap19.member.window.RegMemDialog;

public class RentMainWindow extends AbstractBaseWindow {  // JFrame 기능을 가진 클랙스 상속

	JFrame frame;  // ?
	
	// 메뉴를 등록하는 메뉴바
	JMenuBar menuBar;
	
	// 메인 메뉴 항목
	JMenu carMenu, memberMenu, resMenu, helpMenu;
	
	// 메뉴에 등록되는 메뉴 항목 (서브메뉴)
	JMenuItem carMenu11, carMenu12, carMenu13, carMenu14;
	JMenuItem memMenu21, memMenu22, memMenu23, memMenu24;
	JMenuItem resMenu31, resMenu32, resMenu33, resMenu34;
	JMenuItem helpMenu41;
	
	JPanel jPanel;
	JLabel lCarName;
	JTextField tf;
	JButton btnSearch;
	JComboBox comboBox;  // 검색 조건 설정
	
	// MemberController
	MemberController memberController;
	
	// CarController
	// ResController
	
	public RentMainWindow() {
		setTitle("렌트카 조회/예약 시스템");
		
		menuBar = new JMenuBar();
		carMenu = new JMenu("차량 관리");
		memberMenu = new JMenu("회원 관리");
		resMenu = new JMenu("예약 관리");
		helpMenu = new JMenu("도움말");
	}
	
	// 서브메뉴 생성 메서드
	protected void startFrame() {
		// 현재 프레임(윈도우창)에 메뉴바를 설정
//		frame.setJMenuBar(menuBar);
		this.setJMenuBar(menuBar);  // this는 현재 frame 의미  위에 거랑 같음
		
		// 1. 회원 관리
		menuBar.add(memberMenu);
		memberMenu.add(memMenu21 = new JMenuItem("회원등록"));
		memberMenu.add(memMenu22 = new JMenuItem("회원조회"));
		memberMenu.addSeparator();  // 구분선 삽입
		memberMenu.add(memMenu23 = new JMenuItem("회원수정"));
		memberMenu.add(memMenu24 = new JMenuItem("회원삭제"));
		
		// 2. 차량 관리
		menuBar.add(carMenu);
		carMenu.add(carMenu11 = new JMenuItem("차량등록"));
		carMenu.add(carMenu12 = new JMenuItem("차량조회"));
		carMenu.addSeparator();  // 구분선 삽입
		carMenu.add(carMenu13 = new JMenuItem("차량수정"));
		carMenu.add(carMenu14 = new JMenuItem("차량삭제"));
		
		// 3. 예약 관리
		menuBar.add(resMenu);
		resMenu.add(resMenu31 = new JMenuItem("예약등록"));
		resMenu.add(resMenu32 = new JMenuItem("예약조회"));
		resMenu.addSeparator();  // 구분선 삽입
		resMenu.add(resMenu33 = new JMenuItem("예약수정"));
		resMenu.add(resMenu34 = new JMenuItem("예약삭제"));
		
		// 4. 도움말
		menuBar.add(helpMenu);
		helpMenu.add(helpMenu41 = new JMenuItem("버전"));
		
		jPanel = new JPanel();
		lCarName = new JLabel("차량번호");
		tf = new JTextField(10);
		
		comboBox = new JComboBox();
		comboBox.addItem("차량번호");
		comboBox.addItem("차량색상");
		comboBox.addItem("배기량");
		comboBox.addItem("제조사");
		
		btnSearch = new JButton("차량 조회하기");
		// 리스너 등록
		
		jPanel.add(lCarName);
		jPanel.add(tf);
		jPanel.add(comboBox);
		jPanel.add(btnSearch);
		
		Container con = getContentPane();
		con.add(jPanel,"North");  // North 대신 north넣으면 에러   빨간줄은 안생기지만 실행시 에러
		
		// 윈도우 창 설정
		setLocation(200,100);
		setSize(800,600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
	}
	
	public static void main(String[] args) {
		RentMainWindow rentCar = new RentMainWindow();
		rentCar.startFrame();
		
	}
	
	// ----------------------- //
	// 내부클래스에 이벤트핸들러 처리
	// ----------------------- //
	
	// 회원관리
	class MemberHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				System.out.println(e.getActionCommand());
				
				if(e.getSource() == memMenu21) {
					new RegMemDialog(memberController, "회원 등록창: ");
					
				} else if (e.getSource() == memMenu22) {
					
				} else if (e.getSource() == memMenu23) {
					
				} else if (e.getSource() == memMenu24) {
					
				}
				
			} catch (Exception e2) {System.out.println(e2.getMessage());
			}
		}
		
	}
	// 차량관리
	// 예약관리
	// 도움말
	
}
