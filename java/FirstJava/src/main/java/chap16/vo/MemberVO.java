package chap16.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberVO {
	
	// 회원번호, 아이디, 이름
	private int memberno ;
	private String id;
	private String name;
}