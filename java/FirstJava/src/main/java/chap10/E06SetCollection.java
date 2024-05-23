package chap10;

import java.util.HashSet;
import java.util.Set;

public class E06SetCollection {

	public static void main(String[] args) {
		// Set : 순서가 없음. 중복 불가
		Set<String> set = new HashSet<String>();
		
		set.add("cat");set.add("cat");set.add("cat");set.add("cat");
		set.add("line");set.add("line");set.add("line");set.add("line");
		set.add("dog");set.add("dog");set.add("dog");set.add("dog");
		
		System.out.println(set);
	}

}
