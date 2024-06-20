package oracle_goods;

import oracle_common.OracleDriver;

public class OracleGoods {
	public void connect() {
		System.out.println("OracleGoods!!");
	}
	public void listGoods() {
		OracleDriver driver = new OracleDriver();
		driver.connect();
		System.out.println("Oracle 데이터베이스에서 상품정보 조회");
	}
}
