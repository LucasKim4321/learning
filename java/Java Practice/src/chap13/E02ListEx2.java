package chap13;

import java.util.Vector;

public class E02ListEx2 {

	public static void main(String[] args) {
		Vector list = new Vector();
		list.add(1.2);  // List method
		list.add(Math.PI);  // List method
		list.addElement(3.4);  // previous method
		System.out.println(list);
		
		// 향상된 for문
		for (Object o : list) {
			System.out.println(o);
		}
		double num = 3.4;
		
		// 해당 요소의 인덱스 (없으면-1)
		int index = list.indexOf(num);
		if (index >= 0) {  // 요소가 존재함
			System.out.println(num+"의 위치:"+index);
		}
		else {  // 존재하지 않음
			System.out.println(num+"는 list에 없습니다.");
		}
		
		num = 1.2;
		// 값이 존재하는지 확인
		if (list.contains(num)) {
			// 제거(이전메서드)
			list.removeElement(num);
			System.out.println(num+"삭제됨");
		}
		
		// 해당 요소의 인덱스 (없으면 -1)
		System.out.println(list.indexOf(num));  // -1
		System.out.println(list);  // toString()
	}

}
