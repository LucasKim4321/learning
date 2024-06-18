package chap19.reservation.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import chap19.car.vo.CarVO;
import chap19.reservation.dao.ResDAO;
import chap19.reservation.dao.ResDAOImpl;
import chap19.reservation.vo.ResVO;

public class ResControllerImpl implements ResController{
	
	public ResDAO resDAO;
	
	public ResControllerImpl() {
		resDAO = new ResDAOImpl();
	}

	@Override
	public List<ResVO> listRes(ResVO resVO) {
		// 조회
		List<ResVO> resList = new ArrayList<ResVO>();
		
		try {
			resList = resDAO.selectRes(resVO);
		} catch (Exception e) {System.out.println(e.getMessage());}
		
		return resList;
	}

	@Override
	public int regRes(ResVO resVO) {
		// 등록
		int result = 0;
		
		try {
			result = resDAO.insertRes(resVO);
		} catch (Exception e) {System.out.println(e.getMessage());}
		
		return result;
	}

	@Override
	public int modRes(ResVO resVO) {
		// 수정
		int result = 0;
		
		try {
			result = resDAO.updateRes(resVO);
		} catch (Exception e) {System.out.println(e.getMessage());}
		
		return result;
	}

	@Override
	public int removeRes(ResVO resVO) {
		// 삭제
		int result = 0;
		
		try {
			result = removeRes(resVO);
		} catch (Exception e) {System.out.println(e.getMessage());}
		
		return result;
	}

	@Override
	public CarVO checkCar(String segment) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResVO checkRes(String type, String value) {
		// 체크
		ResVO vo = new ResVO();
		
//		try {
//			vo = resDAO.checkResNum(resNumber);
//		} catch (Exception e) {System.out.println(e.getMessage());}
		return vo;
	}
	
	@Override
	public List<ResVO> checkDate(String startDate, String returnDate) {
		
		
		return null;
		
	}
 
	

}
