package chap07;

public class Ex05_ReturnEx2 {

	public static void main(String[] args) {
		Return2 obj = new Return2();
		
		obj.getTest(0);
		obj.getTest(1);
		
		System.out.println(obj.getName(0));
		System.out.println(obj.getName(1));
	}

}

class Return2 {
	void getTest(int type) {
		System.out.println("getTest() 메서드 시작");
		if(type == 1) {
			return;
		}
		System.out.println("getTest() 메서드 끝");
	}
	
	String getName(int type) {
		if (type==1) {
			return "";
		}
//		return "";  // return 동시에 두개 존재시 에러
		return "홍길동";
	}
}
