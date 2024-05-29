package chap13;

import static java.util.stream.Collectors.toCollection;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;
import static java.util.stream.Collectors.toSet;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Function;




public class E07CollectMethod {

	public static void main(String[] args) {
		// collect(): 요소 하나하나를 매개 변수로 받아서 하나로 합쳐서 반환하는 최종 연산 메서드
		// toList(), toSet(), toCollection(), toMap()
		System.out.println("-- 배열");
		String[] animals = {"토끼","호랑이","고양이","강아지","고양이","고양이"};
		System.out.println(Arrays.toString(animals));
		
		System.out.println("-- List 변환");
		List<String> ani1 = Arrays.stream(animals).collect(toList());
		System.out.println(ani1);
		
		System.out.println("-- Set 변환");
		Set<String> ani2 = Arrays.stream(animals).collect(toSet());
		System.out.println(ani2);
		
		System.out.println("-- TreeSet");
		TreeSet<String> ani3 = ani1.stream().collect(toCollection(TreeSet::new));
		System.out.println(ani3);
		
		System.out.println("-- HashMap");  // key,value
		Map<String, Integer> ani4 = ani1.stream().collect(toMap(Function.identity(), String::length, (x1,x2)-> x1+x2));
		// toMap(key를 생성함 함수식, value값을 생성하는 함수식, key가 중복일 경우 처리하는 함수식
		System.out.println(ani4);
		
		System.out.println("--");
		String[][] level = {  // String 속성 2차원 배열
				{"홍길동","초급"}, {"홍길순","중급"}, {"동순이","고급"}
		};
		Map map = Arrays.stream(level).collect(toMap(x -> x[0], x->x[1]));
		System.out.println(map);
		
		// key 중복일 경우
		String[][] level2 = {
				{"홍길동","초급"}, {"홍길순","중급"}, {"홍길동","중급"}, {"동순이","고급"}
		};
		Map map2 = Arrays.stream(level2).collect(toMap(x -> x[0], x->x[1], (x,y) -> x+","+y));
		System.out.println(map2);
		
		String n = "";
		n = n + "A";
		System.out.println(n);
		n = n + "B";
		System.out.println(n);
	}

}
