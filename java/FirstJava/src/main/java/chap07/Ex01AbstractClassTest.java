package chap07;

public class Ex01AbstractClassTest {

	public static void main(String[] args) {
		// 미완성 추상 클래스 => 객체를 생성할 수가 없음.
//		Ex01Car car new Ex01Car("검정","독일");  // error
		// 추상(abstract) 클래스
		Ex01ElectricCar car1 = new Ex01ElectricCar("검정","독일");
		System.out.println(car1);
		car1.printInfo();
		System.out.println(car1.fillup());
		
		Ex01GasolineCar car2 = new Ex01GasolineCar("검정","독일");
		System.out.println(car2);
		car2.printInfo();
		System.out.println(car2.fillup());
		
	}

}
