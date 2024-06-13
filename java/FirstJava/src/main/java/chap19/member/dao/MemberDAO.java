package chap19.member.dao;

import java.sql.SQLException;
import java.util.List;

import chap19.member.vo.MemberVO;

public interface MemberDAO {
	// 회원 정보 조회 기능 처리하는 인터페이스
	public List<MemberVO> selectMember(MemberVO memberVO) throws Exception;
	// 회원 정보 등록 기능 처리하는 인터페이스
	public int insertMember(MemberVO memberVO) throws Exception;
	// 회원 정보 수정 기능 처리하는 인터페이스
	public int updateMember(MemberVO memberVO) throws Exception;
	// 회원 정보 삭제 기능 처리하는 인터페이스
	public int deleteMember(MemberVO memberVO) throws Exception;
	
	// 회원 정보 id 조회
	public MemberVO checkId(String memId) throws Exception;
}