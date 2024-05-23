package chap13;

public class E03Circle extends E03Shape {

	// 필드
	double r;
	
	// 생성자
	E03Circle() {
		this(1);
	}
	E03Circle(double r) {
		this.r = r;
	}
	
	// 메서드 재정의(오버라이딩)
	@Override
	double area() {  // 면적
		return (r*r)*Math.PI;
	}

	@Override
	double length() {  // 둘레
		return (r*2)*Math.PI;
	}
	
}
