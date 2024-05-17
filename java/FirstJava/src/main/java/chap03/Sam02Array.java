package chap03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sam02Array {

	public static void main(String[] args) {
		// 배열
		int[] number = {10,20,30};
		int[] number1 = new int[3];  // 3개의 공간이 있는 배열을 만듬 (각 값은 0)
		System.out.println(number+", "+number1);  // 배열의 위치값(주소)이 나옴
		System.out.println(Arrays.toString(number));  // Arrays.toString(대상배열) 대상 배열의 값들이 나옴 
		System.out.println(Arrays.toString(number1));
		
		String[] str1 = new String[3];  // 배열은 같은 타입끼리만 사용. string(문자열)은 string끼리 int(숫자열)는 int끼리
		str1[0] = "홍길동";str1[1] = "홍길순";str1[2] = "동길이";
		String[] str2 = {"자바","파이썬","코틀린(Kotlin)"};
//		코틀린 : 자바 100%호환 안드로이드가 생기면서 새로 생긴 안드로이드용 언어  간결함
		
		System.out.println(str1+", "+str2);
		System.out.println(Arrays.toString(str1));
		System.out.println(Arrays.toString(str2));
		System.out.println(str1.length+", "+str2.length);
		
		String[] str3 = str2.clone();  // 대상배열.clone()  대상을 복사
		System.out.println(str3);
		System.out.println(Arrays.toString(str3));
		
		for (int i=0; i<str3.length; i++) {
			System.out.println(str3[i]);  // 자바스크립트랑 똑같이 함
		}
		
		String city = "서울|대전|대구|부산";
		System.out.println(city);
		String[] arrCity = city.split("\\|");
		System.out.println(Arrays.toString(arrCity));
		System.out.println("이스케이프 문자 표시 : \"  \\ ...");
		
		// 배열 활용하기
		int[] correct = {1,2,3,4,1,4,5,2,1,3};  // int[] 1차원 배열 선언
		int[][] answer = {  // int[][] 2차원 배열 선언
				{2,2,3,4,1,4,5,2,1,3}, // 행
				{2,2,3,4,1,4,5,2,1,3},
				{2,2,3,4,1,4,5,2,1,3},
				{1,2,3,4,1,4,5,2,1,3},  // 정답자
				{2,2,3,4,1,4,5,2,1,3},
		};
		System.out.println("답안 :"+Arrays.toString(correct));
		System.out.println("학생답안 :"+Arrays.toString(answer));
		System.out.println("학생답안 :"+Arrays.deepToString(answer));  // 다차원 배열 출력
		
		// 만점자 찾기
		int no = 0;
		for (int[] dap :answer) {
			no++;
			if (Arrays.equals(correct,dap)) {  // Arrays.equals(대상1, 대상2)  대상1,2를 비교해서 같으면 true
				System.out.println(no+" : "+Arrays.toString(dap)+" 만점");
			} else {
				System.out.println(no+" : "+Arrays.toString(dap)+" 만점 아님");
			}
		}

		// 배열 복사
		String[] han1 = new String[] {"라면","미역국","수제비","갈비탕","순대국"};
//		String[] han2 = Arrays.copyOf(null, no)
		String[] han2 = Arrays.copyOf(han1, han1.length-1);
		String[] han3 = Arrays.copyOf(han1, han1.length-2);
		String[] han4 = Arrays.copyOf(han1, han1.length-3);
		String[] han5 = Arrays.copyOf(han1, han1.length-4);
		String[] han6 = Arrays.copyOf(han1, han1.length-5);
		
		System.out.println(Arrays.toString(han1));
		System.out.println(Arrays.toString(han2));
		System.out.println(Arrays.toString(han3));
		System.out.println(Arrays.toString(han4));
		System.out.println(Arrays.toString(han5));
		System.out.println(Arrays.toString(han6));
		
		System.out.println("첫 번재와 마지막 요소 제외한 복사");
		// copyOfRange(대상배열, 시작위치(인덱스번호부터 시작), 끝위치(인덱스번호 앞까지)
		String[] cp = Arrays.copyOfRange(han1, 1, han1.length-1);
//		String[] cp = Arrays.copyOfRange(han1, 1, 4);
		System.out.println(Arrays.toString(cp));
		
		//정렬
		// Arrays.sort(대상);
		Arrays.sort(han1,2,5); // 인덱스 2번부터 5번앞까지
		System.out.println(Arrays.toString(han1));
		
		
		// 컬렉션(저장통) 프레임워크에서 List자료형에 배열을 다른 메서드
		
		// List객체(컬렉션) 생성하기
		List<String> st = new ArrayList<String>();  // 외부 내장 객체,클래스 불러올때 선언해줘야함. 자동완성기능쓰면 알아서 해줌.
		st.add("홍길순");
		st.add("동길이");
		System.out.println(st);
		
		List<String> st2 = Arrays.asList("동길이홍","길길홍");
		System.out.println(st2);
//		System.out.println(Arrays.toString(st2));  // 에러남
	}

}
