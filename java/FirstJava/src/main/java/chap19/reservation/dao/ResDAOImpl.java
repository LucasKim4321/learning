package chap19.reservation.dao;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import chap19.car.vo.CarVO;
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
		return 0;

	}

	@Override
	public CarVO checkCar(String value) throws Exception {
		int result = 0;
		String _value = value;
		
		CarVO vo = new CarVO();
		
		String sql = "SELECT * FROM t_car WHERE segment = ?";
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, _value);  // 입력한 이름으로 테이블상의 데이터 검색
		
		rs = pstmt.executeQuery();

		
		while(rs.next()) {
			String carNumber	= rs.getString("carNumber");
			String carName 		= rs.getString("carName");
			String carColor 	= rs.getString("carColor");
			int displacement 	= rs.getInt("displacement");
			String manufacturer = rs.getString("manufacturer");
			String segment 		= rs.getString("segment");
			
			vo.setCarNumber(carNumber);
			vo.setCarColor(carColor);
			vo.setCarName(carName);
			vo.setDisplacement(displacement);
			vo.setManufacturer(manufacturer);
			vo.setSegment(segment);
		
		}
		return vo;
	}

	@Override
	public ResVO checkRes(String type, String value) throws Exception {
		int result = 0;
		String _type = type;
		String _value = value;
		
		ResVO vo = new ResVO();
		
		String sql = "SELECT * FROM t_res WHERE "+_type+" = ?";
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,  _value);  // 입력한 이름으로 테이블상의 데이터 검색
		
		rs = pstmt.executeQuery();

		
		while(rs.next()) {
			
			String resNumber		= rs.getString("resNumber");  // 예약번호
			Date resDate 			= rs.getDate("resDate");  // 예약번호
			Date startDate			= rs.getDate("startDate");  // 이용시작일자
			Date returnDate 		= rs.getDate("returnDate");  // 반납일자
			String resCarNumber		= rs.getString("resCarNumber"); // 예약차번호
			String resUserId 		= rs.getString("resUserId");  // 예약자아이디
			
			vo.setResNumber(resNumber);
			vo.setResDate(resDate);
			vo.setStartDate(startDate);
			vo.setReturnDate(returnDate);
			vo.setResCarNumber(resCarNumber);
			vo.setResUserId(resUserId);
		
		}
		return vo;
	}
	
	@Override
	public List<ResVO> checkDate(String wanttedStart, String wanttedReturn) throws Exception {

		Date _wanttedStart = Date.valueOf(wanttedStart);
		Date _wanttedReturn = Date.valueOf(wanttedReturn);
		
//		Date _wanttedStart = Date.valueOf("2024-11-11");
//		Date _wanttedReturn = Date.valueOf("2024-11-14");
////		String _wanttedStart = wanttedStart;
////		String _wanttedReturn = wanttedReturn;
		
		List<ResVO> availableCars = new ArrayList<ResVO>();
		
		String sql = "";
		
//		SELECT * FROM t_res WHERE not(('2024-4-2' <= startDate and startDate < '2024-4-9')OR('2024-4-2' < returnDate and returnDate <= '2024-4-9'));  // 반납일에도 시작 가능  반납일에 시작할 경우 시간으로 세분화
		sql = "SELECT * FROM t_res WHERE NOT((? <= startDate and startDate <= ?)OR(? <= returnDate and returnDate <= ?))";
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setDate(1, _wanttedStart);
		pstmt.setDate(2, _wanttedReturn);
		pstmt.setDate(3, _wanttedStart);
		pstmt.setDate(4, _wanttedReturn);

		rs = pstmt.executeQuery();
		System.out.println(rs);
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
			
			availableCars.add(vo);
		}
		rs.close();
		System.out.println(availableCars);
		
		return availableCars;
		
		
	}
 


}
