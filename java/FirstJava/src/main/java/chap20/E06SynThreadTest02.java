package chap20;

public class E06SynThreadTest02 {

	Object objKey = new Object();  // 동기화 블럭의 락으로 사용
	
	Thread t1 = new Thread("thread1") {
		public void run() { method1(); }
	};
	
	Thread t2 = new Thread("thread2") {
		public void run() { method2(); }
	};
	
	public synchronized void method1() {
		
		System.out.println("\n method1()");
		System.out.println("method1 실행 스레드: "+Thread.currentThread().getName());
		System.out.println("method1 thread1: "+t1.getState());
		System.out.println("method1 thread2: "+t2.getState());
		for (long j=0; j<10000000000L; j++) {}
		
	}

//	public synchronized void method2() {
	public void method2() {
		
		synchronized (objKey) {
			System.out.println("\n method2()");
			System.out.println("method2 실행 스레드: "+Thread.currentThread().getName());
			System.out.println("method2 thread1: "+t1.getState());
			System.out.println("method2 thread2: "+t2.getState());
			for (long j=0; j<10000000000L; j++) {}
		}
		
//		System.out.println("\n method2()");
//		System.out.println("method2 실행 스레드: "+Thread.currentThread().getName());
//		System.out.println("method2 thread1: "+t1.getState());
//		System.out.println("method2 thread2: "+t2.getState());
//		for (long j=0; j<10000000000L; j++) {}
		
	}
	
	void startAll() {
		t1.start();	t2.start();
		
	}
	
	public static void main(String[] args) {
		// 동기화 메서드와 동기화 블록의 락이 다른 경우에는 두 메서드는 동기화하지 않고 동시에 실행
		E06SynThreadTest02 st = new E06SynThreadTest02();
		st.startAll();
	}

	
}
