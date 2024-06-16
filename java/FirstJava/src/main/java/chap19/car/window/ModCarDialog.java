package chap19.car.window;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import chap19.car.controller.CarController;
import chap19.car.vo.CarVO;

public class ModCarDialog extends JDialog {
	// 회원 정보 등록 화면
	
	// 회원 정보 등록 요청 객체
	CarController carController;
	
	// 화면 구성 요소 객체
	JPanel jPanel, searchPanel, btnPanel;
	JLabel lSearchId, lCarNumber, lCarName, lCarColor, lDisplacement, lManufacturer;
	JTextField tfSearch, tfCarNumber, tfCarcarName, tfCarColor, tfDisplacement, tfManufacturer;
	JButton btnSearch, btnModify, btnCancel;

	// 생성자	
	public ModCarDialog(CarController carController, String str) {
		
		this.carController = carController;
				
		setTitle(str);
		init(); // 화면 요소 객체 생성 메서드 호출
	}

	private void init() {

		searchPanel = new JPanel();
		lSearchId	= new JLabel("차량 번호");
		tfSearch	= new JTextField(20);
		btnSearch   = new JButton("조회");
		
		lCarNumber 		= new JLabel("차량 번호");
		lCarColor 	= new JLabel("색상");
		lCarName 		= new JLabel("차종");
		lDisplacement 	= new JLabel("배기량");
		lManufacturer 	= new JLabel("제조사");
		
		tfCarNumber		= new JTextField(20);
		tfCarColor 	= new JTextField(20);
		tfCarcarName 		= new JTextField(20);
		tfDisplacement 	= new JTextField(20);
		tfManufacturer 	= new JTextField(20);
		

		// 검색에 관련 UI Panel
		searchPanel.add(lSearchId);
		searchPanel.add(tfSearch);
		searchPanel.add(btnSearch);
		
		btnPanel = new JPanel();
		btnModify = new JButton("수정");
		btnCancel = new JButton("취소");
		
		btnPanel.add(btnModify);
		btnPanel.add(btnCancel);
		btnSearch.addActionListener(new MemberBtnHandler());   // 이벤트 리스너 추가
		btnModify.addActionListener(new MemberBtnHandler());
		btnCancel.addActionListener(new MemberBtnHandler());

		
		jPanel = new JPanel(new GridLayout(0,2));
		
		jPanel.add(lCarNumber);
		jPanel.add(tfCarNumber);

		jPanel.add(lCarName);
		jPanel.add(tfCarcarName);

		jPanel.add(lCarColor);
		jPanel.add(tfCarColor);
		
		jPanel.add(lDisplacement);
		jPanel.add(tfDisplacement);

		jPanel.add(lManufacturer);
		jPanel.add(tfManufacturer);

//		searchPanel.add(jPanel, BorderLayout.SOUTH);
		add(searchPanel, BorderLayout.NORTH);
		add(jPanel, BorderLayout.CENTER);
		add(btnPanel, BorderLayout.SOUTH);
		
		setLocation(400,200);
		setSize(500,400);
		pack();  // 창 크기를 알맞게 조정
		setModal(true);
		setVisible(true);
	}
	class MemberBtnHandler implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			if (e.getSource() == btnSearch) {  // 조회 버튼 동작
				String searchId = tfSearch.getText().trim();
				
				if (searchId != null && searchId.length() != 0) {
					
					// 조회 요청
					CarVO searchedVO = carController.checkNum(searchId);
					
					if(searchedVO.getCarNumber() != null) {  // 검색결과 값이 있을 경우
						
						tfCarNumber.setText(searchedVO.getCarNumber());
						tfCarColor.setText(searchedVO.getCarColor());
						tfCarcarName.setText(searchedVO.getCarName());
						tfDisplacement.setText(Integer.toString(searchedVO.getDisplacement()));
						tfManufacturer.setText(searchedVO.getManufacturer());
						
					} else {  // 없을 경우
						showMessage("아이디가 존재하지 않습니다.", -1);
					}
					
				} else {
					showMessage("검색 할 아이디를 입력해주세요.", -1);
				}
				tfSearch.setText("");  // 클리어 안하면 화면에 찌거기 데이터가 남음
				
			} else if(e.getSource() == btnModify) {
				// 화면에 있는 값을 변수로 저장
				String carNumber 		= tfCarNumber.getText().trim();
				String carColor = tfCarColor.getText().trim();
				String carName 	= tfCarcarName.getText().trim();
				String displacement 	= tfDisplacement.getText().trim();
				String manufacturer = tfManufacturer.getText().trim();
				
				CarVO vo = CarVO.builder().carNumber(carNumber).carColor(carColor).carName(carName).displacement(Integer.valueOf(displacement) ).manufacturer(manufacturer).build();
				System.out.println("modify CarVO:"+vo);
				
				// 회원 정보 DB수정 요청
				int result = carController.modCar(vo);  // 애초에 carNumber가 서버에서 primary 설정이라 중복이면 안만들어지긴 함
				System.out.println("result: "+result);  // 만들기 성공하면 1 실패하면 0
				
				if (result > 0) {
					showMessage("차량을 수정했습니다.",result);
				
				} else {
					showMessage("차량 수정 실패",result);
				}
				
			} else if (e.getSource()==btnCancel){//삭제 
				dispose();
				return;
			}
			
		}
	}

	// 메시지 전달 창
	private void showMessage(String msg, int result) {

		if (result > 0) {
			JOptionPane.showMessageDialog(this,msg,"메시지박스",JOptionPane.INFORMATION_MESSAGE);

		} else {
			JOptionPane.showMessageDialog(this,msg,"메시지박스",JOptionPane.WARNING_MESSAGE);
			
		}
		
	}

}
