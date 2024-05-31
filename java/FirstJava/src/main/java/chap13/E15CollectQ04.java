package chap13;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class E15CollectQ04 {

	public static void main(String[] args) {
		// 4. 파일명들에 확장자가 누락되어 있습니다. 파일명 뒤에'.java'를 모두 붙여서 출력하는 코드 구현
		//   보기> Sample01, Sample02,..
		//			[ Sample01.java, Sample02.java,...]
		
		List<String> fileList = Arrays.asList("Sample01","Sample02","Sample03","Sample04");
		
		System.out.println(fileList);
		List<String> newFileList = fileList.stream().map(x -> x +".java").collect(Collectors.toList());
		System.out.println(newFileList);
		
	}

}
