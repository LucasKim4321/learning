package chap09.member;

import java.util.Arrays;

public class MemberImpl implements Member{
	String memberData;
	MemberVO[] memberList = new MemberVO[10];

	@Override
	public String viewMember(MemberVO vo) {
		System.out.println("회원 정보 조회");
		if(memberData=="")
			System.out.println("정보가 없습니다.");
		return memberData;
	}

	@Override
	public void regMember(MemberVO vo) {
		// 회원등록하는 기능 구현
		memberData = vo.getId()+","+
				vo.getName()+","+
				vo.getPassword()+","+
				vo.getPhoneNum();
		
		memberList[memberList.length] = vo;
		System.out.println(Arrays.toString(memberList));
//		System.out.println(memberData);
		System.out.println("회원 가입되었습니다.");
		
	}

	@Override
	public void modMember(MemberVO vo) {
		// 회원정보를 수정하는 기능 구현
		memberData = vo.getId()+","+
				vo.getName()+","+
				vo.getPassword()+","+
				vo.getPhoneNum();

		System.out.println("수정되었습니다.");
		
	}

	@Override
	public void delMember(MemberVO vo) {
		memberData="";
		System.out.println("id: "+vo.getId()+"가 탈퇴 처리되었습니다.");
		
	}
	
	
	

}
