package chap09.member;

import java.util.ArrayList;
import java.util.Arrays;

public class MemberImpl2 implements Member2{
	String memberData;
	
	// 동적 배열 처리
	// 리스트에 집어넣어서 배열을 만듬.
	ArrayList<MemberVO2> members = new ArrayList<MemberVO2>();

	@Override
	public MemberVO2 viewMember(MemberVO2 vo) {
		System.out.println("회원 정보 조회");
		
		System.out.println(members.indexOf(vo));  // 있으면 위치, 없으면 -1
		
		int idx = members.indexOf(vo);
//		System.out.println(members.get(idx));
		
		// 전체 조회 (List에 있는 자료를 순차적 읽기)
		members.forEach((member)-> {
			System.out.println("--------");
			System.out.println(member.getId());
			System.out.println(member.getPassword());
			System.out.println(member.getName());
			System.out.println(member.getPhoneNum());
		});
//		if(members=="")
//			System.out.println("정보가 없습니다.");
		return members.get(idx);
	}

	@Override
	public void regMember(MemberVO2 vo) {
		// 회원등록하는 기능 구현
		memberData = vo.getId()+","+
				vo.getName()+","+
				vo.getPassword()+","+
				vo.getPhoneNum();
		
		System.out.println(memberData);
		System.out.println("회원 가입되었습니다.");
		
		members.add(vo);
		System.out.println("회원 목록: "+members);
		
	}

	@Override
	public void modMember(MemberVO2 vo) {
		// 회원정보를 수정하는 기능 구현
		memberData = vo.getId()+","+
				vo.getName()+","+
				vo.getPassword()+","+
				vo.getPhoneNum();

		System.out.println("수정되었습니다.");
		
	}

	@Override
	public void delMember(MemberVO2 vo) {
		memberData="";
		System.out.println("id: "+vo.getId()+"가 탈퇴 처리되었습니다.");
		
	}

	@Override
	public ArrayList<MemberVO2> listMember() {
		return members;
	}

	
	

}
