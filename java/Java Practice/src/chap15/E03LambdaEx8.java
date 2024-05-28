package chap15;

public class E03LambdaEx8 {

	static Student[] list = {
			new Student("홍길동",90,80,"컴공"),
			new Student("이순신",85,60,"통계"),
			new Student("동길이",55,10,"기계"),
	};
	public static void main(String[] args) {
		System.out.println("학생명 : ");
	}

}

class Student {
	private String name;
	private int eng;
	private int math;
	private String major;
	
	public Student(String name, int eng, int math, String major) {
		this.name = name;
		this.eng = eng;
		this.math = math;
		this.major = major;
	}
	public String getName() {
		return name;
	}
	public int getEng() {
		return eng;
	}
	public int getMath() {
		return math;
	}
	public String getMajor() {
		return major;
	}
}
