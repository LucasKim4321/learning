package chap17;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class E08JMenuTest {
	
	JFrame frame;
	JMenuBar menuBar;
	JMenu carMenu, memberMenu, rentMenu, helpMenu;
	JMenuItem carMenu11, carMenu12, carMenu13, carMenu14;
	JMenuItem memMenu21, memMenu22, memMenu23, memMenu24;
	JMenuItem helpMenu41;
	
	JPanel jPanel;
	JLabel lCarname;
	
	JTextField tf;
	JButton searchBtn;

	public E08JMenuTest() {
		frame = new JFrame("렌터카 예약 시스템");
		
		menuBar = new JMenuBar();
		
		carMenu = new JMenu("차량 관리");
		memberMenu = new JMenu("회원 관리");
		rentMenu = new JMenu("예약 관리");
		helpMenu = new JMenu("도움말");
	}
	
	public void createFrame() {
		frame.setJMenuBar(menuBar);  // 프레임에 메뉴바 설정
		menuBar.add(carMenu);  // 메뉴바에 메뉴 설정
		carMenu.add(carMenu11 = new JMenuItem("차량 등록"));  // 메뉴에 메뉴 항목 설정
		carMenu.add(carMenu12 = new JMenuItem("차량 조회"));
		carMenu.add(carMenu13 = new JMenuItem("차량 수정"));
		carMenu.add(carMenu14 = new JMenuItem("차량 삭제"));
		carMenu.addSeparator();  // 메뉴 구분선
		
		menuBar.add(memberMenu);
		
		memberMenu.add(memMenu21 = new JMenuItem("회원 등록"));
		memberMenu.add(memMenu22 = new JMenuItem("회원 조회"));
		memberMenu.addSeparator();  // 메뉴 구분선
		memberMenu.add(memMenu23 = new JMenuItem("회원 수정"));
		memberMenu.add(memMenu24 = new JMenuItem("회원 삭제"));

		menuBar.add(rentMenu);
		
		menuBar.add(helpMenu);
		helpMenu.add(helpMenu41 = new JMenuItem("버전"));
		
		jPanel = new JPanel();
		lCarname = new JLabel("차량명");
		
		tf = new JTextField(15);  // JTextField() ()안에 기본값("문자열" 또는 숫자) 넣기가능
		
		searchBtn = new JButton("차량 조회하기");
		
		// 프레임 자체에 있는 메뉴바영역은 별도로 추가하지 않고 **
		
		jPanel.add(lCarname);
		jPanel.add(tf);
		jPanel.add(searchBtn);
		
		Container con = frame.getContentPane();
		con.add(jPanel, BorderLayout.NORTH);

		frame.setLocation(500,500);
		frame.setSize(800,600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		// JMenuBar -> JMenu -> JMenuItem
		E08JMenuTest jMenuTest = new E08JMenuTest();
		jMenuTest.createFrame();
	}

}
