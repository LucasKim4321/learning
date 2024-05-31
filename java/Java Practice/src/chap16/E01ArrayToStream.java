package chap16;

import java.util.Arrays;
import java.util.stream.Stream;

public class E01ArrayToStream {

	public static void main(String[] args) {
		String[] arr = new String[] {"a","b","c","d","e","f"};
		
		Stream<String> stream1 = Arrays.stream(arr);
		stream1.forEach(s -> System.out.println(s+" "));
		System.out.println();
		
		Stream<String> stream2 = Arrays.stream(arr,2,5);  // arr의 인덱스 번호 2~4번
		stream2.forEach(s->System.out.println(s+" "));
		
		
	}

}
