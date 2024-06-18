package chap20;

public class E07SynThreadTest03 {

	public static void main(String[] args) {
		
		// 통장 객체 생성
		Account acc = new Account();
		
		Parent p = new Parent(acc);
		Child c = new Child(acc);
		
		p.start();
		c.start();
		
		try {
			Thread.sleep(2000);
		} catch (Exception e) {System.out.println(e.getMessage());}
		
		p.interrupt();
		c.interrupt();
		
	}

}


// 자원: 통장 클래스
class Account {
	int money;
	
	
	// 출금
	synchronized void withdraw() {
		// 잔액이 없는 경우에는 대기(출금 금지)
		while(money <= 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
				break;  // while문 종료
			}
		}
		
		notifyAll();
		
		int m = 0;
		while (m > money || m == 0) {
		m = (int)(Math.random()*5+1)*100000;
		}
		money -= m;
		System.out.println(Thread.currentThread().getName()+m+"원 출금, 잔액: "+money);
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

//자원을 이용하는 객체: 부모클래스, 자식클래스
class Parent extends Thread {
	Account account;
	
	public Parent(Account account) {
		super("부모");
		this.account = account;
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				account.deposit();  // 잔액이 없으면 입금하는 동작
				sleep((int)(Math.random()*200));  // 0~199
			} catch (Exception e) {System.out.println(e.getMessage()); break;}
		}
	}
}

class Child extends Thread {
	Account account;
	
	public Child(Account account) {
		super("자식");
		this.account = account;
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				if (account.money>0) {
					account.withdraw();  // 잔액이 있으면 확인
				}
				sleep((int)(Math.random()*200));  // 0~199
			} catch (Exception e) {System.out.println(e.getMessage()); break;}
		}
	}
	
}