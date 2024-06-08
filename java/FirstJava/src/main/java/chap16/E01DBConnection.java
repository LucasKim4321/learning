package chap16;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class E01DBConnection {

	public static void main(String[] args) {
		// 데이터 베이스 접속
		Connection conn = null;
		
		try {
			// mariadb 드라이버 클래스 로드
			Class.forName("org.mariadb.jdbc.Driver");
			try {
				conn = DriverManager.getConnection(
						"jdbc:mariadb://localhost:3306/mydb",  // Host(url)
						"root",  // 계정(user)
						"3690"  // password
						);
				if (conn != null) {
					System.out.println("conn: "+conn);
					System.out.println("접속 되었습니다.");
				}
	
			} catch (SQLException e) {
				e.printStackTrace();
			}
			finally {
				if (conn != null) try {
					conn.close();
					System.out.println("접속 해제!!!");
				}
				catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

}
