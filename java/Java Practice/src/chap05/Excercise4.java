package chap05;

public class Excercise4 {

	public static void main(String[] args) {
//		String y = "";
//		for (int i=0; i<5; i++) {
//			y += "*";
//			System.out.println(y);
//		}
		//04
//		for (int i=1; i<6; i++) {
//			String x = "";
//			for (int j=0; j<i; j++) {
//				x += "*";
//			}
//			System.out.println(x);
//		}
		//05
//		for (int i=5; i>0; i--) {
//			String x = "";
//			for (int j=0; j<i; j++) {
//				x += "*";
//			}
//			System.out.println(x);
//		}
		//06
		for (int i=1; i<6; i++) {
			String x = "";
			for (int f=i; f<5; f++) {
				System.out.print(" ");
			}
			for (int j=0; j<2*i-1; j++) {
				x += "*";
			}
			System.out.println(x);
		}
	}

}
