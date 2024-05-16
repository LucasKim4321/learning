package chap02;

public class Sam02VarRef {

	public static void main(String[] args) {
		// 참조형
		String str1 = "홍길동";
		String str2 = "홍길순";
		System.out.println(str1 + ", "+str2);
		// debuging
		// breakpoint에서 멈춤 멈춘 자리의 문장은 실행안함
		// f6 멈춤곳에서 하나문장씩 넘김  f8 breakpoint단위로 넘김
		// 해당 값의 위치등의 정보가 디버깅창에 나옴.
		
		int i=0;
		i = i + 10;
		i = i + 10;
		i = i + 10;
		System.out.println(i);
		
		// 형전환 : 명시적, 묵시적
		int num1 = 10;
//		short num2 = num1;  // 형식이 달라서 에러  형전환 필요  명시적
		short num2 = (short)num1;  // 형전환 후 사용 가능
		float num3 = 10;  // 묵시적(자동) 형전환이 일어남 10.0f
		int num4 = (int)10.2;  // double -> int
//		System.out.printf(num1+num2);
		
		System.out.println((char)(77)+(char)(-42)+(char)(56)+(char)(-82)+(char)(28)+(char)(-62));
	}

}
