package chap09;

public class E01GenericClass01 {

	public static void main(String[] args) {
		// 제네릭 클래스
		// 클래슨내에서 사용되는 자료형을 외부에서 지정해 사용
		// 다이몬드 기호 "<영문자>" :
		// E: Element, K: Key, N: Number, T: Type, V: Value
		
		Genclass<Integer> g = new Genclass<Integer>();  // <속성> 해당 속성 값으로 정의됨  여기에<속성>생략해도 되긴됨
		g.setT(123);
		System.out.println(g.getT());
		
		Genclass2<String> g2 = new Genclass2<String>();
		g2.setT("김길동");
		System.out.println(g2.getT());
		
		Genclass2 g3 = new Genclass2();  // 이렇게도 사용 가능하지만 추천하지 않음
		g3.setT("김길동");
		System.out.println(g3.getT());
		
	}

}


class Genclass<T> {  // <T> type이 없다는걸 나타냄
	private T t;
	public T getT() {
		return t;
	}
	public void setT(T t) {
		this.t = t;
	}
}
class Genclass2<P> {  // <> 문자는 아무거나 상관없음  인자같이 작동
	private P t;
	public P getT() {
		return t;
	}
	public void setT(P t) {
		this.t = t;
	}
}