package chap16.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import chap16.vo.MyMemberVo;


public class MyMemberDAO {
	
	// 데이터베이스 관련 객체
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	
	// 생성자 : db접속
	public MyMemberDAO() {
		try {
			// DB 드라이브 로드
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mariadb://localhost:3306/mydb",
					"root",
					"3690"
					);
			if (conn != null) {
				System.out.println("conn: "+conn);
				System.out.println("접속 되었습니다.");
			}
		} catch (Exception e) { System.out.println(e.getMessage()); }
		finally {
//			if (conn!=null)
//				try {
//					conn.close();
//					System.out.println("접속해제!!!");
//				} catch (Exception e) { System.out.println(e.getMessage()); }
		}
	}
	
	// 데이터 입력
	public int insert(MyMemberVo vo) {
		int result = 0;
		
		try {
			String sql = "insert into member (memberno, id, name) values (?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getMemberno());
			pstmt.setString(2, vo.getId());
			pstmt.setString(3, vo.getName());
			result = pstmt.executeUpdate();
		} catch (Exception e) {System.out.println(e.getMessage());}
		
		return result;
	}
	
	// 데이터 조회
	
	// 데이터 수정
		
	// 데이터 삭제
		
	// 회원 목록
	public List<MyMemberVo> list() {
		List<MyMemberVo> list = new ArrayList<MyMemberVo>();
		
		try {
			String sql = "select * from member";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while( rs.next()) {
				MyMemberVo vo2 = new MyMemberVo();
				
				vo2.setMemberno(rs.getInt("memberno"));
				vo2.setId(rs.getString("id"));
				vo2.setName(rs.getString("name"));
				
				list.add(vo2);
			}
			
		} catch (Exception e) { System.out.println(e.getMessage()); }
		
		return list;
	}

}
