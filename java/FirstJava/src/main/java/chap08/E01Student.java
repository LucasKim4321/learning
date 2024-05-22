package chap08;

import lombok.Data;

@Data
public class E01Student {
//	public: 모든 곳에서 접근 가능, 기본값: 지정하지 않은 상태 같은 폴더내에서 접근가능, private 클래스 내에서만 접근
//	protected : 상속 관계에서는 접근가능, 같은 패키지 가능
//	1.
//	public String name;
//	public int grade;
//	2.
//	protected String name;
//	protected int grade;
//	3.
	private String name;
	private int grade;
	
	// 인자가 없는 생성자 : 객체 생성시점에 한번 수행하는 메서드
	// 인자 없는 생성자 호출시 에러를 막기위해 기본적으로 생성함
	public E01Student() {
		System.out.println("E01Student 기본생성자 호출");
	}

	// 매개 변수가 있는 생성자
	public E01Student(String name, int grade) {
		System.out.println("매개변수가 있는 Student 생성자 호출");
		this.name = name;  // 매개변수
		this.grade = grade;
	}
	
	// 기능 수행을 위한 일반 메서드
	public void study() {
		System.out.println("시험 공부를 합니다.");
	}
	public int test() {
		System.out.println("시험 점수입니다.");
		return 0;
	}
	// 학생 신상 정보 출력 메서드
//	@Override
//	public String toString() {
//		return "E01Student [name=" + name + ", grade=" + grade + "]";
//	}
}
