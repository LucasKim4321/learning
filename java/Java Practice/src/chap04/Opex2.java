package chap04;

public class Opex2 {

	public static void main(String[] args) {
		int a = 5+5;
		System.out.println("a=5+5="+a);
		int b = a-5;
		System.out.println("b=a-5="+b);
		int c = b*2;
		System.out.println("c=b*2="+c);
		int d = c/5;
		System.out.println("d=c/5="+d);
		int e = 10%3;
		System.out.println("e=10%3="+e);
		
		System.out.println(10/4);  // 2.5가 정답이지만 2출력
		
		double f = 10/4;
		double g = 2.55543;
		System.out.printf("%f,%f \n",f,g);  // 2,000000,  2.555430 출력  형변환 안하면 제대로 계산안됨
		
		double h = 10;
		double i = 4;
		System.out.println("10/4 "+h/i);  // 2.5
		int h2 = 10;
		int i2 = 4;
		System.out.println("10/4 "+h2/i2);  // 2
		double h3 = 10;
		int i3 = 4;
		System.out.println("10/4 "+h3/i3);  // 2.5 // 계산하는 값 중 하나가 double로 선언되면 소수점 이하까지 정상적으로 계산
		int h4 = 10;
		double i4 = 4;
		System.out.println("10/4 "+h4/i4);  // 2.5
		

		System.out.println(10d/4);  // 강제형변환 후 정상 출력
		double h5 = 10/4d;  // 강제형변환 후 정상 출력
		System.out.println(h5);
		int a2 = 10;
		int b2 = 4;
		System.out.println("10/4 "+(double)a2/b2);
		
		
	}

}
