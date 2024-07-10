package com.spring.springbootJsp.member.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.spring.springbootJsp.member.vo.MemberVO;


// MemberJDBCTemplate 스프링 객체 관리
@Repository
public class MemberJDBCTemplate {
	
	@Autowired  // 필요한 객채 알아서 생성
	private JdbcTemplate jdbc;
	
	// JdbcTemplate 테스트
	
	// 1. 회원 목록
	public List<MemberVO> jdbcMemberList() {

		List<MemberVO> list = new ArrayList<MemberVO>();
		String sql = "select * from t_member";
		
		// List<MemberVO> list = 쿼리문 실행 결과
		// jdbc객체.query(쿼리문, new BeanPropertyRowMapper<객체>(클래스타입.class));
		list = jdbc.query(sql, new BeanPropertyRowMapper<MemberVO>(MemberVO.class));
		
		return list;
	}
	
	
	// 2. 회원조회
	public MemberVO jdbcMemberView(String id) {
		String sql = "select * from t_member where id=?";
		
		MemberVO member = jdbc.queryForObject(sql, new BeanPropertyRowMapper<MemberVO>(MemberVO.class),id);
		
		return member;
	}
	
	
	// 3. 회원삭제
	public int jdbcMemberUpdate(String id) {
		int isOK = 0;
		
		String sql = "delete from t_member where id = ?";
		
		isOK = jdbc.update(sql, id);
		
		return isOK;
	}
	
	
	// 4. 회원수정
	public int jdbcMemberDelete(MemberVO vo) {
		int isOK = 0;

//		String sql = "update t_member set pwd=?,name=?,email=? where id=?";
		String sql = "update t_member set"
					+" pwd=?, name=?, email=? where id=?";
		
		isOK = jdbc.update(sql, vo.getPwd(), vo.getName(), vo.getEmail(), vo.getId());
		
		return isOK;
	}
	
	
	// 5. 회원 등록
	public int jdbcMemberInsert(MemberVO vo) {
		int isOK = 0;
		
		String sql = "insert into t_member (id, pwd, name, email) values (?, ?, ?, ?)";
		
		// 업데이트 수행 후 결과 값 리턴 성공 시 1이상
		isOK = jdbc.update(sql, vo.getId(), vo.getPwd(), vo.getName(), vo.getEmail());
		
		return isOK;
		
	}
	
	
	
}
