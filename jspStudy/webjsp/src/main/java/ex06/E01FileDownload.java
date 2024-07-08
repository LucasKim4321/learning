package ex06;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/download.do")
public class E01FileDownload extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doHandler(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doHandler(req, resp);
	}

	protected void doHandler(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doHandler가 모두 처리 :b");
		System.out.println("파일 다운로드 요청 받음~ ");
		
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		
		String file_upload = "c:\\upload";  // 파일 경로
		String fileName = req.getParameter("fileName");  // 파일 이름
		System.out.println("파일이름: "+fileName);
		
		OutputStream out = resp.getOutputStream();
		String downFile = file_upload+File.separator+fileName;  // 만약 '/'을 파일 구분자로 가지고 있지 않는 OS에서 JVM이 돌리려고 보면 잘 동작하지 않을것이라고 생각한다. 따라서 이와 같이 작성하여야 한다.
		
		File f = new File(downFile);
		resp.setHeader("Cache-Control", "no-cache");// 파일이름 유지
		resp.addHeader("Content-disposition", "attachment;fileName="+fileName);
		
		FileInputStream in = new FileInputStream(f);
		byte[] buffer = new byte[1024*8];
		
		while(true) {
			int count = in.read(buffer);
			if(count == -1) break;
			out.write(buffer, 0, count);
		}
		in.close();
		
		
		
	}
	
}
