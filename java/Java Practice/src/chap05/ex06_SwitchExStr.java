package chap05;

import java.util.Scanner;

public class ex06_SwitchExStr {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.printf("주소를 입력하세요.");
		String addr = sc.next();
		switch(addr) {
		case"서울":
			System.out.println("저희 집은 서울입니다.");
			break;
		case"제주":
			System.out.println("저희 집은 제주입니다.");
			break;
		default :
			System.out.println("주소 없음");
		}
	}

}
