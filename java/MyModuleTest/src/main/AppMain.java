package main;

import mysql_goods.MySqlGoods;
import oracle_goods.OracleGoods;

public class AppMain {

	public static void main(String[] args) {
		// mysql_goods 모듈에 있는 클래스를 불러와 사용
		MySqlGoods mySqlGoods = new MySqlGoods();
		mySqlGoods.listGoods();
		System.out.println();
		
		OracleGoods oracleGoods = new OracleGoods();
		oracleGoods.listGoods();
		System.out.println();
	}

}
