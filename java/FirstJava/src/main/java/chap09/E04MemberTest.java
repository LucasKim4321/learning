package chap09;

import chap09.member.Member;
import chap09.member.MemberImpl;
import chap09.member.MemberVO;

public class E04MemberTest {

	public static void main(String[] args) {
		// 회원 정보 초기화
//		MemberVO memberVO = new MemberVO("홍길동","1234","홍길동","010-0000-0000");
		MemberVO memberVO = MemberVO.builder().id("hong").password("1234").name("홍길동").phoneNum("010-0000-0000").build();
		
		
		// 구현하는 메서드
		Member member = new MemberImpl();  // 인터페이스 = 인터페이스 구현한 클래스, 업캐스팅
		member.regMember(memberVO);  // memberVO의 데이터를 받아서 회원등록을 하는 메소드 실행
		
		String memberInfo = member.viewMember(memberVO);
		System.out.println(memberInfo);
		
		// 회원 정보 수정
		memberVO.setName("길순이");
		memberVO.setPhoneNum("010-1111-1111");
		
		System.out.println("------");
		member.modMember(memberVO);
		System.out.println(member.viewMember(memberVO));

		System.out.println("------");
		member.delMember(memberVO);
		System.out.println(member.viewMember(memberVO));
	}

}
