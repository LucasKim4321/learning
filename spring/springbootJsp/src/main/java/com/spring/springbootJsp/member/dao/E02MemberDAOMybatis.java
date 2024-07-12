package com.spring.springbootJsp.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.springbootJsp.member.mapper.MemberXmlSQLMapperInterface;
import com.spring.springbootJsp.member.vo.MemberVO;

@Repository
public class E02MemberDAOMybatis {
	
	@Autowired
	private SqlSession session;
	
	@Autowired
	private MemberXmlSQLMapperInterface memberXmlSqlDAO;
	
	// mybatis xml과 java mapper interface 열결 테스트
	public String getTime() {
		return memberXmlSqlDAO.getTime(); // mapper를 통해 member_sql.xml에서 작성된 getTime 실행
	}
	public String getTime2() {
		return session.selectOne("getTime");  // 위에거랑 같은 역할
	}
	
	// 회원 목록 조회
	public List<MemberVO> getMemberList() {
		return memberXmlSqlDAO.getMemberList();
		
		// Mybatis의 SqlSession 객체를 이용하여 함수 실행
//		return session.selectList("getMemberList");
	}
	
	// 회원 정보 조회
	public MemberVO getMemberView(String id) {
//		return memberXmlSqlDAO.getMemberView(id);
		return session.selectOne("getMemberView", id);
	}
	
	// 회원 등록
	public void insertMember(MemberVO vo) {
		memberXmlSqlDAO.insertMember(vo);
//		session.selectOne("insertMember", vo);
		
	}
	
}
