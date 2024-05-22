package chap07;

public class Excercise10 {

	public static void main(String[] args) {
		int[] arr = {20,15,21,11,-5,-10,14};
		
		Math m = new Math();
		int max = m.max(arr);
		int min = m.min(arr);
		
		System.out.println("최대값 : "+max);
		System.out.println("최소값 : "+min);

	}

}

class Math {
	public int max(int[] arr) {
		int b = 0;
		for(int a : arr) {
			if(b==0) {
				b = a;
			}
			if (a>b) {
				b = a;
			}
		}
		return b;
	}
	public static int min(int[] arr) {
		int b = 0;
		for(int a : arr) {
			if(b==0) {
				b = a;
			}
			if (a<b) {
				b = a;
			}
		}
		return b;
	}
}