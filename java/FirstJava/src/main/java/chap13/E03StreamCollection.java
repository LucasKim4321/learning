package chap13;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Stream;

public class E03StreamCollection {

	public static void main(String[] args) {
		// Collection
		
		List<String> list1 = new ArrayList<String>();
		var list2 = new HashSet<Integer>();  // HashSet 중복제거
		
		list1.add("dog");list1.add("dog");
		list1.add("cat");list1.add("cat");
		
		list2.add(3);list2.add(3);
		list2.add(5);list2.add(5);
		list2.add(6);list2.add(6);
		
		// 스트림 생성
		Stream<String> arrStrm1 = list1.stream(); // 배열구조->Arryas.strea(배열)
		Stream<Integer> arrStrm2 = list2.stream();
		
		// 출력
		System.out.println("------");
		arrStrm1.distinct().forEach(System.out::println);  // stream.distinct() 중복제거
		arrStrm2.forEach(System.out::println);
		
		// 비어 있는 스트림 처리하기
		System.out.println("------");
		String[] arr1 = null;
//		Stream<String> stream = Stream.of(arr1);  // Arrays.stream(arr1);  // null에러
		Stream<Object> stream = Stream.of((arr1==null ? Stream.empty():arr1));  // 데이터가 null일시 처리
	}

}
