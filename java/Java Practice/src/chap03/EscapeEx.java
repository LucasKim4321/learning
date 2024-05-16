package chap03;

public class EscapeEx {

	public static void main(String[] args) {
		// \n = 줄바꿈  \t = 탭  \\ = \  \' = '  \" =  "
		String great = "안녕하세요, \n저는 \"홍길동\"입니다.";
		String great2 = "\t반갑습니다.";
		System.out.println(great);
		System.out.println(great2);
	}

}
