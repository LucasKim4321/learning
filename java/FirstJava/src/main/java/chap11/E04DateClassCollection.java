package chap11;

import java.text.CompactNumberFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

public class E04DateClassCollection {

	public static void main(String[] args) {
		// 날짜와 시간, 숫자 처리
		Calendar cal = Calendar.getInstance();
		Date date = cal.getTime();  // util.date
		System.out.println(date);
		
		System.out.println(cal.get(Calendar.YEAR));
		System.out.println(cal.get(Calendar.MONTH));
		System.out.println(cal.get(Calendar.DAY_OF_MONTH));
		System.out.println(cal.get(Calendar.HOUR_OF_DAY));
		System.out.println(cal.get(Calendar.MINUTE));
		System.out.println(cal.get(Calendar.SECOND));
		
		// 숫자 표시 : #, 0
		int myMoney = -5000;
		System.out.println(myMoney);
		
		DecimalFormat df = new DecimalFormat("#,###.##");  // -5,000
		System.out.println(df.format(myMoney));
		DecimalFormat df2 = new DecimalFormat("0,000.00");  // -5,000.00
		System.out.println(df2.format(myMoney));
		DecimalFormat df3 = new DecimalFormat("0.0#E0");  // -5.0E3
		System.out.println(df3.format(myMoney));
		DecimalFormat df4 = new DecimalFormat("(수익)#,##0; (손실)#,##0");
		System.out.println(df4.format(50000));  // (수익)50,000
		System.out.println(df4.format(-50000));  // (손실)50,000
		System.out.println(df4.format(0));  // (수익)0

		DecimalFormat df5 = new DecimalFormat("##0%");
		System.out.println(df5.format(0.01));  // 1%
		
		// 숫자를 줄여서 표시
		int users = 14638;
		int views = 1500;
		NumberFormat nf = CompactNumberFormat.getCompactNumberInstance();  // 싱글 톤
		System.out.printf("구독자 %s\n", nf.format(users));  // 1만
		System.out.printf("조회수 %s\n", nf.format(views));  // 2천
		
		// 날짜, 시간 형식
		Date today = new Date();
		System.out.println("today: " + today);  // today: Mon May 27 15:13:07 KST 2024  현재위치 기준
		SimpleDateFormat f1 = new SimpleDateFormat("YYYY년 MM월 DD일 E HH시 MM분 SS초");
		System.out.println(f1.format(date));  // 2024년24 05월 148일 월 15시 05분 785초  현재위치 기준
		
		// LocalDate : 날짜정보 다루는 클래스
		LocalDate ldate1 = LocalDate.now();
		System.out.println("localdate: "+ldate1);  // localdate: 2024-05-27  현재위치 기준
		
		LocalDate ldate2 = LocalDate.parse("2023-05-26");  // 문자열 -> 날짜형
		System.out.println(ldate2);  // 2023-05-26
		System.out.println(ldate2.plusDays(365));  // 2024-05-25
		
		System.out.printf("%d년은 %s입니다.\n",ldate1.getYear(),(ldate1.isLeapYear()));  // 2024년은 true입니다.  날짜.isLeapYear() 윤년 판별
		System.out.printf("%d년은 %s입니다.\n",ldate2.getYear(),(ldate2.isLeapYear()));  // 2023년은 false입니다.
		
		System.out.println(ldate2.minusYears(1)+", "+ldate2.plusYears(1));  // 2022-05-26, 2024-05-26
		System.out.println(ldate2.minusMonths(1)+", "+ldate2.plusMonths(1));  // 2023-04-26, 2023-06-26
		System.out.println(ldate2.minusWeeks(1)+", "+ldate2.plusWeeks(1));  // 2023-05-19, 2023-06-02
		System.out.println(ldate2.minusDays(100)+", "+ldate2.plusDays(100));  // 2023-02-15, 2023-09-03
		
		LocalTime time1 = LocalTime.now();
		System.out.println("localtime(): "+time1);  // localtime(): 15:37:18.903760900  시:분:초
		System.out.println(time1.getHour());  // 15
		
		LocalTime time2 = LocalTime.of(11,20,11);
		System.out.println(time2+", "+time2.plusHours(1));  // 11:20:11, 12:20:11  시:분:초
		
		LocalTime time3 = LocalTime.now(ZoneId.of("Asia/Colombo"));  //  Asia/Colombo 지역의 시간
		System.out.println(time3);  // 12:11:24.323823200
		
//		ZoneId.getAvailableZoneIds().stream().forEach(System.out::println);  // 모든 지역 출력
		
		LocalDateTime time4 = LocalDateTime.now();
		System.out.println(time4);  // 2024-05-27T15:44:15.463891500
		
		
	}
}
