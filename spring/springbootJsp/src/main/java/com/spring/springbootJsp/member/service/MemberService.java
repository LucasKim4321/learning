package com.spring.springbootJsp.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.springbootJsp.member.dto.PageRequestDTO;
import com.spring.springbootJsp.member.dto.PageResponseDTO;
import com.spring.springbootJsp.member.mapper.MemberXmlSQLMapperInterface;
import com.spring.springbootJsp.member.vo.MemberVO;

@Service
public class MemberService {
	
	// DAO(database 처리하는 인터페이스 구현)
	@Autowired
	private MemberXmlSQLMapperInterface memberDAO;
	
	// 회원 목록 (페이지 기능 추가)
	public PageResponseDTO<MemberVO> getMemberList(PageRequestDTO pageRequestDTO) {
		List<MemberVO> list = memberDAO.getMemberList2(pageRequestDTO);  // 레코드 전체 추출
		
		// 페이지 처리 기능을 추가
		int total = memberDAO.getCount(pageRequestDTO);
		
		PageResponseDTO<MemberVO> pageResponseDTO = PageResponseDTO.<MemberVO>withAll()
				.memberList(list)
				.pageRequestDTO(pageRequestDTO)
				.total(total)
				.build();
		return pageResponseDTO;
	}
}
