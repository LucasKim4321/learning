package chap12;

import java.util.function.Supplier;

import lombok.AllArgsConstructor;

public class E02RunnableFun01 {

	public static void main(String[] args) {
		// 자주 사용하는 함수형 인터페이스를 미리 만들어서 제공
		// 매개변수가 없는 함수형 인터페이스
		// Runnable : void run(), Supplier : T get()
		
		
		// 다형성 : ex) + => 산술식, 결합
		Runnable r = () -> {
			System.out.println("Runnable은 매개변숟 없으며, 반환 자료형도 없는 인터페이스");
		};
		r.run();
		
		Runnable r2 = () -> {
			System.out.println("안녕0");
		};
		r2.run();
		
		Supplier<String> s = () -> "Supplier는 매개변수가 없지만 반환 자료형은 있음.";
		System.out.println(s.get());

		System.out.println("-- 함수형 인터페이스를 이용하여 클래스 작성 및 객체 생성");
		MessageCenter mc = new MessageCenter("Hello!!... Lambda!!");
		System.out.println("mc: "+mc);
		MessageCenter main = getMsg( ()->mc );  // 매개변수 없고, 반환값이 있는 함수식을 전달
		System.out.println("main: "+main);
		
		String msg = getMsg2(1000);
		System.out.println(msg);
	}

	// Supplier<MessageCenter> dd = () -> mc;  =>  dd = "Hello!!... Lambda!!"
	private static MessageCenter getMsg( Supplier<MessageCenter> dd) {
		return dd.get();
	}
	
	public static String getMsg2(int num) {
		return num+"";  // 숫자+문자열 => 문자열로 바뀜
	}

}
@AllArgsConstructor
//@ToString
class MessageCenter {
	private final String msg;
	@Override
	public String toString() {
		return msg;
	}
}