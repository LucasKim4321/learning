package chap15;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class E01File01 {

	public static void main(String[] args) {
		// 자바 스트림 : 입출력을 도와주는 클래스
		// 바이트 데이터 (동영상, 이밎, 사운드 등 : 1byte 단위)
		// 문자 데이터 (텍스트 : 2byte)
		
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			// 경로를 생략하면 프로젝트 폴터가 root("/")이고 root가 현재 위치가 됨.
			fis = new FileInputStream("pom.xml");  // fis 파일핸들러
			fos = new FileOutputStream("test_pom.xml");
			
			int i;
			while((i=fis.read()) != -1) {  // 방금 읽은 내용(데이터)이 있으면 처리
				fos.write(i);
//				System.out.print(i);
				System.out.print((char)i);
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());			
		}
//		catch (FileNotFoundException e) {
//			System.out.println(e.getMessage());
//			e.printStackTrace();
//		}
	}

}
