package chap16;

import java.util.List;

import chap16.dao.MemberDAO;
import chap16.vo.MemberVO;

public class E02MemberMain {

	public static void main(String[] args) {
		
		MemberDAO dao = new MemberDAO(); // db 입력 수정 삭제 조회 목록 처리하는 객체(서비스)
		MemberVO vo = new MemberVO();
		
		vo.setMemberno(2);
		vo.setId("hong200");
		vo.setName("홍길순200");
		
		System.out.println(vo);
		
		// 데이터 추가
		int rs = dao.insert(vo);
		if (rs > 0 ) {
			System.out.println("회원 정보 정상적으로 등록 되었습니다.");
		}
		
		System.out.println("result code: "+rs);
		
		// 회원 목록
//		List<MemberVO> list = dao.list();
//		list.stream().forEach(System.out::println);
		dao.list().stream().forEach(System.out::println);
		
		

	}

}