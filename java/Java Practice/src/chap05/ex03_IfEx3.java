package chap05;

import java.util.Scanner;

public class ex03_IfEx3 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.printf("수학 점수 입력: ");
		int math = sc.nextInt();
		System.out.printf("영어 점수 입력: ");
		int eng = Integer.parseInt(sc.next());
//		if(math >= 60) {
//			if (eng >= 60) {
//				System.out.println("통과");
//			}
//		}else {
//			System.out.println("탈락!");
//		}
		if (math>=60&&eng>=60) {
			System.out.println("통과");
		}else {
			System.out.println("탈락!");
		}
		
	}

}
