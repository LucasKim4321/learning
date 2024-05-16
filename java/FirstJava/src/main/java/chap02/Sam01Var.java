package chap02;

public class Sam01Var {

	public static void main(String[] args) {
		// 문자형
		char chr = 'A';
		System.out.println("char : "+chr);  // 문자
		System.out.println("Encoding : "+(int)chr);  // ASCII코드 번호 출력
		System.out.println("Decoding : "+(char)65);
		char dd = 65;
		System.out.println("dd : "+dd);  // dd = ASCII코드 65 = A 출력
		System.out.println("'A'+1 : "+'A'+1);  // A1
		System.out.println("('A'+1) : "+('A'+1));  // ASCII코드 66
		System.out.println("(char)('A'+1) : "+(char)('A'+1));  // 대문자 B
		System.out.println("(char)('A'+32) : "+(char)('A'+32));  // 소문자 a
		System.out.println("(char)('C'+32) : "+(char)('C'+32));  // 소문자 c
		System.out.println("(char)('c'-32) : "+(char)('c'-32));  // 대문자 C
		// 대문자를 소문자로 : 대문자 코드값 +32
		// 소문자를 대문자로 : 소문자 코드값 -32
		// System.out.println();  문자 하나는 ''가능 문자열은 ""
		
		// 숫자형 : 정수형, 실수형
		// 정수형 : byte(1), short(2), int(4), long(8)
		// 실수형 : float(4), double(8)
		// 1byte -> 8bit : 2^8가지(256가지) : 0-255 -> -128~127
		
		 byte a1 = -128, a2 = 127;  // 값 초과하면 에러
		 System.out.printf("byte : min=%d, max=%d\n ",a1, a2);
		 int c1 = 1000;
		 long c2 = 1000L;
		 
		 float f1 = 10.2f;
		 double f2 = 10.2;
		 System.out.printf("float : %f, double : %8.2f \n",f1,f2);  // double:%8.2f 8 전체 자리수 .2 소수점 이하 자리수
		 System.out.printf("10진수 : %d, 8진수 : %o 16진수 : %X \n", 10, 10, 10);
		 System.out.printf("지수: %e, %e, %f \n", 1.e3, 1.e-3, 1.e-3);
//		 System.out.printf("int c1 = 1000 : ",c1);
//		 System.out.printf("long c2 = 1000L : ",c2);
//		 System.out.printf("float f1 = 10.2f : ",f1);
//		 System.out.printf("double f2 = 10.2 : ",f2);
		 
		 // 비기본자료형 => 참조형
		 // 문자열
		 String str1 = "Apple";
		 System.out.printf("%s, %s, %c",str1,str1.toUpperCase(),'a');  // 대상.toUpperCase() 대상 문자열을 대문자로
	}
}
