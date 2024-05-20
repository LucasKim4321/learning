package chap03;

import java.util.Scanner;

public class Test_Q06 {

	public static void main(String[] args) {
//		비트 연산을 활용하여 5문제 답을 하나씩 비교해 맞으면 O, 틀리면 'X'
//		답 입력> 10110
//		  정답> 11010
//		  결과> OXXOO
		
		int [] dap = {1,1,0,0,1};
		System.out.println("답 입력> ");
		Scanner sc = new Scanner(System.in);
		String in = sc.nextLine();  //키보드로부터 값 입력
		
		System.out.println("정답> ");
		for (int n : dap)
			System.out.print(n);
		System.out.println("\n결과 > ");
		int targetLoc = 0;
		// String("홍길동") -> 배열.toCharArray() -> char("홍","길","동")  string속성을 char속성으로 변환하면 배열 구조가 바뀜
		// String -> char[] -> [0], [1], ...[n]
		for (char c : in.toCharArray()) {
			// &연산 : 1 1 -> 1 나머지 0
			System.out.println(c+","+dap[targetLoc++]);
//			System.out.print( (c^dap[targetLoc]) == 1 ? "0" : "X" );
		}
	}

}
