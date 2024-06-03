package chap14;

import java.io.FileOutputStream;

public class E06File2 {

	public static void main(String[] args) {
		// FileOutputStream
		
		char c1 = 74;
		char c2 = 97;
		char c3 = 118;
		
		try(FileOutputStream fos = new FileOutputStream("java.file")) {  // try(대상) 괄호안에 쓰면 자동으로 close() 실행 
			fos.write(c1);  // J
			fos.write(c2);  // a
			fos.write(c3);  // v
			fos.write(c1);  // J
			fos.write(64);  // @
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
