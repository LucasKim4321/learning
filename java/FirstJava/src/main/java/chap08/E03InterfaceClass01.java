package chap08;

public class E03InterfaceClass01 {

	public static void main(String[] args) {
//		 인터페이스 :  상수와 추상메서드로만 구성
		ICompute a = new Apartment();  // 업케스팅 클래스에서 implements ICompute 안해주면 에러
		float area1 = a.compute(30);
		System.out.printf("아파트의 면적은 %f제곱미터입니다.\n",area1);
		float pyung1 = a.toPyung(20);
		System.out.printf("아파트의 평수는 %f평입니다.",pyung1);
	}

}

// 상위 요소로 작성 : 하위클래스에 구현할 목적으로 작성
abstract interface ICompute{  // abstract 생략 가능(기본값 abstract)
	static final float pyung = 3.3f;  // static final 생략 가능(기본값 static final)  final읽기전용
	
	// 추상 메서드
	abstract float compute(int area);  // 함수(메서드)  abstract 생략 가능
	
	default float toPyung(float area) {  // 디폴트(default) 메서드  본체가 있는 메서드
		return area/pyung;
	}
}

class Apartment implements ICompute {  // interface 기능을 상속 받을 때 implements사용

	// 상속받은 함수를 완성시켜줘야 에러 안남
	@Override
	public float compute(int area) {
//		pyung++;  // 인터페이스에서 선언된 상수는 변경안됨
		return area*pyung;
	}
	
}