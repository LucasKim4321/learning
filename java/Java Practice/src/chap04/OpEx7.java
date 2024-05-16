package chap04;

public class OpEx7 {

	public static void main(String[] args) {
		int score = 80;
//		조건식?값1(연산식):값2(연산식)  조건식이 참이면 값1 아니면 값2
		String pass = score >= 60 ? "합격" : "불합격";
		System.out.println(pass);
	}

}
