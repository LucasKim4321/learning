package chap21;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class E09ReadXMLTest {

	public static void main(String[] args) throws Exception {
		
		File fXmlFile = new File("src\\main\\java\\chap21\\company.xml");
		if(fXmlFile != null) System.out.println("불러오기 성공");
		else System.out.println("불러오기 실패");
		
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(fXmlFile);
		doc.getDocumentElement().normalize();
		
		System.out.println("Root elemewnt: "+doc.getDocumentElement().getNodeName());
		
		NodeList nList = doc.getElementsByTagName("emp");
		
		System.out.println("------");
		for (int i=0; i<nList.getLength(); i++) {
			Node nNode = nList.item(i);  // nodelist의 인덱스번호
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				
				System.out.println("firstName: "+getTagValue("firstName",eElement));
				System.out.println("lastName: "+getTagValue("lastName",eElement));
				System.out.println("nickName: "+getTagValue("nickName",eElement));
				System.out.println("salary: "+getTagValue("salary",eElement));
				System.out.println("car: "+getTagValue("car",eElement));
				System.out.println("\n");
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

/*
XML(eXtensible Makeup Language) : 확장성 있는 마크업 언어
프로그램 간에 정보를 교환하기 위한 데이터 형식

 구성 요소
태그(tag): 데이터 구성
속성(attribute): 데이터를 상세하게 설명하는 용도

 태그 규칙
- 모든 태그는 시작 태그와 종료 태그를 가져야한다.
태그는 또 다른 하위 태그를 가질 수 있다.(계층 구조)
형식) <사용자 정의 태그이름> 담겨질 내용 </사용자 정의 태그이름>
예)	<?xml version="1.0" encoding="UTF-8"?>  // xml태그 선언  닫는거 없음
	<info>
		<name>홍길동</name>
		<address>부산</address>
		요소안에 이스케이프 문자가 있을 경우
		<other>
			<![CDATA[
				SELECT *
				FROM DUAL
				WHERE a < b
				AND b > c
			]]>
		</other>
	</info>
*/