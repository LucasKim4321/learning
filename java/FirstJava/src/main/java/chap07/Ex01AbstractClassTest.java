package chap07;

public class Ex01AbstractClassTest {

	public static void main(String[] args) {
		// 추상(abstract) 클래스
		Ex01Car car1 = new Ex01Car("검정","독일");
		System.out.println(car1);
		car1.printInfo();
		Ex01Car car2 = new Ex01Car("검정","독일");
		Ex01Car car3 = new Ex01Car("검정","독일");
		
	}

}
