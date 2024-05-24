package chap10;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class E07MapClass {

	public static void main(String[] args) {
		// Key와 Value 쌍으로 저장 구조
		Map<String, Integer> map = new HashMap<String,Integer>();
		map.put("java", 1);
		map.put("javascript",2);
		map.put("react",3);
		map.put("python",4);
		map.put("perl",5);
		
		System.out.println(map);
		
		Set<String> keys = map.keySet();  // map의 키 값을 set타입의 keys에 대입
		System.out.println(keys);
		System.out.println("-- keys: forEach");
		
		keys.forEach(System.out::println);
		
		System.out.println("맵의 매핑수 : "+map.size());
		System.out.println(map.containsKey("react"));  // 맵클래스객체.containsKey 맵객체의 키값에 있으면 true
		
		System.out.println("--- 1 ---");
		if (map.containsKey("java"))
//			System.out.println(map.get("react"));  // 해당 키값의 Value 값을 가져옴
			map.remove("java");
		else
			System.out.println("java가 없음");
		System.out.println(map);
		
		System.out.println("--- 2 ---");
		map.computeIfPresent("react",(String key, Integer value) -> ++value);
		System.out.println(map);

		map.computeIfPresent("perl",(String key, Integer value) -> --value);
		System.out.println(map);
		
		System.out.println("--- valueSet");
		System.out.println(map.values());
//		map.values().forEach((value) -> System.out.println(value));
		
		System.out.println("----entrySet");
		System.out.println(map+","+map.entrySet());  // ?
		Set entrySet = map.entrySet();
		
		System.out.println(entrySet);
		entrySet.forEach( (x) -> System.out.println(x));
	}

}
