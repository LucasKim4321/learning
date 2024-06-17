package chap19.reservation.dao;

import java.util.List;

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
	
	// 체크
	public int checkResNum(String resNumber) throws Exception;
}
