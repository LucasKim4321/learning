package chap21;

import java.io.InputStream;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class E08PublicDataTest {

	public static void main(String[] args) throws Exception {
//		data.seoul.go.kr  서울시 자료가 아주 많음  공공데이터 메뉴로 이동
//		샘플 URL	서울시 문화재정보(영어)
//		http://openapi.seoul.go.kr:8088/(인증키)/xml/SebcHeritageInfoEng/1/5/
		
		// 서울시 문화재 공공데이터 API구현하기
		// 내 인증키  key = 70516e4c55786f7735365353467161
		
		String key = "70516e4c55786f7735365353467161";

		URL url = new URL("http://openapi.seoul.go.kr:8088/"+key+"/xml/SebcHeritageInfoEng/1/5/");
		
		InputStream stream = url.openStream();

		//-------------------------//
		// 불러온url을 xml형식으로 전환하는 과정
		char ch = 0;
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(stream);  // org.w3c.dom.Document 이걸로 불러옴
		doc.getDocumentElement().normalize();
		//-------------------------//
		
		NodeList nList = doc.getElementsByTagName("row");
		System.out.println("----");
		for (int i = 0; i <nList.getLength(); i++) {
			Node nNode = nList.item(i);
			
			
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {  // 단일요소(노드) 판별
				
				// XML태그를 이용해서 각각의 문화재 상세정보를 가져와서 콘솔화면에 출력
				Element eElement = (Element)nNode;
				
				/*  출력값 홈페이지에서 확인 가능
				공통	list_total_count	총 데이터 건수 (정상조회 시 출력됨)
				공통	RESULT.CODE	요청결과 코드 (하단 메세지설명 참고)
				공통	RESULT.MESSAGE	요청결과 메시지 (하단 메세지설명 참고)
				1	MAIN_KEY	키값
				2	MNG_NO	문화재 일련번호
				3	NAME_ENG	문화재명칭
				4	QUANTITY_SCALE	수량ㆍ규모
				5	H_ENG_CITY	행정시
				6	H_ENG_GU	행정구
				7	H_ENG_DONG	행정동
				8	WGS84_X	X좌표
				9	WGS84_Y	Y좌표
				10	DESIGNATION_DATE	지정일
				11	UNDESIGN_DATE	해제일
				*/
				
				System.out.println("문화재 키값: "+getTagValue("MAIN_KEY",eElement));
				System.out.println("문화재 일련 번호: "+getTagValue("MNG_NO",eElement));
				System.out.println("문화재 명칭: "+getTagValue("NAME_ENG",eElement));
				System.out.println("수량ㆍ규모: "+getTagValue("QUANTITY_SCALE",eElement));
				System.out.println("문화재 키값: "+getTagValue("MAIN_KEY",eElement));
				System.out.println("행정시: "+getTagValue("H_ENG_CITY",eElement));
				System.out.println("행정구: "+getTagValue("H_ENG_GU",eElement));
				System.out.println("행정동: "+getTagValue("H_ENG_DONG",eElement));
				System.out.println("\n\n");
			}
		}
	}
	
	private static String getTagValue(String sTag, Element eElement) {
		NodeList nList = eElement.getElementsByTagName(sTag).item(0).getChildNodes();
		Node nValue = (Node) nList.item(0);
		
		if (nValue == null) return "1"; // 문화재 수량이 없는 경우 "1"로 설정하여 반환
		
		return nValue.getNodeValue();
	}

}
	