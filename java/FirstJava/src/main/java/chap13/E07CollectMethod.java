package chap13;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;



public class E07CollectMethod {

	public static void main(String[] args) {
		// collect(): 요소 하나하나를 매개 변수로 받아서 하나로 합쳐서 반환하는 최종 연산 메서드
		// toList(), toSet(), toCollection(), toMap()
		
		String[] animals = {"토끼","호랑이","고양이","강아지","고양이","고양이"};
		System.out.println(Arrays.toString(animals));
		
		System.out.println("-- List 변환");
		List<String> ani1 = Arrays.stream(animals).collect(toList());
		
		System.out.println(ani1);
	}

}
