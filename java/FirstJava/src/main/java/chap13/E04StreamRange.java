package chap13;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import lombok.AllArgsConstructor;
import lombok.Data;

public class E04StreamRange {
	static int cnt=0;  //
	public static void main(String[] args) {
		// 특정 범위에서 스트림 얻기
		// IntStream.range(시작,마지막)  마지막 미포팜
		// IntStream.rangeClosed(시작,마지막)  마지막 포함
		
		List<Board> boardList = new ArrayList<Board>();
		IntStream.range(1, 6)
			.forEach(i-> {
				boardList.add(new Board(i, "title_"+i, "user_"+i, LocalDateTime.now()));
				});  // 1~5
		boardList.stream().forEach(System.out::println);
		
		// 람다식에서 지역변수 사용은 제약
		System.out.println("-- 람다식에서 지역변수");
//		int cnt = 0;  // (안됨) 지역변수 제약 
//		람다식에서 외부변수 : 멤버변수, 지역변수 final 배열구조에 초기값설정
		final int[] cnt2 = {10};
		boardList.forEach( x -> {
			System.out.println(x);
			System.out.println("람다식 안에서 멤버변수 사용가능"+cnt++);
			System.out.println("람다식 안에서 멤버변수 사용가능"+cnt2[0]++);
			});
		
		// 램덤 수에서 스트림
		IntStream intStream1 = new Random().ints(5);  // new Random() 랜덤한 숫자 생성  ints(5) 5개의 int속성 숫자
		intStream1.forEach(System.out::println);
		
		System.out.println("--");
		IntStream intStream2 = new Random().ints(1,5).limit(10);  // ints(1,5) 1~4까지의 숫자  limit(10) 10개
		intStream2.forEach(System.out::println);
	}

}

@Data@AllArgsConstructor
class Board {
	int no;
	String title;
	String user;
	LocalDateTime createDate;
}