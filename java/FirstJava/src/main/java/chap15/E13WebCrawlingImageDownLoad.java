package chap15;

import java.util.List;
import java.util.stream.Collectors;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class E13WebCrawlingImageDownLoad {

	public static void main(String[] args) {
		// 이미지 다운

		Document document;
		try {
			document = Jsoup.connect("https://product.kyobobook.co.kr/new/#?page=1&sort=new&year=&month=&week=&per=20&saleCmdtDvsnCode=KOR&gubun=preOrderGubun").get();
//			System.out.println(document);
			Elements elements = (Elements)document.select("#mainDiv .container_wrapper > #contents > .contents_inner > #contents > .tab_wrap > #tabBest01 #tabBest01Sub01 .switch_prod_wrap .prod_list");  //  .prod_link .img_box img
			elements.stream().forEach(title -> System.out.println(title.html()));
			
//			List<String> list =
//			elements.stream().map(element -> {
//				String path = element.attr("src");
//				String ext = path.split("\\.")[(path.split("\\.").length-1)];  // .을 기준으로 나눴을때 마지막에 있는게 확장자
//				
//				// "abvc.txtesxx" => "jpg"로 처리
//				// 4자 이하는 확장자, 확장자가 없으면 jpg로 처리
//				ext = (ext.length() > 4 || "".contentEquals(ext)) ? "jpg" : ext ;
//				return element.attr("src")+"|"+element.attr("alt")+"|"+ext;
//			})
//			.collect(Collectors.toList());
//			System.out.println(list);
			
			
			
//			.forEach( s -> {
//			System.out.println(s);
//			});
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
