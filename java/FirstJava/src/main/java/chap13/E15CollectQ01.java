package chap13;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class E15CollectQ01 {

	public static void main(String[] args) {
		
		// 1. Stream을 이용해서 구구단 
		IntStream.rangeClosed(1, 9).forEach( dan -> {
			System.out.println(dan+"단");
			IntStream.rangeClosed(1, 9).forEach(i -> {
				System.out.printf("%d x %d = %d \n",dan,i,(dan*i));
			});
		});

	}

}
