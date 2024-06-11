package chap17;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class E04AwtEventTest03 {

	private Frame frame;
	private Button btn1, btn2, btn3, btn4,btn5;
	
	public E04AwtEventTest03() {
		frame = new Frame("익명클래스로 이벤트 핸들러 구현");
		btn1 = new Button("btn1");
		btn2 = new Button("btn2");
		btn3 = new Button("btn3");
		btn4 = new Button("btn4");
		btn5 = new Button("btn5");
	}
	
	public static void main(String[] args) {
		// 익명 클래스로 이벤트 핸들러 구현
		E04AwtEventTest03 awtEventTest = new E04AwtEventTest03();
		awtEventTest.startFrame();
		
	}
	
	public void startFrame() {
		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("버튼1 클릭");				
			}
		});
		btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("버튼2 클릭");				
			}
		});
		btn3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("버튼3 클릭");				
			}
		});
		btn4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("버튼4 클릭");				
			}
		});
		btn5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("버튼5 클릭");				
			}
		});
		
		frame.add(btn1, BorderLayout.NORTH);
		frame.add(btn2, BorderLayout.SOUTH);
		frame.add(btn3, BorderLayout.WEST);
		frame.add(btn4, BorderLayout.EAST);
		frame.add(btn5, BorderLayout.CENTER);
		
		frame.setSize(400,400);
		frame.setVisible(true);
		
		frame.addWindowListener(new WindowHandler());
	}
//	public static class WindowHandler extends WindowAdapter {
//		@Override
//		public void windowClosing(WindowEvent e) {
//			System.out.println("윈도우 창 닫기");
//			System.exit(0);  // 창 닫음  // Frame단위가 한묶음?
//		}
//	}
	
	public static class WindowHandler implements WindowListener {

		@Override
		public void windowOpened(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowClosing(WindowEvent e) {
			System.out.println("윈도우 창 닫기");
			System.exit(0);  // 창 닫음  // Frame단위가 한묶음?
			
		}

		@Override
		public void windowClosed(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowIconified(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowDeiconified(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowActivated(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowDeactivated(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}

}
