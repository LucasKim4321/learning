package chap19.reservation.vo;


import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResVO {
	private String resNumber;  // 예약번호
	private Date resDate;  // 예약날짜
	private Date startDate;  // 이용시작일자
	private Date returnDate;  // 반납일자
	private String resCarNumber;  // 예약차번호
	private String resUserId;  // 예약자아이디
}
