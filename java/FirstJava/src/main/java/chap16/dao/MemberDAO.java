package chap16.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import chap16.vo.MemberVO;

public class MemberDAO {
	
	// 데이터베이스 관련 객체
	Connection conn = null;
	Statement stmt =  null; // sql문장처리하는 객체
	PreparedStatement pstmt = null;
	ResultSet rs = null; // query 결과값처리하는 객체
	
	// 생성자 : db접속
	public MemberDAO() {
		
		try {
			// DB 드라이브 로드
			Class.forName("org.mariadb.jdbc.Driver"); 
			
			conn = DriverManager.getConnection(
					"jdbc:mariadb://localhost:3306/mydb", // Host
					"java", // 계정
					"1234"  // 패스워드
					);
			
			if (conn != null) {
				System.out.println("conn: "+conn);
				System.out.println("접속 되었습니다.");
			}
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		} finally {
			
//			if (conn != null) try {
//				conn.close();
//				System.out.println("접속 해제!!!");
//			} catch (Exception e2) {}
		}	
				
	}
	
	// 데이터 입력
	public int insert(MemberVO vo) {
		int result = 0;
		try {
			// "INSERT INTO MEMBER (memberno, id, NAME) VALUES ("+ 1 +"  ,'" + hong +"','" + 홍길동 +"')"
			String sql = "insert into member (memberno, id, name) " +
						" values ("+vo.getMemberno()+", '" +vo.getId()+"' , '"+vo.getName()+"' )";
			System.out.println("sql: "+ sql);
			
			stmt = conn.createStatement();	// sql문장을 처리할 객체
			System.out.println("stmt: "+stmt);
			result = stmt.executeUpdate(sql);// insert, delete, update
			
			// -------------------------------------------------- //
			// PrepareStatement()
			// -------------------------------------------------- //
			
			String sql2 = """
					insert into member(memberno, id, name)
					values (?,?,?)
					""";
			
			pstmt = conn.prepareStatement(sql2);
			pstmt.setInt(1, vo.getMemberno());
			pstmt.setString(2, vo.getId());
			pstmt.setString(3, vo.getName());
			
			result = pstmt.executeUpdate();

			
		} catch (Exception e) {}
		
		return result;
	}
	
	// 데이터 조회
	
	// 데이터 수정
	
	// 데이터 삭제
	
	// 회원 목록
	public List<MemberVO> list() {
		List<MemberVO> list = new ArrayList<MemberVO>();
		
		try {
			String sql = "select * from member";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while( rs.next()) {
				MemberVO vo = new MemberVO();
				
				vo.setMemberno(rs.getInt("memberno"));
				vo.setId(rs.getString("id"));
				vo.setName(rs.getString("name"));
				
				list.add(vo);
			}
			
		} catch (Exception e) {}
		
		//System.out.println("query select result : "+list);
		return list;
	}

	

}