package chap16;

import java.util.stream.IntStream;

public class StrToStream {

	public static void main(String[] args) {
		String str = "자바 세상을 만들자";
		
		IntStream isr1 = str.chars();
		
		isr1.forEach(s-> System.out.println((char)s));
	}

}
