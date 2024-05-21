package chap07;

public class Ex02Cat extends Ex02Pet {

	public Ex02Cat(boolean wing, int legCount) {
		super(wing, legCount);
	}

	@Override
	public void run(String name) {
		System.out.printf("%s는 소리없이 뜁니다.\n",name);
	}
	
}
