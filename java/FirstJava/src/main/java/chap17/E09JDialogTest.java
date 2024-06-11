package chap17;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class E09JDialogTest extends JFrame {

	JLabel label = new JLabel("다이얼로그 테스트");
	JButton btn1 = new JButton("첫번째 다이얼로그 띄우기");
	JButton btn2 = new JButton("두번째 다이얼로그 띄우기");
	
	public E09JDialogTest() {
		setTitle("다이얼로그 테스트");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(3,0));
		
		getContentPane().add(label);
		getContentPane().add(btn1);
		getContentPane().add(btn2);
		
		setLocation(500,500);
		setSize(500,300);
		setVisible(true);
		
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Dialog1(e.getActionCommand()+" 첫번째 다이얼로그");
			}
		});
		
		btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Dialog2(label, "두번째 다이얼로그");
			}
		});
	}
	
	
	public static void main(String[] args) {
		// JDialog: 팝업 창 기능
		new E09JDialogTest();
		
	}

}

class Dialog1 extends JDialog {
	ImageIcon icon1;
	JLabel dlb = new JLabel("");
	
	public Dialog1(String str) {
		getContentPane().add(dlb);
		icon1 = new ImageIcon("C:\\javaStudy\\learning\\images\\frog (1).jpg");
		dlb.setIcon(icon1);
		
		setTitle(str);
		setLocation(200,100);
		setSize(400,400);
		setVisible(true);
		setModal(true);
	}
	
}

class Dialog2 extends JDialog {
	JTextField tf = new JTextField(10);
	JButton okButton = new JButton("OK");
	
	public Dialog2(JLabel label, String string) {
		setLayout(new FlowLayout());
		add(tf);
		add(okButton);
		
		setTitle("입력 다이얼로그창");
		setSize(400,400);
		setLocation(600,100);
		setVisible(true);
		setModal(true);
		
		okButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String text = tf.getName();
				label.setText(text);
				dispose();
			}
		});
	}
	
}
