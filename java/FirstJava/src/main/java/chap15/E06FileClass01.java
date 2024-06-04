package chap15;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class E06FileClass01 {

	public static void main(String[] args) {
		// File클래스 : 파일이나 디렉터리에 대응
		// "c:/abc/ddd/text.txt" => 문자열 =>  파일시스템으로 전환
		// "/" or "\\" => "c:\\abc\\ddd\\text.txt"
		
		
		// File.separator => 해당 OS에 맞는 구분자가 추출
		String path = "workspace" + File.separator + "realjava" + File.separator +"src";
		System.out.println(path);
		
		System.out.println("-- File API");
		// "C:\javaStudy\java\FirstJava"
		
		// 해당OS에 맞는 path 문자를 적용 
		String path2 = "C:"+File.separator+"javaStudy"+File.separator+"java"+File.separator+"FirstJava";
		System.out.println(path2);
		
		// 대상 경로
		File paths = new File(path2); // OS에서 사용하는 경로로 인식하는 객체
		
		// 모든 파일과 디렉토리 수집
		String[] files = paths.list();
		System.out.println(Arrays.toString(files));
		
		// 파일인자 디렉토리 판별한 내용을 저장하는 List
		List<String> fileList = new ArrayList<String>();
		
		System.out.println("-- 1. 확장 for(자료형 변수 : 배열){}");
		for(String fNm : files) {
			File fileDir = new File(fNm);
			
			if (fileDir.isDirectory()) {// 디렉토리이면 처리
				fNm = "[디렉토리]:"+fNm;
			} else {// 파일이면 처리
				fNm = "파일:"+fNm;
			}
			
			fileList.add(fNm);
			
		}
		 
		//fileList.sort(Comparator.naturalOrder()); // 순차 정렬
		fileList.sort(Comparator.reverseOrder()); // 역 정렬
		fileList.forEach(System.out::println);
		
		System.out.println("-- stream()");
		
		String files2 [] = new File(path2).list();
		List<String> fileList2 = Arrays.stream(files2)
										.map( x -> {
											File fileDir = new File(x);
											return (fileDir.isDirectory() ? "[디렉토리]:"+x: "파일:"+x);
											
										})
										.collect(Collectors.toList());
		
		fileList2.stream().sorted().forEach(System.out::println);
		
		System.out.println("-- fillter()");
		Arrays.stream(files2)
				.filter(x -> new File(x).isFile()) 		// 파일(true)이면 다음 함수를 수행
				.filter(x -> x.startsWith("hangule")) 	// 파일이름이 "hangul"로 시작되는 문자열이면 true
				.map(x -> {
					new File(x).delete();
					return x;
				})
				.forEach(x -> {
					System.out.println("파일 ["+x+"]이 삭제되었습니다.");
				});
		

		
		

	}

}
