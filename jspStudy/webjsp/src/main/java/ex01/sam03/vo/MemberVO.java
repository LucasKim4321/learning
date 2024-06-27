package ex01.sam03.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberVO {
	private String id;
	private String pwd;
	private String name;
	private String email;
	private Date joinDate;
}
