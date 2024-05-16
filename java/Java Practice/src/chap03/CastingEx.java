package chap03;

public class CastingEx {

	public static void main(String[] args) {
		// 자동형변환 예시
		int number = 10;  // int 자료형
		long number2 = number;  // 자동형변호나 int < long
		System.out.println(number2);
//		작은 크기의 자료형을 큰 크기의 자료형 바꿀 시 자동형변환이 일어난다.
//		byte(1)<short(2)<int(4)<long(8)<float(4)<double(8
//		char(2),boolean(1)
		
		// 강제형변호나 예시
		double pi = 3.14; // double 자료형
		int pi2 = (int)pi;  // 강제형변환
		System.out.println(pi);  // 3.14
		System.out.println(pi2);  // 값의 손실 발생 3
		
		double score = 100;
		int score2 = (int)score;
		System.out.println(score);  // 100.0
		System.out.println(score2);  // 100
	}

}
