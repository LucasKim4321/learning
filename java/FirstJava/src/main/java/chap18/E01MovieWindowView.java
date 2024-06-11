package chap18;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import chap18.controller.MovieController;

public class E01MovieWindowView extends JFrame implements ActionListener {
	
	String resultMsg = null;
	
	JTextField tMovieTitle;
	JButton btnTitleInsert, btnSave, btnExit, btnDelete;
	List movieList;
	
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
		
		setBounds(0,0,1000,600);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// 이벤트 등록 처리
		movieList.addActionListener(this);
		btnTitleInsert.addActionListener(this);
		btnSave.addActionListener(this);
		btnExit.addActionListener(this);
		btnDelete.addActionListener(this);

		
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
				controller.addTitle();
			} else if (e.getSource() == btnSave) {
				controller.saveTitles();
			} else if (e.getSource() == btnDelete) {
				controller.delTitles();
			} else {
				controller.exitTitles();
			}
			
			
		} catch (Exception e2) {}
		
	}
	

}
