package chap18.model;

//import java.awt.*;
import java.awt.List;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class MovieModel {
	// 추가
	public void addTitle(String mTitle, List movieList) {
		movieList.add(mTitle);
		System.out.println("추가되었습니다.");
	}

	// 선택
	public void selectTitles() {
		System.out.println("선택되었습니다.");
	}
	
	// 저장
	public void saveTitles(List movieList) {
		
		File file = new File("src/main/resources/movieInfo.txt");
		try {
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file),"UTF-8"));
			PrintWriter writer = new PrintWriter(bw, true);  // autoFlush=true
			
			String items[] = movieList.getItems();
			
			Arrays.stream(items).forEach(System.out::println);
			Arrays.stream(items).forEach( (title) -> {
				writer.println(title);      // 파일 출력
				System.out.println(title);  // 콘솔 출력
			});
			
			bw.close();
			writer.close();
			
		} catch (Exception e) {}
		
		
		System.out.println("저장되었습니다.");
	}
	
	// 삭제
	public void delTitles(String mTitle, List movieList) {
		movieList.remove(mTitle);
		System.out.println("삭제되었습니다.");
	}
	// 종료
	public void exitTitles() {
		System.out.println("종료되었습니다.");
	}
}
