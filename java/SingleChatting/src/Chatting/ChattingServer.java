package Chatting;

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

public class ChattingServer {

	public static void main(String[] args) {
		// 채팅 서버 프로그램
		
		ServerSocket serverSocket = null;
		Socket socket = null;
		
		InputStream is = null;
		OutputStream os = null;
		
		BufferedReader br = null;
		BufferedWriter bw = null;
		
		PrintWriter writer = null;
		String inMessage = null;
		String outMessage = null;
		
		Scanner sc = new Scanner(System.in);
		
		try {
			serverSocket = new ServerSocket(8888);
			System.out.println("서버 실행 중...");
			
			socket = serverSocket.accept();
			is = socket.getInputStream();
			os = socket.getOutputStream();
			
			br = new BufferedReader(new InputStreamReader(is));
			bw = new BufferedWriter(new OutputStreamWriter(os));
			writer = new PrintWriter(bw, true);
			writer.println("서버: 접속을 환영합니다. 메시지를 먼저 보내세요.");
			
			
			// 소켓에 정보를 보내기, 받기
			while(true) {
				// 수신 문자 콘솔에 출력
				inMessage = br.readLine();
				System.out.println(inMessage);
				
				System.out.print("메시지 입력: ");
				outMessage = sc.nextLine();
				if(outMessage.equals("exit")) {
					break;
				}
				writer.println("서버: "+outMessage);
			}
			
			sc.close();
			writer.close();
			socket.close();
			
		} catch (Exception e) {
			
		}
		
	}

}
