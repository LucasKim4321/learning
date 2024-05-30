package chap13;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class E10CollectMethod03 {

	public static void main(String[] args) {
		// 배열의 요소들을 특정한 값을 기준으로 집계하거나 분류 : groupingBy()

		List<Score> scores = Arrays.asList(
				new Score("레바",77,71,90),
				new Score("보겸",100,70,82),
				new Score("우왁굳",90,90,61)
				);
		scores.stream().forEach(System.out::println);
		
		// 수학 점수를 기준으로 A, B, C, D, F 학점으로 분류
		// groupingBy(함수형 인터페이스 타입이 1개인 경우) -> 입력 요소에 대해 구현한 함수에 따라 요소를 그룹화하고 결과를 Map형태로 반환
		// Map<a,b> 대상 처리 후 리턴  a 리턴값의 속성 b 맵핑할 대상의 속성
		// Map<String , Integer> map  => k:v=> 1:1
		// Map<String, List<Integer>> map> key:v => 1:n

		Map<String, List<Score>> result = scores.stream().collect(Collectors.groupingBy( s->{
												// return "문자"가 그룹핑 기준 => key로 설정
												// 처리중인 요소(scores의 개별요소) => value로 설정
												return (s.getMat()>=90?"A":s.getMat()>=80?"B":s.getMat()>=70?"C":s.getMat()>=60?"D":"F");
												}));
		System.out.println(result);
		
		System.out.println("-- 개별 수학 학점");
		result.keySet().forEach( k-> {
			List<Score> score = result.get(k);  // get(키) => 값을 추출
			score.stream().forEach( s -> System.out.printf(s.getName()+" : "));

			System.out.printf("수학 %s 학점\n",k);
			
			Long cnt = score.stream().collect(Collectors.counting());
			System.out.printf("%d 명\n",cnt);
		});
		
		// 근태 정보를 이용해서 출근, 지각, 결근 집계
		System.out.println("-- 근태 정보를 이용해서 출근, 지각, 결근 집계");
		List<String> jobCheck = Arrays.asList(
				"출근","출근","지각","출근","출근",
				"지각","출근","지각","출근","출근",
				"지각","지각","결근","출근","출근",
				"지각","출근","출근","출근","출근"
				);
		System.out.println("jobCheck : "+jobCheck);
		
		Map<String, Long> info = jobCheck.stream()
				.collect(Collectors.groupingBy(
						Function.identity(),  // 그룹핑 기준, Map의 key
						Collectors.counting()  //  결과 값을 Map의 value
						));
		System.out.println("홍길동 : "+info+" ?!?!?!");
		System.out.println("info keySet : "+info.keySet());
		System.out.println("info values : "+info.values());
		
		// partitioningBy()는 groupingBy()와 유사
		// groupingBy() : Function 함수형 인터페이스 : 스트림으로 넘어온 요소를 특정 자료형으로 반환 : x -> x
		// partitioningBy() : Predicate 함수형 인터페이스 : 스트림으로 넘어온 요소를 Boolean 자료형으로 반환 : x -> true/false
		
		// 수학 점수가 80점 이상인 사람과 그렇지 않은 사람을 구분
		System.out.println("-- 수학 80점 이상인 사람과 그렇지 않은 사람을 구분");
		Map<Boolean, List<Score>> result2 = scores.stream().collect(Collectors.partitioningBy( s-> {
			return (s.getMat()>=80 ? true : false);  // return 값이 그룹핑, key역할
		}));
		System.out.println("result2 : "+result2);
		result2.keySet().stream().forEach(key -> {
			System.out.println("-----"+key+":"+result2.get(key));
			if(key) {
				System.out.println("-- 수학점수가 80이상인 학생");
				List<Score> value = result2.get(key);
				value.stream().forEach( s-> System.out.println(s.getName()+","+s.getMat()));
			}
		});
		
		// 수학 점수가 80점 이상인 사람과 그렇지 않은 사람이 각각 몇명인지 파악
		System.out.println("-- 수학 점수가 80점 이상인 사람과 그렇지 않은 사람이 각각 몇명인지 파악");
		Map<Boolean, Long> result3 = scores.stream().collect(Collectors.partitioningBy( s -> {
			return s.getMat()>80? true:false;
			}, Collectors.counting()
		));
		System.out.println(result3);
		System.out.println("80점 이상 : "+result3.get(true)+"명");
	}

}
