package chap19.reservation.window;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import chap19.reservation.controller.ResController;

public class RegResDialog extends JDialog {
	// 예약 정보 등록 화면
	private String resNumber;  // 예약번호
	private Date resDate;  // 예약날짜
	private Date startDate;  // 이용시작일자
	private Date returnDate;  // 반납일자
	private String resCarNumber;  // 예약차번호
	private String resUserId;  // 예약자아이디
	
	// 예약 정보 등록 요청 객체
	ResController resController;
	
	// 예약 구성 요소 객체
	JPanel jPanel, btnPanel, searchPanel;
	JLabel lSearchSegment, lResNumber, lResDate, lStartDate, lReturnDate, lResCarNumber, lResUserId;
	JTextField tfSearch, tfResNumber, tfResDate, tfStartDate, tfReturnDate, tfResCarNumber, tfResUserId;
	JButton btnSearch, btnRegister, btnCancel;
	
	// 생성자
	public RegResDialog(ResController resController, String str) {
		this.resController = resController;
		
		setTitle(str);
		init();  // 화면 요소 객체 생성 메서드 호출
	}

	private void init() {
		searchPanel		= new JPanel();
		lSearchSegment	= new JLabel("차량 크기");
		tfSearch		= new JTextField(20);
		btnSearch		= new JButton("검색");
		
		lResNumber		= new JLabel("예약번호");
		lResDate		= new JLabel("예약날짜");
		lStartDate		= new JLabel("이용시작일자");
		lReturnDate		= new JLabel("반납일자");
		lResCarNumber	= new JLabel("예약차번호");
		lResUserId		= new JLabel("예약자아이디");
		
		tfResNumber		= new JTextField();
		tfResDate		= new JTextField();
		tfStartDate		= new JTextField();
		tfReturnDate	= new JTextField();
		tfResCarNumber	= new JTextField();
		tfResUserId		= new JTextField();

		// 검색에 관련 UI Panel
		searchPanel.add(lSearchSegment);
		searchPanel.add(tfSearch);
		searchPanel.add(btnSearch);
		
		btnPanel = new JPanel();
		btnRegister = new JButton("등록");
		btnCancel = new JButton("취소");
		
		btnPanel.add(btnRegister);
		btnPanel.add(btnCancel);
		btnRegister.addActionListener(new ReservationBtnHandler());
		btnCancel.addActionListener(new ReservationBtnHandler());
		
		jPanel = new JPanel(new GridLayout(0,2));
		
		jPanel.add(lResNumber);
		jPanel.add(tfResNumber);

		jPanel.add(lResDate);
		jPanel.add(tfResDate);

		jPanel.add(lStartDate);
		jPanel.add(tfStartDate);

		jPanel.add(lReturnDate);
		jPanel.add(tfReturnDate);

		jPanel.add(lResCarNumber);
		jPanel.add(tfResCarNumber);

		jPanel.add(lResUserId);
		jPanel.add(tfResUserId);
		
		add(searchPanel, BorderLayout.NORTH);
		add(jPanel, BorderLayout.CENTER);
		add(btnPanel, BorderLayout.SOUTH);
		
		setLocation(400,200);  // 가로 세로
		setSize(500,400);  // 가로 세로
		pack();  // 창 크기를 알맞게 조정  // size설정 무시
		setModal(true);  // modal창으로 만듬
		setVisible(true);
		
	}
	
	class ReservationBtnHandler implements ActionListener {

		
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnRegister) {
				// 화면에 있는 값을 변수로 저장
				
			}
			else if (e.getSource() == btnCancel) {  // 취소 
				dispose();
				return;
			}
			
		}
		
	}
		
}
