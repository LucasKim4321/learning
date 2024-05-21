package chap05;

public class E01NestedClass01 {

	public static void main(String[] args) {
//		중첩 클래스
//		-인스턴스 내부 클래스
//		-지역 내부 클래스  블럭{} 내에서 선언된 변수
//		-익명 내부 클래스
//		-정적 중첩 클래스
		
		// outer class에 대한 인스턴스 생성
		E01Student st1 = new E01Student("홍길동");
		// 내부 클래스에 대한 인스턴스 생성
		E01Student.Score st1Score = st1.new Score();  //  st1대신 기존 생성자 사용가능
		
		st1Score.eng = 23;
		st1Score.mat = 21;
		st1Score.showInfo();  // 홍길동 영어23 수학21

		st1Score = new E01Student("동길이").new Score(); // 기존 값 덮어씌움
		st1Score.showInfo();  // 동길이 영어0 수학0
		System.out.println(st1);  // 홍길동
//		st1Score = new E01Student.Score();  // 내부 클래스 Score에 static안붙이면 사용불가
		
	}

}
