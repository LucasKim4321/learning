package chap19.member.dao;

import java.util.List;

import chap19.member.vo.MemberVO;

public interface MemberDAO {
	public List<MemberVO> selectMember(MemberVO memberVO) throws Exception;
	public void insertMember(MemberVO memberVO);
	public void updateMember(MemberVO memberVO);
	public void deleteMember(MemberVO memberVO);
}
