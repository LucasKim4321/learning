package chap04;

public class Method01 {
	public static void main(String[] args) {
//		hello(); // 안됨
		Method01 m = new Method01();  // Method01은 설계도 상태라 객체를 만들어줘야 사용 가능
		m.hello();  // 인자값, 반환값 없는 구조
		m.sum1(10, 20);
		
		int result = m.sum2(100,200);
		System.out.println("sum2:"+result);

		System.out.println("--------static------");
		hello2();
		sum3(10,50);
		sum4(90,50);
	}
	
	// 함수 (메서드)
	public void hello() {
		System.out.println("Hello Java!");
	}
	
	public void sum1(int num1, int num2) {  // 리턴값 없으면 void
		System.out.println(num1+","+num2);
		System.out.println((num1+num2));
	}
	
	public int sum2(int num1, int num2) {  // 리턴값 있으면 리턴값의 속성
		return (num1+num2);
	}
	

	public static void hello2() {  // static 선언시 객체가 아닌 클래스 단위로 바뀜 // 객체 생성 없이 불러오기 가능
		System.out.println("Hello Java!");
	}
	
	public static void sum3(int num1, int num2) {  // 리턴값 없으면 void
		System.out.println(num1+","+num2);
		System.out.println((num1+num2));
	}
	
	public static int sum4(int num1, int num2) {  // 리턴값 있으면 리턴값의 속성
		return (num1+num2);
	}
	
	

}
