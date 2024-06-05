package chap15;

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

public class E13WebCrawlingImageDownLoad {

	public static void main(String[] args) {
		// 이미지 다운
		
		
		// 경로 설정
		String img_path = "C:"+File.separator+"javaStudy"+File.separator+"learning"+File.separator+"java"
		+File.separator+"FirstJava"+File.separator+"src"+File.separator+"main"+File.separator+"java"+File.separator+"chap15"+File.separator+"WebCrawling"+File.separator;
		System.out.println(img_path);

		Document document;
		try {
			document = Jsoup.connect("https://www.namgarambooks.co.kr/").get();
//			System.out.println(document);
			Elements elements = (Elements)document.select("#wrap .container .inner .post-item img");  // .title
//			elements.stream().forEach(title -> System.out.println(title.outerHtml()));
			
			// 1.  "src=이미지 파일 경로 | alt=도서제목 | 이미지 확장자"
			List<String> list =
			elements.stream().map(element -> {
				String path = element.attr("src");
				// src="이미지 파일"의 확장자만 추출
				String ext = path.split("\\.")[(path.split("\\.").length-1)];  // .을 기준으로 나눴을때 마지막에 있는게 확장자
				
				// "abvc.txtesxx" => "jpg"로 처리
				// 4자 이하는 확장자, 확장자가 없으면 jpg로 처리
				ext = (ext.length() > 4 || "".contentEquals(ext)) ? "jpg" : ext ;
				
				// 반환 : 이미지 src속성값 + alt속성값 + 이미지 확장자
				// img 태그의 alt값이 없으면 랜덤한 이름 생성
				String alt = element.attr("alt").trim();
				int len = alt.length();
				if (len <1) {
					UUID uuid = UUID.randomUUID();  // 중복되지않는 랜덤한 난수(숫자,영어 조합) 생성
					alt = "다운로드_"+uuid.toString();
				}
//				return element.attr("src")+"|"+element.attr("alt")+"|"+ext;  // alt 값이 있을 때
				return element.attr("src")+"|"+alt+"|"+ext;  // alt 값이 없을 때
			})
			.collect(Collectors.toList());
			
//			System.out.println(list);
			list.stream().forEach(System.out::println);
			
			// 2. 다운로드 이미지 파일 리스트
			List<String> imgFileList = 
					list.stream()
					.map(mapper-> {
						// 다운로드 파일이름 생성 : 저장할 파일이름 생성
						String returnVal = mapper.split("\\|")[1]+"."+mapper.split("\\|")[2];  // alt+확장자
						
						// 이미지가 있는 서버에 URL객체로 통해 접속하여 이미지 가져오기
						URL url;
						try {
							url = new URL("https:"+mapper.split("\\|")[0]);  // mapper.split("\\|")[0]서버 주소
							try (InputStream  in  = new BufferedInputStream(url.openStream());
								 OutputStream out = new BufferedOutputStream(new FileOutputStream(img_path+returnVal))) {
								
								// 서버에 있는 이미지 파일을 읽어서 로컬 저장소에 파일로 저장
								for (int i; (i =in.read()) != -1;) {  //  == int i; while( (i=in.read()) != -1){}  // 파일 데이터가 있으면 처리
									out.write(i);
								}
								
							} catch (Exception e) {
								System.out.println(e.getMessage());
							}
						} catch (MalformedURLException e) { System.out.println(e.getMessage()); }
						return returnVal;
					})
					.collect(Collectors.toList());
			
//			System.out.println(imgFileList);
//			imgFileList.stream().forEach(System.out::println);
			imgFileList.forEach(System.out::println);
			
			// 3. 압축하기
			try (FileOutputStream fos = new FileOutputStream(img_path+"book.zip");
					ZipOutputStream zos = new ZipOutputStream(fos)) {
				imgFileList.stream().forEach(file-> {
					byte[] bytes = new byte[1024];  // 읽어올 블럭 단위
					File f = new File(img_path+file);
					// zip 파일의 output Stream
					try(FileInputStream fis = new FileInputStream(f)) {
						ZipEntry zipEntry = new ZipEntry(f.getName());
						
						// 압출할 파일 추가
						zos.putNextEntry(zipEntry);
						
						int length;
						while( (length = fis.read(bytes)) != 0) {
							zos.write(bytes,0, length);
						}
						
						
					} catch (Exception e) {
						System.out.println(e.getMessage());  // null 에러 표시 원인은?
					}
					
					// 1개의 이미지 -> 압축처리한 후, 원본 삭제
					if (f.exists()) { f.deleteOnExit(); }  // 파일이 존재하면 파일 삭제
				});
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}


	}

}
