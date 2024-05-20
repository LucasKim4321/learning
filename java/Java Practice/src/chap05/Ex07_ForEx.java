package chap05;

import java.util.Scanner;

public class Ex07_ForEx {

	public static void main(String[] args) {
//		for (int i=0; i<10; i++) {
//			System.out.println("i="+i);
//		}
		Scanner sc = new Scanner(System.in);
		int len = Integer.parseInt(sc.next());
		int sum = 0;
		for (int i=1; i<=len; i++) {
			sum += i;
		}
		System.out.println("합계:"+sum);
	}

}
