package chap19.member.dao;

import java.util.ArrayList;
import java.util.List;

import chap19.common.base.AbstractBaseDAO;
import chap19.member.vo.MemberVO;

public class MemberDAOImpl extends AbstractBaseDAO implements MemberDAO{

	@Override
	public List<MemberVO> selectMember(MemberVO memberVO) throws Exception {
		List<MemberVO> memList = new ArrayList<MemberVO>();
		
		String _memName = memberVO.getMemName();  // 넘겨받은 데이터(입력한 이름으로 생성한 객체)의 Name값을 입력받아 _memName 변수 생성 
		String sql = "";
		System.out.println("_memName: "+_memName);
		
		if (_memName == "all") {
			System.out.println(_memName);
			sql = "select * from member";
			pstmt = conn.prepareStatement(sql);
		}
		else if (_memName != null && _memName.length() != 0) {  // 넘겨 받은 객체에 값이 있으면
			System.out.println(_memName+"검색");
			sql = "SELECT * FROM t_member WHERE memName = ? ORDER BY memId";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, _memName);  //  입력한 이름으로 테이블상의 데이터 검색
			
		}
		
		rs = pstmt.executeQuery();
		
		while (rs.next()) {
			String memID 		= rs.getString("memId");
			String memPassword  = rs.getString("memPwd");
			String memName 		= rs.getString("memName");
			String memAddress 	= rs.getString("memAddress");
			String memPhoneNum 	= rs.getString("memPhoneNumber");
			
			MemberVO vo = new MemberVO();
			vo.setMemId(memID);
			vo.setMemPassword(memPassword);
			vo.setMemName(memName);
			vo.setMemAddress(memAddress);
			vo.setMemPhoneNum(memPhoneNum);
			
			// 생성자를 이용하여 객체 멤버 변수에 db로부터 받은 값을 전달
//			MemberVO vo = new MemberVO(memID, memPassword, memName, memAddress, memPhoneNum);
//			
//			MemberVO vo = MemberVO.builder()
//						.memId(memID)
//						.memPassword(memPassword)
//						.memName(memName)
//						.memAddress(memAddress)
//						.memPhoneNum(memPhoneNum)
//						.build();
			
			memList.add(vo);
			
		}
		rs.close();
		
		return memList;
	}

	@Override
	public void insertMember(MemberVO memberVO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateMember(MemberVO memberVO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteMember(MemberVO memberVO) {
		// TODO Auto-generated method stub
		
	}

}
