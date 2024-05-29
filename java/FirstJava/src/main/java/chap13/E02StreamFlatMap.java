package chap13;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class E02StreamFlatMap {
	
	public static void main(String[] args) {
		// 스트림 가변 인자
		String[] str1 = {"홍길동","동길이","동순이"};
		String[] str2 = {"김길동","이순신","강감찬"};
		
		Stream<String[]> stm1 = Stream.of(str1, str2);  // Stream.of(가변인자)
		System.out.println("-- Stream.of(s,t)");
		stm1.forEach(x -> {
			System.out.println(Arrays.toString(x));
		});
		
		System.out.println("-- 스트림.flatMap()");
		Stream<String[]> stm2 = Stream.of(str1, str2);  // Strea.of(가변인자)
		Stream<String> flatstm = stm2.flatMap(Arrays::stream);  // Arrays.stream(str1)
		
		flatstm.forEach( x -> System.out.println(x));
		
		System.out.println("-- range()");
		IntStream intStream = IntStream.range(0, 5);  // range(0, 5) 0~4  5개
		intStream.forEach(System.out::println);

		System.out.println("-- rangeClosed()");
		IntStream.rangeClosed(0, 5).forEach(i -> System.out.println(i));  // rangeClosed(0, 5) 0~5 6개
		
		// 스트림 내에서 외부에 있는 기억장소를 사용시 : 멤버변수를 적용
		IntStream.rangeClosed(1, 10).forEach(i->sum+=i);
		System.out.println("sum="+sum);
	}

	static int sum = 0;
}
