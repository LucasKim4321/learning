package chap07;

public class Ex08SingletonMain {

	public static void main(String[] args) {
//		singleton기법 클래스 내부에 지정된 하나의 객체만 사용가능하고 새로 생성할 수도 없게 만드는 기법
		
//		Ex08Singleton s = new Ex08Singleton(); // 에러  생성자가 private 속성이라 안됨
		Ex08Singleton s1 = Ex08Singleton.getInstance();
		Ex08Singleton s2 = Ex08Singleton.getInstance();
		Ex08Singleton s3 = Ex08Singleton.getInstance();
	}

}
