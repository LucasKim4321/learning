package com.spring.springbootJsp.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.springbootJsp.member.mapper.E02MemberJavaSQLMapperInterface;
import com.spring.springbootJsp.member.vo.MemberVO;

@Repository
public final class E03MemberDAOJavaSQL {
	
	@Autowired
	private SqlSession session;
	
	// 1. 회원 목록
	// 1-1 어노테이션
	public List<MemberVO> getMemberList() {
		E02MemberJavaSQLMapperInterface member = 
				session.getMapper(E02MemberJavaSQLMapperInterface.class);
		
		return member.getMemberList();
	}
}
