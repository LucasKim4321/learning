package chap11;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class E03StringMethod {

	public static void main(String[] args) throws UnsupportedEncodingException, ClassNotFoundException {  // throws 예외처리
		// String Method
		
		String str = "Hello Java!!";
		
		System.out.println("length(): "+str.length());  // 문자열의 길이
		System.out.println("charAt(index): "+str.charAt(3));  // 인덱스 번호에 해당하는 문자 출력
		System.out.println("indexOf(문자): "+str.indexOf('o'));  // 해당 문자의 인덱스 번호 출력  없으면 -1
		System.out.println("replace(oldChar, newChar):"+str.replace("Java", "Pyhton"));  // Java를 Python으로 바꿈
		System.out.println("substring(start,end)"+str.substring(3));  //3번재부터 나옴
		System.out.println("substring(start,end)"+str.substring(0,3));  // 0번째부터 3번째까지(3번째 미포함)
		System.out.println("substring(start,end)"+str.substring(2,3));  // 2번째
		
		System.out.println("trim(): "+"Hello".length()+","+"   Hello  ".trim().length());  // trim() 문자열의 양끝 공백을 다 자르고 길이 측정
		System.out.println("concat():"+str.concat(" hello python !!!"));
		
		// 주민 번호 뒷번호 * 표시하기
		String jumin = "19001001-123456";
		int idx = jumin.indexOf("-");  // "-"인덱스 번호 8
		String front = jumin.substring(0,idx);  // front = 19001001
		String temp = jumin.substring(idx+1, jumin.length());  // temp = 123456
		
		String end = "";
		for (int i=0; i<temp.length(); i++) {
			if (i==0) {  // 주민 뒷자리 첫번째 숫자
				end += temp.charAt(i);  // end += 1
			}
			else {  // 주민 뒷자리 두번째 이후 숫자
				end+= "*";  // 나머지 모두 *
			}
		}
		System.out.println("주민등록번호: "+front+"-"+end);  // 19001001-1*****
		
		// split() : 특정문자로 기준으로 분리해서 배열로 저장
		System.out.println("-- split()");
		String fruitData = "사과 바나나 귤 수박";
		
		String[] data = null;
		data = fruitData.split(" ");
		System.out.println(Arrays.toString(data));
		
		System.out.println("-- for");
		for (int i=0; i<data.length; i++) {
			System.out.println(data[i]);
		}
		System.out.println("-- 확장 for");
		for (String s : data) System.out.println(s);
		
		// 문자열을 바이트배열로 전환
		byte[] b = "hello".getBytes();
		System.out.println("-- getBytes()");
		System.out.println(b.length);  // 배열임을 의미
		System.out.println(Arrays.toString(b));  // "ahello"의 아스키 코드값
		
		String decodeName2 = new String(b, 2, 3, "UTF-8");  // 배열 b의 2번째부터 3개의 문자열
		System.out.println(decodeName2);  // llo
		
		// StringBuffer : String+Buffer 기능 추가
		// 멀티 스레드 동기화를 제공
		String name = "홍길동";
		System.out.println(name.concat("길순이"));  // 홍길동길순이
		System.out.println(name);  // 홍길동
		
		StringBuffer sb = new StringBuffer("홍길순");
		System.out.println(sb);  // 홍길순
		sb.append("동길이");  // sb에 "동길이"추가
		sb.append("동순이");
		System.out.println(sb);  // 홍길순동길이동순이
		
		// 멀티 스레드 동기화를 제공하지 않음
		StringBuilder sb2 = new StringBuilder("부산");  // buffer랑 비슷한데 용도가 다름
		System.out.println(sb2);  // 부산
		sb2.append("서울"); sb2.append("대구");
		System.out.println(sb2);  // 부산서울대구
		
		// class 클래스 : 실행 중 메모리의 클래스 객체로 부터 원래 클래스에 관한 정보 추출
		//1.
		Class c1 = E01EnumClassTest.class;
		System.out.println(c1.getName());  // 패키지명+클래스이름
		System.out.println(c1.getSimpleName());  // 클래스이름
		System.out.println(c1.getPackage());  // package 패키지명
		System.out.println(c1.getPackage().getName());  // 패키지명
		
		System.out.println("----");
		Class c2 = Class.forName("chap10.E07MapClass");  // Class.forName("클래스이름");  클래스를 찾아줌
		System.out.println(c2);  // chap10.E07MapClass.class
		System.out.println(c2.getName());  // 패키지명+클래스이름
		System.out.println(c2.getSimpleName());  // 클래스이름
		System.out.println(c2.getPackage().getName());  // 패키지명

		System.out.println("----");
		E02EnumValue e1 = new E02EnumValue();
		Class c3 = e1.getClass();
		System.out.println(c3.getName());  // 패키지명+클래스이름
		System.out.println(c3.getSimpleName());  // 클래스이름
		System.out.println(c3.getPackage().getName());  // 패키지명

		System.out.println("----");
		// 같은 경로에 있는 다른 리소스파일(.xml, 이미지, 설정파일 등)의 경로 추출
		String sPath = c3.getResource("rabbit1.avif").getPath();
		System.out.println(sPath);

		System.out.println("----");
		// StringTokenizer클래스 : split()와 유사
		String data1 = "사과 바나나 수박 참외";
		String data2 = "202405/27";
		StringTokenizer str1 = new StringTokenizer(data1); // 구분자 생략시 공백
		System.out.println(str1);
		while(str1.hasMoreTokens()) {
			System.out.println(str1.nextToken());
		}
		StringTokenizer str2 = new StringTokenizer(data2, "/"); // "/"을 기준으로 나눔
		while(str2.hasMoreTokens()) {
			System.out.println(str2.nextToken());
		}
	}

}
