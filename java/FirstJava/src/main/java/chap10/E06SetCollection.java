package chap10;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class E06SetCollection {

	public static void main(String[] args) {
		// Set : 순서가 없음. 중복 불가
		Set<String> set = new HashSet<String>();
		
		set.add("cat");set.add("cat");set.add("cat");set.add("cat");
		set.add("lion");set.add("lion");set.add("lion");set.add("lion");
		set.add("dog");set.add("dog");set.add("dog");set.add("dog");
		
		System.out.println(set);
		
		System.err.println("-----");
		// List : 중복 가능
		List<String> list = new ArrayList<String>();
		list.add("dog");list.add("dog");
		list.add("cat");list.add("cat");
		list.add("frog");list.add("frog");
		list.add("rabbit");list.add("rabbit");
		System.out.println(list);
		
		set.addAll(list);  // list의 중복된 값을 set에 추가해 중복제거
		System.out.println(set);
		
		System.out.println("-- 중복제거된 set => List2에 저장");
		List<String> list2 = new ArrayList<String>();
		list2.addAll(set);
		System.out.println(list2);
		
		// TreeSet : 이진 트리의 형태로 데이터를 저장하는 자료구조
		// 이진 트리 : 각 노드의 자식 노드가 최대 두개로 왼쪽 한 개 오른쪽 한 개로 구성 구조
		// in-order(중위 순회) : 좌측, 가운데, 우측
		// pre-order(전위 순회) : 가운데, 왼쪽, 우측
		// post-order(후위 순회) : 좌측, 오른쪽, 우측
		
		var arr = new ArrayList<String>();
		arr.add("사자");arr.add("호랑이");arr.add("원숭이");
		
		System.out.println("-- ArrayList를 TreeSet으로 가져오기[addAll()]");
		
		var trs = new TreeSet<String>();
		trs.addAll(arr);
		System.out.println("TreeSet:"+trs);
		
		System.out.println("-- TreeSet에 타이거 추가[add()]");
		trs.add("타이거");
		System.out.println("TreeSet:"+trs);
		
		String addString = "토끼";
		System.out.printf("-- TreeSet에 %s가 없으면 추가[contains()]\n", addString);
//		System.out.println(trs.contains(addString));  // contains 있으면 true 없으면 false
		if (trs.contains(addString))  // 판별해서 출력
			System.out.printf("TreeSet에 %s가 있습니다.\n",addString);
		else
			System.out.printf("TreeSet에 %s가 없습니다.\n",addString);

		System.out.println("arr"+arr);
		System.out.println("trs"+trs);
		System.out.printf("-- TreeSet에 %s보다 크거나 같은 값 중에 제일 가까운 값을 출력[ceiling()]","자");
		System.out.printf("%s\n",trs.ceiling("자"));  // 타이거
		
		System.out.printf("-- TreeSet에 %s보다 작거나 같은 값 중에 제일 가까운 값을 출력[floor()]","자");
		System.out.printf("%s\n",trs.floor("자"));  // 원숭이
		
		System.out.printf("-- TreeSet에 %s보다 큰 값을 출력[higher()]","토끼");
		System.out.printf("%s\n",trs.higher("토끼"));  // 호랑이
		
		System.out.printf("-- TreeSet에 %s보다 작은 값을 출력[lower()]","토끼");
		System.out.printf("%s\n",trs.lower("토끼"));  // 타이거

		System.out.printf("-- TreeSet에 첫 번째 값을 출력[fisrt()]","토끼");
		System.out.printf("%s\n",trs.first());  // 사자
		
		System.out.printf("-- TreeSet에 마지막 값을 출력[last()]","토끼");
		System.out.printf("%s\n",trs.last());  // 호랑이
		
		System.out.println("-- Iterator로 내림차순");
		Iterator<String> it = trs.descendingIterator();  // it을 내림차순함
		while(it.hasNext()) {  // 다음값이 있으면 true
			System.out.println(it.next());  // 값출력 후 다음
		}
		
		
	}

}
