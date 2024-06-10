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
		System.out.println("result code: "+rs);
		if (rs > 0 ) {
			System.out.println("회원 정보 정상적으로 등록 되었습니다.");
		}
		else{
			System.out.println("등록 실패!!!");
		}

		
		// 회원 정보 조회
		vo = dao.selectOne(2);
		System.out.println("-- 회원정보 --");
		System.out.println("회원번호: "+vo.getMemberno());
		System.out.println("아이디: "+vo.getId());
		System.out.println("이름: "+vo.getName());
		
		// 회원 정보 수정
		vo.setMemberno(2);
		vo.setName("동길이200");
		int update_rs = dao.update(vo);
		System.out.println("회원 정보 수정\nupdate_rs: "+update_rs);
		if (update_rs > 0) {
			System.out.println("수정 완료");
		} else {
			System.out.println("수정 실패!!!");
		}
		
		// 회원 정보 삭제
		int delete_rs = dao.delete(2);
		System.out.println("회원 정보 삭제\ndelete_rs: "+delete_rs);
		if (delete_rs > 0 ) {
			System.out.println("회원 정보 삭제 완료!!");
		}
		else {
			System.out.println("삭제 실패!!!");
		}
	
		
		
		// 회원 목록
//		List<MemberVO> list = dao.list();
//		list.stream().forEach(System.out::println);
		dao.list().stream().forEach(System.out::println);
		
		// 자원 해제
		int close_rs = dao.close();
		if (close_rs > 0 ) {System.out.println("자원 해제");}

	}

}