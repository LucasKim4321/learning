package chap14;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;

public class E07File03 {

	public static void main(String[] args) {
		System.out.println("-- 한글 한글자 처리 : 3byte구성, 3회 read() --");
		
		try (FileInputStream fis = new FileInputStream("hangul.txt");
			 FileOutputStream fos = new FileOutputStream("hangul2.txt")) {
				 
			// 영문자 : 1byte
			// 한글 : UTF-8방식 => 3byte, EUC-KR : 2byte
			fos.write( fis.read());
			fos.write( fis.read());  // 두개만 읽으면 한글 깨짐
			fos.write( fis.read());
			
		} catch (Exception e) {}
		
		System.out.println("-- 문자 처리 : Reader, Writer");
		try(FileReader fr = new FileReader("hangul.txt");
			FileWriter fw = new FileWriter("hangul3.txt")) {
			
			fw.write(fr.read());  // 한글자씩 읽음
			fw.write(fr.read());
			fw.write(fr.read());
			fw.write(fr.read());
			fw.write(fr.read());
			
		}catch(Exception e) {}
	}

}
