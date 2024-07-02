package practice;

import java.util.Scanner;

public class E10Receipt {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int n = sc.nextInt();
		int result = 0;
		int a,b;
		for (int i=1; i<=n; i++) {
			a=sc.nextInt();
			b=sc.nextInt();
			result=result+(a*b);
		}
		if (x==result) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
		
	}

}
