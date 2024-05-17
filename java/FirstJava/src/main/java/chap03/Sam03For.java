package chap03;

import java.util.Scanner;

public class Sam03For {

	public static void main(String[] args) {
		String[] names = {"자바","파이썬","코틀린"};
		for (String name : names) {
			System.out.println(name);
		}
		
		// String -> char
		String str = "Hello Java";
		char[] chr = str.toCharArray(); // Char속성 Array로 전환
		System.out.println(chr);
		for (char ch : chr) {
			System.out.println(ch);
		}
		
		// if, if/else, else if, for, while, do-while
		// switch
		System.out.println("switch()");
		int in = 6;
		switch(in) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 9:
			System.out.println("홀수");
			break;
		case 2:
		case 4:
		case 6:
		case 8:
		case 10:
			System.out.println("짝수");
			break;
		default:
			System.out.println("1부터 10까지의 숫자가 아님");
		}
		
//		java14부터 지원
		switch(in) {
		case 1,3,5,7,9:
			System.out.println("홀수");
			break;
		case 2,4,6,8,10:
			System.out.println("짝수");
			break;
		default:
			System.out.println("1부터 10까지의 숫자가 아님");
		}

		switch(in) {
		case 1,3,5,7,9 -> System.out.println("홀수");
		case 2,4,6,8,10 -> System.out.println("짝수");
		default -> {
			System.out.println("1부터 10까지의 숫자가 아님");
			System.out.println("정확한 수를 입력하세요");
			}
		}
		
		// switch에서 반환처리하기
		int mon = 0;
		Scanner sc = new Scanner(System.in); // 키보드 준비
		System.out.println("계절을 판단 할 수 있게 월을 입력:");
		mon = sc.nextInt(); //키보드 사용해서 mon값 입력
		String season = switch(mon) {
			case 12,1,2  : yield "겨울";  // yield return 역할
			case 3,4,5   : yield "봄";
			case 6,7,8   : yield "여름";
			case 9,10,11 : yield "가을";
			default      : yield "기후온난화";
		};
		System.out.printf("%d월은 %s입니다.",mon,season);
		
	}

}
