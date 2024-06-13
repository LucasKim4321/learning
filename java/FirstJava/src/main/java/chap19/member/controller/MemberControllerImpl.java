package chap19.member.controller;

import java.util.ArrayList;
import java.util.List;

import chap19.member.dao.MemberDAO;
import chap19.member.dao.MemberDAOImpl;
import chap19.member.vo.MemberVO;

public class MemberControllerImpl implements MemberController {
	
	public MemberDAO memberDAO;  // 이유?

	public MemberControllerImpl() {
		memberDAO = new MemberDAOImpl();
	}
	
	@Override
	public List<MemberVO> listMember(MemberVO memberVO) {
		List<MemberVO> memList = new ArrayList<MemberVO>();
		
		// 회원 정보 조회하는 dao 호출
		try {
			memList =  memberDAO.selectMember(memberVO);
			
		} catch (Exception e) {System.out.println(e.getMessage());	}
		return memList;
	}

	@Override
	public int regMember(MemberVO memberVO) {
		//회원 정보 등록 하는 dao 호출
		int result = 0;
		try {
			result = memberDAO.insertMember(memberVO);
		} catch (Exception e) { System.out.println(e.getMessage());	}
		
		return result;
	}

	@Override
	public int modMember(MemberVO memberVO) {
		int result = 0;
		//회원 정보 수정 하는 dao 호출
		try {
			result = memberDAO.updateMember(memberVO);
		} catch (Exception e) { System.out.println(e.getMessage());	}
		
		return result;
	}

	@Override
	public int removeMember(MemberVO memberVO) {
		//회원 정보 삭제 하는 dao 호출
		int result = 0;
		
		try {
			result = memberDAO.deleteMember(memberVO);
		} catch (Exception e) { System.out.println(e.getMessage());	}
		
		return result;
	}

}