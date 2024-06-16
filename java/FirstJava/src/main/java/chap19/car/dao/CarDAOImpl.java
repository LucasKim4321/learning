package chap19.car.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import chap19.car.vo.CarVO;
import chap19.common.base.AbstractBaseDAO;

public class CarDAOImpl extends AbstractBaseDAO implements CarDAO{

	// 차 정보 조회 기능 처리
	@Override
	public List<CarVO> selectCar(CarVO carVO) throws Exception {
		
		List<CarVO> memList = new ArrayList<CarVO>();
		
		String _carName = carVO.getCarName();  // 넘겨받은 데이터(입력한 이름으로 생성한 객체)의 Name값을 입력받아 _carColor 변수 생성 
		String sql = "";
		
		
		if ( _carName != null && _carName.length() != 0) {  // 넘겨 받은 객체에 값이 있으면
			sql = "SELECT * FROM t_car WHERE carName = ? ORDER BY carNumber";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, _carName);  //  입력한 이름으로 테이블상의 데이터 검색
			
		} else {  // 동작확인
			sql = "select * from t_car";
			
			pstmt = conn.prepareStatement(sql);
		}

		rs = pstmt.executeQuery();
		
		while(rs.next()) {
			String carNumber 		= rs.getString("carNumber");
			String carName 	= rs.getString("carName");
			String carColor 		= rs.getString("carColor");
			int displacement 	= rs.getInt("displacement");
			String manufacturer 	= rs.getString("manufacturer");
			
			CarVO vo = new CarVO();
			vo.setCarNumber(carNumber);
			vo.setCarColor(carColor);
			vo.setCarName(carName);
			vo.setDisplacement(displacement);
			vo.setManufacturer(manufacturer);
			
			memList.add(vo);
			
		}
		rs.close();
		
		return memList;
	}

	// 차 정보 등록 기능 처리
	@Override
	public int insertCar(CarVO carVO) throws SQLException {
		int result = 0;// sql문장 수행횟수
		String sql = """
				INSERT INTO t_car (
					carNumber, 
					carName ,
					carColor, 
					displacement ,
					manufacturer 
				) VALUES 
					(?,?,?,?,?)
				""";
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, carVO.getCarName());
		pstmt.setString(2, carVO.getCarColor());
		pstmt.setInt(3, carVO.getDisplacement());
		pstmt.setString(4, carVO.getManufacturer());
		pstmt.setString(5, carVO.getCarNumber());
		
		result = pstmt.executeUpdate();

		return result;
	}

	@Override
	public int updateCar(CarVO carVO) throws SQLException {
		int result = 0;
		String sql = """
				UPDATE t_car 
				SET carName = ?,
						carColor = ?,
						displacement = ?,
						manufacturer = ?
				WHERE carNumber = ?
				""";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, carVO.getCarName());
		pstmt.setString(2, carVO.getCarColor());
		pstmt.setInt(3, carVO.getDisplacement());
		pstmt.setString(4, carVO.getManufacturer());
		pstmt.setString(5, carVO.getCarNumber());
		
		result = pstmt.executeUpdate();
		return result;
	}

	@Override
	public int deleteCar(CarVO carVO) throws Exception {
		int result = 0;
		String sql = """
				DELETE FROM t_car WHERE carNumber =?
				""";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, carVO.getCarNumber());
		
		result = pstmt.executeUpdate();
		System.out.println("11result: "+result);
		
		return result;
		
	}

	// 차 번호로 정보 조회 유무 체크
	@Override
	public CarVO checkNum(String carNum) throws Exception {
		int result = 0;
		String _carNum = carNum;
		
		CarVO vo = new CarVO();
		
		String sql = "SELECT * FROM t_car WHERE carNumber = ?";
		
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, _carNum);  //  입력한 이름으로 테이블상의 데이터 검색
			

		rs = pstmt.executeQuery();

		while(rs.next()) {
			String carNumber 		= rs.getString("carNumber");
			String carName 	= rs.getString("carName");
			String carColor 		= rs.getString("carColor");
			int displacement 	= rs.getInt("displacement");
			String manufacturer 	= rs.getString("manufacturer");
			
			vo.setCarNumber(carNumber);
			vo.setCarColor(carColor);
			vo.setCarName(carName);
			vo.setDisplacement(displacement);
			vo.setManufacturer(manufacturer);
		
		}
		return vo;

	}
}