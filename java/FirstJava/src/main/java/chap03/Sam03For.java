package chap03;

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
		
		
		
	}

}
