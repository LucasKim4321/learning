package chap05;

import lombok.ToString;

@ToString
public class E01Student {
	String name;
	
	public E01Student(String name) {
		this.name = name;
	}
	
	// inner class
	public class Score {
		int eng;
		int mat;
		
		public void showInfo() {
			// 외부 클래스의 자원 접근이 용이하다.
			System.out.println("이름 : "+name);
			System.out.println("영어 : "+eng);
			System.out.println("수학 : "+mat);
		}
	}
}
