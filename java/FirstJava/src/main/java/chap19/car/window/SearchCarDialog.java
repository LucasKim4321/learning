package chap19.car.window;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class SearchCarDialog extends JDialog {
//	명령어만 다르고 다루는 방식은 모든 언어가 다 비슷(똑같?)
	
	JPanel		panelSearch, panelBtn;
	JTextField	tf;
	JLabel		lCarName;
	
	JButton btnSearch;
	JButton btnReg;
	JButton btnModify;
	JButton btnDelete;
	
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
	public SearchCarDialog(CarController carController, String str) {
		this.carController = carController;
		
		setTitle(str);
		init();
	}
	
	// UI 객체 생성하는 메서드
	public void init() {
		carTable = new JTable();
		// 테이블 행 선택 객체
		ListSelectionModel rowSel = carTable.getSelectionModel();
		// 선택 방법
		// SINGLE_SELECTION(단일 선택),SINGLE_INTERVAL_SELECTION, MULTIPLE_INTERVAL_SELECTION(다중 선택)
		rowSel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);  // SINGLE_SELECTION 단일 선택
		
		ListSelectionModel colSel = carTable.getColumnModel().getSelectionModel();
		colSel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		// ListSelection 이벤트 처리
//		rowSel.addListSelectionListener(이벤트 핸들러);
		
		panelSearch = new JPanel();
		panelBtn 	= new JPanel();
		
		lCarName	= new JLabel("차종");
		tf 			= new JTextField("차종을 입력하세요.");
		btnSearch   = new JButton("조회하기");
		
		// 검색에 관련 UI Panel
		panelSearch.add(lCarName);
		panelSearch.add(tf);
		panelSearch.add(btnSearch);
		
		btnReg	  = new JButton("차량등록하기");
		btnModify = new JButton("수정하기");
		btnDelete = new JButton("삭제하기");
		
		// 각 버튼에 대한 이벤트 핸들러
		btnSearch.addActionListener(new MemberBtnHandler());
		btnReg.addActionListener(new MemberBtnHandler());  // 사용자 정의 이벤트 핸들러 추가
		btnModify.addActionListener(new MemberBtnHandler());
		btnDelete.addActionListener(new MemberBtnHandler());
		
		// 버튼에 관련 UI Panel
		panelBtn.add(btnReg);
		panelBtn.add(btnModify);
		panelBtn.add(btnDelete);

		// ------------------//
		//      Table설정
		// ------------------//
		
		// 테이블 데이터 모델 생성
		carRentTableModel = new CarRentTableModel(carItems, columnNames);
		// 테이블 UI view에 테이블 데이터 모델을 설정
		carTable.setModel(carRentTableModel);
		
		// 테이블 이벤트 핸들러
		rowSel.addListSelectionListener(new ListRowSelectionHandler());  // 행 클릭시
		colSel.addListSelectionListener(new ListColSelectionHandler());  // 행 클릭시
		
		// 각 panel을 대화창에 배치
		add(panelSearch, BorderLayout.NORTH);
		add(new JScrollPane(carTable), BorderLayout.CENTER);
		add(panelBtn, BorderLayout.SOUTH);
		
		setLocation(300,100);	// 다이얼로그 출력 위치
		setSize(800,600);		// 창의 크기
//		pack();
		setModal(true);			// 항상 부모창 위에 표시
		setVisible(true);		// 대화창을 화면에 표시
		
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
//			System.out.println("조회한 정보가 없습니다.");
			message("조회한 정보가 없습니다.");
			
			carItems = new Object[0][6];  // **
			carRentTableModel = new CarRentTableModel(carItems, columnNames);
			carTable.setModel(carRentTableModel);
		}
		
	}
	
	// 메시지 전달할 메서드  메서드 안에 메서드 쓰는거 안됨
	private void message(String msg) {
		JOptionPane.showMessageDialog(this, msg, "메시지 박스", JOptionPane.QUESTION_MESSAGE);  // promt랑 비슷?
	}
	
	// 차량관리 이벤트를 처리하는 클래스(내부 클래스 이벤트 핸들러)
	class MemberBtnHandler implements ActionListener {
		String carNumber			= null;
		String carName		= null;
		String carColor			= null;
		String displacement		= null;
		String manufacturer		= null;
		String segment		= null;
		List<CarVO> carList	= null;

		@Override
		public void actionPerformed(ActionEvent e) {
			// 조회버튼 클릭할 경우
			if (e.getSource() == btnSearch) {  // 조회 버튼 동작
				String name = tf.getText().trim();
				
				carList = new ArrayList<CarVO>();
				CarVO carVO = new CarVO();
				
				if (name != null && name.length() != 0) {
					
					carVO.setCarName(name);  // 이름 기준으로 조회
					// 조회 요청
					carList = carController.listCar(carVO);
//					Optional<carList> carList = memberController.listMember(carVO);
					if(carList != null && carList.size() != 0) {  // 검색결과 값이 있을 경우
						loadTableData(carList);
					} else {  // 없을 경우
						loadTableData(null);
					}
					
//					System.out.println("-- 이름 검색");
//					carList.stream().forEach(System.out::println);
					
				} else {
					// 전체 조회
					carList = carController.listCar(carVO);
					loadTableData(carList);
					
//					System.out.println("--전체 조회");
//					carList.stream().forEach(System.out::println);
				}
				tf.setText("");  // 클리어 안하면 화면에 찌거기 데이터가 남음
				return;
				
			} else if (e.getSource() == btnReg) {  // 추가 버튼 동작
				new RegCarDialog(carController, "차량 등록창");
				return;
				
			} else if (e.getSource() == btnModify) {  // 수정 버튼 동작
				carNumber		= (String) carItems[rowIdx][0];
				carName			= (String) carItems[rowIdx][1];
				carColor		= (String) carItems[rowIdx][2];
				displacement	= (String) carItems[rowIdx][3];
				manufacturer	= (String) carItems[rowIdx][4];
				segment			= (String) carItems[rowIdx][5];

				CarVO carVO = CarVO.builder().carNumber(carNumber).carColor(carColor).carName(carName).displacement(Integer.valueOf(displacement) ).manufacturer(manufacturer).segment(segment).build();
				System.out.println("수정 된 차량: "+carVO);
				
				carController.modCar(carVO);
				return;
				
			} else if (e.getSource() == btnDelete) {  // 삭제 버튼 동작
				carNumber		= (String) carItems[rowIdx][0];
				carName			= (String) carItems[rowIdx][1];
				carColor		= (String) carItems[rowIdx][2];
				displacement	= (String) carItems[rowIdx][3];
				manufacturer	= (String) carItems[rowIdx][4];
				segment			= (String) carItems[rowIdx][5];

				
				CarVO carVO = CarVO.builder().carNumber(carNumber).carColor(carColor).carName(carName).displacement(Integer.valueOf(displacement) ).manufacturer(manufacturer).segment(segment).build();
				System.out.println("삭제 된 차량: "+carVO);
				
				carController.removeCar(carVO);
				return;
				
			}
		}  // end actionPerformed
	}  // end MemberBtnHandler
	
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
	
	
}
