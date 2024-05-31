package chap13;

import java.util.stream.Stream;

public class E15CollectQ05 {

	public static void main(String[] args) {

		// 5. 로또 번호를 스트림을 이용하여 난수를 발생시켜서 출력
		/*
		 * 조건 
		 * - 중복 값이 있으면 안된다.
		 * - 1부터 45까지의 수만 올 수 있다.
		 * - 순차적으로 정렬
		 * 
		 *  > 결과 : 2 4 5 22 24 48
		 */
		
		Stream.generate(Math::random)
			.peek(x->System.out.println("random : "+x))
			.map(n-> (n*44)+1)
			.peek(x->System.out.println("(x*44)+1"+x))
			.map(Math::round)
			.peek(x->System.out.println("round(x*44)+1"+x))
			.distinct()
			.limit(6)
			.sorted()
			.peek(x->System.out.println(x))
			.forEach(x-> System.out.printf("%d ", x));
		
//		Stream.generate(Math::random)
//		.map(n-> (n*44)+1)
//		.map(Math::round)
//		.distinct()
//		.limit(6)
//		.sorted()
//		.forEach(x-> System.out.printf("%d ", x));
	}

}
