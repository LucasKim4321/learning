package chap04;

import chap04.vo.VO2;

public class ClassTest01 {

	public static void main(String[] args) {
		// 사용자가 정의한 타입으로 객체를 생성
		VO2 myData = new VO2();
		myData.name = "홍길동";
		myData.age = 15;
		myData.height = 182.3;
		
		System.out.println(myData);
		
		System.out.println(myData.name);
		System.out.println(myData.age);
		System.out.println(myData.height);
		
		VO3 myData2 = new VO3();
		myData2.address = "부산시";
		myData2.tel = "000-0000-0000";
		
		System.out.println(myData2);
		System.out.println(myData2.address);
		System.out.println(myData2.tel);
		
		// private 선언된 변수
//		myData2.job = "디자인";  // error 안불러와짐
		
	}

}

class VO3 {
	// 접근 제어자: (default),public,private,protected
	String address;
	String tel;
	
	private String job;  // 클래스 내에서만 접근가능
}