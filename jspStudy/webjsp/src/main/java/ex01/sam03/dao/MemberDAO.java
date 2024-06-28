package ex01.sam03.dao;

import java.util.List;

import ex01.sam03.vo.MemberVO;

public interface MemberDAO{
	// DAO Data Access Object
	public void connDB();  // DB연결하기
	public List<MemberVO> listMembers();  // 회원 목록 조회
	public int regMember (MemberVO memberVO);  // 회원 등록
	public int modMember (MemberVO memberVO);  // 회원 수정
	public MemberVO viewMember (String id);  // 회원 조회
	public int removeMember (MemberVO memberVO);  // 회원 삭제
}
