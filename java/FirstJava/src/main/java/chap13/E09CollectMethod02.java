package chap13;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import lombok.AllArgsConstructor;
import lombok.Data;

public class E09CollectMethod02 {

	public static void main(String[] args) {
		List<FreeBoard> boardList = Arrays.asList(
				new FreeBoard(1, "가입인사", "Hello!!!"),
				new FreeBoard(2, "가입인사", "반갑습니다!!!"),
				new FreeBoard(3, "질문있습니다.", "어디 가시나요!!!")
				);
		List<FreeBoard> reversedList = boardList.stream()
									.collect(Collectors.collectingAndThen(Collectors.toList(), (contents)-> {  // collect 메소드를 써서 Collectors를 시켜서 처리
										Collections.reverse(contents);
										return contents;
										// return contents.stream() 스트림으로 반환환해 다른 작업
									}));
		// counting(): 스트림의 요소 하나 하나를 세어 최종 스트림 요소의 수를 반환
		long cnt = boardList.stream().collect(Collectors.counting());  // 요소의 개수
		
		System.out.println("FreeBoard 게시글 수 : "+cnt);
		
		System.out.println("-- 정렬 전");
		System.out.println(boardList);
		boardList.stream().forEach(System.out::println);
		
		System.out.println("-- 정렬 후");
		System.out.println(reversedList);
		reversedList.stream().forEach( (b) -> {
			System.out.printf("no = %d\n",b.getNo());
			System.out.printf("게시글 제목 : %s\n",b.getTitle());
			System.out.printf("게시글 내용 : %s\n",b.getContents());
		});
		
		// 요소중 제일 큰값, 제일 작은 값 : maxBy(), minBy()
		System.out.println("-- 요소중 제일 큰값, 제일 작은 값 : maxBy(), minBy()");
//		Score name,kor,eng,mat,msg
		List<Score> scores = Arrays.asList(
				new Score("레바",77,71,90),
				new Score("보겸",100,70,82),
				new Score("우왁굳",90,90,61)
				);
		
		System.out.println("-- 국어점수가 가장 낮은 학생");
		scores.stream().collect(Collectors.minBy(Comparator.comparing(Score::getKor)))  // minBy(Comparator.comparing(대상)) 대상을 비교해 최소값인 대상 리턴
		.ifPresent( s -> System.out.printf("최저 점수 : %d, 이름 : %s\n",s.getKor(),s.getName()));  // ifPresent 값이 존재하면 처리
		
		System.out.println("-- 국어점수가 가장 높은 학생");
		scores.stream().collect(Collectors.maxBy(Comparator.comparing(Score::getKor)))  // maxBy(Comparator.comparing(대상)) 대상을 비교해 최대값인 대상 리턴
		.ifPresent( s -> System.out.printf("최고 점수 : %d, 이름 : %s\n",s.getKor(),s.getName()));  // ifPresent 값이 존재하면 처리
		
		System.out.println("-- 영어점수가 가장 높은 학생");
		scores.stream().collect(Collectors.maxBy(Comparator.comparing(Score::getEng)))  // maxBy(Comparator.comparing(대상)) 대상을 비교해 최대값인 대상 리턴
		.ifPresent( s -> System.out.printf("최고 점수 : %d, 이름 : %s\n",s.getEng(),s.getName()));  // ifPresent 값이 존재하면 처리
		
		System.out.println("-- 이름순으로 제일 빠른 학생");
		scores.stream().collect(Collectors.minBy(Comparator.comparing(Score::getName)))
		.ifPresent( s -> System.out.printf("이름 : %s\n",s.getName()));
		
		System.out.println("-- 이름순으로 제일 느린 학생");
		scores.stream().collect(Collectors.maxBy(Comparator.comparing(Score::getName)))
		.ifPresent( s -> System.out.printf("이름 : %s\n",s.getName()));
		
		
		// 스트림 요소들을 하나로 조합하는 메서드 : joining()
		System.out.println("-----");
		List<String> langList = Arrays.asList("py","java","c");
		System.out.println("list:"+langList);
		
		// 단순 조합
		System.out.println("-- joinging()");
		String word = langList.stream().collect(Collectors.joining());
		System.out.println("-- 연결: "+word);
		
		String word2 = langList.stream().collect(Collectors.joining(", "));
		System.out.println("-- 연결2: "+word2);
		

		String word3 = langList.stream().collect(Collectors.joining(",","프로그래밍 언어에는 ","등이 있습니다."));
		System.out.println("-- 연결3: "+word3);
		
		
		// reducing()
		// 스트림 요소에서 처리할 경우
		
		int sum1 = IntStream.rangeClosed(1, 10).reduce(100, Integer::sum);
		System.out.println(sum1);
		
		IntStream range = IntStream.rangeClosed(1, 10);
		// .boxed() : IntStream -> Stream<Integer>로 박싱
		long sum2 = range.boxed()  // boxed() 정수형 스트림으로 처리 가능하게끔 해줌
				.collect(Collectors.reducing(1000, Integer::sum));
		System.out.println(sum2);
				
		
		
		
	}

}

@Data
@AllArgsConstructor
class FreeBoard {
	private int no;
	private String title;
	private String contents;
}

