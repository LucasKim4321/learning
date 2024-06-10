package chap16;

import chap16.dao.MyMemberDAO;
import chap16.vo.MyMemberVo;

public class E02MyMemberMain {

	public static void main(String[] args) {
		MyMemberDAO dao = new MyMemberDAO();	
		MyMemberVo vo = new MyMemberVo();
		vo.setMemberno(3);
		vo.setId("Kim0131");
		vo.setName("김태진");
		
		int rs = dao.insert(vo);	
		if (rs>0) {
			System.out.println("회원 정보가 정상적으로 등록 되었습니다.");
		}
		else {
			System.out.println("실패하였습니다.");
		}
		System.out.println("result code: "+rs);
		
		dao.list().stream().forEach(System.out::println);
	}

}
