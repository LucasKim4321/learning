package chap08;

public class E01SmartPhoneMain {

	public static void main(String[] args) {
		E01Phone p = new E01Phone();
		p.name = "전화기";
		p.company = "현대";
		p.color = "화이트";
		
		System.out.println("Phone 출력");
		System.out.println(p.name);
		System.out.println(p.company);
		System.out.println(p.color);
		p.call();
		p.receive();
		
		E01SmartPhone sp = new E01SmartPhone();
		sp.name = "갤럭시";
		sp.company = "삼성";
		sp.color = "블랙";

		System.out.println("SmartPhone 출력");
		System.out.println(sp.name);
		System.out.println(sp.company);
		System.out.println(sp.color);
		sp.call();
		sp.receive();
		sp.installApp();
	}

}