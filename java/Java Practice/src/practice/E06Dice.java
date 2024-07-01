package practice;

import java.util.Scanner;

public class E06Dice {

	public static void main(String[] args) {
		int a = (int) ((Math.random()*6)+1);
		int b = (int) ((Math.random()*6)+1);
		int c = (int) ((Math.random()*6)+1);
		
//		Scanner sc = new Scanner(System.in);
//		int a,b,c;
//		a=sc.nextInt();
//		b=sc.nextInt();
//		c=sc.nextInt();
		
		int price = 0;
		if (a==b && b==c) {
			price=10000+a*1000;
		} else if (a==b || b==c || a==c) {
			if (a==c) {
				price=1000+a*100;
				
			} else {
			price=1000+b*100;
			}
		} else {
			price = (a>=b && a>=c ? a : b>=c ? b : c)*100;
		}
		System.out.println(a+","+b+","+c);
		System.out.println(price);
	}

}
