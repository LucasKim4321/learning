package com.spring.springbootJsp.member.dto;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.spring.springbootJsp.member.controller.E01MemberController;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;

@Getter
@ToString
@Log4j2
public class PageResponseDTO<E> {

	static Logger logger = LoggerFactory.getLogger(E01MemberController.class);
	
	private int page;
	private int size;
	private int total;
	
	// 시작 페이지
	private int start;  // 페이지버튼의 시작 페이지 번호
	private int end;	// 페이지버튼의 마지막 페이지 번호
	
	private boolean prev;  // 이전 페이지의 존재 여부
	private boolean next;  // 다음 페이지의 존재 여부
	
	private List<E> memberList;  // <E>제네릭타입
	
	// 생성자: 페이징 초기화 설정
	@Builder(builderMethodName = "withAll")
	public PageResponseDTO(PageRequestDTO pageRequestDTO, List<E> memberList, int total) {
		this.page = pageRequestDTO.getPage();
		this.size = pageRequestDTO.getSize();
		
		this.total = total;
		this.memberList = memberList;
		
		// 해당 블럭의 페이지 범위 계산 : 1 block : 10페이지
		// Math.ceil(숫자) : 자리올림/10.0))*10;
		
		this.end = (int) (Math.ceil(this.page/10.0))*10;  // 끝번호	1블럭: 10, 2블럭: 20...
		this.start = this.end -9;						  // 시작번호	1블럭: 1, 2블럭: 11...
		
		// 1024/10 => 102.4 => 103 page로 계산
		int last = (int) Math.ceil(total/(double)size);
		
		// 마지막 페이지 번호가 블럭의 끝페이지 번호보다 작으면 마지막 페이지 번호를 블럭의 끝번호로 설정
		this.end = end > last ? last : end;
		
		// 페이지 블럭이 1을 초과시 true, 그렇지 않으면 false
		this.prev = this.start > 1; 
		
		// 블럭의 끝 페이지 번호의 총 개수가 전체 레코드 총 개수보다 크면 false, 그렇지 않으면 true
		this.next = total > this.end * this.size;
		
		log.info("현재 페이지: "+this.page);
		
		log.info("시작 페이지: "+this.start);
		log.info("끝 페이지: "+this.end);
		
		log.info("이전 페이지: "+this.prev);
		log.info("다음 페이지: "+this.next);
	}
	
}
