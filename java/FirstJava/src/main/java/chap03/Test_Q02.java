package chap03;

import java.util.Arrays;
import java.util.Scanner;

public class Test_Q02 {

	public static void main(String[] args) {
		// 양의 정수를 입력받아서 각 자리의 합을 출력해 보세요
		// 실행결과 num=2347 2347의 자릿수의 합은 16
		
		int num;
		Scanner sc = new Scanner(System.in);
		System.out.println("자연수를 입력하세요.");
		System.out.println("num= ");
//		num = sc.nextInt();  // string -> int  (키보드 입력은 다 문자)
		num = Integer.parseInt(sc.next());  // string -> int
//		System.out.printf("%d %d %d \n",num/10,num/100,num%10);
//		System.out.println(10/3);  // 정수/정수 => 정수
//		System.out.println(10/3.0);  //  정수/실수 => 실수
		
		int remainder = 0, sum = 0;
		int mok = num;
		do {
			remainder = mok % 10; // 나머지
			mok = mok / 10;  // 몫
			// 나머지 값은 각 자리수를 의미
			sum += remainder;  // 각 자릿수 합계
			System.out.println("나머지 = "+remainder+", 몫 = "+mok);
		}while(mok != 0);  // 특정 조건을 만족할때까지 반복
		System.out.println(num+"의 자릿수의 합은"+sum);
//		do {
//			remainder += mok % 10;
//			mok = mok / 10;  // 몫
//			System.out.println("나머지 = "+remainder+", 몫 = "+mok);
//		}while(mok != 0);
//		System.out.println(num+"의 자릿수의 합은"+sum);
		
		
//		// 내가 만든것
//		Scanner sc = new Scanner(System.in);
//		String num = sc.next();
//		String[] numArray = num.split("");
//		int sum = 0;
//		for (int i=0; i<numArray.length; i++) {
//			sum += Integer.parseInt(numArray[i]);
//		}
//		System.out.printf("실행결과 num=%s  %s의 $s자릿수의 합은 %d",num,num,sum);
//		
//		// 2
//		int num2 = sc.nextInt();
////		sum = 0;
//		int len = 5;
//		num1234 sum = 1234%10+ (1234%100-1234%10)+(1234%1000-1234%100)
//		for (int i=0; i<len; i++) {
//			
//		}
		
//		System.out.printf("실행결과 num=%s  %s의 자릿수의 합은 %d",num,num,sum);
		
	}

}
