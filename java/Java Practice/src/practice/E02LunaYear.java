package practice;

import java.util.Scanner;

public class E02LunaYear {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int year = sc.nextInt();
		
		int checkLunaYear = 0;
		
		if (year%400==0) {
			checkLunaYear=1;
			
		} else if (year%4==0 && year%100!=0) {
			checkLunaYear=1;
			
		} else {
			checkLunaYear=0;
		}
		System.out.println(checkLunaYear);
		
	}

}
