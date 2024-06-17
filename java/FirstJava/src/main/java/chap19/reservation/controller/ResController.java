package chap19.reservation.controller;

import java.util.List;

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
	
	// 체크
	public ResVO checkResNum(ResVO resVO);
	
	// date.valueof
	//
}
