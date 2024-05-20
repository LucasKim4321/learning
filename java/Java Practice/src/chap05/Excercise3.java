package chap05;

public class Excercise3 {

	public static void main(String[] args) {
		// 두 개의 주사위의 두 눈의 합이 6이 되는 모든 경우의 수를 출력하는 프로그램을 작성하시오.
		for (int x=1; x<6; x++) {
			for (int y=1; y<=6; y++) {
				if(x+y==6)
					System.out.println("두 눈의 합이 6이 되는 숫자"+x+","+y);
			}
		}
	}

}
