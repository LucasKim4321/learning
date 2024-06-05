package chap18;

import java.io.FileInputStream;
import java.util.Arrays;

public class E04FileInputStreamEx3 {

	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream("src/chap18/E01InputStreamEx.java");
			int data = 0;
			byte[] buf = new byte[fis.available()];
			while ( (data=fis.read(buf, 0, buf.length)) != -1) {
				System.out.println(new String(buf, 0, data));
			}
		} catch (Exception e) {e.getMessage();}
	}

}
