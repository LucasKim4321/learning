package chap08;

public class E02ClassInher {

	public static void main(String[] args) {
		// 업캐스팅(Upcasting) : 기능축소
		// : 부모 클래스 타입 참조변수 = 자식클래스 타입변수 or 인스턴스
		// 다운캐스팅(Downcasting) : 기능확대
		// : 자식 클래스 타입 참조변수 = (자식클래스타입)부모클래스타입 타입변수 인스턴스
		System.out.println(10/3);
		System.out.println((float)10/3);  // int속성의10/3을 float속성으로 형전환
		

		// 업캐스팅(Upcasting) : 기능축소
		E02Student s = new E02Middle("동순이",10,50);
		s.study();
		s.test();
//		s.studentInfo()  // 기능 축소에 의해 작동안됨
		
		// 다운캐스팅(Downcasting) : 기능확대
		E02Middle m2 = (E02Middle)s; // 기능 확대  (타입)값 값을 타입의 속성으로 형전환
		m2.study();m2.test();m2.studentInfo();
		
		E02Student s2 = new E02College("길동이",3);
		
		E02Student[] arrStudent = new E02Student[3];
		arrStudent[0] = new E02Middle("동순이",10,50);
		arrStudent[1] = new E02Middle("길동이",7,30);
		arrStudent[2] = new E02Middle("홍길동",9,40);
		E02Middle t = (E02Middle)arrStudent[0];
	}

}
