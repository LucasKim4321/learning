package ex01.sam06;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;

//@WebFilter("/*")  // 모든 페이지 필터
//@WebFilter("/loginFilter/*")  // 하위 페이지 모두 필터
@WebFilter("/loginFilter")  // 주소 입력시 필터가 먼저 받아서 처리한 후 넘겨줌
public class E01EncoderFilter extends HttpFilter implements Filter {
      
	ServletContext ctx; 
	
    public E01EncoderFilter() {
    	super();
    }

	public void destroy() {
		// 필터 소멸 시 종료 작업 처리
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	
		System.out.println("=> doFilter()");
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		String ctx = ((HttpServletRequest)request).getContextPath();
		String pathInfo = ((HttpServletRequest)request).getRequestURI();
		String realPath = request.getRealPath(pathInfo);
		
		String msg = "context 정보: "+ctx+
					 "\nURI 정보: "+pathInfo+
					 "\n물리적 경로: "+realPath;
		
		System.out.println(msg);
		
		// 다음 필터로 넘기는 작업 실행
		chain.doFilter(request, response);
		
		System.out.println("-----------------");
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// 필터 생성시 초기화 작업
		System.out.println("=> filter init()");
		ctx = fConfig.getServletContext();
	}

}
