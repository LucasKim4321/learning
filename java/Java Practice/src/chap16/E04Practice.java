package chap16;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class E04Practice {

	public static void main(String[] args) {
		Stream<String> stream = Stream.generate(()-> "애국가").limit(10);
		stream.forEach(s-> System.out.println(s));
		
		System.out.println("-------");
		Stream<Integer> stream2 = Stream.iterate(1, n -> n+1).limit(10);  // iterate(초기값  n -> n+1)
		stream2.forEach(s-> System.out.println(s));

		
		System.out.println("-------");
		int[] arr = {1,2,3,4,5};
		System.out.println("-------Arrays.stream()");
		IntStream intstream1 = Arrays.stream(arr);
		intstream1.forEach(s-> System.out.print(s+"\t"));
		
		System.out.println("\n-------IntStream.of()");
		IntStream intstream2 = IntStream.of(arr);
		intstream2.forEach(s-> System.out.print(s+"\t"));
		
		System.out.println("\n-------IntStream.range()");
		IntStream intstream3 = IntStream.range(1,6);
		intstream3.forEach(s-> System.out.print(s+"\t"));
		
		System.out.println("\n-------IntStream.rangeClosed()");
		IntStream intstream4 = IntStream.rangeClosed(1,6);
		intstream4.forEach(s-> System.out.print(s+"\t"));
		
		
		System.out.println("\n-------");
		System.out.println("int 형 난수 스트림 : ");
		IntStream isr = new Random().ints(3);
		isr.forEach(s-> System.out.println(s));
		
		System.out.println("-------");
		isr = new Random().ints (10,0,3);  // (갯수, 시작값, 끝값전까지)
		isr.forEach(s-> System.out.println(s));
	

		System.out.println("-------");
		isr = new Random().ints(10,0,3);
		isr.forEach(s-> System.out.println(s));
		
		System.out.println("-------");
		LongStream lsr = new Random().longs(3,0,10);  // (갯수, 시작값, 끝값전까지)
		lsr.forEach(s->System.out.println(s));
		
		System.out.println("-------");
		DoubleStream dsr = new Random().doubles(3);
		dsr.forEach(s->System.out.println(s));
		

		System.out.println("-------");
		String str = "자바 세상을 만들자";
		
		IntStream isr1 = str.chars();
		
		isr1.forEach(s-> System.out.println((char)s));
		
		try {
			Path path = Paths.get("src/chap16/StrToStream.java");
			Stream<String> stream3 = Files.lines(path, Charset.defaultCharset());
			stream3.close();
			System.out.println();
			
			File file = path.toFile();
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			br.lines().forEach(s-> System.out.println(s));
			stream3.close();
		}
		catch(Exception e) {	
			System.out.println(e.getMessage());
		}
	}

}
