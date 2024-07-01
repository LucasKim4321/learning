package practice;

import java.util.Scanner;

public class E01Grade {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int result = sc.nextInt();
		
		result = result/10;
		switch(result) {
		case 10,9:
			System.out.println("A");
			break;
		case 8: 
			System.out.println("B");
			break;
		case 7:
			System.out.println("C");
			break;
		case 6:
			System.out.println("D");
			break;
		default:
			System.out.println("F");
		
		}
	}

}
