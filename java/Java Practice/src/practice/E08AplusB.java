package practice;

import java.util.Scanner;

public class E08AplusB {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int A,B;
		for(int i=1; i<=T; i++) {
			A = sc.nextInt();
			B = sc.nextInt();
			System.out.println(A+B);
		}
	}

}
