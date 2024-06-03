package chap14;

import java.util.Arrays;
import java.util.List;

public class E03Try03 {

	public static void main(String[] args) {
		// 직접 만드는 사용자 예외 클래스
		List<String> list = Arrays.asList("홍길동","동순이","김갑돌");
		try {
			hasBread(list);
		} catch (BreadException e) {
			System.out.println(e.getMessage());
		}
	}

	public static boolean hasBread(List<String> list) throws BreadException {
		if (list.contains("홍길동")) {
			throw new BreadException();
		}
		return true;
	}

}

// 예외 클래스 작성
class BreadException extends Exception {
	public BreadException() {
		super("홍길동은 치명적인 오류가 있다!!!");
		
		System.out.println("사용자가 직접 작성한 Exception ");
	}
}