package chap09.member;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class MemberVO {
	private String id;
	private String password;
	private String name;
	private String phoneNum;
}
