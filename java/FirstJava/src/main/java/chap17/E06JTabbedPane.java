package chap17;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class E06JTabbedPane {

	JFrame jFrame;
	JTabbedPane jTab;
	ImageIcon icon1, tabicon;
	JButton btn1,btn2;
	JLabel jLab;
	
	JPanel jPan;
	
	JTextField tf1;
	JTextArea tArea;
	
	public void createFrame() {
		jFrame = new JFrame("JTab 테스트");
		icon1 = new ImageIcon("C:\\javaStudy\\learning\\images\\frog (1).jpg");  // 원본 크기로 나옴
		
		jLab = new JLabel(icon1);
		
		tabicon = new ImageIcon("src/main/resources/frog (2).png");  // 원본 크기로 나옴
		

		// 패널에 요소 추가
		jPan = new JPanel();
		tf1 = new JTextField("테스트");
		btn1 = new JButton("전송");
		jPan.add(tf1);
		jPan.add(btn1);
		
		tArea = new JTextArea(7,20);
		tArea.setText("내용을 입력하세요.");
		
		jTab = new JTabbedPane();
		jTab.addTab("탭1", jLab);
		jTab.addTab("탭2", new JPanel().add(tArea));
		jTab.addTab("탭3", tabicon, jPan, "세 번째 탭");
		
		jFrame.add(jTab);
		
		jFrame.setPreferredSize(new Dimension(500,500));
		jFrame.pack();
		
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setVisible(true);
		
		
	}
	
	public static void main(String[] args) {
		// JTabbedPane: 탭 컴포넌트
		E06JTabbedPane jTabbed = new E06JTabbedPane();
		jTabbed.createFrame();

	}

}
