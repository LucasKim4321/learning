package chap10;

import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class E09Collection_Q01 {

	public static void main(String[] args) {
//		로또 예상번호를 몇 개 생성할지를 키보드로 입력받아서 그 수만큼
//		로또 예측 번호 6개를 정렬한 뒤 출력하고, 중복은 배제
//		맨 뒤에 7번째 예측 번호는 '보너스'를 붙여서 다음과 같이 출력
		
//		결과)
//		몇 개의 예상 번호를 출력하시겠습니까? 2
//		40. 44. 23. 39. 16. 18. +보너스 22.
//		30. 29. 43. 55. 22. 34. +보너스 22.
		
		int times = 0;  // 로또 예상 번호 수
		
		Scanner sc = new Scanner(System.in);  // 키보드 입력
		times = sc.nextInt();
		
		Random rnd = new Random();  // 난수 발생
		
		for (int i=0; i<times; i++) {  // 로또 생성 개수만큼
			// 로또 번호 생성
			Set<Integer> setList = new TreeSet<Integer>();
			
			for (int j=0; j<7; j++) {  // 로또 번호 생성 : 7개 (6개, 1개 보너스
				
				int number = rnd.nextInt(45)+1;  // 1~45 rnd.nextInt(숫자) 숫자 범위의 랜덤한 숫자 생성
				// 난수가 존재하는 판단 후 처리
				if(!setList.contains(number)) {  // !(not)을 붙여 반대값 출력
					if (j==6) {
						// 보너스 숫자
						System.out.println("------");
						for (int no : setList) {
							System.out.printf("%d. ", no);
						}
						System.out.println("+보너스"+number);
					}
					else {
						setList.add(number);
					}
				}
				else {
					j--;  // 새로 생성한 난수가 이미 존재하면 제어변수j를 재설정해서 반복
				}
			}
//			System.out.println("생성된 로또 번호 : "+setList);
		}

	}

}
