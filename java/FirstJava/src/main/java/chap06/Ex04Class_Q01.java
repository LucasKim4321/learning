package chap06;

import java.util.Scanner;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

public class Ex04Class_Q01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int idx = 0;
		Friend[] friends = new Friend[5];
		friends[idx++] = new Friend("Dooli", 60, "010-1234-1111");
		friends[idx++] = Friend.builder()  //idx++하면 idx값이 먼저 대입되고 그다음에 +1됨
				.name("Heedong")
				.age(52)
				.address("010-1234-2222")
				.build();
		friends[idx++] = Friend.builder()
				.name("Douner")
				.age(52)
				.address("010-1234-3333")
				.build();
		friends[idx++] = Friend.builder()
				.name("Ddochi")
				.age(62)
				.address("010-1234-4444")
				.build();
		friends[idx++] = Friend.builder()
				.name("Michol")
				.age(40)
				.address("010-1234-5555")
				.build();
		
		System.out.println("--- List ---");
		for (Friend f : friends) {
			System.out.println(f.getName());
		}
		
		System.out.println();
		do {
			System.out.println("신상을 알고 싶은 사람의 이름을 입력해주세요 (0:종료)");
			String in = sc.next();  // 키보드로 문자 입력
			if ("0".equals(in)) {
				System.out.println("종료");
				break;
			}
			else {
				for (Friend f : friends) {
					if (f.getName().equals(in)) {
						System.out.println(f+"\n");
						System.out.println(f.toString()+"\n");
					}
				}
			}
		}while(true);
	}

}

// 친구 정보
@Data
@AllArgsConstructor
@Builder
class Friend {
	private String name;
	private int age;
	private String address;
}