package chap03;

import java.util.Scanner;

public class Sam01BitOper {

	public static void main(String[] args) {
		// 비트 연산자 ( AND:&&(&), OR:||(|),XOR:^ , NOT:!, <,<<,>>, ... )
		// << 비트를 왼쪽으로 한칸 옮김  결과 *2
		// >> 비트를 오른쪽으로 한칸 옮김  결과 /2
		int a = 2;
		int b = 3;
		int n = 2;
		System.out.println("비트 연산"+a+"<<"+n+" = "+(a<<n));  // 2<<2 = 8   0010 -> 0100
		System.out.println("비트 연산"+a+">>"+n+" = "+(a>>n));  // 2>>2 = 0 비트 이동이라 음수로 변하진 않음
		System.out.println("비트 연산"+a+"&"+b+" = "+(a&b));  // 2&3 = 2  0010&0011 -> 0010
		System.out.println("비트 연산"+a+"|"+b+" = "+(a|b));  // 2|3 = 3  0010|0011 -> 0011
		System.out.println("비트 연산 ~"+a+" = "+(~a));  // ~2 = -3
		System.out.println("비트 연산"+a+"^"+b+" = "+(a^b));  //  0010^0011 -> 0001
		System.out.printf("[%32s] [%d] \n",Integer.toBinaryString(3),3);
		System.out.printf("[%32s] [%d] \n",Integer.toBinaryString(~3),~3);  // %5d 5는 전체 자리에 값이 없으면 공백
		System.out.printf("[%32s] [%d] \n",Integer.toBinaryString(-4),-4);
		
//		System.out.println("삼항 연산자");
//		int number;
//		Scanner sc = new Scanner(System.in);
//		System.out.print("숫자");
//		number = sc.nextInt();
//		String result = (number%2==0) ? "짝수":"홀수";
//		System.out.println(result + "number");
		
		int num1 = 10;
		System.out.println(num1++);  // 계산전에 출력에 먼저되서 10이 나옴 후 계산값 
		System.out.println(num1);  // 
		System.out.println(++num1);
		System.out.println(num1);
		
		
	}

}
