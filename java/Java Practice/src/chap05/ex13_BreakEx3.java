package chap05;

public class ex13_BreakEx3 {

	public static void main(String[] args) {
		target:for (int i=0; i<5; i++) {
			for (int j=0; j<5; j++) {
				if (j==3) {
					break target;  // break 대상;  대상을 종료시킴 
				}
				System.out.println("i="+i+", j="+j);
			}
		}
	}

}
