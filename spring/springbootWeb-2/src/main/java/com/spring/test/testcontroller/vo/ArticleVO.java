package com.spring.test.testcontroller.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ArticleVO {
	private int articleNO;
	private String title;
	private String content;
	private String writer;
	private Date writeDate;
		
}
