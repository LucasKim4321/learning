package chap08;

public class E05FinalStaticClass {

	public static void main(String[] args) {
		// final, static
		
		//클래스 각각 기억장소를 배정받음
		DynamicNumber n1 = new DynamicNumber();
		DynamicNumber n2 = new DynamicNumber();
		
		System.out.println("------n1");
		n1.increaseNum();
		System.out.println(n1.getNumCounter());
		n1.increaseNum();
		System.out.println(n1.getNumCounter());
		
		
		System.out.println("------n2");
		n2.increaseNum();
		System.out.println(n2.getNumCounter());
		n2.increaseNum();
		System.out.println(n2.getNumCounter());

		System.out.println("-------static");
		//static클래스의 변수는 하나의 기억장소를 배정받음
		StaticNumber s1 = new StaticNumber();
		StaticNumber s2 = new StaticNumber();
		
		System.out.println("------s1");
		s1.increaseNum();
		System.out.println(s1.getNumCounter());
		s1.increaseNum();
		System.out.println(s1.getNumCounter());
		
		
		System.out.println("------n2");
		s2.increaseNum();
		System.out.println(s2.getNumCounter());
		s2.increaseNum();
		System.out.println(s2.getNumCounter());
		
		
		StaticNumber2.num3 = 100;
		StaticNumber2.increaseNum();
		System.out.println(StaticNumber2.getNumCounter());
		
	}

}

class DynamicNumber {
	private int num1 = 0;  // 인스턴스 변수
	
	public int getNumCounter() {
		return num1;
	}
	
	public void increaseNum() {
		num1++;
	}
}
class StaticNumber {
	static int num2 = 0;  // 클래스단위 변수
	
	public int getNumCounter() {
		return num2;
	}
	
	public void increaseNum() {
		num2++;
	}
}
class StaticNumber2 {
	static int num3 = 0;
	
	public static int getNumCounter() {
		return num3;
	}
	
	public static void increaseNum() {
		num3++;
	}
}