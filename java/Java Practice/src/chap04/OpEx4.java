package chap04;

public class OpEx4 {

	public static void main(String[] args) {
//		비교 연산자 >, >=, <, <=, ==, != 비교 후 true/false 값 출력
//		= 대입  == 같은지 비교  != 같지 않으면 true
//		AND 기호 &&(&)  양쪽 다 true 일 때만 true
//		OR  기호 ||(|)  하나라도 true면 true
//		XOR 기호 ^  둘 중 하나만 true일 때 true
//		NOT 기호 !  결과 값의 반대
		//integer.toBinaryString(10진수);  // 10진수 값을 2진수로 변환시켜줌
		System.out.println(Integer.toBinaryString(888));
		System.out.println(~8888);  // 8888의 32자리 모든 비트를 뒤집은 값 -8889 출력
		System.out.println(Integer.toBinaryString(2));
		System.out.println(Integer.toBinaryString(~2));  // 첫자리 부호를 나타내는 비트 와 나머지 31자리 (총32자리)의 모든 비트를 반대로 변환
		System.out.println(Integer.toBinaryString(-3));  // ~2 와 -3은 같음
//		32자리 비트의 첫자리 비트 1은 음수, 0은 양수 4,294,967,296가지의 숫자 표현 -2,147,483,648 ~ 2,147,483,647 사이의 숫자
		System.out.println(Integer.toBinaryString(~2147483647));
		
//		비트 논리 연산
//		비트 연산 1 true 0 false
//		NOT빼고 기존 연산자와 동일
//		NOT 기호 ~ 반대의 값 (보수)
//		2 : 10  3 : 11
		System.out.println("2&3 : "+(2&3));  // 2진수로 비교 된 값 2진수 10을 10진수 2로 출력
		System.out.println("2|3 : "+(2|3));  // 결과값 2진수 11을 10진수 3으로 출력
		System.out.println("2^3 : "+(2^3));;  // 결과값 2진수 01을 10진수 1로 출력
		System.out.println("~3 : "+~3);  // 3의 비트를 뒤집은 값 -4를 출력
		
		System.out.println(Integer.toBinaryString(~3).length());  // 부호포함 32자리
		System.out.println(Integer.MAX_VALUE);  // 정수자료형의 양수 최대값 (2의 31승 -1) 2,147,483,647
		System.out.println(~Integer.MAX_VALUE);  // 음수 최대값 -2,147,483,648
		System.out.println(Integer.parseInt("1111111111111111111111111111100",2)-Integer.MAX_VALUE-1);  // -4
	}

}
