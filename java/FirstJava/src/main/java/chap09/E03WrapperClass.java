package chap09;

import java.util.Scanner;

public class E03WrapperClass {

	public static void main(String[] args) {
		// Wrapper클래스 : 기본 자료형 -> 객체화
		// 기본 자료형 boolean, byte, char, short, int, long, float, double
		// Wrapper클래스 Boolean, Byte, Charactor, Short, Integer, Long, Float, Double
		
		System.out.println("int 최대값:"+Integer.MAX_VALUE);
		System.out.println("int 최소값:"+Integer.MIN_VALUE);
		System.out.println("long 최대값:"+Long.MAX_VALUE);
		System.out.println("long 최소값:"+Long.MIN_VALUE);
		System.out.println("양수 long의 2진수 값:"+Long.toBinaryString(Long.MAX_VALUE));
		System.out.println("음수 long의 2진수 값:"+Long.toBinaryString(Long.MIN_VALUE));
		System.out.println("long의 2진수 값의 길이 :"+Long.toBinaryString(Long.MIN_VALUE).length());
		
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자:");
		String num = sc.next();  // String타입
		int number = Integer.parseInt(num);  // String -> int
		System.out.println((num+100)+","+(number+100));
	}

}
