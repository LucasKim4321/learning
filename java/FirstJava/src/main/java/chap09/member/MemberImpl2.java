package chap09.member;

import java.util.ArrayList;
import java.util.Arrays;

public class MemberImpl2 implements Member2{
	// 동적 배열 처리
	// 리스트에 집어넣어서 배열을 만듬.
	ArrayList<MemberVO2> members = new ArrayList<MemberVO2>();

	@Override
	public MemberVO2 viewMember(MemberVO2 vo) {
		System.out.println("회원 정보 조회");
		
//		System.out.println(members.indexOf(vo));  // 있으면 위치, 없으면 -1
		
		int idx = members.indexOf(vo);
//		System.out.println(members.get(idx));
		
		return members.get(idx);
	}

	@Override
	public void regMember(MemberVO2 vo) {
		
		members.add(vo);
		System.out.println("회원 가입되었습니다.");
		System.out.println("회원 목록: "+members);
		
	}

	@Override
	public void modMember(MemberVO2 vo) {
		System.out.println("수정되었습니다.");
	
	}

	@Override
	public void delMember(MemberVO2 vo) {
		System.out.println("id: "+vo.getId()+"가 탈퇴 처리되었습니다.");
		
	}

	@Override
	public ArrayList<MemberVO2> listMember() {
		return members;
	}

	
	

}
