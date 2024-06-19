package chap21;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class E07ChatServerTest {

	
	public static void main(String[] args) {

		// 채팅 서버 프로그램 (서버)
		
		ServerSocket serverSocket = null;
		Socket socket = null;
		
		E07ChatServerThread thread;
		
		OutputStream os = null;
		
//		BufferedReader br = null;
		BufferedWriter bw  = null;
		
		PrintWriter writer = null;
		
		InetAddress clientIP = null;
		String inMessage = null;	// 클라이언트로 부터 문자 받기	
		String outMessage = null;	// 클라이언트로 문자 보내기
		
		Scanner sc = new Scanner(System.in);
		
		// 서버 소켓 생성시 자기 혼자 계속 돌아가고 있음.
		// 접속시 소켓 생성
		try {
			serverSocket = new ServerSocket(8888);  // 서버 포트 설정
			System.out.println("다중 채팅 서버 실행 중...");
			
			while(true) {
				socket = serverSocket.accept();  // 서버 소캣 생성
				
				if (socket != null ) {
					System.out.println("클라이언트가 접속 성공!!");
				} else {
					System.out.println("클라이언트가 접속 실패!!!!");
				}
				
				// 클라이언트로부터 넘어온 메시지(닉네임) 읽기
				InputStream is = socket.getInputStream();
				BufferedReader br = new BufferedReader(new InputStreamReader(is));
				String nickName = br.readLine();
				
				thread = new E07ChatServerThread(socket, nickName);
				thread.start();
			}
			
			
		} catch (Exception e) {System.out.println(e.getMessage());}
		
	}

}
