package chap21;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class E08PublicDataTest {

	public static void main(String[] args) throws Exception {
//		data.seoul.go.kr  서울시 자료가 아주 많음
//		샘플 URL	서울시 문화재정보(영어)
//		http://openapi.seoul.go.kr:8088/(인증키)/xml/SebcHeritageInfoEng/1/5/
		
		// 서울시 문화재 공공데이터 API구현하기
		// 내 인증키  key = 70516e4c55786f7735365353467161
		
		String key = "70516e4c55786f7735365353467161";

		URL url = new URL("http://openapi.seoul.go.kr:8088/"+key+"/xml/SebcHeritageInfoEng/1/5/");
		
		InputStream stream = url.openStream();
		
	}

}
