package chap07;

public class Ex06_MethodCall {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Method {
	static void ddprintName() {
		System.out.println("printName() 실행");
	}
	
	void printEmail() {
		System.out.println("printEmail() 실행");
		printId();  // 다른 메서드 실행
	}
	
	void printId() {
		System.out.println("printId() 실행");
	}
}
