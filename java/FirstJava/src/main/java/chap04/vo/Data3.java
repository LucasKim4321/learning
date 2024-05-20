package chap04.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
//@Data  // Getter,Setter,ToString,Constructor 포함
public class Data3 {
	String name;
	int age;
}
