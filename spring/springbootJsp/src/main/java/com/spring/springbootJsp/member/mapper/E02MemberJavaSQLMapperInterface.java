package com.spring.springbootJsp.member.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.spring.springbootJsp.member.vo.MemberVO;

@Mapper
public interface E02MemberJavaSQLMapperInterface {
	// 동적SQL => Groovy class일 경우 적용됨.
	// mapping: SQL문 실행할 함수와 SQL문 작성함수 1:1맵핑
	
	// 1-1. 회원목록 List : 어노테이션 적용할 경우
	@Select("select * from t_member")  // member_sql.xml에 썼던거 대신 이거 씀
	public List<MemberVO> getMemberList(@Param("id") String id);
}
