package chap05;

public class Excercise5 {

	public static void main(String[] args) {
		int x = 0, i = 0, count = 0;
		while(x!=6) {
			count++;
			x = (int)(Math.random()*6+1);
			System.out.println("주사위 값 : "+x);
		}
		System.out.println("주사위 값 6이 나올때까지 반복한 횟수 : "+count);
	}

}
