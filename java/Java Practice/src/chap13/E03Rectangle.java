package chap13;

public class E03Rectangle extends E03Shape {

	// 필드
	int w,h;
	
	//생성자
	E03Rectangle() {
		this(1,1);
	}
	E03Rectangle(int w, int h) {
		this.w = w;
		this.h = h;
	}
	
	// 메서드 재정의(오버라이딩)
	@Override
	double area() {  // 면적
		return (w*h);
	}

	@Override
	double length() {  // 둘레
		return (w+h)*2;
	}

}
