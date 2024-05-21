package chap06;

public class E01ClassObject {

	public static void main(String[] args) {
		MyObject obj1 = new MyObject();
		MyObject2 obj2 = new MyObject2();
		System.out.println(obj1);
		System.out.println(obj2);
		
		String A = new String("길순이");  // 매번 기억장소를 새로 할당받음
		String B = "길순이";  // 한번 할당 받은 기억장소를 그대로 사용
		String C = "길순이";  // 한번 할당 받은 기억장소를 그대로 사용
		
		System.out.println(A);
		System.out.println(B);
		System.out.println(C);
		
		if (A==B)
			System.out.println("주소가 같음");
		else
			System.out.println("주소가 다름");
		// 결과는 주소가 다름이 나옴
		// 값이 들어있는 주소를 비교함
		if (B==C)
			System.out.println("주소가 같음");
		else
			System.out.println("주소가 다름");

		if (A.equals(B))
			System.out.println("주소가 같음");
		else
			System.out.println("주소가 다름");
	}

}

class ssss {}
class MyObject extends Object{
	String name;
	
	@Override
	public String toString() {
		return "MyObject[name="+name+"]";
	}
}  // extends Object가 기본값
class MyObject2 {}  // extends Object가 생략 되어있음.
// 최상위 클래스 (Object)
// 모든 클래스는 부모클래스로 Object기능을 상속 받음.