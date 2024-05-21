package chap04.vo;

public class Data {
	String name;
	int age;
	
	// 생성자
	public Data() {
//		System.out.println("생성자 호출");
//		this.name = "";
//		this.age = 0;
		this("",0);
	}
	
	public Data(String name) {
		this(name, 2);  // 생성자 호출
	}

	public Data(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	// 멤버 함수(메서드)
//	public void hello() {}
	
	public String toString() {
		return "Data [name="+this.name+",age="+age+"]";
	}
	
	
}
