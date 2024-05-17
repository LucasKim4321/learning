package chap05;

public class ex14_ContinueEx {

	public static void main(String[] args) {
		for (int i=0; i<10; i++) {
			if ( i==5) {
				continue;  // 더 실행 안하고 다음으로 넘어감
			}
			System.out.println(i);
		}
	}

}
