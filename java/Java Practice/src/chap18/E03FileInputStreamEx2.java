package chap18;

import java.io.FileInputStream;
import java.util.Arrays;

public class E03FileInputStreamEx2 {

	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream("src/chap18/E01InputStreamEx.java");
			int data = 0;
			byte[] buf = new byte[fis.available()];  // 파일.available() 파일의 크기만큼 배열을 선언.
			while ((data=fis.read(buf)) != -1) {
				System.out.print(new String (buf, 0, data));
			}
		} catch (Exception e) {e.getMessage();}
		
	}

}
