package chap10;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class E02LinkedListCollection {

	static List<String> list1 = new ArrayList<String>();
	static List<String> list2 = new LinkedList<String>();
	
	public static void main(String[] args) {
//		Collections framework
//		Collection, Map
//		Collection -> List, Set  // List,Set 중복관련한것 빼고는 똑같음
//		List -> ArrayList, LinkedList, vector -> Stack  중복허용
//		Set -> HashSet, SortedSet -> TreeSet  중복제거
		
//		ArrayList 모든 값을 지우고 복사하는 과정으로 기능 구현 부하가 많음
//		LinkedList 각 데이터가 주소값을 가지고있고 그것들을 불러옴.
		list1.add("dog");list1.add("cat");list1.add("lion");
		myToString();
		list2.add("dog");list2.add("cat");list2.add("lion");
		myToString();
		list1.add(2,"tiger");list2.add(2,"tiger");
		myToString();
		
	}
	
	public static void myToString() {
		System.out.println("---");
		System.out.println("ArrayList : "+list1);
		System.out.println("ArrayList : "+list2);
	}

}
