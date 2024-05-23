package chap13;

abstract class E03Shape {
	
	// 필드
	int x, y;
	
	// 생성자
	E03Shape() {
		this(0, 0);
	}
	public E03Shape(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	// 추상 메서드
	abstract double area();
	abstract double length();
	
	// 일반 메서드
	public String getLocation() {
		return "x : "+x+", y : "+y;
	}
}
