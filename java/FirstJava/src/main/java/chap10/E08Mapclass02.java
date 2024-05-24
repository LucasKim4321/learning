package chap10;

import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

public class E08Mapclass02 {

	public static void main(String[] args) {
		Map<String, Integer> scoreMap = new HashMap<String, Integer>();
		
		scoreMap.put("이순신", 90);
		scoreMap.put("홍길동", 80);
		scoreMap.put("임꺽정", 88);
		scoreMap.put("동길이", 77);
		scoreMap.put("임꺽정", 90);
		System.out.println(scoreMap);
		
		Set<String> scoreSet = scoreMap.keySet();  // key값들을 scoreSet에 대입
		System.out.println(scoreSet);
		
		// Map구조 -> keys -> 배열에 작업 상황
		Object[] obj = scoreSet.toArray();  // 업캐스팅 : String -> Object
		
		String[] arrKeys = new String[obj.length];
		System.out.println(obj);
		System.out.println("--------");
		for (int i=0; i<obj.length; i++) {
			String key = (String)obj[i];  // 다운캐스팅 Object -> String
			arrKeys[i] = key;  // 키값을 배열 구조에 저장
			System.out.println(key+", "+scoreMap.get(key));
		}
		System.out.println(Arrays.toString(arrKeys));
		
		Iterator<String> it = scoreSet.iterator();
		while( it.hasNext()) {
			System.out.println((String)it.next());
		}
		
		// Enumeration : Iterator이전
		Vector<String> v = new Vector<String>();
		v.add("홍길동");
		v.add("동길이");
		v.add("강감찬");
		System.out.println("---- Vector "+v);
		Enumeration<String> enu = v.elements();
		while(enu.hasMoreElements()) {  // hasMoreElements() == Iterator의 hasNext()기능이랑 같음
			System.out.println(enu.nextElement());  // nextElement()  == Iterator의 next()기능이랑 같음
		}
		
	}

}
