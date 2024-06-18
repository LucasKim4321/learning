package chap20;

public class E03DaemonThreadTest {

	public static void main(String[] args) {
		// 스레드 상태 출력
		Thread.State state;
		
		Thread t = new Thread() {  // 익명 클래스 NEW 상태
			
			@Override
			public void run() {
				int i = 0;
				while(true) {  // 무한 반복
					if (i>10000) {  // 루프 빠져나오는 조건
						System.out.println(i);
						break;  // 조건 만족시 break로 while 종료
					}
					i++;
				} // end while
			} // end run
		};
		
		state = t.getState();  // 스레드의 상태 추출  현재 NEW 상태
		System.out.println("1.스레드 상태: "+state);  // NEW 만들어진 상태
		
		t.start();  // RUNNABLE: 스레드의 준비 상태
		state = t.getState();
		System.out.println("2.스레드 상태: "+state);  // RUNNABLE 실행가능한
		
//		Thread.interrupted();  // 스레드 강제 종료
//		t.interrupt();  ??
		state = t.getState();
		System.out.println("3.스레드 상태: "+state);  // RUNNABLE
		
		try {
			
			Thread.sleep(1000);  // 스레드 1초 대기
		} catch (InterruptedException e) {System.out.println(e.getMessage());}
		
		state = t.getState();  // sleep 후 TERMINATED 끝남
		System.out.println("4.스레드 상태: "+state);  // TERMINATED
		System.out.println("메인 스레드 종료");
		
	}

}
