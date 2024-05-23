package chap09.member;

import java.util.ArrayList;

public interface Member2 {
	public MemberVO2 viewMember(MemberVO2 vo);  // 회원 조회 메서드
	public void regMember(MemberVO2 vo);  // 회원 등록 메서드
	public void modMember(MemberVO2 vo);  // 회원 정보 수정 메서드
	public void delMember(MemberVO2 vo);  // 회원 정보 삭제 메서드
	
	public ArrayList<MemberVO2> listMember();  // 회원 전체 조회
}
