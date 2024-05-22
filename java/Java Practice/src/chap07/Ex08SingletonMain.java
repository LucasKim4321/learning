package chap07;

public class Ex08SingletonMain {

	public static void main(String[] args) {
//		Ex08Singleton s = new Ex08Singleton(); // 에러
		Ex08Singleton s1 = Ex08Singleton.getInstance();
		Ex08Singleton s2 = Ex08Singleton.getInstance();
		Ex08Singleton s3 = Ex08Singleton.getInstance();
	}

}
