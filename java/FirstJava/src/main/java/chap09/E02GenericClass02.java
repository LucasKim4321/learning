package chap09;

public class E02GenericClass02 {

	public static void main(String[] args) {
		// 제한된 자료형의 제네릭
		Computer<ComputerPart> vga = new Computer<ComputerPart>();
		vga.setComponent(new Graphics());  // ComputerPart component = new Graphics();
//		vga.setComponent(new Monitor());  // error 상속관계가 아닌 클래스타입은 올 수 없음. ComputerPart속성을 상속 받지 않았기 때문에
		vga.toInfo();
		
		// 생성자
		Computer<ComputerPart> men = new Computer<>(new Memory());
//		Computer<ComputerPart> men = new Computer<>(new Monitor());  // 에러
		men.toInfo();
	}

}
// 제한된 자료형 제네릭 클래스
// ComputerPart 클래스로 부터 상속받은 클래스 타입만 사용할 수 있게 제한
class Computer <T extends ComputerPart> {  // extends ComputerPart를 가진
	private T component;
	
	// constructor
	public Computer() {}
	public Computer(T component) {
		this.component = component;
	}
	
	// method
	public void toInfo() {
		System.out.println(component.getClass().getName());
	}
	public void setComponent(T component) {
		this.component = component;
	}
}


class ComputerPart {}

class Graphics extends ComputerPart {}

class Memory extends ComputerPart {}

class Monitor {}