package ex01.sam03.service;

import java.util.List;

import ex01.sam03.vo.MemberVO;

public interface MemberDAOService {

	public List<MemberVO> listMembers();  // 회원 목록 조회
	public int registerMember(MemberVO memberVO);  // 회원 등록

}
