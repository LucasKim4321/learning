package chap19.member.controller;

import java.util.List;

import chap19.member.vo.MemberVO;

public interface MemberController {
	// 회원 조회
	public List<MemberVO> listMember(MemberVO memberVO);
	// 회원 가입
	public void regMember(MemberVO memberVO);
	// 회원 수정
	public void modMember(MemberVO memberVO);
	// 회원 삭제
	public void removeMember(MemberVO memberVO);
}
