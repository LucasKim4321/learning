package WebCrawling;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class WebCrawlingImageDownload {

	public static void main(String[] args) {
		// 경로 설정
//		String img_path = "\\Desktop"+File.separator;
//		String img_path = "C:"+File.separator+"javaStudy"+File.separator+"learning"+File.separator+"java"
//		+File.separator+"FirstJava"+File.separator+"src"+File.separator+"main"+File.separator+"java"+File.separator+"chap15"+File.separator+"WebCrawling"+File.separator;
//		System.out.println(img_path);
		
		Document document;
		try {
			document = Jsoup.connect("file:///C:/Users/xowls/OneDrive/Desktop/[Digital%20Lover%20(Nakajima%20Yuka)]%20DLO-01%20Kare%20to%20no%20Yakusoku%20_%20DLO-01%20Promise%20with%20Him%20[Portuguese-BR]%20[Digital]%20-%20E-Hentai%20Galleries.html").get();
			System.out.println(document);
			System.out.println("연결 성공");
//			System.out.println(document);
//			Elements elements = (Elements)document.select("#gdt > .gdtm > div > a");  // .title
////			elements.stream().forEach(title -> System.out.println(title.outerHtml()));
//			
//			// 1.  "src=이미지 파일 경로 | alt=도서제목 | 이미지 확장자"
//			List<String> list =
//			elements.stream().map(element -> {
//				String path = element.attr("href");
//				return path;
//			})
//			.collect(Collectors.toList());
//			
////			System.out.println(list);
//			list.stream().forEach(System.out::println);
			
		} catch (Exception e) {
			System.out.println("연결 실패");
			System.out.println(e.getMessage());
		}


	}

}
