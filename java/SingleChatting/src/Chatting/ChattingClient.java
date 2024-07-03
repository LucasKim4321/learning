package Chatting;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ChattingClient {

	public static void main(String[] args) {
		// 채팅 클라리언트 프로그램

		Socket socket = null;
		InputStream is = null;
		OutputStream os = null;
		
		BufferedReader br = null;
		BufferedWriter bw = null;
		PrintWriter writer = null;
		
		String inMessage = null;  // 클라이언트로부터 문자 받기
		String outMessage = null;  // 클라이언트로 문자 보내기
		
		
		try {
			socket = new Socket("localHost",8888); 
//			socket = new Socket("127.0.0.1",8888);  // localHost(본인컴퓨터) 접속   // "http://www.naver.com:80" 이런거 의미
//			cmd ipconfig IPv4 주소 . . . . . . . . . : 192.168.0.146 
//			socket = new Socket("192.168.0.146 ",8888);  외부에서 접속가능한 내 서버 주소
			
			if(socket != null) {
				System.out.println("서버 접속 성공");
			}

			is = socket.getInputStream();
			os = socket.getOutputStream();

			Scanner sc = new Scanner(System.in);
			
			br = new BufferedReader(new InputStreamReader(is));
			bw = new BufferedWriter(new OutputStreamWriter(os));
			
			writer = new PrintWriter(bw,true);
			
			while(true) {
				
				// 서버로 부터 전송받은 문자 확인
				inMessage = br.readLine();
				System.out.println(inMessage);
				
				System.out.print("메시지 입력: ");
				outMessage = sc.nextLine();
				if (outMessage.equals("exit")) {
					break;
				}
				writer.println("다정한 클라이언트: "+outMessage);
			}

			sc.close();
			writer.close();
			socket.close();
			
		} catch (Exception e) {System.out.println(e.getMessage());}

	}

}
