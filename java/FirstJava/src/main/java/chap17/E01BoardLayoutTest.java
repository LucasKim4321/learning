package chap17;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class E01BoardLayoutTest {

	public static void main(String[] args) {

		// BoardLayout
		/*
		 Object -> Component, MenuComponent -> MenuItem, MenuBar ...
		 Container -> Window, Panel
		 Window -> Frame, Dialog
		 Panel -> Applet
		 Button, Choice, List, Label, Checkbox, Scrollbar ...
		 */
		
		Frame frame;
		Button center, west, east, north, south;
		TextField tf1;
		
		frame = new Frame("BoarderLayout 예제");
		south = new Button("South");
		east = new Button("East");
		west = new Button("West");
		center = new Button("Center");
		
		tf1 = new TextField("입력창입니다.");
		
		// 정렬방식 기본값 BorderLayout  =>  frame.setLayout(new BorderLayout());
		frame.add(tf1,BorderLayout.NORTH);  // BorderLayout.NORTH 프레임 위쪽에 배치
		frame.add(south,BorderLayout.SOUTH);  // 아래
		frame.add(west,BorderLayout.WEST);  // 왼쪽
		frame.add(east,BorderLayout.EAST);  // 오른쪽
		frame.add(center,BorderLayout.CENTER);  // 가운데

		frame.addWindowListener(new WindowHandler());
		frame.setLocation(0,0);
		frame.setSize(400,200);  // 프레임 크기  setSize(가로,세로)
		frame.setVisible(true);  // 프레임 표시  true 표시하는 프로그램을 띄움  지정을하지 않거나 false하면 프로그램이 돌아가진 않고 메모리 상에서만 돌아감.
		
		System.out.println("-- FlowLayout");
		Frame frame2;
		Button btn1, btn2, btn3;
		
		frame2 = new Frame("FlowLayout 예제");
		btn1 = new Button("OK");
		btn2 = new Button("Open");
		btn3 = new Button("Close");
		
		frame2.setLayout(new FlowLayout());  //  setLayout(배치방식)   FlowLayout()  가로 방식
		frame2.add(btn1);
		frame2.add(btn2);
		frame2.add(btn3);
		

		frame2.addWindowListener(new WindowHandler());
		frame2.setLocation(400,0);
		frame2.setSize(200,100);  // 프레임 크기  setSize(가로,세로)
		frame2.setVisible(true);  // 프레임 표시
		
		System.out.println("-- GridLayout 예문: 테이블 형태 배치");
		Frame frame3;
		Button btn4, btn5, btn6;
		TextField tf01, tf02, tf03;
		
		frame3 = new Frame("GridLayout 예제");
		
		btn4 = new Button("btn4");
		btn5 = new Button("btn5");
		btn6 = new Button("btn6");
		
		tf01 = new TextField("입력창1");
		tf02 = new TextField("입력창2");
		tf03 = new TextField("입력창3");
		
		// 배치할 요소의 행, 열
		frame3.setLayout(new GridLayout(3,3));  //  3행은 고정 열은 변동됨  반대로 지정하면 반대로 
		
		frame3.add(btn4);
		frame3.add(tf01);
		
		frame3.add(btn5);
		frame3.add(tf02);
		
		frame3.add(btn6);
		frame3.add(tf03);

		frame3.addWindowListener(new WindowHandler());
		frame3.pack();  // 컴포넌트 크기 일치하도록 설정
		frame3.setLocation(600,0);
		frame3.setVisible(true);
		

		System.out.println("-- GridLayout 예문: 테이블 형태 배치");
		Frame frame4;
		Button btnOk, btnCancel;
		TextField txt;
		Panel panel;
		
		frame4 = new Frame("GridLayout 예제");
		
		btnOk = new Button("OK");
		btnCancel = new Button("Cancel");
		txt = new TextField("입력창");
		
		panel = new Panel();
		
		frame4.add(txt, BorderLayout.NORTH);
		
		panel.setBackground(Color.green);
		panel.add(btnOk);
		panel.add(btnCancel);

		frame4.add(panel, BorderLayout.CENTER);  // CENTER만 다른 자리에 아무거도 없으면 모든 빈자리 차지
		
		frame4.addWindowListener(new WindowHandler());
		frame4.setLocation(750,0);
		frame4.setSize(400,400);
		frame4.setVisible(true);
		
		
		
	}

	public static class WindowHandler extends WindowAdapter {
		@Override
		public void windowClosing(WindowEvent e) {
			System.out.println("윈도우 창 닫기");
			System.exit(0);  // 창 닫음  // Frame단위가 한묶음?
		}
	}
}


