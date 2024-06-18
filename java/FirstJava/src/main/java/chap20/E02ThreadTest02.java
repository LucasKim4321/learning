package chap20;

public class E02ThreadTest02 {

	public static void main(String[] args) {
		// join():다른 스레드의 실행이 완료될 때 까지 기다리는 메서드
		
		Sum t1 = new Sum();
		Sum t2 = new Sum();
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		
		System.out.println(" 두 스레드의 sum합계: "+(t1.sum+t2.sum));
		
	}

}


class Sum extends Thread {
	int sum = 0;
	@Override
	public void run() {
		for (int  i=1; i<=10; i++) {
			sum+=i;
			System.out.println("==> "+Thread.currentThread());
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
//class Sum2 extends Thread {
//	int sum = 0;
//	@Override
//	public void run() {
//		for (int  i=1; i<=10; i++) {
//			sum+=i;
//		}
//	}
//}

/*
 *  * 스레드 상태 제어
 * interrup() : 예외 발생 일시정지
 * notify(), notifyAll(): 일시정지 -> 실행 대기 상태
 * resume(): suspend()의 의해 일지 정지 상태 -> 실행 대기 상태
 * seelp( 밀리초) : 매개변수 시간동안 일시정지
 * join() : 
 * wait(): 동기화 블록 내에서 일시정지
 * suspend()
 * yield(): 실행 중 우선순이가 동일한 드른 스레드에게 실행을 양보
 * stop(): 스레드 종료
 * 
 * 
 *  스레드 생성 -> (RUNNABLE(실행) :  실행준비 -> 실행  ) -> 종료
 *  
 *  스레드의 실행 상태(State)
 *  runnable상태 : 스레드를 실행하기 위한 준비 상태
 *  running상태: 스레드 스케줄러가 선택한 스레드를 실행하는 상태
 *  
 *  1. 스레드 생성 시 new상태
 *  2. start() 메서드를 호출하면 스레드는 runnable(실행 준비) 상태
 *  3. JVM의 스레드 스케줄러의 의해서 스레드의 run()메서드 가 호출-> running상태
 *  4. run()메서드 완료하면 종료(terminated)
 */