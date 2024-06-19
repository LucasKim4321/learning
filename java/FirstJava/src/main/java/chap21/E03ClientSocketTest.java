package chap21;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class E03ClientSocketTest {

	public static void main(String[] args) {

//		Socket클래스: 원격지에 접속 요청 후, 원결지와 데이터 통신기능을 제공하는 클래스


		Socket socket = null;
		
		InputStream is = null;
		OutputStream os = null;
		
		BufferedReader br = null;
		BufferedWriter bw = null;
		
		PrintWriter writer = null;		
		String message = null;
		String sendMsg = "";
		
		try {
//			socket = new Socket("127.0.0.1",8888);  // localHost(본인컴퓨터) 접속   // "http://www.naver.com:80" 이런거 의미
//			socket = new Socket("192.168.0.12",8888);
//			socket = new Socket("192.168.0.146",8888);
			socket = new Socket("192.168.219.178",8888);
			
			if(socket != null)
				System.out.println("접속 성공");
			else
				System.out.println("접속 실패");
			while(true) {
				is = socket.getInputStream();  // 가져오기
				os = socket.getOutputStream();  // 보내기
				
				br = new BufferedReader(new InputStreamReader(is));  // byte -> 문자 -> 버퍼기능
				message = br.readLine();
				System.out.println(message);
				
				bw = new BufferedWriter(new OutputStreamWriter(os));
				writer = new PrintWriter(bw, true);
				
				Scanner sc = new Scanner(System.in);
				
				System.out.println("문자보내기: ");
				sendMsg = sc.nextLine();
				
	//			writer.println("클라이언트: 안녕하세요");
				writer.println("클라이언트111: "+sendMsg);
			}
		} catch (Exception e) {System.out.println(e.getMessage());}
	}

}
