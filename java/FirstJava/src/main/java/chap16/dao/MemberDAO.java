package chap16.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
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
					"root", // 계정
					"3690"  // 패스워드
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
			
			// """  """ 이런식으로 쓰면 괄호 같이 적용?
			String sql2 = """
					insert into member(memberno, id, name) 
					values (?,?,?)
					""";
			
			pstmt = conn.prepareStatement(sql2);
			System.out.println("1111"+pstmt);  // parameters 값은 비어있음
			pstmt.setInt(1, vo.getMemberno());
			pstmt.setString(2, vo.getId());
			pstmt.setString(3, vo.getName());
			System.out.println("2222"+pstmt);  // set한것들 parameters 값에 들어감
			result = pstmt.executeUpdate();  // update 후 반환값 1  실행 횟수에 따라 바뀜

			
		} catch (Exception e) {System.out.println("!!!"+e.getMessage());}
		
		return result;
	}
	
	// 데이터 조회
	public MemberVO selectOne(int memberno) {
		
		MemberVO vo = new MemberVO();
		
		try {
//			String sql = "SELECT * FROM member WHERE memberno="+memberno;
//			stmt = conn.createStatement();
//			stmt.execute(sql);
		
			// PrepareStatement()
			String sql2 = "SELECT * FROM member WHERE memberno= ?";
			pstmt = conn.prepareStatement(sql2);
			pstmt.setInt(1, vo.getMemberno());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				vo.setMemberno(rs.getInt("memberno"));
				vo.setId(rs.getString("id"));
				vo.setName(rs.getString("name"));
			}
			else { System.out.println("읽어올 데이터가 없습니다.");}
		} catch (Exception e) {System.out.println("!!!"+e.getMessage());}
		
		return vo;
	}
	
	// 데이터 수정
	public int update(MemberVO vo) {
		
		int result = 0;
		
		try {
//			String sql = "UPDATE member SET NAME = '"+vo.getName()+"' WHERE memberno = "+vo.getMemberno();
//			stmt = conn.createStatement();
//			result = stmt.executeUpdate(sql);
			
			// PrepareStatement()
			String sql = "UPDATE member SET NAME = ? WHERE memberno = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setInt(2, vo.getMemberno());
			result = pstmt.executeUpdate();
			
		} catch (Exception e) { System.out.println("!!!"+e.getMessage());}
		
		return result;
	}
	
	// 데이터 삭제
	public int delete(int memberno) {
		int result = 0;
		try {
//			String sql = "DELETE FROM member WHERE memberno = "+memberno;
//			stmt = conn.createStatement();
//			result = stmt.executeUpdate(sql);
			
			//PrepareStatement()
			String sql = "DELETE FROM member WHERE memberno = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memberno);
			result = pstmt.executeUpdate();
		} catch (Exception e) {System.out.println("!!!"+e.getMessage());}
		return result;
	}
	
	// 회원 목록
	public List<MemberVO> list() {
		List<MemberVO> list = new ArrayList<MemberVO>();
		System.out.println("333 list"+list);
		
		try {
			String sql = "select * from member";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while( rs.next()) {
				MemberVO vo2 = new MemberVO();
				
				vo2.setMemberno(rs.getInt("memberno"));
				vo2.setId(rs.getString("id"));
				vo2.setName(rs.getString("name"));
				
				list.add(vo2);
			}
			
		} catch (Exception e) {}
		
		//System.out.println("query select result : "+list);
		return list;
	}
	
	// 자원 close()
	public int close() {
		if (conn!=null) {
			try {conn.close();} catch (Exception e) {System.out.println(e.getMessage());}
			try {stmt.close();} catch (Exception e) {System.out.println(e.getMessage());}
			try {pstmt.close();} catch (Exception e) {System.out.println(e.getMessage());}
			try {rs.close();} catch (Exception e) {System.out.println(e.getMessage());}
			return 1;
		}else {return 0;}
	}

	

}