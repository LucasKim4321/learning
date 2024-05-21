package chap04.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
// 인자없는 생성자 기본 내장, 인자 있는 생성자 생성시 기본 내장 생성자 사용불가능(따로 생성해줘야함)
@NoArgsConstructor
@AllArgsConstructor
//@Data  // Getter,Setter,ToString,Constructor 다 포함 이거만 써도됨
public class Data3 {
	String name;
	int age;
}
