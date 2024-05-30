package chap13;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class E11CollectMethod04 {

	public static void main(String[] args) {
		// distinck(), count(), min(), max()


		List<FreeBoard> list = Arrays.asList(
				new FreeBoard(1, "가입인사", "Hello!!!"),
				new FreeBoard(2, "가입인사", "반갑습니다!!!"),
				new FreeBoard(3, "질문있습니다.", "어디 가시나요!!!")
				);
		long cnt1 = list.stream().collect(Collectors.counting());
		System.out.println("게시글 수 : "+cnt1);
		
		long cnt2 = list.stream().count();
		System.out.println("게시글 수 : "+cnt2);
		
		
		System.out.println("----");
		List<Integer> numbers = Arrays.asList(10,4,7,56,43,99);
		Integer minNumber = numbers.stream().min(Integer::compare).get();
		System.out.println(numbers);
		System.out.println("최소값 : "+minNumber);

		
		System.out.println("-------");
		List<Score> scores = Arrays.asList(
				new Score("레바",77,71,90),
				new Score("보겸",100,70,82),
				new Score("우왁굳",90,90,61)
				);
		
		scores.stream().collect(Collectors.minBy(Comparator.comparing(Score::getMat)))
		.ifPresent(System.out::println);
		
		Score minMathScore = scores.stream().min(Comparator.comparing(Score::getMat)).get();
		System.out.println(minMathScore);
		
		System.out.println(scores.stream().min(Comparator.comparing(Score::getMat)));
		System.out.println(scores.stream().min(Comparator.comparing(Score::getMat)).get());
		
		// sum() : 요소의 모든 수를 더하는 메서드
		System.out.println("-- reduce()");
		int sum1 = IntStream.rangeClosed(1, 5)
//				.boxed()  // 생략하면 자동으로 박싱해줌 // IntStream -> Stream<Integer>, collect(메서드 안에서 xxx.reducing() 반드시 써야함
				.reduce(0, (a,b)->a+b);
		System.out.println("1~5까지의 합(reduce(0, (a,b)->a+b)) : "+sum1);
		
		int sum2 = IntStream.rangeClosed(1, 5).boxed().reduce(0, Integer::sum);
		System.out.println("1~5까지의 합(reduce(0, Integer::sum)) : "+sum2);
		
		Integer sum3 = IntStream.rangeClosed(1, 10).skip(8).sum();  // skip(8) 8개 넘김
		System.out.println(sum3);
		
		// average() : 스트림이 요소의 평균값
		System.out.println("-- average()");
		IntStream.rangeClosed(1, 100).average().ifPresent(System.out::println);
		
		double avg = IntStream.rangeClosed(1, 100).average().getAsDouble();
		System.out.println(avg);
		
		// allMatch() : 스트림이 모든 요소가 조건을 만족하면 true
		// anyMatch() : 스트림이 요소가 하나 이상의 조건을 만족하면 true
		// noneMatch() : 스트림이 모든 요소가 조건을 만족하지않으면 true
		
		scores.stream().forEach( s-> {
			System.out.println(s);
		});
		
		// 모든 학생 수학점수가 40점 이상이면 true 미만이면 false
		boolean rs1 = scores.stream().anyMatch( x -> x.getMat() >= 40);
		System.out.println("수학 과락이 아닌 사람(40점 이상)이 있나요? "+(rs1?"네":"아니오"));
		
		boolean rs2 = scores.stream().allMatch( x-> x.getKor() >= 40);
		System.out.println("국어 과락은 없나요? "+(rs2?"네":"아니오"));
		
		boolean rs3 = scores.stream().noneMatch( x-> x.getEng() >= 40);
		System.out.println("영어는 모두 과락인가요? "+(rs3?"네":"아니오"));
		
		// findAny() : 스트림 요소 중에 조건에 맞는 첫 번째 요소 추출
		// findFirst() : 스트림 요소 중에 첫 번째 요소 추출
		System.out.println("-- findAny()");
		List<Integer> li = Arrays.asList(4,8,2,10,6);
		// 요소들 중에 제일 먼저 찾은 요소를 추출
		li.stream().findAny().ifPresent(System.out::println);
		
		li.stream().filter( x-> x>7).findAny().ifPresent(System.out::println);
		
		// findAny() 병렬 스트림 : 순서와 관계 없이 첫 번째 요소 추출 (먼저 된것)
		li.parallelStream().filter( x-> x>7).findAny().ifPresent(System.out::println);
		
		// 요소중 첫 번째
		li.stream().filter( x-> x>7).findFirst().ifPresent(System.out::println);
		
		// findFirst() 병렬 스트림 : 똑같이 첫 번째거 나옴
		li.parallelStream().filter( x-> x>7).findFirst().ifPresent(System.out::println);
	}

}
