package chap04.vo;

public class Data2 {
	// class 자료구조형
	// 생성자, 읽기, 쓰기
	String name;
	int age;
	
	public Data2() {
		this("김길동",10);
	}

	public Data2(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}

	@Override
	public String toString() {
		return "Data2 [name=" + name + ", age=" + age + "]";
	}
	
	
}