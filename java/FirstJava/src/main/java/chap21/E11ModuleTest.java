package chap21;

import mysql_goods.MySqlGoods;
//import oracle_goods.OracleGoods;

public class E11ModuleTest {

	public static void main(String[] args) {
		// Maven프로젝트에선 module-info에 requires 설정 없이 BuildPath 등록 후 바로 써짐
		
		MySqlGoods mySqlGoods = new MySqlGoods();
		mySqlGoods.listGoods();
		
//		OracleGoods oracleGosods = new OracleGoods();
//		oracleGoods.listGoods();
	}

}

/* 모듈 프로젝트
 * module-info.java 파일을 생성하여 아래 내용 추가
 * 
 * module oracle_module {
 * 	exports oracle_goods;
 * }
 * 
 * 모듈 가져와서 사용하기
 * module-info.java 파일 생성하여 아래 내용 추가
 * 
 * module MyModuleTest(프로젝트와 동일한 모듈명) {
 * 	requires oracle_module;
 * }
 * 
 * 이클립스 환경에서는 modulepath를 등록해야함.
 * 프로젝트 -> BuildPath -> Configure .. -> Projects탭 => Module Path -> Add버튼 등록
 *
 * 
 */
