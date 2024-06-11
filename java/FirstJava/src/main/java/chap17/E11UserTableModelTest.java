package chap17;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class E11UserTableModelTest extends JFrame {
	
	JPanel searchPanel;
	JPanel bPanel;
	
	JList memberJList;
	JLabel lCondition;
	
	JTextField tCondition;
	JButton searchBtn;
	JComboBox combo;
	
	JTable memTable;
	
	JButton updateBtn, deleteBtn;
	Object[][] emp = new Object[0][4];
	
	E11UserTableModelTest() {
		initTableModelTest();
		
		setTitle("사용자 정의 테이블 실습");
		setLayout(new BorderLayout());
		
		Container c = getContentPane();
		c.add(searchPanel, "North");  // BorderLayout.NORTH
		
		c.add(new JScrollPane(memTable), "Center");  // BorderLayout.CENTER
		c.add(bPanel, BorderLayout.SOUTH);  // "South"랑 같음
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(200,200);
		pack();
		
		setVisible(true);
		
		
		
	}
	

	private void initTableModelTest() {		
		// 화면 요소 구성하기
		searchPanel = new JPanel();
		tCondition = new JTextField(10);
		lCondition = new JLabel("입력창");
		
		memberJList = new JList();
		memberJList.setBackground(Color.GREEN);
		
		memTable = new JTable();
		memTable.setModel(new E11UserTableModel(emp));
		
		searchBtn = new JButton("조회하기");
		// 조회버튼 클릭시 처리하는 내용
		searchBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Object[][] data = {
						{"220000","박길동","총무부"},
						{"220001","홍길동","관리부"},
						{"220002","동길동","영업부"},
						{"220003","동길이","관리부"},
						{"220003","동길이","관리부"}
				
				};
				memTable.setModel(new E11UserTableModel(data));
			}
		});
		
		// 그룹창( 입력라벨, 텍스트, 버튼)
		searchPanel.add(lCondition);
		searchPanel.add(tCondition);
		searchPanel.add(searchBtn);
		
		bPanel = new JPanel();
		updateBtn = new JButton("수정하기");
		deleteBtn = new JButton("삭제하기");
		
		bPanel.add(updateBtn);
		bPanel.add(deleteBtn);
		
	}


	public static void main(String[] args) {
		new E11UserTableModelTest();
		
	}

}


// 다음주 월요일까지 개인 포폴 사전 발표 and 팀 프로젝트 주제 선정