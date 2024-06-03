package chap14;

import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Scanner;

public class E08File04 {

	public static void main(String[] args) {
		// 문자열 -> 파일 처리
		// String -> ByteArrayInputStream -> InputStream -> FileOutputStream -> File
		
		Scanner sc = new Scanner(System.in);
		System.out.print("이름을 입력하세요.");
		String name = sc.nextLine();
		name += "\n"+name;
		System.out.println(name);
		
		// String -> byte로 전환 -> FileOutputStream
		InputStream is = new ByteArrayInputStream(name.getBytes());  // name.getBytes()  name을 바이트로 바꿈
		
		try(FileOutputStream fw = new FileOutputStream("hangul4.txt")) {
			int i; 
			while ( (i=is.read())!= -1) {
				fw.write(i);
			}
		} catch (Exception e) {}
	}

}
