package chap15;

import java.io.File;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class E11ExcelFileStyle {

	public static void main(String[] args) {
		// 엑셀 스타일 적용
		// 경로 설정
		String path = "C:"+File.separator+"javaStudy"+File.separator+"learning"+File.separator+"java"
		+File.separator+"FirstJava"+File.separator+"src"+File.separator+"main"+File.separator+"java"+File.separator+"excel"+File.separator;
		System.out.println(path);
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("1학년 2반 성적");
		
		// sheet 눈금선 없애기
		sheet.setDisplayGridlines(false);
		
		// 표 헤더 cell style 정의
		CellStyle tableHCellStyle = workbook.createCellStyle();
		
		// 배경색
		tableHCellStyle.setFillBackgroundColor(IndexedColors.LIGHT_GREEN.getIndex());  // 컬러
		tableHCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);  // 패턴
		
		// 정렬
		tableHCellStyle.setAlignment(HorizontalAlignment.CENTER);  // 수평 가운데 정렬
		tableHCellStyle.setVerticalAlignment(VerticalAlignment.CENTER);  // 수직 정렬
		
		// 폰트
		Font headerFont = workbook.createFont();
		headerFont.setFontHeightInPoints((short)12);
		headerFont.setBold(true);
		tableHCellStyle.setFont(headerFont);
		
		// 테두리 선
		tableHCellStyle.setBorderLeft(BorderStyle.THIN);
		tableHCellStyle.setBorderRight(BorderStyle.THIN);
		tableHCellStyle.setBorderBottom(BorderStyle.THIN);
		tableHCellStyle.setBorderTop(BorderStyle.THIN);
		
		// Row 생성
		Row row = sheet.createRow(0);
		
		// Cell 생성
		Cell cell = row.createCell(0);
		cell.setCellStyle(tableHCellStyle);
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
		try (FileOutputStream fos = new FileOutputStream(new File(path+"자바로생성한성적표2.xls"))) {
			workbook.write(fos);
			System.out.println("엑셀 파일이 작성되었습니다.");
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
