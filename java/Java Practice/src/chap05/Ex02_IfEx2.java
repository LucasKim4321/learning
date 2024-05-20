package chap05;

import java.util.Scanner;

public class Ex02_IfEx2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.printf("점수 입력: ");
		int score = Integer.parseInt(sc.next());
		String grade = "";
		
		System.out.println("학점부여 시작");
		if(score>=95) grade = "A+";
		else if(score>=90) grade = "A";
		else if(score>=85) grade = "B+";
		else if(score>=80) grade = "B";
		else if(score>=70) grade = "C";
		else if(score>=60) grade = "D";
		else grade = "F";
		System.out.println("당신의 학점은"+grade+"입니다.");
		System.out.println("학점부여 끝");
	}

}
