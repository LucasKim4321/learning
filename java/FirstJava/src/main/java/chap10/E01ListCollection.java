package chap10;

import java.util.ArrayList;
import java.util.List;

public class E01ListCollection {

	public static void main(String[] args) {
//		Collections framework
//		Collection, Map
//		Collection -> List, Set  // List,Set 중복관련한것 빼고는 똑같음
//		List -> ArrayList, LinkedList, vector -> Stack  중복허용
//		Set -> HashSet, SortedSet -> TreeSet  중복제거
		
//		ArrayList 모든 값을 지우고 복사하는 과정으로 기능 구현 부하가 많음
//		LinkedList 각 데이터가 주소값을 가지고있고 그것들을 불러옴.
		
		List<String> arr = new ArrayList<String>();  // List<String>인터페이스의 ArrayList<String>()클래스를 통해 구현
		
		arr.add("홍길동");  //  add("데이터") 리스트배열 마지막에 데이터를 넣음
		arr.add("동길이");
		arr.add("동순이");
		arr.add("동길이홍");
		
		System.out.println(arr);
		System.out.println("-- 확장 for");
		for (String s : arr) {  // 리스트 배열을 하나씩 불러와서 출력
			System.out.println(s);
		}

		System.out.println("-- forEach");
		arr.forEach( (s) -> {
			System.out.println(s);
		});
		
		System.out.println("-- forEach2");
		arr.forEach(System.out::println);  // 간단히 출력만 할때
		
		System.out.println("-- add(index,data)");  // 배열.add(index,data)
		arr.add(0,"김길동");  // arr배열의 0번째 인덱스에 김길동 추가
		arr.forEach(System.out::println); 
		
		System.out.println("-- 수정 : set(index,data)");  // array[5] = 100
		arr.set(3, "강감찬");
		arr.forEach( x -> System.out.println(x));
		
		System.out.println("-- 특정 위치 값 추출");  // array[1]
		System.out.println(arr.get(0));  // 김길동
		System.out.println(arr.get(3));  // 강감찬
		
		System.out.println("크키 : "+arr.size());  // 리스트의 length값이 나옴
		
		System.out.println("-- 배열에 값이 있으면 index 추출");
		System.out.println(arr.indexOf("강감찬"));  // 강감찬의 index번호 3출력
		System.out.println(arr.indexOf("ㅇㅇ"));  // 없으면 -1 추출
		
		System.out.println("-- 삭제 : index위치에 있는 요소 삭제");
		arr.remove(3);
		arr.forEach(System.out::println);
		
		int idx = arr.indexOf("동길이");
		System.out.printf("검색결과 : ");
		if (idx > -1) {
			System.out.println(arr.get(idx));
		}
		else
			System.out.println("존재하지않습니다.");
		
		System.out.println("-- delArr리스트를 참조해서 arr리스트에서 삭제");
		List<String> delArr = new ArrayList<String>();
		delArr.add("김길동");
		delArr.add("동길이홍");
		
		arr.removeAll(delArr);  // 묶어서 삭제 할 경우
		arr.forEach(System.out::println);

	}

}
