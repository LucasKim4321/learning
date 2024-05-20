package chap03;

import java.util.Scanner;

public class Test_Q07 {

	public static void main(String[] args) {
//		암호화, 복호화
//		'A' 입력 '>'출력, 아스키 코드 '65' - 3 => '62'
//		'apple' -> '^mmib'
		
		Scanner sc = new Scanner(System.in);
		System.out.println("단어를 입력: ");
		String word = sc.next();
		System.out.println(word);
		
		String pass1 = "";  // 암호화
		String pass2 = "";  // 복호화
		
		System.out.println("암호화>");
		for (char c : word.toCharArray()) {
			pass1 += ""+(char) (c-3);
			System.out.println(c+"("+(int)c+"),"+(c-3));
		}
		System.out.printf("암호화된 단어: %s\n",pass1);

		System.out.println("복호화>");
		for (char c : word.toCharArray()) {
			pass2 += ""+(char) (c+3);
			System.out.println(c+"("+(int)c+"),"+(c+3));
		}
		System.out.printf("복호화된 단어: %s\n",pass2);
	}

}
