package com.spring.springbootJsp.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.springbootJsp.member.mapper.E02MemberJavaSQLMapperInterface;
import com.spring.springbootJsp.member.vo.MemberVO;

//@Repository  // 적용시 에러
@Component // 컴포넌트에 등록 후 사용
public final class E03MemberDAOJavaSQL {
	
//	@Autowired
//	E02MemberJavaSQLMapperInterface member;
//	
//	@Autowired
//	private SqlSession session;
	
	// @Autowired 미사용 시
	private final E02MemberJavaSQLMapperInterface member;
    private final SqlSession session;
    
    // 생성자를 통해 의존성 주입
    public E03MemberDAOJavaSQL(E02MemberJavaSQLMapperInterface member, SqlSession session) {
        this.member = member;
        this.session = session;
        
    }

	// 1. 어노테이션 적용
	// 1-1 회원 목록
	public List<MemberVO> getMemberList() {
//		member = session.getMapper(E02MemberJavaSQLMapperInterface.class);
		
		return member.getMemberList();
	}
	
	// 1-2 회원 조회
	public MemberVO getMemberView(String id) {
//		member = session.getMapper(E02MemberJavaSQLMapperInterface.class);
		return member.getfindIdMemberList(id);
	}
	
	// -------------------------------------------------------- //
	// SQL Class 밉핑 : SQL어노테이션에 사용되는 SQL물 모듈화
	// -------------------------------------------------------- //
	public List<MemberVO> getFinalMemberList() {
//		member = session.getMapper(E02MemberJavaSQLMapperInterface.class);
		
		return member.getFinalMemberList();
	}
	public List<MemberVO> getMemberList2() {
//		member = session.getMapper(E02MemberJavaSQLMapperInterface.class);
		return member.getMemberList2();
	}

	public List<MemberVO> getMemberList3() {
//		member = session.getMapper(E02MemberJavaSQLMapperInterface.class);
		
		return member.getMemberList3();
	}
	// -------------------------------------------------------- //


	// 회원 등록
	public int insertMember(MemberVO vo) {
//		member = session.getMapper(E02MemberJavaSQLMapperInterface.class);
		
		return member.insertMember(vo);
	}
	
	// 회원 수정
	public int updateMember(MemberVO vo) {
//			member = session.getMapper(E02MemberJavaSQLMapperInterface.class);
		
		return member.updateMember(vo);
	}
		
	// 회원 삭제
	public int deleteMember(String id) {
		
		return member.deleteMember(id);
	}
	// 회원 조회
	public MemberVO viewMember(String id) {
		
		return member.viewMember(id);
	}
	// 중복아이디 체크
	public String idCheck(String id) {
		
		return member.idCheck(id);
	}
}
