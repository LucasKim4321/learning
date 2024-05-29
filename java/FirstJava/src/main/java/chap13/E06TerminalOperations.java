package chap13;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class E06TerminalOperations {

	public static void main(String[] args) {
		// 최종 연산 : toArray(), forEach() ...
		int[] numbers = IntStream.rangeClosed(1, 10).toArray();
		System.out.println(Arrays.toString(numbers));
		Arrays.stream(numbers).forEach(System.out::println);
		
		System.out.println("-- forEach(), forEachOrdered()");
		List<Integer> list = Arrays.asList(2,4,6,8,10);
		
		System.out.println("-- 직렬 forEach()");  // 순서대로 처리 느림
		list.forEach(x->System.out.println(x+""));

		System.out.println("-- 병렬 forEach() : 비순서");  // 동시에 처리 빠름  결과 순서 없음
		list.parallelStream().forEach(x->System.out.println(x+""));
		
		System.out.println("-- 병렬 forEachOrdered() : 순서보장");
		list.parallelStream().forEachOrdered( x->  {
			System.out.println(x+" ");
		});
		
		// reduce() : 누적 함수를 사용하여 스트림요소에 대한 값을 반환
		// reduce(초기값, (인자1,인자2))
		System.out.println("-- reduce() 합계");  // 합계구함
		int[] nums = {1,2,3};
		int sum = 0;
		for (int x : nums) {
			sum += x;
		}
		System.out.println("sum = "+sum);
		
		int sum2 = Arrays.stream(nums).reduce(0, (x,y) -> x+y);
		System.out.println("sum2 = "+sum2);
		
		int sum3 = Arrays.stream(nums).reduce(0, Integer::sum);
		System.out.println("sum3 = "+sum3);
		
		System.out.println("-- 1부터 100까지의 합");
		int sum4 = IntStream.rangeClosed(1, 100).reduce(0, (x,y)->x+y);
		int sum5 = IntStream.rangeClosed(1, 100).reduce(0, (x,y)-> {
			return x+y;
		});
		int sum6 = IntStream.rangeClosed(1, 100).reduce(0, Integer::sum);

		System.out.println("sum4 = "+sum4);
		System.out.println("sum5 = "+sum5);
		System.out.println("sum6 = "+sum6);

		System.out.println("-- reduce() 곱하기"); 
		int fac = IntStream.rangeClosed(1, 4).reduce(1, (x,y) -> x*y);  // factorial 4 값을 구하는 식
		System.out.println("fac = "+fac);
		
//		Integer.sum(fac, fac); 구조
//		public static int sum(int a, int b) { return a+b;}
		
//		Optional 클래스 : null이 발생하는 것을 대비한 타입으로 null인 경우 default값을 설정할 수 있음.
		System.out.println("-----");
		int optSum1 = 0;
		OptionalInt optSum2;
		optSum1 = IntStream.rangeClosed(7, 10).reduce(6, Integer::sum);  // 6+34
		System.out.println("optSum1 = "+optSum1);
		
		optSum2 = IntStream.rangeClosed(6, 10).reduce(Integer::sum);  // 40
		System.out.println("optSum2 = "+optSum2);  //
		System.out.println("optSum2 = "+(optSum2.getAsInt()+100));

		System.out.println("-----");
		OptionalInt optSum3 = OptionalInt.empty();
		if (optSum3.isEmpty()) {
			System.out.println("비어 있음");
		}
		optSum3 = OptionalInt.of(123);
		if (optSum3.isPresent()) {
			System.out.println(optSum3.getAsInt());
		}
		else {
			System.out.println("값이 없음");
		}
		
		// Optional클래스에서 제공하는 메서드
		
		// isPresent() : 값의 유무 판멸 : true,false
		// orElse(T), orElse(double) : 저장된 값이 없는 경우 디폴트 값 지정
		// ifPresent(consumer), ifPresent(DoubleConsumer) : 지정된 값이 있는 경우 처리
		
		// IntStream -> Optional도 기본형값으로 OptionInt 반환

		System.out.println("-----");
		OptionalInt t1 = OptionalInt.of(0);  // 0저장
		OptionalInt t2 = OptionalInt.empty();  // null을 저장
		
		System.out.println(t1.isPresent());  // true
		System.out.println(t2.isPresent());  // false

		System.out.println(t1.getAsInt());
//		System.out.println(t2.getAsInt());  // 에러 발생
		
		Optional<String> t3 = Optional.ofNullable(null);
		Optional<String> t4 = Optional.empty();
		System.out.println(t3.equals(t4));  // equals 같은지 비교 true  empty() = null
		
		System.out.println("-----");
		IntStream.rangeClosed(1, 5)
			.reduce(Integer::sum)  // 15
			.ifPresent(System.out::println);  // ifPresent 값이 있을 경우에만 처리
	}
}
