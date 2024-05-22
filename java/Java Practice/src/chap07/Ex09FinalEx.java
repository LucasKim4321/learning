package chap07;

public class Ex09FinalEx {

	public static void main(String[] args) {
		Final f = new Final(300);
//		f.number = 200; // 에러
		System.out.println(f.number);
	}

}


class Final {
	final int number;  // final 변수 읽기전용 but 생성자를 통한 수정은 가능
	
	Final(int number) {
		this.number = number;
	}
}