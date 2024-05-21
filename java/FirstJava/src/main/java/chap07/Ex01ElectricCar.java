package chap07;

class Ex01ElectricCar extends Ex01Car {

	public Ex01ElectricCar(String color, String manufacturer) {
		super(color, manufacturer);  // super() : 상위요소(부모생성자)
	}

	@Override
	public String fillup() {
		return "전기를 충전합니다.";
	}

}

class Ex01GasolineCar extends Ex01Car {

	public Ex01GasolineCar(String color, String manufacturer) {
		super(color, manufacturer);
	}

	@Override
	public String fillup() {
		return "휘발유를 주유합니다.";
	}
}
