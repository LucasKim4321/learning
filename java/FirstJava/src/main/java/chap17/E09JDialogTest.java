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
		add(btn1);  // 프레임 영역에 btn1 추가 (현재 보이는건 같지만 getContentPane().add()가 옳다)
		getContentPane().add(btn2);  // 컨텐츠 영역에 btn2 추가
		
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
/*
 * 모달창이란?
 * 화면을 개발할 때 자주 나오는 구성 요소 중 하나가 모달(Modal)창입니다.
 * 팝업(Popup)창과 약간 혼동해서 쓰는 경향이 있는데 Modal 과 Popup는 개념이 다릅니다,
 * 팝업(Popup)은 현재 화면에 다른 화면을 하나의창(Browser)으로 보여주는 기능이고, 
 * 모달(Modal)은 화면 위에 하나의 작은 화면을 더 만들어 부가적인 일들을 처리할 수 있게 만드는 기능입니다. 
 * */
class Dialog1 extends JDialog {
	ImageIcon icon1 = new ImageIcon("C:\\javaStudy\\learning\\images\\frog (1).jpg");;
//	JLabel dlb = new JLabel(icon1);
	JLabel dlb = new JLabel("");
	
	public Dialog1(String str) {
		getContentPane().add(dlb);
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
	
	public Dialog2(JLabel label, String title) {
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
				dispose();  // 다디얼로그 종료
			}
		});
	}
	
}


/*
 frm.add(btn1);
지난 시간에 사용했던 위의 코드는 버튼을 프레임 영역에 붙이는 코드일까요, 컨텐츠 영역에 붙이는 코드일까요?
네, frm이 프레임 객체이기 때문에 프레임 영역에 붙이는 코드입니다. 프레임 영역에 붙여도 결과적으로는 잘 붙었습니다만 원래 컨텐츠 영역에 붙이는 것이 정석입니다.
그래서 코드를 조금 수정하겠습니다.

frm.getContentPane().add(btn1);
중간에 복잡한 영어가 끼었네요^^; 이름에도 알 수 있듯이 컨텐츠 영역을 가져오는 함수입니다. 프레임에서 컨텐츠 영역을 가져와서 거기다가 버튼을 붙이는 방식입니다.
앞으로 프레임에 구성요소를 붙일때 번거롭더라도 중간에 getContentPane()을 넣어주도록 합시다.
자, 이제 레이아웃을 배워봅시다. 레이아웃은 '배치'라는 뜻인데요, 컨텐츠 영역에 부착되는 구성요소들을 어떻게 배치할 건지 정해줄 필요가 있습니다.

이때 사용하는 함수가 바로 setLayout().

frm.setLayout() ....... 노노

frm.getContentPane().setLayout() ......... 이렇게 쓰면 되겠습니다^^

셋 레이아웃 함수의 괄호 속에는 사용하고자 하는 레이아웃의 이름을 적어주면 되는데요, 다양한 레이아웃 중에 '플로우 레이아웃'을 사용해보도록 하겠습니다.


  
  
 */
