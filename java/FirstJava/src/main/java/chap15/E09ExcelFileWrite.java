package chap15;

import java.io.File;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class E09ExcelFileWrite {

	public static void main(String[] args) {
		// 엑셀 파일 생성
		
		// 경로 설정
		String path = "C:"+File.separator+"javaStudy"+File.separator+"learning"+File.separator+"java"
		+File.separator+"FirstJava"+File.separator+"src"+File.separator+"main"+File.separator+"java"+File.separator+"chap15"+File.separator+"excel"+File.separator;
		System.out.println(path);
	
		// 1. 엑셀 workbook 생성
		XSSFWorkbook workbook = new XSSFWorkbook();
		
		// 2. 엑셀 sheet생성
		XSSFSheet sheet = workbook.createSheet("1학년 1반 성적");
		
		// 3. Row 생성
		Row row = sheet.createRow(0);
		
		// 4. Cell 생성
		Cell cell = row.createCell(0);
		cell.setCellValue("학번");
		
		cell = row.createCell(1);
		cell.setCellValue("이름");
		
		cell = row.createCell(2);
		cell.setCellValue("국어");
		
		cell = row.createCell(3);
		cell.setCellValue("영어");
		
		cell = row.createCell(4);
		cell.setCellValue("수학");
		
		// 엑셀 파일 작성
		try (FileOutputStream fos = new FileOutputStream(new File(path+"자바로생성한성적표.xls"))) {
			workbook.write(fos);
			System.out.println("엑셀 파일이 작성되었습니다.");
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
