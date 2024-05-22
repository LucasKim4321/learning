package chap08;

public class E01College extends E01Student {
	private int courses;  // 대학생 학점
	public E01College(String name, int grade) {
		super(name,grade);
	}
	public void collegeInfo() {
		System.out.println("나는 대학생입니다.");
		System.out.println("이름:"+getName()+",학년"+getGrade());
	}
}
