package chap04;

public class OpEx6 {

	public static void main(String[] args) {
		System.out.println(3<<2);
		System.out.println("3의 이진수 : "+Integer.toBinaryString(3));
		System.out.println("12의 이진수 : "+Integer.toBinaryString(12));
		System.out.println("3<<2의 이진수 : "+Integer.toBinaryString(3<<2));

		System.out.println(8>>2);
		System.out.println("8의 이진수 : "+Integer.toBinaryString(8));
		System.out.println("2의 이진수 : "+Integer.toBinaryString(2));

		System.out.println(-8>>>3);
		System.out.println("-8의 이진수 : "+Integer.toBinaryString(-8));
		System.out.println("-8>>>3의 이진수 : "+Integer.toBinaryString(-8>>>3));
	}

}
