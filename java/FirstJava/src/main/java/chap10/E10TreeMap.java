package chap10;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class E10TreeMap {

	public static void main(String[] args) {
		// TreeMap : TreeSet유사, 키를 기준으로 정렬되어 key,value형태로 Entry로 저장된 Map
		
		System.out.println("HashMap은 정렬되지 않은 Key,Value형태");
		Map<String, String> hashmap = new HashMap<String, String>();
		hashmap.put("400", "선풍기");
		hashmap.put("700", "신문지");
		hashmap.put("200", "동백꽃");
		hashmap.put("900", "김길순");
		System.out.println(hashmap);
		
//		var map = new java.util.TreeMap<String, String>();  // var 타입 추론  /  import 안하고 직접적으로 넣을 수도 있음
		Map<String,String> map = new TreeMap<String, String>();
		map.put("400", "선풍기");
		map.put("700", "신문지");
		map.put("200", "동백꽃");
		map.put("900", "김길순");
//		map.putAll(hashmap);
		System.out.println(map);
	}

}
