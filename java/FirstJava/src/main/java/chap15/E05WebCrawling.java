package chap15;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class E05WebCrawling {

	public static void main(String[] args) {
		Document document;
		try {
			document = Jsoup.connect("https://product.kyobobook.co.kr/bestseller/total?period=002#?page=1&per=20&period=002&ymw=&bsslBksClstCode=A").get();
			Elements elements = (Elements) document.select("#contents > .tab_wrap > .tab_wrap .tab_content .view_type_list  .prod_list ");//.prod_item .prod_area .prod_info_box .prod_rank .text "); //> .tab_wrap #tabRoot  .view_type_list .prod_list .prod_item ");// .prod_arera  .prod_info_box .prod_rank .text");
			
			elements.stream()
					.forEach( book_title -> System.out.println(book_title.text()));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}