package chap14;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
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

		
		// 버퍼를 이용하여 파일 스트림 처리
		// 장치간에 데이터의 전송속도, 처리속도를 최적의 상태로 유지
		// FileInputStream -> BufferInputStream -> BufferedInputStream -> FileinputStream
		
		System.out.println("-- 버퍼 이용하기");
		try( FileInputStream fis = new FileInputStream("pom.xml");
			 BufferedInputStream bis = new BufferedInputStream(fis);
			 FileOutputStream fos = new FileOutputStream("test_pom2.xml");
				BufferedOutputStream bos = new BufferedOutputStream(fos)) {
			int i;
			while( (i=bis.read()) != -1 ) {
				bos.write(i);
			}
			
		} catch (Exception e) {}
		finally {
			System.out.println("파일 복사 완료!!");
		}
		
		System.out.println("-- 다운로드");
		try {
			URL url = new URL("https://ssl.pstatic.net/melona/libs/1496/1496326/ed34de11baccdc54aed2_20240523115950073.jpg");
			try {
				InputStream in = new BufferedInputStream(url.openStream());
				OutputStream out = new BufferedOutputStream(new FileOutputStream("test001.jpg"));
				
				// for(초기치; 조건식; 증감치){}
				for (int i; (i=in.read())!=-1;) {
					out.write(i);					
				}
				
				in.close();
				out.close();
	
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
	}

}
