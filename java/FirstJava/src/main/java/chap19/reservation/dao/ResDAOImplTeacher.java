package chap19.res.dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import chap19.common.base.AbstractBaseDAO;
import chap19.member.vo.MemberVO;
import chap19.res.vo.ResVO;

public class ResDAOImpl extends AbstractBaseDAO  implements ResDAO{

	@Override
	public List<ResVO> selectResInfo(ResVO resVO) throws Exception {
		// 예약 조회
		List<ResVO> resList = new ArrayList<ResVO>();
		
		String _resNumber = resVO.getResNumber();
		String sql = "";
		
		if ( _resNumber != null && _resNumber.length() != 0) {
			sql = """
					SELECT 
						resNumber, resCarNumber, 
						resDate,
						useBeginDate,
						returnDate,
						resUserId 
					FROM t_res
					WHERE resNumber = ?
					ORDER BY resNumber DESC 
					""";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, _resNumber);
			
		} else {
			sql = """
				  SELECT 
						resNumber, resCarNumber, 
						resDate,
						useBeginDate,
						returnDate,
						resUserId 
					FROM t_res
					ORDER BY resNumber DESC 
					""";
			
			pstmt = conn.prepareStatement(sql);
		}

		rs = pstmt.executeQuery();
		
		while(rs.next()) {
			String resNumber 		= rs.getString("resNumber");
			String resCarNumber 	= rs.getString("resCarNumber");
			String resUserId 		= rs.getString("resUserId");
			Date resDate 			= rs.getDate("resDate");
			Date useBeginDate 	= rs.getDate("useBeginDate");
			Date returnDate 	= rs.getDate("returnDate");

			
			ResVO vo = new ResVO();
			vo.setResNumber(resNumber);
			vo.setResCarNumber(resCarNumber);
			vo.setResUserId(resUserId);
			vo.setResDate(resDate);
			vo.setUseBeginDate(useBeginDate);
			vo.setReturnDate(returnDate);
			
			resList.add(vo);
			
		}
		rs.close();
		
		
		return resList;
	}

	@Override
	public int insertResInfo(ResVO resVO) throws Exception {
		// 예약 등록
		int result = 0;
		String sql = """
				INSERT INTO t_res (
					resNumber, 
					resDate ,
					useBeginDate, 
					returnDate,
					resCarNumber,
					resUserId
				) VALUES 
					(?,?,?,?,?,?)
				""";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, resVO.getResNumber());
		pstmt.setDate(2, resVO.getResDate());
		pstmt.setDate(3, resVO.getUseBeginDate());
		pstmt.setDate(4, resVO.getReturnDate());
		pstmt.setString(5, resVO.getResCarNumber());
		pstmt.setString(6, resVO.getResUserId());
		
		result = pstmt.executeUpdate();
		return result;
	}

	@Override
	public int updateResInfo(ResVO resVO) throws Exception {
		// 예약 수정
		int result = 0;
		String sql = """
					UPDATE t_res 
					SET 
						resDate 		= ?,
						useBeginDate 	= ?,
						returnDate 		= ?
					WHERE resNumber = ?;	
				""";
		pstmt = conn.prepareStatement(sql);
		pstmt.setDate(1, resVO.getResDate());
		pstmt.setDate(2, resVO.getUseBeginDate());
		pstmt.setDate(3, resVO.getReturnDate());
		pstmt.setString(4, resVO.getResNumber());

		
		result = pstmt.executeUpdate();
		return result;
	}

	@Override
	public int deleteResInfo(ResVO resVO) throws Exception {
		// 예약 취소(삭제)
		int result = 0;
		String sql = """
				DELETE FROM t_res WHERE resNumber =?
				""";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, resVO.getResNumber());
		
		result = pstmt.executeUpdate();
		
		return result;
	}

}