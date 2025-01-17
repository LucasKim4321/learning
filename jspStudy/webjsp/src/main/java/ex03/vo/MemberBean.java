package ex03.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberBean {
	
	private String id;
	private String pw;
	private String name;
	private String email;
	private String joinDate;
	
}