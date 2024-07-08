package ex05.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JsonVO {
	private String name;
	private int age;
	private String gender;
	private String nickname;
}
