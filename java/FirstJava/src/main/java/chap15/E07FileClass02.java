package chap15;

import static java.util.stream.Collectors.toList;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class E07FileClass02 {

	public static void main(String[] args) {
		// 파일 속성  표시하기
		String path =  "C:"+File.separator+"javaStudy"+File.separator+"java"+
						File.separator+"FirstJava"+File.separator;
		System.out.println(path);
		
		// 모든 파일과 디렉토리 수집하기
		String[] files = new File(path).list();
		
		// 디렉토리 filter식 작성
		Predicate<String>  dirCondition = x -> {
			File fileDir = new File(x);
			return fileDir.isDirectory();
		};
		
		// 파일 fileter식 작성
		Predicate<String> fileCondition = Predicate.not(dirCondition);
		
		List<String> dirList = Arrays.stream(files)
									.filter(dirCondition)
									.map(dir ->"["+dir+"]")
									.collect(toList());
		
		
		List<String> fileList = Arrays.stream(files)
									.filter(fileCondition)
									.map( file -> {
										File f = new File(file);
										
										file += f.canExecute()?"\t실행파일": "\t실행불가";
										file += f.canRead()?"\t읽기가능":"\t읽기불가";
										file += f.canWrite()?"\t쓰기가능":"\t쓰기불가";
										file += f.isHidden()?"\t숨김파일":"\t일반파일";
										return file;
									})
									.collect(toList());
		
		Stream.of(dirList, fileList)
				.flatMap(List::stream)
				.forEach(System.out::println);
	
		System.out.println("-- exist(), mkdirs()....");
		
		// 디렉토리 유무 : 특정 경로가 없으면 생성
		File p = new File(path);
		System.out.println(p.exists());
		
		if (!p.exists()) {
			p.mkdir();
		}
		
		// 파일 생
		Scanner sc = new Scanner(System.in);
		
		System.out.print("생성할 파일이름을 입력하세요. (확장자 생략): ");
		String file = sc.next().trim();
		file = file+".txt";
		System.out.println(file);
		
		File f = new File(path+file);
		
		if ( f.exists()) {
			System.out.println("이미 생성된 파일입니다.");
		}
		
		try {
			System.out.println("파일을 생성합니다."+f.getCanonicalPath());
			f.createNewFile();
			System.out.println(f.exists());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		
		

	}

}
