package chap19.common.base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public abstract class AbstractBaseDAO {
	
	protected static final String driver = "orb.mariadb.jdbc.Driver";
	protected static final String url = "jdbc:mariadb://localhost:3306/rentcar";  //rentcar데이터베이스를 불러옴
	protected static final String user = "root";
	protected static final String pwd = "3690";
	
	static protected Connection conn = null;
	protected PreparedStatement pstmt = null;
	protected ResultSet rs = null;
	
	public AbstractBaseDAO() {
		if (conn == null) {
			connDB();
		}
	}
	
	// db 드라이브 로딩
	public void connDB() {
		try {
			// DB 드라이브 로드
			Class.forName(driver);
			conn = DriverManager.getConnection(url,user,pwd);
			
			System.out.println("Connection 생성 성공");
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
			try {
				rs.close(); pstmt.close(); conn.close();
			} catch (Exception e2) {e2.getMessage();}
		
		}
		
	}

}
