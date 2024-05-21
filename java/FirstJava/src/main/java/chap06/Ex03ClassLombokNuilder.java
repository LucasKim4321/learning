package chap06;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

public class Ex03ClassLombokNuilder {

	public static void main(String[] args) {
		// Lombok Builder
		Person per1 = Person.builder().no(1).build();
		System.out.println(per1);  // toString 안넣으면 주소만 나옴
		
		Person per2 = Person.builder()
				.no(2)
				.name("동길이")
				.build();
		System.out.println(per2);
		
		Person per3 = Person.builder()
				.no(3)
				.name("동순이")
				.phone("010-0101-0101")
				.build();
		System.out.println(per3);

	}

}
// VO(Value Object), DTO(Data Transfer Object)
//@ToString
//class Person {
//	private int no;
//	private String name;
//	private String phone;
//	
//	
//	@Builder
//	public Person(int no, String name, String phone) {
//		super();
//		this.no = no;
//		this.name = name;
//		this.phone = phone;
//	}
//	
//}

@Data
@Builder
@AllArgsConstructor
class Person {
	private int no;
	private String name;
	private String phone;
}