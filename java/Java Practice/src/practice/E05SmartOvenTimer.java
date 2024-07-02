package practice;

import java.util.Scanner;

public class E05SmartOvenTimer {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int cookingTime = sc.nextInt();
		int result = a*60+b+cookingTime;
		a=result/60;
		b=result%60;
		
		if (a>=24) {
			a=a-24;
			
		}
		System.out.println(a+" "+b);
		
		
	}

}
