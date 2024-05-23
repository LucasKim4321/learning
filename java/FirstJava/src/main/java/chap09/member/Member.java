package chap09.member;

public interface Member {
	public String viewMember(MemberVO vo);  // 회원 조회 메서드
	public void regMember(MemberVO vo);  // 회원 등록 메서드
	public void modMember(MemberVO vo);  // 회원 정보 수정 메서드
	public void delMember(MemberVO vo);  // 회원 정보 삭제 메서드
}
