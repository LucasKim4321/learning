package chap17;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class E07JOptionTest extends JFrame implements ActionListener{

	JButton btn1, btn2, btn3, btn4;
	String[] str = {"카드결제", "계좌이체"};
	ImageIcon img1;
	JLabel jLab;
	
	public E07JOptionTest() {
		super("여러가지 메시지 박스 테스트");  // 창의 제목
		setLayout(new FlowLayout());  // 가로 방향으로 배치
		
		btn1 = new JButton("출력 메시지 박스");
		btn2 = new JButton("확인 메시지 박스");
		btn3 = new JButton("입력 메시지 박스");
		btn4 = new JButton("선택 메시지 박스");
		img1 = new ImageIcon("C:\\javaStudy\\learning\\images\\frog (1).jpg");
		jLab = new JLabel(img1);
		
		// 현재클래스(프레임 기능을 가진 클래스)
//		add(btn1);add(btn2);add(btn3);add(btn4);
		add(btn1, BorderLayout.NORTH);
		add(btn2, BorderLayout.EAST);
		add(btn3, BorderLayout.WEST);
		add(btn4, BorderLayout.CENTER);
		add(jLab, BorderLayout.SOUTH);
//		add(img1);

		setLocation(300,300);
		setSize(600,400);
//		setPreferredSize(new Dimension(600,400));
//		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);
		
	}
	
	public static void main(String[] args) {
		// JOptionPane : 간단한 메시지를 입력받거나 경고를 출력
		new E07JOptionTest();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn1) {
			JOptionPane.
			showMessageDialog(  // 사용자 메시지 박스
					this,
					"출력 메시지 박스", // 메시지
					"메시지",  // 창제목
					JOptionPane.INFORMATION_MESSAGE  //아이콘
					);
		} else if (e.getSource() == btn2) {
			JOptionPane.
			showMessageDialog(  // YES,NO,CANCEL과 같은 버튼으로 확인하는 메시지 박스
					this,
					"확인 메시지 박스", // 메시지
					"확인",  // 창제목
					JOptionPane.YES_NO_CANCEL_OPTION  //아이콘
					);
			
		} else if (e.getSource() == btn3) {
			JOptionPane.showInputDialog(  ///  사용자로부터 자료를 입력받기 위한 메시지 박스
					this,
					"입력 메시지 박스", // 메시지
					"입력",  // 창제목
					JOptionPane.YES_NO_OPTION  //아이콘)
					);
			
		} else if (e.getSource() == btn4) {
			JOptionPane.showOptionDialog(  // 위 세가지를 포함하여 맞춘 메시시지 박스
					this,
					"선택 메시지 박스", // 메시지
					"옵션",  // 창제목
					JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.INFORMATION_MESSAGE,
					null,
					str,
					str[0]
					);
			
		}
		
	}

}
