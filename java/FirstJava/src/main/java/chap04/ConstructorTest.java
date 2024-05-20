package chap04;

import chap04.vo.Data;
import chap04.vo.Data2;

public class ConstructorTest {
	public static void main(String[] args) {
		// 객체 초기화
		Data d = new Data();
		System.out.println(d.toString());
		Data d2 = new Data("김길동",20);
		System.out.println(d2);
		
		Data d3 = new Data("김길동");
		System.out.println(d3);
		
		Data2 data1 = new Data2();
		Data2 data2 = new Data2("홍길순",12);
		
		System.out.println(data1);
		System.out.println(data2.toString());
	}
}
