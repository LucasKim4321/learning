package chap15;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class E07ZipunZipClass01 {

	public static void main(String[] args) {
		// Zip and Unzip
		String path = "C:"+File.separator+"javaStudy"+File.separator+"learning"+File.separator+"java"
		+File.separator+"FirstJava"+File.separator+"src"+File.separator+"main"+File.separator+"java"+File.separator+"chap15"+File.separator+"test"+File.separator;
		System.out.println(path);
		
		// 블럭 : 한번 읽어오는 단위
		// 블럭 단위 설정
		byte[] bytes = new byte[1024];
		
		// 압축할 파일 목록
		String[] files = new File(path).list();  // 경로에 있는 파일 리스트
		System.out.println(Arrays.toString(files));  
		
		try(FileOutputStream fos = new FileOutputStream(path+"test.zip");
				ZipOutputStream zos = new ZipOutputStream(fos)) {
			Arrays.stream(files)
			.forEach( x -> {
				File f = new File(path+x);
				try(FileInputStream fis = new FileInputStream(f)) {
					ZipEntry zipEntry = new ZipEntry(f.getName());  // 압축할 파일이름
					zos.putNextEntry(zipEntry);
					int length;
					while((length = fis.read(bytes)) >= 0) {  // 파일의 길이 만큼 반복
						zos.write(bytes,0,length);
					}
					
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			});
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
