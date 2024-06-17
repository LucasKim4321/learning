package chap20;

public class E01ThreadTest01 {

	public static void main(String[] args) {
		Thread currThread = Thread.currentThread();
		System.out.println("현재 실행중인 스레드:"+currThread.getName());
		System.out.println("현재 실행중인 스레드:"+Thread.activeCount());
		
//		for (int i=1; i<100; i++) {
//			System.out.printf("%3d ", i);
//		}
//		System.out.println();
//		for (int i=1; i<100; i++) {
//			System.out.printf("%3d ", i);
//		}
		
		MyThread01 t1 = new MyThread01();
		MyThread02 t2 = new MyThread02();
		
		
		t1.setName("스레드01");
		t1.start();
		
		
		t2.setName("스레드02");
		t2.start();
		
		Runnable r = new RunnableImpl();
		Thread t3 = new Thread(r );
		
		t3.setName("인터페이스 스레드");
		t3.setPriority(Thread.MAX_PRIORITY);
		t3.setDaemon(true);//  데몬 스레드로 설정(메인 스레드 종료하면 현재 스레드종료)
		t3.start();
		

		System.out.println("===> "+t1.getName()+": 우선순위 ->"+t1.getPriority());  // 우선순위를 표시(5)
		System.out.println("===> "+t2.getName()+": 우선순위 ->"+t2.getPriority());  // 우선순위를 표시(5)
		System.out.println("===> "+t3.getName()+": 우선순위 ->"+t3.getPriority());  // 우선순위를 표시(10)

		System.out.println("==> 메인스레드 마지막부분:"+currThread.getName());
		
		
		

	}

}

class MyThread01 extends Thread{

	public void run() {
		System.out.println("Thread 클래스 상속 방식");
		for (int i=1; i<100; i++) {
			System.out.println("Thread1: "+i+"-> "+Thread.currentThread());
			System.out.println("1.현재 실행중인 스레드:"+Thread.activeCount());
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
class MyThread02 extends Thread{
	public void run() {
		System.out.println("Thread 클래스 상속 방식");
		for (int i=100; i<200; i++) {
			System.out.println("Thread2: "+i+"-> "+Thread.currentThread());
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {e.printStackTrace();}
		}
		
	}
}

class RunnableImpl  implements Runnable{

	@Override
	public void run() {
		System.out.println("인터페이스 구현 방식");
		for (int i=400; i<550; i++) {
			System.out.println("Thread3: "+i+"-> "+Thread.currentThread());
			System.out.println("2.현재 실행중인 스레드:"+Thread.activeCount());
			try {
				Thread.sleep(30);
			} catch (InterruptedException e) {e.printStackTrace();}
		}
	}
	
}

/*
 *  프로세서 : 실행 파일을 실행시키면 CPU는 실행 파일의 명령어를 메모리에 로드해서 실행되며 실행된 상태를 프로세스
 *  멀티 프로세서 : 여러 개의 프로그램이 동시에 실행된 상태
 *  멀티 프로그래밍: 한 개의 CPU가 두가지 이상의 작업을 동시에 처리하는 것(브라우저, 음악플레이어, 문서 편집기)
 *  스레드(Thread): 실행 중인 프로그램은 프로세서 내에서 또 다시 세부 실행 단위
 *  멀티 태스킹: CPU가 여러 개의 스레드를 동시에 실행하는 것
 *  멀티 프로세싱: 여러 개의 CPU(멀티코어)가 여러 개의 스레드를 동시에 실해하는 것
 *  
 *  데몬(Daemon) 스레드 : 스레드들 중에 메인 스레드가 종료하면 동시에 종료되는 스레드
 * 
 * 

 */