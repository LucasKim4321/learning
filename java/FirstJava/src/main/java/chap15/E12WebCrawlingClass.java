package chap15;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class E12WebCrawlingClass {

	public static void main(String[] args) {
		// 웹 크롤링(Web crawling)
//		 인터넷 주소창에 주소/robots.txt 정보 알람가능
//		 * Document : 웹사이트의 모든 소스코드(HTML,CSS,Javascript)
//		 * Elements : Document의 특정 범위
//		 * Element : HTML 태그 일부를 담을 수 있는 최종 요소
		
		Document document;
		try {
			document = Jsoup.connect("https://www.namgarambooks.co.kr/").get();
//			System.out.println(document);
			Elements elements = (Elements)document.select("#wrap .container .inner .post-item .title");
			elements.stream().forEach(title -> System.out.println(title.text()));
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		System.out.println("-- 교보문고 : 카테고리 항목 가져오기");
		List<String> category_title = new ArrayList<String>();
		try {
			document = Jsoup.connect("https://product.kyobobook.co.kr/new/#?page=1&sort=new&year=2024&month=06&week=1&per=20&saleCmdtDvsnCode=KOR&gubun=newGubun&saleCmdtClstCode=").get();
//			System.out.println(document);
//			Elements elements = (Elements)document.select("#mainDiv .container_wrapper > #contents > .contents_inner > #contents > .tab_wrap > #tabBest01 .tab_text");
			Elements elements = (Elements)document.select("#tabBest01 .tab_text");  // 찾고자 하는 것에 가장 가까운 id에서 부터 타고 내려가면 빠름
			elements.stream().forEach(tabName -> {
				System.out.println(tabName.text());
				category_title.add(tabName.text());
			});
			System.out.println("-- result");
			System.out.println(category_title);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
	}

}
