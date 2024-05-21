package chap05;

public class E01NestedClass02 {

	public static void main(String[] args) {
		// 지역 내부 클래스
		E01NestedClass02 outer = new E01NestedClass02();
		outer.localMethod();
	}
	
	//(default)
	void localMethod() {
		int age = 23;
		
		// 지역 클래스 : "{}" 블럭내에서 클래스 선언
		class LocalClass {
			public void howOldAreYou() {
				System.out.println("홍길동 나이 : "+age);
			}
		}
		LocalClass innerClass = new LocalClass();
		innerClass.howOldAreYou();
	}

}
