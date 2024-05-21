package chap07;

public class Ex02Parrot extends Ex02Pet {

	public Ex02Parrot(boolean wing, int legCount) {
		super(wing, legCount);
	}

	@Override
	public void run(String name) {
		System.out.printf("%s는 두발로 뜁니다.\n",name);
	}
	
	public void fly(String name) {
		System.out.printf("%s는 뛰지 않고 날라갑니다.\n",name);
	}


}
