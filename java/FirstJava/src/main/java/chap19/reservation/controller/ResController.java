package chap19.reservation.controller;

import java.sql.Date;
import java.util.List;

import chap19.car.vo.CarVO;
import chap19.reservation.vo.ResVO;

public interface ResController {
	// 조회
	public List<ResVO> listRes(ResVO resVO);
	
	// 등록
	public int regRes(ResVO resVO);
	
	// 수정
	public int modRes(ResVO resVO);
	
	// 삭제
	public int removeRes(ResVO resVO);

	// 차 체크
	public CarVO checkCar(String segment);
	
	// 예약 체크
	public ResVO checkRes(String type, String value);

	// 예약 가능 날짜 체크
	public List<ResVO> checkAvailableDate(Date startDate, Date returnDate);

}
