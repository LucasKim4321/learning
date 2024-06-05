package chap18;

import java.io.FileInputStream;
import java.util.Arrays;

public class E02FileInputStreamEx {

	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream("src/chap18/E01InputStreamEx.java");
			int data = 0;
			while ((data=fis.read()) != -1) {
				System.out.print((char)data);
			}
		} catch (Exception e) {e.getMessage();}
		
	}

}
