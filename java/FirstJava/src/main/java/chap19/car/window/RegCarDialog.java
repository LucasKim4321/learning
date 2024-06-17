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

public class RegCarDialog extends JDialog {
	// 회원 정보 등록 화면
	
	// 회원 정보 등록 요청 객체
	CarController carController;
	
	// 화면 구성 요소 객체
	JPanel jPanel, btnPanel;
	JLabel lCarNumber, lCarName, lCarColor, lDisplacement, lManufacturer,lSegment;
	JTextField tfCarNumber, tfCarcarName, tfCarColor, tfDisplacement, tfManufacturer,tfSegment;
	JButton btnRegister, btnCancel;

	// 생성자	
	public RegCarDialog(CarController carController, String str) {
		
		this.carController = carController;
				
		setTitle(str);
		init(); // 화면 요소 객체 생성 메서드 호출
	}

	private void init() {
		
		lCarNumber 		= new JLabel("차량 번호");
		lCarColor		= new JLabel("색상");
		lCarName 		= new JLabel("차종");
		lDisplacement 	= new JLabel("배기량");
		lManufacturer 	= new JLabel("제조사");
		lSegment		= new JLabel("크기");
		
		tfCarNumber		= new JTextField(20);
		tfCarColor		= new JTextField(20);
		tfCarcarName 	= new JTextField(20);
		tfDisplacement 	= new JTextField(20);
		tfManufacturer 	= new JTextField(20);
		tfSegment		= new JTextField(20);
		

		// 검색에 관련 UI Panel
		
		
		
		btnPanel = new JPanel();
		btnRegister = new JButton("등록");
		btnCancel = new JButton("취소");
		
		btnPanel.add(btnRegister);
		btnPanel.add(btnCancel);
		btnRegister.addActionListener(new MemberBtnHandler());
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

		jPanel.add(lSegment);
		jPanel.add(tfSegment);
		
		add(jPanel, BorderLayout.NORTH);
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
				
			if(e.getSource() == btnRegister) { 
				// 화면에 있는 값을 변수로 저장
				String carNumber 		= tfCarNumber.getText().trim();
				String carColor = tfCarColor.getText().trim();
				String carName 	= tfCarcarName.getText().trim();
				String displacement 	= tfDisplacement.getText().trim();
				String manufacturer = tfManufacturer.getText().trim();
				String segment = tfSegment.getText().trim();
				
				CarVO vo = CarVO.builder().carNumber(carNumber).carColor(carColor).carName(carName).displacement(Integer.valueOf(displacement) ).manufacturer(manufacturer).segment(segment).build();
				System.out.println("modify CarVO:"+vo);
				
				// 회원 정보 DB수정 요청
				int result = carController.regCar(vo);  // 애초에 carNumber가 서버에서 primary 설정이라 중복이면 안만들어지긴 함
				System.out.println("result: "+result);  // 만들기 성공하면 1 실패하면 0
				
				if (result > 0) {
					showMessage("차량을 등록했습니다.",result);
					
				} else {
					showMessage("차량 등록 실패",result);
				}
				
			} else if (e.getSource()==btnCancel){  // 취소 
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
