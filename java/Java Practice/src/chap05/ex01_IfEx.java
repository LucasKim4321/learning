package chap05;

import java.util.Scanner;

public class ex01_IfEx {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.printf("점수 입력: ");
		int score = sc.nextInt();
		System.out.println("시험 시작");
		if(score>=60) {
			System.out.println("합격입니다.");
		}
		else {
			System.out.println("불합격입니다.");
		}
		System.out.println("시험 끝");
	}

}
