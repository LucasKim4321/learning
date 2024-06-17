package chap19.reservation.window;

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
	JPanel jPanel, btnPanel;
	JLabel lResNumber, lResDate, lStartDate, lReturnDate, lResCarNumber, lResUserId;
	JTextField tfResNumber, tfResDate, tfStartDate, tfReturnDate, tfResCarNumber, tfResUserId;
	JButton btnRegister, btnCancel;
	
	// 생성자
	public RegResDialog(ResController resController, String str) {
		this.resController = resController;
		
		setTitle(str);
		init();  // 화면 요소 객체 생성 메서드 호출
	}

	private void init() {
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
//		jPanel, btnPanel;
	}
		
}
