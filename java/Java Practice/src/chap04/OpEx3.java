package chap04;

public class OpEx3 {

	public static void main(String[] args) {
		int a = 10;
		int b = 10;
		++a;  // 전위연산 : ++변수명, 먼저 변수에 1증가 시킨 후 다른 연산을 실행.
		b++;  // 후위연산 : 변수명++, 다른 연산 실행 후 변수에 1증가
		System.out.println(a);  // 11
		System.out.println(b);  // 11 // 단독 사용시 둘 다 차이없음
		
		int c = 10;
		int d = ++c;
		System.out.println("전위연산 결과 : "+d);  // 11
		System.out.println("c : "+c);  // 11
		
		int x = 10;
		int y = x++;
		System.out.println("후위연산 결과 : "+y);  // 10  y값에 x값 먼저 대입 후 x++계산
		System.out.println("x : "+x);  // 11
		
		int e = 10;
		e++;
		System.out.println("e++ : "+e);  // 11
		int f = 10;
		f += 1;
		System.out.println("f += 1 : "+f);  // 11
		int g = 10;
		g = g +1;
		System.out.println("c = c + 1 : "+c);  // 11
	}

}
