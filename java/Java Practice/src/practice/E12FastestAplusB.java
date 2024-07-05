package practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class E12FastestAplusB {

	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			int t = Integer.parseInt(br.readLine());  // 첫 줄에서 테스트 케이스 수를 읽음
			int a;
			int b;
			for (int i = 1; i <= t; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());  // 각 테스트 케이스마다 새로운 줄 읽기
				a = Integer.parseInt(st.nextToken());
				st = new StringTokenizer(br.readLine()); 
				b = Integer.parseInt(st.nextToken());
//				bw.write("a+b = "+(a + b) + "\n");
				bw.write((a + b) + "\n");
				
			}
			  // 모든 쓰기 작업이 끝난 후 flush 호출
			bw.flush();
			bw.close();
			br.close();
			
		} catch (Exception e) {
		}
		
		
	}
}