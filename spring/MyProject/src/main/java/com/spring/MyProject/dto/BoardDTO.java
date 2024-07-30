package com.spring.MyProject.dto;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BoardDTO {

    private Long bno;

    @NotEmpty
    @Size(min=3, max=100)
    private String title;

    @NotEmpty
    private String content;

    @NotEmpty
    private String writer;

    private LocalDateTime regDate;
    private LocalDateTime modDate;
    
    // 첨부파일 이름

}

/*

@Valid 제약조건 어노테이션 정리
- JSR 표준 스펙은 다양한 제약 조건 어노테이션을 제공하고 있습니다.

Anotation	   	            제약조건
@NotNull	   	            Null 검증
@Null	  	   	            Null 만 입력 가능
@NotEmpty	   	            Null 이 아니고, 빈 스트링("") 이 아닌지 검증(" " 은 허용)
@NotBlank	   	            Null 이 아니고, 공백(""과 " " 모두 포함)이 아닌지 검증
@Size(min=,max=)	   	    해당 값이 주어진 값 사이에 해당하는지 검증(String, Collection, Map, Array 에도 가능)
@Pattern(regex=)	   	    주어진 패턴과 일치하는지 검증
@Max(숫자)	   	            지정 값 이하인지 검증
@Min(숫자)	   	            지정 값 이상인지 검증
@Future	   		            현재 보다 미래인지 검증
@Past	   		            현재 보다 과거인지 검증
@Positive	   	            양수만 가능
@PositiveOrZero	   	        양수와 0만 가능
@Negative	   	            음수만 가능
@NegativeOrZero	   	        음수와 0만 가능
@Email	   		            이메일 형식인지 검증
@Digits(integer=, fraction= )대상 수가 지정된 정수와 소수 자리 수 보다 작은지 검증
@DecimalMax(value=) 	    지정된 값(실수) 이하 인지 검증
@DecimalMin(value=)	        지정된 값(실수) 이상 인지 검증
@AssertFalse	   	        false 여부 검증
@AssertTrue	   	            true 여부 검증

*/
