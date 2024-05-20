package chap04;

public class Method02 {

	public static void main(String[] args) {
		hello();
		hello("홍길순");
		hello(123);
		
		System.out.println(sum(10));
		System.out.println(sum(10,20));
		System.out.println(sum(10,20,30));
		System.out.println(sum(10,20,30,100,2,3));
		
		System.out.println("---재귀함수");
		System.out.println(sum2(3));
//		s
	}
	
	// 오버로딩
	// 이름이 중복되도 형식에 맞는 것을 찾아서 불러옴
	public static void hello() {
		System.out.println("Hello");
	}
	public static void hello(String name) {
		System.out.println(name);
		System.out.println("Hello!!");
	}
	public static void hello(int num) {
		System.out.println(num);
	}
	
	// 가변인자 함수
	// 인자를 주는 만큼 다 받음
	// 함수(매개변수,...., 가변인자) => sum(String a, String b, int... num1)도 가능
	public static int sum(int...num1) {  // 자료형.... 매개변수(배열구조)
		int tot = 0;
		for(int i : num1) {  // num1[0],num1[1]....
			tot += i;
		}
		return tot;
	}
	
	// 재귀함수: 종료하는 조건식을 줘야함 없으면 overflow현상 일어남
	public static int sum2 (int a) {
		if (a==1)
			return 1;
		else
			return a+sum2(a-1); // 3+sum2(2) -> 3+2+sum2(1) -> 3+2+1
	}
}