package practice;

import java.util.Scanner;

public class E04Alarm {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int h = sc.nextInt();
		int m = sc.nextInt();
		int result = h*60+m;
		result = result-45;
		h= result/60;
		m= result%60;
		if(m<0) {
			h=23;
			m=60+m;
		}
		System.out.println(h+" "+m);
	}

}