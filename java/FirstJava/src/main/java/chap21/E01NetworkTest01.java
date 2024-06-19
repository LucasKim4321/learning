package chap21;

import java.io.IOException;
import java.net.InetAddress;
import java.net.URL;
import java.util.Arrays;

public class E01NetworkTest01 {

	public static void main(String[] args) throws IOException {
		// 네트워크: 원격지에 있는 장치간에 서로 연결
		// 클라이언트(Client), 서버(Server)
		// 1Byte -> 8bit -> 0~255  4Byte: 약 42.94억
		// IPV4 4byte 주소  IPV6 128bit(16Byte)
		// IP주소 : 숫자로 구성된 주소   DNS 도메인네임(호스트명)시스템: 문자로 구성된 주소 체계
		// 주소를 치면 DNS서버에 실제 주소가 뭔지 물어본 후 실제 주소로 접속
		// cmd ipconfig: 내 ip주소 확인  ping ip주소: 응답확인  ping DNS주소: 응답확인  nslookup DNS주소: 사이트의 ip주소 표시
		// 프로토콜: 통신규약 - 정보 전달하는 규약
		// 					상호 간의 접속방식, 데이터 형식, 오류 검출 방식등을 규정
		// 					HTTP, HTTPS, FTP(FileTransferProtocol), TCP/IP(오류체크o), UDP(오류체크x) ...
		// 포트번호: 0~65535 (0~1023까지 사용)
		// 네트워크  OSI 7계층으로 표현 (OSI 7 Layer)
		// 인터넷 : TCP/IP베이스
		
		// InetAddresss: IP주소와 관련된 기능을 제공하는 클래스
		// SocketAddress: InetAddress클래스의 기능을 그대로 제공하면서 포트번호관리 기능을 제공
		InetAddress addr1 = InetAddress.getByName("www.oracle.com");
		InetAddress addr2 = InetAddress.getByAddress(new byte[] {(byte)104,(byte)74,(byte)162,(byte)89});
		
		System.out.println(addr1);
		System.out.println(addr2);
		
		// 하나의 호스트가 여러개의 IP를 가지고 있는 경우
		InetAddress[] addr3 = InetAddress.getAllByName("www.naver.com");
		System.out.println(Arrays.toString(addr3));
		Arrays.stream(addr3).forEach(System.out::println);
		
		// URL(Uniform Resource Location)
		// 프로토콜://호스트명:포트번호/경로명/파일명?쿼리스트링
		URL url = new URL("https://www.egovframe.go.kr/home/sub.do?menuNo=9");
		
		System.out.println("------------------");
		System.out.println("https://www.egovframe.go.kr/home/sub.do?menuNo=9");
		System.out.println("------------------");
		System.out.println("getAuthority: "+url.getAuthority());
		System.out.println("getContent: "+url.getContent());
		System.out.println("getProtocol: "+url.getProtocol());
		System.out.println("getHost: "+url.getHost());
		System.out.println("getPort: "+url.getPort());
		System.out.println("getPath: "+url.getPath());
		System.out.println("getFile: "+url.getFile());
		System.out.println("getQuery: "+url.getQuery());
		
		
	}

}
