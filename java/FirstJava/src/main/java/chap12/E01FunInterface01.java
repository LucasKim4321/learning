package chap12;

public class E01FunInterface01 {

	public static void main(String[] args) {
//		함수형 인터페이스 (Function Interface)
//		람다식(Lambda expression)
//		메서드 참조(Method reference): x -> System.out.print(x) ==> System.out::println

		
		// 2.
		Sample01Function f = () -> System.out.println("함수형 인터페이스 내용입니다.");
		f.test();

		// 1.
		A a = new AA();
		a.test2();
		
		Sample02Funciton f2 = (t) -> {
			String result = "";
			for (int i=0; i<t; i++) {
				result += "만세\n";
			}
			return result;
		};
		System.out.println("== 만세 삼창");
		System.out.println(f2.test(3));
	}

}

// 2. 함수에 인터페이스 구현  (함수형 인터페이스 (Function Interface))
interface Sample01Function {
	public abstract void test();  // 한 개 이상 추상 메서드
}

//1. 클래스에 인터페이스 구현
interface A {
	public abstract void test2();
}
class AA implements A {
	@Override
	public void test2() {
		System.out.println("클래스에 구현한 인터페이스");
	}
}

interface Sample02Funciton {
	public abstract String test(int times);
}