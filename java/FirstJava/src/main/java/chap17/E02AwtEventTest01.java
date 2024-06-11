package chap17;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class E02AwtEventTest01 implements ActionListener {
	private Frame frame;
	private Button btn1, btn2, btn3, btn4, btn5;
	
	// 생성자
	
	public E02AwtEventTest01() {
		frame = new Frame("이벤트 핸들러 예제");
		btn1 = new Button("btn1");
		btn2 = new Button("btn2");
		btn3 = new Button("btn3");
		btn4 = new Button("btn4");
		btn5 = new Button("btn5");
	}

	public static void main(String[] args) {
		/*
		 이벤트 소스 : 이벤트를 발생시킨 컴포넌트(button ...)
		 이벤트 리스너: 이벤트 소스가 발생시키는 이벤트를 처리할 수 있는 구현 클래스가 구현할 인터페이스
		 이벤트 핸들러: 이벤트 리스너를 구현할 이벤트를 처리하는 클래스
		 */
		
		E02AwtEventTest01 awtEventTest = new E02AwtEventTest01();
		awtEventTest.starFrame();
	}
	
	public void starFrame() {  // 이벤트 핸들러 처리
		btn1.addActionListener(this);  // btn1에 ActionEvent를 추가함 actionPerformed 실행
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);
		btn5.addActionListener(this);
		
		frame.add(btn1, BorderLayout.NORTH);
		frame.add(btn2, BorderLayout.SOUTH);
		frame.add(btn3, BorderLayout.WEST);
		frame.add(btn4, BorderLayout.EAST);
		frame.add(btn5, BorderLayout.CENTER);
		
		frame.setSize(400,400);
		frame.setVisible(true);
		
		frame.addWindowListener(new WindowHandler());
	}

	@Override
	public void actionPerformed(ActionEvent e) {  // ActionEvent 발생시 실행
		if (e.getSource() == btn1) {
			System.out.println("버튼1 클릭");
			System.out.println("ActionEvent: "+e);
			System.out.println("getActionCommand(): "+e.getActionCommand());
		}
		else if (e.getSource() == btn2) {
			System.out.println("버튼2 클릭");
			System.out.println("ActionEvent: "+e);
			System.out.println("getActionCommand(): "+e.getActionCommand());
		}
		else if (e.getSource() == btn3) {
			System.out.println("버튼3 클릭");
			System.out.println("ActionEvent: "+e);
			System.out.println("getActionCommand(): "+e.getActionCommand());
		}
		else if (e.getSource() == btn4) {
			System.out.println("버튼4 클릭");
			System.out.println("ActionEvent: "+e);
			System.out.println("getActionCommand(): "+e.getActionCommand());
		}
		else if (e.getSource() == btn5) {
			System.out.println("버튼5 클릭");
			System.out.println("ActionEvent: "+e);
			System.out.println("getActionCommand(): "+e.getActionCommand());
			System.out.println("getWhen(): "+(e.getWhen()/1000/60/60/24/365));
		}
		
	}

	public static class WindowHandler extends WindowAdapter {
		@Override
		public void windowClosing(WindowEvent e) {
			System.out.println("윈도우 창 닫기");
			System.exit(0);  // 창 닫음  // Frame단위가 한묶음?
		}
	}

}
