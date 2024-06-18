package chap19.reservation.dao;

import java.sql.Date;
import java.util.List;

import chap19.car.vo.CarVO;
import chap19.reservation.vo.ResVO;

public interface ResDAO {
	// 조회
	public List<ResVO> selectRes(ResVO resVO) throws Exception;
	
	// 등록
	public int insertRes(ResVO resVO) throws Exception;
	
	// 수정
	public int updateRes(ResVO resVO) throws Exception;
	
	// 삭제
	public int deleteRes(ResVO resVO) throws Exception;
	
	// 차 체크
	public CarVO checkCar(String segment) throws Exception;

	// 예약 체크
	public ResVO checkRes(String type, String value) throws Exception;
	
	// 예약 가능 날짜 체크
	public List<ResVO> checkDate(String startDate, String returnDate) throws Exception;
	

}
