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

public class E06ThreadChatServerTest {

	public static void main(String[] args) {
		// 채팅 서버 프로그램 (서버)
		// ******
		ServerSocket serverSocket = null;
		Socket socket = null;
		
		InputStream is = null;
		OutputStream os = null;
		
		BufferedReader br = null;
		BufferedWriter bw = null;
		
		PrintWriter writer = null;
		
		InetAddress clientIP = null;
		String inMessage = null;  // 클라이언트로부터 문자 받기
		String outMessage = null;  // 클라이언트로 문자 보내기
		
		Scanner sc = new Scanner(System.in);
		
		try {
			serverSocket = new ServerSocket(8888);  // 서버 포트 설정
			System.out.println("서버 실행 중...");
			
			socket = serverSocket.accept();  // 서버 소캣 생성
//			is = socket.getInputStream();  // 소켓의 자료를 읽어옴
			
			// 수신 문자 콘솔에 출력
			E06ChatRecvThread rThread = new E06ChatRecvThread(socket);
			rThread.start();
			
			os = socket.getOutputStream();  // 소켓에 출력
			
			// 송수신에 사용 할 입출력 버퍼
//			br = new BufferedReader(new InputStreamReader(is));  // 읽어온 데이터를 문자로 읽음
			bw = new BufferedWriter(new OutputStreamWriter(os));  // 입력한 데이터를 소켓으로 출력
			
			writer = new PrintWriter(bw, true);  // writer가 bw에 입력
			writer.println("서버: 접속을 환영합니다. 메시지를 먼저 보내세요.");  //  os를 통해 소켓에 출력
//			소켓을 통해 클라이언트와 서버간의 소통  클라이언트 소켓이랑 소통   서버도 소켓이랑 소통
			
			clientIP = socket.getInetAddress();// 클라이언트 IP주소 추출
			System.out.println("접속 IP: "+clientIP);
			
			// 소켓에 정보를 보내기, 받기
			while(true) {
				// 수신 문자 콘솔에 출력
//				inMessage = br.readLine();  // 소켓을 읽어옴
//				System.out.println(inMessage);  // 읽어온 데이터 서버에 출력
				
				System.out.print("메시지 입력: ");
				outMessage = sc.nextLine();
				if(outMessage.equals("exit")) {  // exit입력시 서버 프로그램 종료
					break;  // 입력한 메시지가 exit이면 while문 break  break 후 다음 문장 => 서버 종료;
				}
				
				System.out.println("서버: "+outMessage);
				writer.println("서버: "+outMessage);
			}
			
			sc.close();
			writer.close();
			socket.close();
			
		} catch (Exception e) {	}
		
	}

}
