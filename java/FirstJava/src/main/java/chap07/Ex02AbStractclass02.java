package chap07;

public class Ex02AbStractclass02 {

	public static void main(String[] args) {
		// 추상 다형성(Polymorphism)
//		Ex02Cat cat = new Ex02Cat(false, 4);
		
		// 부모클래스 타입의 객체변수 = 자식 객체 주소
		// 업 캐스팅 : 자식클래스의 개겣가 부모 클래스의 타입으로 형 변환
		// 다운 캐스팅 : 부모클래스 타입인 객체가 자식 클래스의 타입으로 형 변환
		Ex02Pet cat = new Ex02Cat(false, 4);
		cat.run(getPetname(cat));  // cat.run("고양이");
		Ex02Pet parrot = new Ex02Parrot(true, 2);
		parrot.run(getPetname(parrot));  // parrot.run("앵무새");

	}
	
	//static : 객체 생성없는 함수 호출
	public static String getPetname(Ex02Pet pet) {
		String str = "";
		if(pet instanceof Ex02Cat) {
			str = "고양이";
		}
		else if (pet instanceof Ex02Parrot) {
			str = "앵무새";
		}
		return str;
	}

}


