package com.spring.springbootJsp.member.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.spring.springbootJsp.member.vo.MemberVO;

@Mapper
public interface MemberXmlSQLMapperInterface {
	// 기능 수행 함수 선언
	// 각 메서드 호출 시 member_sql.xml에서 실행함
	
	// 0. test 기능
	// 메서드 이름과 mapper xml의 select태그 id값이 동일해야 함
	public String getTime();
	
	// 1. 회원 목록 조회
	public List<MemberVO> getMemberList();
	
	// 2. 회원 등록
	public void insertMember(MemberVO vo);
	// 3. 회원 수정
	// 4. 회원 삭제
	// 5. 회원 조회
	public MemberVO getMemberView(@Param("id") String id);  // @Param("id")  #{id} 인식
	// 6. 회원 검색
	
}