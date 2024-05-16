package chap02;

import java.util.Random;
import java.util.Scanner;

public class Sam03Scanner {

	public static void main(String[] args) {
//		 [타입]변수 = 데이터
//		Scanner sc = new Scanner(System.in);  // 표준입력장치(키보드) system(키보드)
//		System.out.print("입력 : ");
//		String in = sc.nextLine();  // 키보드 입력 대기 -> 입력 후 변수에 값 대입
//		System.out.println("입력한 값 : "+in);
		
		// nextxxx(): 공백 이전까지 문자열을 반환
//		int num1 = 0;
//		System.out.print("숫자1:");  // 엔터 사라짐 입력할 때 
//		num1 = sc.nextInt();
//		System.out.println(num1+","+(num1*2));
//		float num2 = sc.nextInt();
//		System.out.println(num1+","+(num2*2));
//		num1 = sc.nextInt();
//		System.out.println(num1+","+(num1*2));
		
//		String str = "";
//		System.out.print("String:");
//		str = sc.nextLine();
//		System.out.println("문자열");
//		
//		char[] chr;
//		System.out.print("char:");
//		chr = sc.next().toCharArray();  // String -> char 배열 전환
//		System.out.println(chr);
//		System.out.println(chr[0]);
//		System.out.println(chr[1]);
		
		final float PI = 3.14159f;  // final 읽기 전용
//		PI = 3.14f;  // 에러남
		System.out.println("PI"+PI);
		
		Random rnd = new Random();
		
		for (int i=0; i<10; i++) {
			int num_rnd = rnd.nextInt(3)+1;  // 1~3 사이의 렌덤한 숫자 발생
			System.out.println(num_rnd);
		}
	}
}