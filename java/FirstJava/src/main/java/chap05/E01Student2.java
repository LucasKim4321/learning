package chap05;

public class E01Student2 {
	
	static String name;
	
	// 생성자
	public E01Student2(String name) {
		this.name = name;
	}
	
	public static class Score {
		int eng;
		int mat;
		
		public Score(String name) {
			// static 멤버변수는 클래스이름.멤버변수 접근가능
			// Student2를 참조
			// this 현재 객체를 참조
			E01Student2.name = name;
		}
		public void showInfo() {
			// 외부 클래스의 자원접근이 용이하다.
			System.out.println("이름 : "+name);
			System.out.println("영어 : "+eng);
			System.out.println("수학 : "+mat);
		}
	}


}
