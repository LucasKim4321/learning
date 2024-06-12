package chap18;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.List;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import chap18.controller.MovieController;

public class E01MovieWindowView extends JFrame implements ActionListener {
	
	String resultMsg = null;
	
	JTextField tMovieTitle;
	JButton btnTitleInsert, btnSave, btnExit, btnDelete;
	List movieList;
	
//	DefaultListModel model = new DefaultListModel();
//	JList movieList = new JList(model);
	
	MovieController controller;
	
	public E01MovieWindowView() {
		super("영화정보 관리 화면");
		
		controller = new MovieController();
		
		// 컴포넌트 객체 생성
		tMovieTitle = new JTextField(30);
		btnTitleInsert = new JButton("영화제목 추가");
		btnSave = new JButton("영화제목 파일 저장");
		btnDelete = new JButton("영화제목 파일 삭제");
		
		movieList = new List();
		btnExit = new JButton("종료");
		
		//컴포넌트 설정
		movieList.setBackground(Color.LIGHT_GRAY);
		
		Panel p = new Panel();
		p.add(new JLabel("영화제목 입력"));
		p.add(tMovieTitle);
		p.add(btnTitleInsert);
		p.add(btnSave);
		p.add(btnDelete);
		
		add(BorderLayout.NORTH, p);
		add(BorderLayout.CENTER, movieList);
		add(BorderLayout.SOUTH, btnExit);
		
		setBounds(200,200,1000,600);  // setBounds(가로위치,세로위치,가로크기,세로크기)
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// 이벤트 등록 처리
		movieList.addActionListener(this);
		btnTitleInsert.addActionListener(this);
		btnSave.addActionListener(this);
		btnDelete.addActionListener(this);
		btnExit.addActionListener(this);

		
	}

	public static void main(String[] args) {
		// MVC디자인 패턴
		/*
		 * 모델(Model): 데이터베이스 연동이나 파일 저장, 로직 등 실제 기능을 수행
		 * 뷰(View) : 사용자의 요청을 받아들이는 화면으로 요청을 컨트롤러로 전달
		 * 컨트롤러(Controller): View에서 전달된 요청에 맞는 모델을 선택
		 */
		
		E01MovieWindowView movieWindowView = new E01MovieWindowView();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			String mTitle = e.getActionCommand();
			
			System.out.println("이벤트 발생: "+mTitle);
			if (e.getSource() == btnTitleInsert) {
				resultMsg = "영화제목을 추가했습니다.";
//				System.out.println("영화제목 추가하기");
				
				// 텍스트에 입력한 영화제목 읽기
				mTitle = tMovieTitle.getText().trim();
				
				// controller에 추가요청(입력한 영화제목, 현재 영화제목 List)
				controller.addTitle(mTitle, movieList);
				
				tMovieTitle.setText("");  // 입력창 초기화
				
			}
			else if (e.getSource() == btnSave) {
				resultMsg = "영화 제목을 파일에 저장했습니다.";
//				System.out.println("영화 제목을 파일에 저장");
				controller.saveTitles(movieList);
			}
			else if (e.getSource() == btnDelete) {
				resultMsg = "해당 영화 제목을 파일에서 삭제했습니다.";
			}
			else if (e.getSource() == btnExit){
				controller.exitTitles();
				System.exit(1);  // 비정상 종료
//				System.exit(0);  // 정상 종료
			}
			else {
				resultMsg = "해당 영화 제목을 파일에서 삭제했습니다.";
				controller.delTitles(mTitle, movieList);
//				controller.selectTitles();
			}
			
			// JOptionPane.showMessageDialog(
			System.out.println(JOptionPane.INFORMATION_MESSAGE);  // JOptionPane.INFORMATION_MESSAGE == 1  JOptionPane.MESSAGE입력 후 보면 목록 나옴
			JOptionPane.showMessageDialog(this,  resultMsg, "메시지 박스", JOptionPane.INFORMATION_MESSAGE);  // 메시지 타입 1   -1 부터 0포함 3까지 있음 5가지
			
		} catch (Exception e2) {}
		
	}

}

/*
 Button : ActionEvent(클릭), FocusEvent, Key...
 Checkbox : ItemEvent(체크박스, 리스트 항목 선택) ...
 Frame : WindowEvent ...
 List : ActionEvent, ItemEvent ...
 Label : FocusEvent ...
 Choice : ItemEvent ...
 Adjustable : AdjustmentEvent ...
 */
