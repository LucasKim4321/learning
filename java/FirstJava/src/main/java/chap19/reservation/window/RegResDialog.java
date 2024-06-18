package chap19.reservation.window;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import chap19.car.controller.CarController;
import chap19.car.vo.CarVO;
import chap19.common.CarRentTableModel;
import chap19.reservation.controller.ResController;
import chap19.reservation.vo.ResVO;

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
	JTextField tfStartSearch, tfReturnSearch, tfResNumber, tfResDate, tfStartDate, tfReturnDate, tfResCarNumber, tfResUserId;
	JButton btnSearch, btnRegister, btnCancel;
	
	// 테이블
	JTable carTable;
	
	// 테이블UI 모델 객체
	CarRentTableModel carRentTableModel;
	
	// 테이블 모델
	String[] columnNames = {"차량 번호","차종","색상","배기량","제조사","크기"};
	Object[][] carItems = new String[0][6];  // 테이블에 표시될 차량 정보 저장(2차원 배열)
	int rowIdx = 0, colIdx = 0;  //  테이블 수정시 선택한 행과 열 인덱스 저장
	
	// 차량 관리 컨트롤러는 입력, 수정, 조회, 삭제 작업요청시 작업처리하는 객체
	CarController carController;
	
	
	
	// 생성자
	public RegResDialog(ResController resController,CarController carController, String str) {
		this.resController = resController;
		
		setTitle(str);
		init();  // 화면 요소 객체 생성 메서드 호출
	}

	private void init() {
		// 테이블 생성
		carTable = new JTable();
		
		
		searchPanel		= new JPanel();
		lSearchSegment	= new JLabel("예약날짜(형식:2024-1-12)");
		tfStartSearch		= new JTextField(20);
		tfReturnSearch		= new JTextField(20);
		btnSearch		= new JButton("검색");
		
		lResNumber		= new JLabel("예약번호");
		lResDate		= new JLabel("예약날짜");
		lStartDate		= new JLabel("이용시작일자");
		lReturnDate		= new JLabel("반납일자");
		lResCarNumber	= new JLabel("예약차번호");
		lResUserId		= new JLabel("예약자아이디");
		
		tfResNumber		= new JTextField(20);
		tfResDate		= new JTextField(20);
		tfStartDate		= new JTextField(20);
		tfReturnDate	= new JTextField(20);
		tfResCarNumber	= new JTextField(20);
		tfResUserId		= new JTextField(20);

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

		add(searchPanel, BorderLayout.NORTH);
		carTable.add(jPanel, BorderLayout.SOUTH);
		add(new JScrollPane(carTable), BorderLayout.CENTER);  // 스크롤 기능 있는 테이블
		add(btnPanel, BorderLayout.SOUTH);
		
		setLocation(300,100);  // 가로 세로
		setSize(800,600);  // 가로 세로
		pack();  // 창 크기를 알맞게 조정  // size설정 무시
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

		@Override
		public void valueChanged(ListSelectionEvent e) {
			if (!e.getValueIsAdjusting()) {
				ListSelectionModel lsm = (ListSelectionModel)e.getSource();
				
				rowIdx = lsm.getMinSelectionIndex();
				System.out.println((rowIdx+1)+" 번째 행이 선택됨...");
			}
		}
		
	}
	// 테이블 열 클릭시 이벤트 처리
	class ListColSelectionHandler implements ListSelectionListener {

		@Override
		public void valueChanged(ListSelectionEvent e) {
			// 선택한 항목의 행 추출
//			ListSelectionModel lsm = (ListSelectionModel)e.getSource();
//			colIdx = lsm.getMinSelectionIndex();
			if (!e.getValueIsAdjusting()) {
				ListSelectionModel lsm = (ListSelectionModel)e.getSource();
				
				colIdx = lsm.getMinSelectionIndex();
				System.out.println((rowIdx+1)+" 번째 행"+(colIdx+1)+" 열이 선택됨...");
			}
			
		}
		
	}
	
	class ReservationBtnHandler implements ActionListener {
//		2024-4-2 2024-4-9
		
		@Override
		public void actionPerformed(ActionEvent e) {
			List<CarVO> carList = null;
			// 조회버튼 클릭할 경우
			if (e.getSource() == btnSearch) {  // 조회 버튼 동작
				System.out.println("조회버튼");
				String startDate = tfStartDate.getText().trim();
				String returnDate = tfReturnDate.getText().trim();

				//(startDate != null && startDate.length() != 0)&&(returnDate != null && returnDate.length() != 0)
				if (true) {

					System.out.println("1");
					List<ResVO> resList = resController.checkDate(startDate, returnDate);
//					resList.stream().forEach(System.out::println);
//					resList.stream().forEach((v)-> {System.out.println(v.getResCarNumber());});
					if (resList != null && resList.size() != 0){
						System.out.println("2");
						for (int i=0; i<resList.size(); i++) {
							String car = resList.get(i).getResCarNumber();
							carList.add(carController.checkNum(car));
						}
						if(carList != null && carList.size() != 0) {
							System.out.println("3");
							loadTableData(carList);
						} else {
							System.out.println("4");
							loadTableData(null);
						}
					} else {
						System.out.println("5");
						message("검색실패");
//						// 전체 조회
//						carList = carController.listCar(carVO);
//						loadTableData(carList);
					}
				
				} else {
					System.out.println("6");
					message("날짜를 입력해주세요");
				}
				
			} else if (e.getSource() == btnRegister) {
				// 화면에 있는 값을 변수로 저장
				
			} else if (e.getSource() == btnCancel) {  // 취소 
				dispose();
				return;
			}
			
		}
		
	}

	// 메시지 전달할 메서드  메서드 안에 메서드 쓰는거 안됨
	private void message(String msg) {
		JOptionPane.showMessageDialog(this, msg, "메시지 박스", JOptionPane.QUESTION_MESSAGE);  // promt랑 비슷?
	}
		
}
