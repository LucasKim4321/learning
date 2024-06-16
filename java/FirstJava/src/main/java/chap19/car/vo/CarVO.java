package chap19.car.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CarVO {
	private String carNumber;
	private String carName;
	private String carColor;
	private int displacement;
	private String manufacturer;
}
