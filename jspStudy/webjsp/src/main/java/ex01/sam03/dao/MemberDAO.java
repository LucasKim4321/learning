package ex01.sam03.dao;

import java.sql.Connection;
import java.sql.DriverManager;

// DB처리
public class MemberDAO {
	// 1-1 DB연결 설정하는 멤버 변수
//	private static final String url = "jdbc:mariadb://localhost:3306/webdb(DB이름)";  // mariadb
	private static final String url = "jdbc:oracle:thin:@//localhost:1521/xe";  // oracledb
	private static final String user = "c##user";
	private static final String pwd = "1234";
	
	private Connection conn;
	
	public MemberDAO() {
		// DB연결하는 메서드 호출
		connDB();
		
	}
	
	// DB연결하기
	public void connDB() {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("oracle 드라이브 로딩 성공");
			
			conn = DriverManager.getConnection(url,user,pwd);
			System.out.println("Oracle Connection 성공");
			System.out.println("------------------");
			
		} catch (Exception e) {System.out.println(e.getMessage());}
		
	}
}
