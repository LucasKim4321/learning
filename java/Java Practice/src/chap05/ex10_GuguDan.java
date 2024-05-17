package chap05;

import java.util.Scanner;

public class ex10_GuguDan {

	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		System.out.printf("단수 입력: ");
//		int dan = Integer.parseInt(sc.next());
//		for (int i=1; i<=12; i++) {
//			System.out.println(dan+"*"+i+"="+dan*i);
//		}
		for (int i=1; i<=9; i++) {
			System.out.println("["+i+"단]");
			for (int j=1; j<=9; j++) {
				System.out.println(i+"*"+j+"="+i*j);
			}
		}
	}

}
