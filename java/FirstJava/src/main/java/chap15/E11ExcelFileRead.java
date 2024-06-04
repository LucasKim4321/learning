package chap15;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class E11ExcelFileRead {

	public static void main(String[] args) {
		// Excel파일 가져오기

		// 경로 설정
		String path = "C:"+File.separator+"javaStudy"+File.separator+"learning"+File.separator+"java"
		+File.separator+"FirstJava"+File.separator+"src"+File.separator+"main"+File.separator+"java"+File.separator+"excel"+File.separator;
		System.out.println(path);
		

		try ( FileInputStream in = new FileInputStream(new File(path+"성적표데이터.xls"))) {
			
			XSSFWorkbook workbook = new XSSFWorkbook(in);
			XSSFSheet sheet = workbook.getSheet("1학년 2반 성적");// sheet 읽기
			// 엑셀 sheet로부터 데이타 있는 모든 Row를 읽기
			Iterator<Row> rowIterator = sheet.iterator();
			
			rowIterator.forEachRemaining( row -> {
				// 학번, 이름, 시험일자, 국어, 영어, 수학
				
				// Row에 있는 모든 Cell 정보를 Iterator 정보로 읽기
				// Iterator<Cell> cellIterator = row.cellIterator();

				//System.out.println(row.getRowNum()+":행");
				if (row.getRowNum()>1) { // 0행, 1행은 표의 제목 부분을 제외
					
					for (Cell cell: row) { // 2행 부터 cell값을 읽기
						//System.out.println(cell.getCellType());
						System.out.print(cell.toString()+"\t");
					}
					
					System.out.println();
				}

			});
			
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}



}
