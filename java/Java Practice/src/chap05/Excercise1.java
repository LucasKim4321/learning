package chap05;

public class Excercise1 {

	public static void main(String[] args) {
		// 1부터 100까지의 정수 중 5의 배수의 합계를 충력하는 프로그램을 작성하시오.
		// for문 이용
		int sum = 0;
		for (int i=1; i<=100; i++) {
			if (i%5==0) {
				System.out.println("sum="+sum+"+"+i);
				sum+=i;
				System.out.println("sum="+sum);
			}
		}
		System.out.println("5의 배수의 합계는"+sum);
	}

}
