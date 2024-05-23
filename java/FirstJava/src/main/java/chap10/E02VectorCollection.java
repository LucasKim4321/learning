package chap10;

import java.util.List;
import java.util.Vector;

import chap08.E01Student;

public class E02VectorCollection {

	public static void main(String[] args) {
		// Vector : ArrayList 이전에 사용
		// Vector : 멀티 스레드 환경에서 동기화를 지원
		
		List v = new Vector();
		// 업캐스팅 (부모클래스 = 하위클래스)
		v.add("홍길동");
		v.add(new Integer(100));  // int -> Integer 전환
		v.add(new E01Student());
		v.add(25);
		
		System.out.println(v);
		System.out.println(v.size());
		
		String name = (String) v.get(0);  // 다운 캐스팅
		Integer num = (Integer) v.get(1);
		E01Student s = (E01Student) v.get(2);
		int num2 = (Integer) v.get(3);  // Integer -> int
		
		System.out.println(name);
		v.set(0, "동길이");
		System.out.println(v);
		v.remove(0);
		System.out.println(v);
	}

}
