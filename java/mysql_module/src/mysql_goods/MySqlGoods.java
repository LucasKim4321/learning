package mysql_goods;

import mysql_common.MySqlDriver;

public class MySqlGoods {
	
	public void listGoods() {
		MySqlDriver driver = new MySqlDriver();
		driver.connect();
		System.out.println("MySql Goods ~~");
	}
}
