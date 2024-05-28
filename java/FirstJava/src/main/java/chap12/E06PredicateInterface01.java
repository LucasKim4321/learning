package chap12;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class E06PredicateInterface01 {

	public static void main(String[] args) {
		// Predicate
		// 1개의 매개변수, boolean 반환 자료형을 갖는 함수형 인터페이스
		// test()
		
		Predicate<Integer> isOdd = (s) -> (s%2) == 1;  // true or false 반환
		
		Scanner sc = new Scanner(System.in);
		System.out.printf("숫자 : ");
		sc.hasNextInt();  // 키보드 데이터값이 있으면 정수로 반환
//		System.out.println(isOdd.test(sc.nextInt()));
		
		boolean rs = isOdd.test(sc.nextInt());
		System.out.println((rs)?"홀수":"짝수");
		
		System.out.println("-- and , or");
		int a = 12;
		int b = 33;
		
		Predicate<Integer> isMin = s -> s > 10;
		Predicate<Integer> isMax = s -> s < 20;
		
		System.out.println(isMin.and(isMax).test(a));  // true  isMin과 isMax를 동시에 만족하면 true
		System.out.println(isMin.and(isMax).test(b));  // false
		
		System.out.println("-- isEqual");
		List<Integer> luckyNo = Arrays.asList(5,12,25,26,38,45);  // 추첨번호
		System.out.println(luckyNo);
		
		Predicate<List<Integer>> isLucky = Predicate.isEqual(luckyNo);
		List<Integer> myNo = Arrays.asList(5,12,25,26,32,45);  // 비교할 배열
		
		if (isLucky.test(myNo)) {  // myNo랑 비교해서 맞으면 true
			System.out.println("1등 당첨");
		}
		else {
			System.out.println("1등 아님");
		}
		
		System.out.println("--- not() , negate()");
		Predicate<Integer> isOdd2 = (s) -> (s%2 ==1);  // 홀수   s -> s%2 ==1; 괄호없이 이렇게도 씀
		Predicate<Integer> isEven2 = Predicate.not(isOdd2);  // 짝수  Predicate.not(대상) 대상의 반대값
		
		int num = 10;
		if (isOdd2.test(num)) {
			System.out.println("홀수");
		}
		else if (isEven2.test(num)) {
			System.out.println("짝수");
		}
		
		// 3의 배수 이거나 홀수인 수를 출력
		System.out.println("-- 3의 배수 이거나 홀수인 수를 출력");
		int[] no = {1,3,6,9};
		
		Predicate<Integer> isOdd3 = s -> s%2 == 1;  // 홀수
		Predicate<Integer> isMultipleThree = s -> s%3 == 0;  // 3의 배수
		
		for (int num1 : no) {
			if (isOdd.or(isMultipleThree).test(num1)) {
				System.out.printf("%d는 홀수이거나 3의 배수입니다.\n",num1);
			}
		}
	}

}
