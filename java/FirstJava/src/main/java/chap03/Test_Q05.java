package chap03;

import java.util.Arrays;
import java.util.Scanner;

public class Test_Q05 {

	public static void main(String[] args) {
//		키보드로부터 입받아서 1부터 입력받은 수만큼 배열에 담아 내용을 for문을 사용하여 출력
		
		int number;
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자를 입력하세요.");
		number = sc.nextInt();  // 키보드로부터 받은 문자형 -> 숫자형
		System.out.println(number);
		int[] data = new int[number];  // number의 크기만큼 배열이 잡힘
		System.out.println("배열의 크기:"+data.length);
		for (int i=0; i<data.length; i++) {
			data[i] = i+1;
		}
		System.out.println("배열 주소"+data);  // 객체의 주소가 나옴
		System.out.println("배열 data:"+Arrays.toString(data));  // 배열의 값들이 나옴

		System.out.println("-- for");
		for(int i=0; i<data.length; i++) {
			System.out.printf("data[%d]=%d\n",i,data[i]);  //printf() 형식이있는 걸 쓸 때
		}

		System.out.println("--확장 for");
		int idx =0;
		for (int num : data) {  // 배열을 있는 데이터를 순서대로 불러오는 역할
			System.out.printf("data[%d]=%d\n",idx++,num);
		}
		
		System.out.println("--Arrays stream()");
		Arrays.stream(data).forEach((num)->System.out.println(num));
		System.out.println("--메서드 참조");
		Arrays.stream(data).forEach(System.out::print);
		
		
		
		int[] a = data;
		System.out.println(a);
		System.out.println(Arrays.toString(a));
	}

}
