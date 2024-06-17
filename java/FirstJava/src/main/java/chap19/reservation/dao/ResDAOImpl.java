package chap19.reservation.dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import chap19.common.base.AbstractBaseDAO;
import chap19.reservation.vo.ResVO;

public class ResDAOImpl extends AbstractBaseDAO implements ResDAO {

	@Override
	public List<ResVO> selectRes(ResVO resVO) throws Exception {
		
		List<ResVO> resList = new ArrayList<ResVO>();
		
		String _ResNumber = resVO.getResNumber();
		String sql = "";
		
		if (_ResNumber != null && _ResNumber.length() != 0) {
			sql = "SELECT * FROM t_res WHERE resNumber = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, _ResNumber);
		} else {
			sql = "select * from t_res order by resNumber DESC";
			
			pstmt = conn.prepareStatement(sql);
		}
		rs = pstmt.executeQuery();
		
		while(rs.next()) {
			String resNumber	= rs.getString("resNumber");  // 예약번호
			Date resDate		= rs.getDate("resDate");  // 예약날짜
			Date startDate  	= rs.getDate("startDate"); // 이용시작일자
			Date returnDate 	= rs.getDate("returnDate");  // 반납일자
			String resCarNumber	= rs.getString("resCarNumber");  // 예약차번호
			String resUserId	= rs.getString("resUserId");  // 예약자아이디
			
			ResVO vo = new ResVO();
			vo.setResNumber(resNumber);
			vo.setResDate(resDate);
			vo.setStartDate(startDate);
			vo.setReturnDate(returnDate);
			vo.setResCarNumber(resCarNumber);
			vo.setResUserId(resUserId);
			
			resList.add(vo);
		}
		rs.close();
		
		return resList;
	}

	@Override
	public int insertRes(ResVO resVO) throws Exception {
		int result = 0;  // sql문장 수행횟수
		String sql = """
				INSERT INTO t_res (
					resNumber,
					resDate,
					startDate,
					returnDate,
					resCarNumber,
					resUserId
					)
					VALUES (?,?,?,?,?,?)					
				""";
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, resVO.getResNumber());  // 예약번호
		pstmt.setDate(2, resVO.getResDate());;  // 예약날짜
		pstmt.setDate(3, resVO.getStartDate());;  // 이용시작일자
		pstmt.setDate(4, resVO.getReturnDate());;  // 반납일자
		pstmt.setString(5, resVO.getResCarNumber());;  // 예약차번호
		pstmt.setString(6, resVO.getResUserId());;  // 예약자아이디
		
		result = pstmt.executeUpdate();		
		
		return result;
	}

	@Override
	public int updateRes(ResVO resVO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteRes(ResVO resVO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int checkResNum(String resNumber) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
}
