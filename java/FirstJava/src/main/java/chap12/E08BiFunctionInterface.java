package chap12;

import java.util.function.BiFunction;
import java.util.function.BiPredicate;

public class E08BiFunctionInterface {

	public static void main(String[] args) {
		// BiFunction 함수형인터페이스 : 2개의 매개변수, 반환값
		// Function : (x) -> x, BiFunction : (x,y) -> z
		BiFunction<Integer, Integer, Integer> bif = (a,b) -> a*b;
		System.out.println(bif.apply(100, 2)+1000);
		
		BiPredicate<Integer, Integer> bip = (a,b) -> a>b;
		System.out.println(bip.test(10, 20));
	}

}
