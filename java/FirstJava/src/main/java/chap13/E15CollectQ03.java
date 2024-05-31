package chap13;

import java.util.stream.IntStream;

public class E15CollectQ03 {

	public static void main(String[] args) {
		// 3. 1에서 100까지의 수 중에서 소수만 골라서 총 몇 개의 요소가 있는지 Stream을 이용하여 구현
		
		IntStream.rangeClosed(2, 100)
		.filter(x-> {
			int i = IntStream.rangeClosed(2, x)
					.map(y-> (x%y)==0? 1:0)  // 나누어 떨어지면 1 아니면 0
					.reduce(0, Integer::sum);  // 나누어 떨어진 값들을 합침
			return i<2;  // 나누어 떨어지는 횟수가 2보다 적어야 소수로 판별 (자기자신 외는 나누어 덜어진 경우가 없다)
		})
		.forEach(System.out::println);
		
	}

}
