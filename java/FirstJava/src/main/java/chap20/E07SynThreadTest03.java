package chap20;

public class E07SynThreadTest03 {

	public static void main(String[] args) {
		
		
	}

}


// 자원: 통장 클래스
class Account {
	int money;
	
	// 출금
	synchronized void withdrow() {
		// 잔액이 없는 경우에는 대기(출금 금지)
		while(money==0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
				break;  // while문 종료
			}
		}
		
		notifyAll();
		System.out.println(Thread.currentThread().getName()+money+"원 출금");
		money = 0;
		
	}
	
	// 입금
	synchronized void deposit() {
		while(money > 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
				break;  // while문 종료
			}
		}
		
		// 랜덤 입금 10~50만원
		System.out.println();
		
		money = (int)(Math.random()*5+1)*100000;
		System.out.println(Thread.currentThread().getName()+money+"원 입금");
		
		notifyAll();
	}
}

// 자원을 이용한 객체 : 부모클래스, 자식클래스