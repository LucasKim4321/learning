package ex01.sam03.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import ex01.sam03.vo.MemberVO;

// DB처리
public class MemberDAOImpl implements MemberDAO{
	// 1-1 DB연결 설정하는 멤버 변수
	
	// mariadb 연결
//	private static final String url = "jdbc:mariadb://localhost:3306/webdb(DB이름)";  // mariadb
	
	// oracle 연결  //  커넥션 풀 적용시 미사용됨.
//	private static final String url = "jdbc:oracle:thin:@//localhost:1521/xe";  // oracledb
//	private static final String user = "c##user";
//	private static final String pwd = "1234";
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	// 2-1 커넥션 풀
	private DataSource dataSource;
	
	public MemberDAOImpl() {
		//  커넥션 풀 적용시 미사용됨.
		// DB연결하는 메서드 호출
//		connDB();  //  커넥션 풀 적용시 미사용됨.
		
		// 2. 커넥션 풀 사용
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:comp/env");
			dataSource = (DataSource) envContext.lookup("jdbc/oracle");
			
		} catch (Exception e) {System.out.println(e.getMessage());}
	}
	
	// DB연결하기
	public void connDB() {
		//  커넥션 풀 적용시 미사용됨.
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("oracle 드라이브 로딩 성공");
			
//			conn = DriverManager.getConnection(url,user,pwd);  //  커넥션 풀 적용시 미사용됨.
			System.out.println("Oracle Connection 성공");
			System.out.println("------------------");
			
		} catch (Exception e) {System.out.println(e.getMessage());}
		
	}

	// 회원 목록 조회
	@Override
	public List<MemberVO> listMembers() {
		
		System.out.println("조회 실행");
		List<MemberVO> list = new ArrayList<MemberVO>();
		
		try {
			// 2-3
			conn = dataSource.getConnection();  // 커넥션 풀 적용
			
//		    conn.commit()이 옵션 넣었다가 autocommit오류나서 빼도 안되서 conn.setAutoCommit(false); 이거 쓰니까 되고 또 주석 처리해도 됨.... ㅡㅡ;
//			conn.setAutoCommit(false);  
			
			String sql = "select * from t_member";
			System.out.println(sql);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();  // 실행한 쿼리 값을 rs에 저장
			
			System.out.println(rs.next());  // 권한 설정 문제시 불러오지 못하면서 false

			while(rs.next()) {  // rs.next() rs의 다음 값이 존재하는 동안 true  // next() 값을불러오고 값이 존재하면 true 그리고 다시 실행시 그 다음 값을 불러옴.
				String id = rs.getString("id");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Date joinDate = rs.getDate("joinDate");

				MemberVO vo = new MemberVO();
				vo.setId(id);
				vo.setPwd(pwd);
				vo.setName(name);
				vo.setEmail(email);
				vo.setJoinDate(joinDate);

				list.add(vo);

			}
			System.out.println("------------------");
			
			rs.close();
			pstmt.close();
			conn.close();
			
		} catch (Exception e) {
			System.out.println("목록 불러오기 실패");
			System.out.println(e.getMessage());}
		
		return list;
	}
	
	// 회원 등록
	@Override
	public int regMember (MemberVO memberVO) {
		int result = 0;
		
		String sql = "";
		try {
			conn = dataSource.getConnection();
			sql = "insert into t_member (id,pwd,name,email) values (?,?,?,?)"; // 날짜 안쓰면 기본날짜
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberVO.getId());
			pstmt.setString(2, memberVO.getPwd());
			pstmt.setString(3, memberVO.getName());
			pstmt.setString(4, memberVO.getEmail());
			
			result = pstmt.executeUpdate();  // 업데이트를 하고 성공하면 int값으로 결과 반환
			pstmt.close();
			
		} catch (Exception e) {System.out.println(e.getMessage());}
		
		return result;
	}
	
	// 회원 수정
	@Override
	public int modMember (MemberVO memberVO) {
		int result = 0;
		return result;
	}
	
	// 회원 조회
	@Override
	public MemberVO viewMember (String id) {
		MemberVO vo = new MemberVO();
		return vo;
	}
	
	// 회원 삭제
	@Override
	public int removeMember (MemberVO memberVO) {
		int result = 0;
		return result;
	}
	
	/*
	* 커넥션 풀(ConnectionPool) : 미리 데이터베이스와 연결 시킨 상태를 유지하는 기술
	* 
	* 톰캣 컨테이너 자체적으로 ConnectionPool기능 제공해줌. (히카리 커넥션 풀(가장좋다고함))
	* 
	* javax.sql.DataSource클래스 이용 -> ConnectionPool 객체
	* JNDI(Java Naming and Directory Interface) : 필요한 자원을 key/value로 저장한 후 필요할 때 키로 통해 값을 호출
	* 
	* 
	*/
}
