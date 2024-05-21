package chap07;

import lombok.AllArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
public abstract class Ex01Car {
	private String color;  // 색
	private String manufacturer;  // 제조사
	
	public void printInfo() {
		System.out.println("이 차의 색 : "+this.color);
		System.out.println("이 차의 제조사 : "+this.manufacturer);
		System.out.println("이 차는 "+fillup());
	}
	// 추상(abstract) 메서드
	public abstract String fillup();
}
