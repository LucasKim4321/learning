package chap12;

import java.text.DecimalFormat;
import java.util.function.Function;

public class E05FunctionInterface02 {

	public static void main(String[] args) {
		// Function
		// default<V> function<V,R> compose(...)
		
		int myMoney = 100000;
		// 세금 10% 납부
		Function<Integer, Integer> work = (money) -> {
			System.out.printf("*[%d] 세금을 납부합니다.\n",(int)(money*0.1));
			return money = (int)(money*0.9);
		};
		
		// 수입금 더하기
		Function<Integer, Integer> before = (income) -> {
			System.out.printf("[%d] 수입이 발생했습니다.\n", income);
			return income;
		};
		myMoney = work.apply(myMoney);
		System.out.println("세금 10% 납부"+myMoney);
		
		// 함수1.compose(함수2) 함수1 실행 전 함수2실행 / 함수2의 return값을 함수1에 apply
		myMoney += work.compose(before).apply(30000);
		System.out.println("수익금 더한 후 "+myMoney);
		
		printInfo(myMoney);
		
		System.out.println("--- andThen");
		Function<String, Integer> work2 = s -> {
			System.out.println("-- 입력된 문자열을 숫자로 변환합니다.");
			return Integer.parseInt(s);
		};
		Function<Integer, String> work3 = i -> {
			System.out.println("-- 입력된 숫자를 문자열로 변환");
			return ""+i;
		};
		
		// 함수1.andThen(함수2) 함수1 실행 후 함수2실행 / 함수1의 return값을 함수2에 apply
		if (work2.andThen(work3).apply("123") instanceof String) {
			System.out.println("String 입니다.");
		}
		else {
			System.out.println("String이 아닙니다.");
		}
		
		System.out.println("-- identity");
		Function<Integer, Integer> fun = Function.identity();  // fun = (x) -> x 의 의미
		System.out.println(fun.apply(10));
		
	}
	// 숫자 출력 형식
	public static void printInfo(int myMoney) {
		DecimalFormat df = new DecimalFormat("#,###원");
		System.out.println("잔액:" +df.format(myMoney));
	}

}
