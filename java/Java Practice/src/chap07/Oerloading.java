package chap07;

public class Oerloading {

	public static void main(String[] args) {
		Operator op = new Operator();
		System.out.println(op.multiply(4, 3));
		System.out.println(op.multiply(4.5, 3.5));
		System.out.println(op.multiply(4, 3.5));
		System.out.println(op.multiply(4.5, 3));
		
	}

}

class Operator {
	int multiply (int x, int y) {
		return x*y;
	}
	double multiply (double x, double y) {
		return x*y;
	}
	double multiply (int x, double y) {
		return x*y;
	}
	double multiply (double x, int y) {
		return x*y;
	}
}