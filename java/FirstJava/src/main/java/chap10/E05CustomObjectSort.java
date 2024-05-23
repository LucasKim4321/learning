package chap10;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

public class E05CustomObjectSort {

	public static void main(String[] args) {
		// 객체 정렬
//		List<Emplyee> list = new ArrayList<Emplyee>();
		// 타입 추론 : var 변수 = 데이터 타입을 값에 맞게 자동으로 바꿔줌.
//		int num = 100;
//		var num1 = 100;
//		var num2 = 100.2;  // 알아서 바꿔줌 double num2 = 100.2
//		var name = "홍길동";
		
		var list = new ArrayList<Emplyee>();
		
		list.add(new Emplyee(1, "홍길동"));
		list.add(new Emplyee(3, "동길이"));
		list.add(new Emplyee(2, "동순이"));
		System.out.println(list);
		Collections.sort(list);
		System.out.println(list);
		
	}

}

@Data@AllArgsConstructor
class Emplyee implements Comparable<Emplyee> {
	private int sabun;
	private String name;
	
	@Override
	public int compareTo(Emplyee o) {
		
		// 정렬 기준 : 멤버변수 설정, 오름/내림
		// 숫자일 경우 : 
		//  오름차순(Ascending)  => this.멤버변수 - 객체.멤버변수
		//  내림차순(descending) => 객체.멤버변수 - this.멤버변수
		
//		return this.sabun - o.sabun;  // Ascending
//		return o.sabun - this.sabun;  // descending
		
		// 문자일 경우 : compareTo()
//		return this.name.compareTo(o.name);  // 오름차순
		return o.name.compareTo(this.name);  // 내림차순
	}
}