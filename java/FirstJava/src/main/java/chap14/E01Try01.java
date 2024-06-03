package chap14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class E01Try01 {

	public static void main(String[] args) {
		// 예외 처리 (Exception), try-catch-finally, throw, throws ...
		// 에러가 발생시 비정상 종료하지 않고 정상 종료

		try {
			int i=5;
			int[] a = new int[i];
			for(int j=0; j<=i; j++) {
				a[j] = j;
				System.out.println(j);
			}
			System.out.println(Arrays.toString(a));
		} catch (Exception e) {
			System.out.println("오류발생 : "+e.getMessage());
		}
		System.out.println("정상종료");
		
		System.out.println("------");
		try {System.out.println(1/0);}
		catch (Exception e) {  // Exception 최상위 처리
			System.out.println(e.getMessage());
			}
		System.out.println("0으로 나눈후 작업종료!");
		
		System.out.println("--- 중첩 Exception 처리");
		try {
			// 1차 오류 발생
			int i=5;
			int[] a = new int[i];
			for(int j=0; j<i; j++) {  // j<=i 할 시 에러
				a[j] = j;
				System.out.println(j);
			}
			System.out.println(Arrays.toString(a));
			System.out.println("정상종료2");
			
			// 2차 오류
			System.out.println(1/1);  // 1/0 할 시 에러
			System.out.println("정상종료3");
			
			// 3차 오류
			String msg = "";
			List<String> list = new ArrayList<String>();
			list.add("홍길동");
			list.add("동길이");
			
			list = Collections.unmodifiableList(list);  // List update 불가
			list.add("강감찬");  // 에러
			
			System.out.println(list);
			System.out.println("정상종료4");
			
		} catch (ArrayIndexOutOfBoundsException e1) {  // 하위 클래스 
			System.out.println("e1 error : "+e1.getMessage());
		} catch (ArithmeticException e2) {  // 상위 클래스  
			System.out.println("e2 error : "+e2.getMessage());
		} catch (Exception e3) {  // 최상위 클래스  모든 에러 잡음
			System.out.println("e3 error : "+e3.getMessage());
		} finally {
			// 예외 처리와 관계없이 무조건 수행할 내용
			System.out.println("test");
		}
		System.out.println("------");
	}

}
