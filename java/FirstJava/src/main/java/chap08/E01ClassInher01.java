package chap08;

public class E01ClassInher01 {

	public static void main(String[] args) {
//		1.
//		상속 -> 자원 재사용
//		E01Middle m = new E01Middle();
//		부모클래스의 기능을 상속받아 재사용
//		m.setName("홍길동");
//		m.setGrade(1);
//		m.study();
//		m.test();
//		System.out.println(m.test());

//		2.
//		상속 -> 자원 재사용
//		E01Middle m = new E01Middle("동순이",10);
//		m.study();
//		System.out.println(m.test());
//		System.out.println(m.getName());
//		System.out.println(m.getGrade());
//		// 자식 클래스에서 작성한 기능
//		m.setScore(30);
//		m.studentInfo();

//		3.
		System.out.println("------E01Middle");
		E01Middle m = new E01Middle("동순이",10,50);
		m.study();  // 자식 클래스의 study()를 불러옴.
		System.out.println(m.test());
		System.out.println(m.getName());
		System.out.println(m.getGrade());
		// 자식 클래스에서 작성하는 기능
		m.setScore(30);
		m.studentInfo();
		System.out.println("------E01College");
		E01College c = new E01College("길동이",3);
		c.study();
		System.out.println(c.test());
		System.out.println(c.getName());
		System.out.println(c.getGrade());
		// 자식 클래스에서 작성한 기능
		c.collegeInfo();
		
		
//		상속 -> 자원 재사용
//		클래스 사이의 관계
		
//		is-a 관계 : 한 클래스가 다른 클래스를 설명
//		College is a student : 대학생은 학생입니다.
//		Bus is a car : 버스는 자동차입니다.
		
//		use-a 관계 : 클래스가 다른 클래스를 사용하는 관계
//		A student uses a calculator : 학생이 계산기를 사용한다.
//		A driver uses a car : 운전자가 자동차를 운전한다.
		
//		has-a 관계 : 한 클래스가 다른 클래스를 소유(포함)하는 관계
//		A car has a tire : 자동차는 타이어를 가집니다.
//		A computer has a monitor : 컴퓨터는 모니터를 가집니다.
		
//		Java에서는 클래스 단일 상속만 가능
//		interface를 이용한 다중 상속 기능 사용 가능
//		상위클래스 : 공통된, 메서드 : 기능 축소 (상위클래스의 기능만 존재)
//		하위클래스 : 개별 속성, 메서드 : 기능 확대 (상위클래스의 기능 + 하위클래스의 기능)
//		상위 클래스 : 학생, 하위 클래스 : 대학생 클래스, 중학생 클래스
		
	}

}
