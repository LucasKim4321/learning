package chap19.reservation.window;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import chap19.car.controller.CarController;
import chap19.car.vo.CarVO;
import chap19.common.CarRentTableModel;
import chap19.member.controller.MemberController;
import chap19.member.vo.MemberVO;
import chap19.reservation.controller.ResController;
import chap19.reservation.vo.ResVO;

public class RegResDialog extends JDialog {
	// 예약 정보 등록 화면
	
	// 예약 정보 등록 요청 객체
	ResController resController;
	// 차량 관리 컨트롤러는 입력, 수정, 조회, 삭제 작업요청시 작업처리하는 객체
	CarController carController;
	// 맴버 컨트롤러
	MemberController memberController;
	
	// 예약 구성 요소 객체
	JPanel pUserId, jPanel, btnPanel, searchPanel;
	JLabel lIdSearch, lSearchSegment, lResNumber, lResDate, lStartDate, lReturnDate, lResCarNumber, lResUserId;
	JTextField tfIdSearch, tfStartSearch, tfReturnSearch, tfResNumber, tfResDate, tfStartDate, tfReturnDate, tfResCarNumber, tfResUserId;
	JButton btnIdCheck, btnSearch, btnRegister, btnCancel;
	JScrollPane scrollTable;
	// 테이블
	JTable carTable;
	
	// 테이블UI 모델 객체
	CarRentTableModel carRentTableModel;
	
	// 테이블 모델
	String[] columnNames = {"차량 번호","차종","색상","배기량","제조사","크기"};
	Object[][] carItems = new String[0][6];  // 테이블에 표시될 차량 정보 저장(2차원 배열)
	int rowIdx = 0, colIdx = 0;  //  테이블 수정시 선택한 행과 열 인덱스 저장
	
	// 아이디 체크 여부
	int idCheck = 0;

	// 생성자
	public RegResDialog(ResController resController,CarController carController,MemberController memberController, String str) {
		this.memberController = memberController;
		this.carController = carController;
		this.resController = resController;
		
		setTitle(str);
		init();  // 화면 요소 객체 생성 메서드 호출
	}

	private void init() {
		// 테이블 생성
		carTable = new JTable();
		scrollTable = new JScrollPane(carTable);
		
		
		searchPanel		= new JPanel();
		lSearchSegment	= new JLabel("예약날짜(형식:2024-1-12)");
		tfStartSearch	= new JTextField(20);
		tfReturnSearch	= new JTextField(20);
		btnSearch		= new JButton("검색");
		
		lResNumber		= new JLabel("예약번호");
		lResDate		= new JLabel("예약날짜(형식:2024-1-12)");
		lStartDate		= new JLabel("이용시작일자(형식:2024-1-12)");
		lReturnDate		= new JLabel("반납일자(형식:2024-1-12)");
		lResCarNumber	= new JLabel("예약차번호");
		lResUserId		= new JLabel("예약자아이디");
		
		tfResNumber		= new JTextField("자동 생성");
		tfResDate		= new JTextField(20);
		tfStartDate		= new JTextField(20);
		tfReturnDate	= new JTextField(20);
		tfResCarNumber	= new JTextField("예약날짜 검색 후 차량 선택시 자동 입력");
		tfResUserId		= new JTextField("아이디 체크시 자동 입력");
		
//		tfResNumber.setEnabled(false);

		// 검색에 관련 UI Panel
		searchPanel.add(lSearchSegment);
		searchPanel.add(tfStartSearch);
		searchPanel.add(tfReturnSearch);
		searchPanel.add(btnSearch);
		
		btnPanel = new JPanel();
		btnRegister = new JButton("등록");
		btnCancel = new JButton("취소");
		
		btnPanel.add(btnRegister);
		btnPanel.add(btnCancel);
		btnSearch.addActionListener(new ReservationBtnHandler());
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

		pUserId = new JPanel();
		lIdSearch = new JLabel("아이디 입력: ");
		tfIdSearch = new JTextField(20);
		btnIdCheck = new JButton("체크");
		pUserId.add(lIdSearch);
		pUserId.add(tfIdSearch);
		pUserId.add(btnIdCheck);
		btnIdCheck.addActionListener(new ReservationBtnHandler());
		
		// 테이블 데이터 모델 생성
		carRentTableModel = new CarRentTableModel(carItems, columnNames);
//		carRentTableModel.columnEditables = new boolean[] {false, false, false, false, false, false, false};
		
		// 테이블 UI view에 테이블 데이터 모델을 설정
		carTable.setModel(carRentTableModel);
		
		ListSelectionModel rowSel = carTable.getSelectionModel();
		rowSel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);  // SINGLE_SELECTION 단일 선택
		
		ListSelectionModel colSel = carTable.getColumnModel().getSelectionModel();
		colSel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		// 테이블 이벤트 핸들러
		rowSel.addListSelectionListener(new ListRowSelectionHandler());  // 행 클릭시
		colSel.addListSelectionListener(new ListColSelectionHandler());  // 열 클릭시

		pUserId.add(searchPanel,BorderLayout.NORTH);
		pUserId.add(scrollTable,BorderLayout.SOUTH);
		add(pUserId, BorderLayout.NORTH);
//		add(searchPanel, BorderLayout.NORTH);
		add(jPanel, BorderLayout.CENTER);
		add(btnPanel, BorderLayout.SOUTH);
		
		jPanel.setBorder(BorderFactory.createEmptyBorder(0 , 10 , 0 , 0));  // 여백
		lResNumber.setHorizontalAlignment(JLabel.LEFT);  // 정렬
		scrollTable.setPreferredSize(new Dimension(680,300));  // 테이블 크기 설정하기
		setLocation(300,100);  // 가로 세로
		setSize(700,500);  // 가로 세로
//		pack();  // 창 크기를 알맞게 조정  // size설정 무시
		setModal(true);  // modal창으로 만듬
		setVisible(true);
		
		
	}

	
	// 차량 정보를 받아 테이블 데이터 모델에 전달하여 테이블 view에 표시하는 메서드
	private void loadTableData(List<CarVO> carList) {
		
		// 넘겨받은 차량정보 List에 차량정보가 있으면 처리
		if (carList != null && carList.size() != 0 ) {  // list가 null이 아니고 list값이 비어있지 않으면
			
			// 차량정보 -> 테이블 데이터로 전환
			carItems = new String[carList.size()][6];  // List의 개수 만큼 테이블 행을 설정
			
			for (int i=0; i<carList.size(); i++) {
				CarVO carVO = carList.get(i);
				
				carItems[i][0] = carVO.getCarNumber();
				carItems[i][1] = carVO.getCarName();
				carItems[i][2] = carVO.getCarColor();
				carItems[i][3] = String.valueOf(carVO.getDisplacement());
				carItems[i][4] = carVO.getManufacturer();
				carItems[i][5] = carVO.getSegment();
			}
			
			// 테이블 데이터 모델 설정
			carRentTableModel = new CarRentTableModel(carItems, columnNames);
			// 테이블 UI view에 테이블 데이터 모델 설정
			carTable.setModel(carRentTableModel);
			
		} else {
			// 전달 받은 데이터가 없을 경우 처리
//				System.out.println("조회한 정보가 없습니다.");
			message("조회한 정보가 없습니다.");
			
			carItems = new Object[0][6];  // **
			carRentTableModel = new CarRentTableModel(carItems, columnNames);
			carTable.setModel(carRentTableModel);
		}
		
	}

	// 테이블의 행 클릭시 이벤트 처리
	class ListRowSelectionHandler implements ListSelectionListener {
		CarVO carVO = null;
		
		@Override
		public void valueChanged(ListSelectionEvent e) {
			if (!e.getValueIsAdjusting()) {
				ListSelectionModel lsm = (ListSelectionModel)e.getSource();
				
				rowIdx = lsm.getMinSelectionIndex();
				System.out.println((rowIdx+1)+" 번째 행이 선택됨...");
				
				carVO = resController.checkCar((String) carItems[rowIdx][5]);
				tfResCarNumber.setText(carVO.getCarNumber());

			}
		}
		
	}
	// 테이블 열 클릭시 이벤트 처리
	class ListColSelectionHandler implements ListSelectionListener {
		CarVO carVO = null;
		
		@Override
		public void valueChanged(ListSelectionEvent e) {
			// 선택한 항목의 행 추출
//			ListSelectionModel lsm = (ListSelectionModel)e.getSource();
//			colIdx = lsm.getMinSelectionIndex();
			if (!e.getValueIsAdjusting()) {
				ListSelectionModel lsm = (ListSelectionModel)e.getSource();
				
				colIdx = lsm.getMinSelectionIndex();
				System.out.println((rowIdx+1)+" 번째 행"+(colIdx+1)+" 열이 선택됨...");
				
				carVO = resController.checkCar((String) carItems[rowIdx][5]);
				tfResCarNumber.setText(carVO.getCarNumber());
				
			}
			
		}
		
	}
	
	class ReservationBtnHandler implements ActionListener {

		List<CarVO> carList = null;
		List<ResVO> resList = null;
		MemberVO memberVO = null;
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnIdCheck) {  // 아이디 체크
				//  아이디 체크 버튼 클릭할 경우
				memberVO = memberController.checkId(tfIdSearch.getText().trim());
				if (memberVO.getMemId() != null) {
					tfResUserId.setText(memberVO.getMemId());
					message("아이디가 확인됐습니다.");
					idCheck = 1;
				} else {
					message("등록되지 않은 아이디 입니다.");
					idCheck = 0;
				}
			
			} else if (e.getSource() == btnSearch && idCheck == 1) {  // 조회
				
				// 조회 버튼 클릭할 경우
				System.out.println("조회버튼");
				String startDate = tfStartSearch.getText().trim();
				String returnDate = tfReturnSearch.getText().trim();
				
				carList = new ArrayList<CarVO>();
				resList = new ArrayList<ResVO>();
				
//				
				if ((startDate != null && startDate.length() != 0)&&(returnDate != null && returnDate.length() != 0)) {
					
					resList = resController.checkDate(startDate, returnDate);
					System.out.println(resList);
					
					if (resList != null) {
						for (int i=0; i<resList.size(); i++) {
							String car = resList.get(i).getResCarNumber();
							carList.add(carController.checkNum(car));
						}
						
						if(carList != null && carList.size() != 0) {
							loadTableData(carList);
							
						} else {
							System.out.println("4");
							loadTableData(null);
						}
						
					} else {
						message("검색실패");
//						// 전체 조회
//						carList = carController.listCar(carVO);
//						loadTableData(carList);
					}
				
				} else {
					message("날짜를 입력해주세요");
				}
				
			} else if (e.getSource() == btnRegister && idCheck == 1) {  // 등록 
				// 등록 버튼 클릭할 경우
				// 화면에 있는 값을 변수로 저장
				
			} else if (e.getSource() == btnCancel && idCheck == 1) {  // 취소 
				// 취소 버튼 클릭할 경우
				dispose();
				return;
			} else {
				message("아이디를 먼저 체크해주세요~");
			}
			
		}
		
	}

	// 메시지 전달할 메서드  메서드 안에 메서드 쓰는거 안됨
	private void message(String msg) {
		JOptionPane.showMessageDialog(this, msg, "메시지 박스", JOptionPane.QUESTION_MESSAGE);  // promt랑 비슷?
	}
		
}
