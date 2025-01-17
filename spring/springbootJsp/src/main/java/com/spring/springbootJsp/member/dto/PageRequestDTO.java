package com.spring.springbootJsp.member.dto;
import java.net.URLEncoder;
import java.time.LocalDate;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;

import com.spring.springbootJsp.member.controller.E01MemberController;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

// 페이징 처리
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Log4j2
public class PageRequestDTO {

	static Logger logger = LoggerFactory.getLogger(E01MemberController.class);
	
	// 시작 페이지 번호
	private int page = 1;
	
	// 페이지에 표시할 최대 레코드 수
	private int size = 10;
	
	private String link;
	
	// 검색 필터링 조건 처리
	private String[] types;  // 이름으로 검색, 이메일 검색,...
	private String keyword;
	private boolean finished;
	
	// 시작 날짜
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate from;
	// 끝나는 날짜
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate to;
	
	// 해당 페이지에 대한 시작 레코드번호 계산
	public int getSkip() {
		// 1 page : 1~10
		// 2 page : 11~20
		
		// 해당페이지의 시작 레코드번호를 계산
		// 1page : (1-1)*10=>0+1=>1
		// 2page : (2-1)*10=>10+1=>11
		// 3page : (3-1)*10=>20+1=>21
		
		return (page-1) * size + 1;
	}
	
	// 해당 페이지에 대한 마지막 레코드번호 계산
	public int getEnd() {
	    return page * size;
	}
	
	public String getLink() {
		
		// 검색 항목 처리
		if (link == null) {
			StringBuilder builder = new StringBuilder();
			// /member/delete?id=hong
			builder.append("page="+this.page);  // 요청페이지 번호
			builder.append("&size="+this.size);  // 1페이지에 보여줄 레코드 수
			
			if (types !=null && types.length>0) {
				for (int i=0; i<types.length; i++) {
					log.info("types["+i+"]="+types[i]);
					
					builder.append("&types="+types[i]);
				}
			}
			
			// 검색 키워드 처리
			if (keyword != null) {
				try {
					builder.append("&keyword="+URLEncoder.encode(keyword, "UTF-8").toString());
				} catch (Exception e) {log.info(e.getMessage()); };
					
			}
			// page=1&size=10&types=name&keyword=인코딩된 단어
			
			// 날짜 처리
			if(from!=null) builder.append("&from="+from.toString());
			if(to!=null) builder.append("&to="+to.toString());
			// page=1&size=10&types=name&keyword=인코딩된 단어&from=...&to=...
			
			link = builder.toString();
			
		}
		
		log.info("asdfasdf link: "+link);
		return link;  // page=1&size=10&types=name&keyword=인코딩된 단어&from=...&to=...
	}
	
	// 조건 검색
	public boolean checkType(String type_check) {
		logger.info("=> Logger type: "+type_check);
		log.info("=> Log4j2 type: "+type_check);
		
		if(types==null || types.length==0) {
			return false;
		}
		
		// 최소 한 개의 요소가 주어진 조건에 만족하면 true
		// types[0] == "n", types[1] == "i", ...
		
		return Arrays.stream(types).anyMatch(type_check::equals);
//		내부 동작
//		boolean flag = false;
//		String param = "n";  // or "i"
//		for (int i=0; i<types.length; i++) {
//			if (types[i].equals("n")) {
//				flag true;
//			}
//		}
//		return flag;
	}
	
}
