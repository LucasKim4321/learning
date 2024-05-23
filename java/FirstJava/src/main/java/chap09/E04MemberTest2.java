package chap09;

import chap09.member.Member2;
import chap09.member.MemberImpl2;
import chap09.member.MemberVO2;

public class E04MemberTest2 {

	public static void main(String[] args) {
		// 구현하는 메서드 (등록, 조회, 수정, 삭제)
		Member2 member = new MemberImpl2();  // 인터페이스 = 인터페이스 구현한 클래스, 업캐스팅
		
		MemberVO2 memberVO2 = MemberVO2.builder().id("hong").password("1234").name("홍길동").phoneNum("010-0000-0000").build();
		member.regMember(memberVO2); // 등록   // memberVO2의 데이터를 받아서 회원등록을 하는 메소드 실행
		System.out.println("-----");
		memberVO2 = MemberVO2.builder().id("Dong").password("2345").name("동길이").phoneNum("010-1111-1111").build();
		member.regMember(memberVO2); // 등록
		System.out.println("-----");
		memberVO2 = MemberVO2.builder().id("King").password("3456").name("킹").phoneNum("010-2222-2222").build();
		member.regMember(memberVO2); // 등록
		
		
		// 전체 조회 (List에 있는 자료를 순차적 읽기)
		System.out.println("-----");
//		System.out.println(member.viewMember(memberVO2));
//		System.out.println("-----");
//		member.listMember().forEach((m)-> {
//			System.out.println("--------");
//			System.out.println(m.getId());
//			System.out.println(m.getPassword());
//			System.out.println(m.getName());
//			System.out.println(m.getPhoneNum());
//		});
		
		
		
//		// 회원 정보 수정
//		memberVO.setName("길순이");
//		memberVO.setPhoneNum("010-1111-1111");
//		
//		System.out.println("------");
//		member.modMember(memberVO);
//		System.out.println(member.viewMember(memberVO));
//
//		System.out.println("------");
//		member.delMember(memberVO);
//		System.out.println(member.viewMember(memberVO));
	}

}
