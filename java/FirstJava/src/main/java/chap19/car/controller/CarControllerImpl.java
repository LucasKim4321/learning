package chap19.car.controller;

import java.util.ArrayList;
import java.util.List;

import chap19.car.dao.CarDAO;
import chap19.car.dao.CarDAOImpl;
import chap19.car.vo.CarVO;

public class CarControllerImpl implements CarController {
	
	public CarDAO carDAO;  // 이유?

	public CarControllerImpl() {
		carDAO = new CarDAOImpl();
	}
	
	@Override
	public List<CarVO> listCar(CarVO carVO) {
		// 회원 정보 조회하는 dao 호출
		List<CarVO> carList = new ArrayList<CarVO>();
		
		try {
			carList =  carDAO.selectCar(carVO);
			
		} catch (Exception e) {System.out.println(e.getMessage());	}
		return carList;
	}

	@Override
	public int regCar(CarVO carVO) {
		//회원 정보 등록 하는 dao 호출
		int result = 0;
		try {
			result = carDAO.insertCar(carVO);
		} catch (Exception e) { System.out.println(e.getMessage());	}
		
		return result;
	}

	@Override
	public int modCar(CarVO carVO) {
		//회원 정보 수정 하는 dao 호출
		int result = 0;
		try {
			result = carDAO.updateCar(carVO);
		} catch (Exception e) { System.out.println(e.getMessage());	}
		
		return result;
	}

	@Override
	public int removeCar(CarVO carVO) {
		//회원 정보 삭제 하는 dao 호출
		int result = 0;
		try {
			result = carDAO.deleteCar(carVO);
		} catch (Exception e) { System.out.println(e.getMessage());	}
		
		return result;
	}

	@Override
	public CarVO checkNum(String carNumber) {
		// 회원 등록시 중복 체크하는 dao 호출
		CarVO vo = new CarVO();
			try {
				vo = carDAO.checkNum(carNumber);  // 중복체크 : 찾아서 있으면 값이 들어있고 아니면 null
			} catch (Exception e) {
				System.out.println(e.getMessage());
				}
		return vo;
	}

}