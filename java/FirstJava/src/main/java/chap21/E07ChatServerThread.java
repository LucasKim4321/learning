package chap21;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class E07ChatServerThread extends Thread {


//	private ServerSocket serverSocket = null;
	// 각각의 클라리언트에 메시지를 전달하는 스레드가 저장되는 List
	private static List<E07ChatServerThread> threads = new ArrayList<E07ChatServerThread>();
	private Socket socket = null;
	
	InputStream is = null;
	OutputStream os = null;
	
	BufferedReader br = null;
	BufferedWriter bw = null;
	PrintWriter writer = null;
	
	String message = null;
	String nickName = null;
	
	// 생성자
	// 생성자가 실행 될 때마다 threads(List)에 자기 자신의 객체 추가
	public E07ChatServerThread(Socket socket, String nickName) {
		this.nickName = nickName;
		this.socket = socket;
		
		threads.add(this);
	}
	
	@Override
	public void run() {
		try {
			is = socket.getInputStream();
			os = socket.getOutputStream();
			
			bw = new BufferedWriter(new OutputStreamWriter(os));
			writer = new PrintWriter(bw, true);
			writer.println("서버에 접속되었습니다.");
			
			while(true) {
				br = new BufferedReader(new InputStreamReader(is));
				message = br.readLine();
				
				// 소켓으로 부터 더이상 읽어올 메시지가 없으면 예외처리하여 while빠져나옴
				if (message == null) {
					throw new IOException();
				}
				
				// 현재 클라이언트 접속자의 메시지를 인자로 전달
				sendMessageAll(message);
			}
		} catch (Exception e) {System.out.println(e.getMessage());}
	}
	
	public void sendMessageAll(String message) {
		
		E07ChatServerThread thread = null;
		
		for( int i=0; i<threads.size(); i++) {
			thread = threads.get(i);  // threads List에서 하나씩 뽑아서 thread에 대입
			
			if(thread.isAlive()) {  // isAlive() 해당 스레드의 run()메서드가 종료됐는지 확인
				try {
					thread.sendMessage(message);
				} catch (Exception e) {e.printStackTrace();}
			}
		}
		
		// 서버 콘솔로 출력
		System.out.println(message);
	}
	
	public void sendMessage(String message) throws Exception {
		writer = new PrintWriter(
					new BufferedWriter(
						new OutputStreamWriter(socket.getOutputStream())), true);
		writer.print(message);
	}


}
