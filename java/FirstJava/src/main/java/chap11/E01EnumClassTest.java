package chap11;


public class E01EnumClassTest {

	public static void main(String[] args) {
		// 열거형(enum) : 단순한 열거형, 값을 갖을 열거형, 4개 이상의 값을 갖는 열거형
		// final double PI = 3.14159;  final 읽기 전용  기호 상수
		
		int inputColor2 = Color.R;
		System.out.println(inputColor2);
		Color inputColor = Color.RED;
		System.out.println(inputColor.equals(inputColor.RED)? "Red" : "Not Red");
		System.out.println(inputColor.equals(Size.SMALL)? "Red" : "Not Red");
		
		System.out.println("-- 열거형");
		Color1 inputColor1 = Color1.RED;
		System.out.println(inputColor1.equals(inputColor1.RED)? "Red" : "Not Red");
		System.out.println(inputColor1.equals(Size.SMALL)? "Red" : "Not Red");
		
		System.out.println("열거형 반복자");
		for(Color1 c : Color1.values()) {
			System.out.println(c.name()+":"+c.ordinal());
		}
		
		System.out.println("----");
		System.out.println(Color1.RED);
		System.out.println(Color1.BLUE);
	}
}

// 색 집합 클래스
class Color {
	final static int R = 10;
	final static Color RED = new Color();  // 자기 자신 클래스 타입으로 만듬
	final static Color BLUE = new Color();
	final static Color ORANGE = new Color();
	
}
// 크기 집합 클래스
class Size {
	final static Size SMALL = new Size();
	final static Size MEDIUM = new Size();
	final static Size LARGE = new Size();
}


// 열거형
enum Color1 {
//	final static int RED = 0;
//	final static int BLUE = 1;
//	final static int ORANGE = 2;
//	RED, BLUE, ORANGE

//	RED {} 익명함수 재정의
	RED {
		@Override
		public String toString() {
			return "빨간색";
		}
	},
	BLUE {
		@Override
		public String toString() {
			return "파란색";
		}
	},
	ORANGE {
		@Override
		public String toString() {
			return "주황색";
		}
	}
}
enum Size1 {
	SMAll, MEDIUM, LARGE
}