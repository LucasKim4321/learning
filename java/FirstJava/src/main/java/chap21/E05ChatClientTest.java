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

public class E05ChatClientTest {

	public static void main(String[] args) {
		
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
//			socket = new Socket("192.168.0.12",8888);  // 강사님  한명만 됨
//			socket = new Socket("192.168.0.21",8888);  // 진우
			if(socket != null) {
				System.out.println("서버 접속 성공");
			}

			is = socket.getInputStream();  // 소켓의 자료를 읽어옴
			os = socket.getOutputStream();  // 소켓에 출력

			Scanner sc = new Scanner(System.in);
			
			br = new BufferedReader(new InputStreamReader(is));
			bw = new BufferedWriter(new OutputStreamWriter(os));
			
			writer = new PrintWriter(bw,true);  // true의미 버퍼는 데이터가 가득차야 보내지만 가득차지 않아도 내보낼 수있게 설정
			
			while(true) {
				// 서버로 부터 전송받은 문자 확인
				inMessage = br.readLine();  // 소켓에 있는 데이터를 읽어옴
				System.out.println(inMessage);  // 읽은 데이터를 본인컴퓨터에 출력
				
				System.out.print("메시지 입력: ");
				outMessage = sc.nextLine();  // 입력한 데이터를 서버에 보냄
				if (outMessage.equals("exit")) {  // exit입력시 종료
					break;
				}
				writer.println("클라이언트111: "+outMessage);
			}

			sc.close();
			writer.close();
			socket.close();
			
		} catch (Exception e) {System.out.println(e.getMessage());}

	}

}
