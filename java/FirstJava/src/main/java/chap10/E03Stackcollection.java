package chap10;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class E03Stackcollection {

	public static void main(String[] args) {
		// Stack : LIFO 구조  나중에 들어온게 먼저 나감
		
		Stack<String> stack = new Stack<String>();
		stack.push("홍길동");
		stack.push("길순이");
		stack.push("이순신");
		stack.add("동길이");
		
		System.out.println(stack);
		System.out.println(stack.size());
		
		// 비어 있는지 유무 확인  true/false
		System.out.println(stack.isEmpty());  // false
		stack.pop();  // 끝에 데이터 제거
		System.out.println(stack);
		
		while(!stack.isEmpty()) {  // 비어 있지 않으면 처리
			System.out.println(stack.pop());
		}
		System.out.println(stack.size());
		
		System.out.println("-----Queue:큐 => FIFO");  // 먼저 들어온게 먼저 나감
		Queue<String> q = new LinkedList<String>();
		q.add("홍길동");
		q.add("김길동");
		q.add("길순이");
		q.add("동길이");
		System.out.println(q);
		q.poll();  // 앞에 데이터 제거
		System.out.println(q);
	}

}
