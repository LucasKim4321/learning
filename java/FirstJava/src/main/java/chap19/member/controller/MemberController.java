package chap19.member.controller;

import java.sql.SQLException;
import java.util.List;

import chap19.member.vo.MemberVO;

public interface MemberController {
	// 회원 조회
	public List<MemberVO> listMember(MemberVO memberVO);
	// 회원 가입
	public int regMember(MemberVO memberVO);
	// 회원 수정
	public int modMember(MemberVO memberVO);
	// 회원 삭제
	public int removeMember(MemberVO memberVO);
	// 회원 ID로 정보 조회
	public MemberVO checkId(String memId);

}