package chap07;

public class Ex08Singleton {
	// static 변수
	private static Ex08Singleton instance = new Ex08Singleton();
	
	//생성자에 private 접근 제한자
	private Ex08Singleton() {
		System.out.println("객체 생성");
	}
	
	// static 메서드
	public static Ex08Singleton getInstance() {

		System.out.println("객체 리턴");
		return instance;
	}
}