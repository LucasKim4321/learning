package chap11;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class E05RegularExClass {

	public static void main(String[] args) {
		// 정규 표현식
		String str = "1234567890";
		
		Pattern p = Pattern.compile("^[0-9]*$");  // 0~9 의 숫자 포함 여부 검사
		Matcher m = p.matcher(str);  // true
		
		System.out.println(m.find());
		System.out.println(str.matches("^[0-9]*$"));  // true
		
		// 대문자와 숫자만 입력하는 6자리 의 문자열 검사
		System.out.println("-----");
		String[] str2 = {"ASDF12", "123456", "QWERTY","as234aa","1324kkk"};
		String regex = "^[0-9A-Z]{6}$";
		for (String data : str2) {
			System.out.printf("%s\t %b\n",data, data.matches(regex));
		}
		
		String target = "sample@sample.com, test@test.co.kr, example@example.com";
		String regex1 = "([\\w]+@[\\w]+.com)";  // "\w" -> [0-9a-zA-z]와 동일  숫자,알파뱃 대소문자

		System.out.println("-----");
		Pattern pattern = Pattern.compile(regex1);
		Matcher matcher = pattern.matcher(target);
		
		while(matcher.find()) {
			System.out.println(matcher.group());
		}
		
		// 치환
		System.out.println("-----");
		String regex3 = "[^0-9]";  // 숫자가 아닌 값 (문자)
		String[] str3 = {"ASDF12", "123456", "QWERTY","as234aa","1324kkk"};
		for (String data : str3) {
			System.out.printf("%s\t %S\n",data, data.replaceAll(regex3, ""));  // regex3에 매칭되는 값 공백으로 대체
		}
		
		// 주민번호
		System.out.println("-----");
		String no = "주민등록번호: 010101-1234567" + "주민등록번호: 020202-2234567";
		String regex4 = "[0-9]{6}-[0-9]{7}";  // 6자리 숫자 + 7자리 숫자
		
		Pattern p4 = Pattern.compile(regex4);
		Matcher m4 = p4.matcher(no);
		
		while(m4.find()) {
			System.out.print(m4.group()+" -> ");
			String newNo = m4.group().substring(0,7) + "****"+m4.group().substring(11);
			System.out.println(newNo);  // 010101-1234567 -> 010101-****567  020202-2234567 -> 020202-****567
		}
	}

}
