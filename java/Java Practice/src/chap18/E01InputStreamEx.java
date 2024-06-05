package chap18;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class E01InputStreamEx {

	public static void main(String[] args) {
		try {
			InputStream in = System.in;
			int data = 0;
			while( (data=in.read()) != -1) {
				System.out.print((char)data);
			}
		} catch (IOException  e) {
			e.getMessage();
		}
	}

}
