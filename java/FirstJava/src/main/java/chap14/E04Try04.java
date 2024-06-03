package chap14;

import lombok.ToString;

public class E04Try04 {

	public static void main(String[] args) {
		// AutoCloseable인터페이스
		
		AutoMachine machine = AutoMachine.getInsAutoMachine();
//		AutoMachine machine1 = AutoMachine.getInsAutoMachine();  // 변수 새로 지정해봤자 기존 클래스를 씀
//		AutoMachine machine2 = AutoMachine.getInsAutoMachine();
		
		try {
			machine.run();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {  // finally 무조건 처리
			if (machine != null) {
				try {
					machine.close();
				} catch (Exception e2) {
					System.out.println(e2.getMessage());
				}
			}
		}
		System.out.println(machine);
		
		
		System.out.println("==> try-with-resource");
		// try() AutoCloseable 사용
		try(AutoMachine machine1 = AutoMachine.getInsAutoMachine();
				AutoMachine machine2 = AutoMachine.getInsAutoMachine()) {
			machine1.run();
			machine2.run();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			System.out.println("모든 AutoMachine이 종료되었습니다.");
		}
		

	}

}

class a {
	private int num;
}

// 싱글톤
@ToString
class AutoMachine implements AutoCloseable {  // AutoCloseable try() 괄호안에 변수 선언시 close() 자동 실행
	
	private static AutoMachine machine;
	
	public static AutoMachine getInsAutoMachine() {
		System.out.println("AutoMachine을 시작합니다.");
		machine = new AutoMachine();
		return machine;
	}

	public void run() throws Exception {
		System.out.println("Automachine이 동작합니다.");
	}
	
	@Override
	public void close() throws Exception {  // try() 괄호안에 변수 선언시 close() 자동 실행
		System.out.println("AutoMachine을 종료합니다.");
		machine = null;
	}
	
}