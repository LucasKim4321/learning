package chap05;

public class Ex09_DoWhileEx {

	public static void main(String[] args) {
		int sum = 0;
		int i =1;
		do {
			sum += i;
			i++;
		}while(i<=100);
		System.out.println("합계:"+sum);
		
		i = 5;
		do {
			i++;
			System.out.println("i="+i);
		} while(i<10);
	}

}
