package com.spring.springbootJsp.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.springbootJsp.member.dto.PageRequestDTO;
import com.spring.springbootJsp.member.mapper.MemberXmlSQLMapperInterface;
import com.spring.springbootJsp.member.vo.MemberVO;

@Repository
public class E02MemberDAOMybatis {
	
	@Autowired
	private SqlSession session;
	
	@Autowired
	private MemberXmlSQLMapperInterface memberXmlSql;
	
	// mybatis xml과 java mapper interface 열결 테스트
	public String getTime() {
		return memberXmlSql.getTime(); // mapper를 통해 member_sql.xml에서 작성된 getTime 실행
	}
	public String getTime2() {
		return session.selectOne("getTime");  // 위에거랑 같은 역할
	}
	
	// 회원 목록 조회
	public List<MemberVO> getMemberList() {
		return memberXmlSql.getMemberList();
		
		// Mybatis의 SqlSession 객체를 이용하여 함수 실행
//		return session.selectList("getMemberList");
	}
	
	
	// 회원 정보 조회
	public MemberVO getMemberView(String id) {
//		return memberXmlSql.getMemberView(id);
		return session.selectOne("getMemberView", id);
	}
	
	// 회원 등록
	public void insertMember(MemberVO vo) {
		memberXmlSql.insertMember(vo);
//		session.selectOne("insertMember", vo);
		
	}
	
	// 회원 삭제
		public void deleteMember(String id) {
			memberXmlSql.deleteMember(id);
//			session.selectOne("deleteMember", id);
//			session.commit();
			return;
		}
		

	// 회원 수정
	public void updateMember(MemberVO vo) {
		memberXmlSql.updateMember(vo);
//		session.selectOne("updateMember", vo);
//		session.commit();
	}
	
	// 중복 아이디 체크
	public String idCheck(String id) {
		
		return memberXmlSql.idCheck(id);
	}
	
	
	// ------------------------------------- //
	// 동적 SQL 활용
	// ------------------------------------- //
	// 조건 검색
	public List<MemberVO> getMemberListIf(String id, String name, String email) {
		
		return memberXmlSql.getMemberListIf(id, name, email);
	}
	
	public List<MemberVO> getForEachSelect(List<String> list) {

		return memberXmlSql.getForEachSelect(list);
	}
	

	public List<MemberVO> setForEachInsert(List<MemberVO> list) {

		return memberXmlSql.setForEachInsert(list);
	}
	

	// 웹 페이지 연동

	// 회원 목록 조회
	public List<MemberVO> getMemberList2(PageRequestDTO pageRequestDTO) {
		return memberXmlSql.getMemberList2(pageRequestDTO);
		
		// Mybatis의 SqlSession 객체를 이용하여 함수 실행
//		return session.selectList("getMemberList");
	}
	
	public int getCount(PageRequestDTO pageRequestDTO) {
		return memberXmlSql.getCount(pageRequestDTO);
	}
	

//	// 회원 정보 조회
//	public MemberVO getMemberView2(String id, String search, String page) {
//		return memberXmlSql.getMemberView(id, search, page);
////		return session.selectOne("getMemberView", id, search, page);
//	}
//	
}
