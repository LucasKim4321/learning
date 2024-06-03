package chap14;

public class E02Try02 {

	public static void main(String[] args) {
		// throw : 강제로 오류를 발생
		
//		System.out.println("throw 객체로 인위적으로 오류를 발생");
//		throw new UnsupportedOperationException("throw로 오류를 강제로 발생");
		
		try {
			System.out.println("1. throw 객체로 강제로 오류를 발생");
			throw new UnsupportedOperationException("throw로 오류를 강제로 발생");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("-- 오류를 위임 : 상위 영역으로 넘기기");

		try {
			execute();
			execute2();
		} catch (Exception e) {e.getMessage();}
		System.out.println("execute() 정상 처리 되었습니다.");

	}
	public static void execute() throws Exception { 
		System.out.println(30/0);
		
//		throw new Exception("throws로 오류를 강제로 위임")
	}
	public static void execute2() throws Exception { 
		
		throw new Exception("throws로 오류를 강제로 위임");
	}

}
