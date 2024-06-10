-- 제약 조건 : CONSTRAINTS
-- SQL제약조건을 통해 테이블 안에 저장될 데이터의 규칙을 정하는 형식
-- 미리 정해진 형식 데이터만 입력을 허용
-- 데이터의 무결성과 신뢰성을 보장
-- NULL, NOT NULL, DEFAULT, UNSIGNED, UNIQUE, PRIMARY KEY, FOREIGN KEY(외래키), CHECK, AUTO_INCREMENT

CREATE TABLE temp(
	id 		INT					AUTO_INCREMENT,  -- AUTO_INCREMENT 자동으로 증가하는 값
	NAME 		VARCHAR(100) 		NOT NULL,  -- NOT NULL 값이 없으면 안됨
	age 		INT UNSIGNED 		NOT NULL,
	deposit 	DOUBLE UNSIGNED	NULL,
	address 	VARCHAR(255) 		DEFAULT '서울',  -- DEFAULT'값'  값이 없으면 '서울'이 기본값
	score 	INT 					CHECK (score >=0 AND score <=100),  -- CHECK(범위) 범위 지정
	PRIMARY KEY (id),  -- KEY 값 중복 불가
	UNIQUE(NAME),  -- 중복 불가
	CHECK (age>=18)
	
);

INSERT INTO temp (NAME, age, deposit, score)
VALUES ('홍길동3',25,300,100);


SELECT * FROM temp;