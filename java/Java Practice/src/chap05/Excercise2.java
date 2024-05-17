package chap05;

public class Excercise2 {

	public static void main(String[] args) {
		//1부터 100까지 수의 짝수와 홀수의 합을 각각 구하시오.
		int evenSum = 0; 
		int oddSum = 0;
		// for문을 이용하여 반복 합계 연산
		for (int i=1; i<=100; i++) {
			if(i%2==0) {
				evenSum+=i;
			}else {
				oddSum+=i;
			}
		}
		System.out.println("짝수의 합계는"+evenSum);
		System.out.println("홀수의 합계는"+oddSum);
	}

}
