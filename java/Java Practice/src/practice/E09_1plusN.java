package practice;

import java.util.Scanner;

public class E09_1plusN {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int result=0;
		for (int i=1; i<=n; i++) {
			result=result+i;
		}
		System.out.println(result);
	}

}
