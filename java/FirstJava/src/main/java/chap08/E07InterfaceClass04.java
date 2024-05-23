package chap08;

import java.util.Arrays;

public class E07InterfaceClass04 {

	public static void main(String[] args) {
//		인터페이스
//		- 추상 클래스가 발전된 기능
//		- 멤버는 상수와 추상 메서드만 가능
//		- 인터페이스 구현하는 클래스는 반드시 추상클래스를 구현해야함.
//		- 인터페이스 타입 참조 변수를 이용해서 업캐스팅으로 많이 사용
//		- 인터페이스는 하위 클래스들의 기능을 표준화
		
		// 정수형 => 개체로 전환 => 정수형 객체 : Wrapper클래스
		// 정수형객체 = 정수형 : 오토박싱, float f = 10; 10은 정수형이지만 실수형float타입으로 바뀜
		E07Data asc = new AscData();  // 업캐스팅 : 부모참조변수 = 자식변수, 객체   부모의 기능만 사용
		asc.setData(1,2,3,6,9,4);
		
		System.out.println("-- before Ascending");
		System.out.println(asc.toString());

		System.out.println("-- after Ascending");
		asc.sort();  // 오름차순 정렬하는 메서드 실행
		System.out.println(asc);
		

		System.out.println("-------------");
		E07Data desc = new DescData();
		desc.setData(1,2,3,6,9,4);
		
		System.out.println("-- before Decending");
		System.out.println(desc.toString());

		System.out.println("-- after Ascending");
		desc.sort();  // 오름차순 정렬하는 메서드 실행
		System.out.println(desc);
	}

}
