package chap06;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

public class E02ClassArr01 {
	
	public static void main(String[] args) {
//
//		int[] t = new int[3];
//		t[0] = 20;
//		t[1] = 20;
//		t[2] = 20;
//		System.out.println(Arrays.toString(t));
//		int[] t2 = {10,20,30};
//		
		Student3 a = new Student3("dd",10,1);
//		System.out.println(a);
		// 객체 배열
		Student3[] students = new Student3[3];
		students[0] = new Student3("홍길동",10,1);
		students[1] = new Student3("동길이",11,3);
		students[2] = new Student3("동순이",12,5);
		
		for(Student3 s : students) {
//			System.out.println(s.toString());
		}
		System.out.println("----");
		for(int i=0; i<students.length; i++) {
//			System.out.println(students[i].toString());
		}
		
		students[0].getAge();
		students[0].setAge(10);
		
		Student3 st01 = new Student3("김길순", 12);
		System.out.println(st01);
	}

}
//
//class Student3 {
//	String name;
//	int age;
//	int grade;
//	
//	public Student3(String name, int age, int grade)  {
//		this.name = name;
//		this.age = age;
//		this.grade = grade;
//	}
//	@Override
//	public String toString() {
//		return "Strudent3[name="+name+",age="+age+",grade="+grade+"]";
//	}
//	// 우클릭 source에 getter setter 써도됨
//}

//@Getter,@Setter@ToString => @Data
@Data
//@ToString
@AllArgsConstructor
//@NoArgsConstructor
@RequiredArgsConstructor

class Student3 {
	
	@NonNull  // 정의된 필드만 생성자에 매개 변수로 포함
	String name;
	
	@NonNull  // 정의된 필드만 생성자에 매개 변수로 포함
	int age;
	
	int grade;
}
