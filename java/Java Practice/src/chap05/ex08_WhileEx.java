package chap05;

public class ex08_WhileEx {

	public static void main(String[] args) {
		int sum = 0;
		int i = 1;
		while (i <=100) {
			sum += i;
			i++;
		}
		System.out.println("합계:"+sum);
	}

}
