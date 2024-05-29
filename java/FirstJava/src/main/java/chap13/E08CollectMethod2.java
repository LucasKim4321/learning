package chap13;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lombok.Data;
import lombok.RequiredArgsConstructor;

public class E08CollectMethod2 {

	public static void main(String[] args) {
		// 최종작업을 추가로 처리할 경우 : collectingAndThen(), reverse()

		System.out.println("---- 배열 역정렬 list");
		List<String> locals = Arrays.asList("서울","대전","대구","광주","부산","제주");
		
		List<String> reversedLocals = locals.stream().collect(Collectors.collectingAndThen(Collectors.toList(), city -> {  // Collectors.collectingAndThen(A,B) 대상을 A한다음 B함
										Collections.reverse(city);  // 배열을 역정렬
										return city;  // list 구조에서 반환
										}));
		System.out.println(locals);
		System.out.println(reversedLocals);
		
		System.out.println(("---- 배열 역정렬 set"));
		Set<String> reversedLocals2 = locals.stream().collect(Collectors.collectingAndThen(Collectors.toList(), city -> {
										Collections.reverse(city);  // 배열을 역정렬
										return city.stream();  // list구조를 다시 stream으로
										})).collect(Collectors.toSet());  // list 구조를 set으로
		System.out.println(locals);
		System.out.println(reversedLocals2);
		
		
		// 수정 할 수 없는 상태 : unmodifiableList() : Collection클래스를 수정불가 상태로 바꿈
		System.out.println("-- unmodifiableList()");
		List<String> G7 = Stream.of("미국","영국","프랑스","독일","이탈리아","캐나다","일본")
								.collect( Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));  // Collections::unmodifiableList 수정불가로 변환
		System.out.println(G7);
//		G7.add("한국");  // unmodifiableList 때문에 안됨
		
		// 평균
		System.out.println("-- averagingInt()");
		List<Integer> scores = Arrays.asList(100,100,61,85,91);
		System.out.println("평균 : "+scores.stream().collect(Collectors.averagingInt(i->i)));
		
		List<Score> scores2 = Arrays.asList(
				new Score ("홍길동",100,100,100),
				new Score ("동길이",100,100,80),
				new Score ("동순이",100,100,90),
				new Score ("김길동",100,100,70)
				);
		double avgMat = scores2.stream().collect(Collectors.averagingInt(Score::getMat));
		System.out.println(avgMat);
	}

}

@Data
@RequiredArgsConstructor  // final 붙은것들 생성자
class Score {
	private final String name;
	private final int kor;
	private final int eng;
	private final int mat;
	private String msg;
}