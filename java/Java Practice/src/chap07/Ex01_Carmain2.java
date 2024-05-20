package chap07;

import java.util.Arrays;

public class Ex01_Carmain2 {

	public static void main(String[] args) {
		// Car 타입의 배열객체 생성
		Ex01_Car[] cars = new Ex01_Car[3];
		
		// car 객체 생성
		Ex01_Car tico = new Ex01_Car();

		tico.color = "화이트";
		tico.company="대우";
		tico.type="경차";
		
		// 모든 인덱스에 tico 객체 저장
		for (int i=0; i<cars.length; i++) {
			cars[i] = tico;
		}
		System.out.println(Arrays.toString(cars));
		
		System.out.println("2번 인덱스 color : "+cars[2].color);
		cars[0].color = "블랙"; // 0번 인덱스 객체의 color 필드에 "블랙" 대입
		System.out.println("2번 인덱스 color : "+cars[2].color); // 객체 하나로 돌려써서 전부 바뀜
	}

}
