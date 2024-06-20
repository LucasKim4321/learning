package chap21;

import my_db_lib.mysql.MySqlDriver;
import my_db_lib.oracle.OracleDriver;

public class E10MyDBLIbTest {

	public static void main(String[] args) {
		
		// 새로운 프로젝트 생성 -> src\java파일 생성 -> 프로젝트를 export -> jarFile생성 -> 이름.jar 지정후 생성
		// buildpath 지정 -> external JARs(외부 라이브러리 지정)
		
		OracleDriver driver1 = new OracleDriver();
		driver1.connect();
		
		MySqlDriver driver2 = new MySqlDriver();
		driver2.connect();
	}

}
