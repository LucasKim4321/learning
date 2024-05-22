package chap08;

import lombok.Data;

// 중학생 클래스
@Data
public class E01Middle extends E01Student {  // extends 부모클래스로부터 상속 받음
	private int score = 0;  // 중학생 점수
	
//	자식클래스에서는 부모 클래스의 생성자 사용 불가능
	
	//2. 부모클래스 멤버변수가 protected로 설정되었을때 적용
//	public E01Middle() {}
//	public E01Middle(String name, int grade) {
////		name = name;  //상속된(부모)클래스의 변수
//		super.name = name;  //상속된(부모)클래스의 변수
//		super.grade = grade;  //상속된(부모)클래스의 변수
//		this.score = 0;  // 현재클래스의 변수
//	}

	// 3. 부모 클래스 멤버변수가 private로 설정되었을 때 사용
	public E01Middle(String name, int grade, int score) {
		super(name,grade);  // 부모생성자에게 값을 넘겨주면 부모생성자가 처리함
		this.score = score;
	}
	public void studentInfo() {
		System.out.println("나는 중학생입니다.");
		System.out.println("이름:"+getName()+",학년"+getGrade()+",점수"+score);
	}

	// 1.
//	public void studentInfo() {
//		System.out.println("나는 중학생입니다.");
//		System.out.println("이름:"+name+",학년"+grade);
//	}
	
	@Override  // 기존에 있는 기능을 덮어씌움
	public void study() {
		System.out.println("중학생 시험 공부를 합니다.");
		super.study();  // 부모 클래스에 있는 메소드 호출 가능
	}
}
