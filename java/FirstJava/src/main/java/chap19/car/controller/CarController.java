package chap19.car.controller;

import java.sql.SQLException;
import java.util.List;

import chap19.car.vo.CarVO;
import chap19.member.vo.MemberVO;

public interface CarController {
	// 차량 조회
	public List<CarVO> listCar(CarVO carVO);
	// 차량 등록
	public int regCar(CarVO carVO);
	// 차량 수정
	public int modCar(CarVO carVO);
	// 차량 삭제
	public int removeCar(CarVO carVO);
	// 차량 번호로 정보 조회
	public CarVO checkNum(String carNumber);

}