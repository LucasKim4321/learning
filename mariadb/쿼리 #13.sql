
-- 회원테이블(t_member) : 아이디(PK), 비밀번호, 이름 주소, 전화번호
-- 렌터카 테이블(t_car) : 차번호(PK), 차이름, 차색상, 배기량, 제조사
-- 예약테이블(t_res) : 예약번호(PK), 예약날짜, 이용시작일자, 반납일자, 예약차번호(FK), 예약자아이디(FK)

CREATE DATABASE rentcar;
USE rentcar;

CREATE table t_member (
	memId				VARCHAR(20),  -- 아이디(PK)
	memPwd			VARCHAR(30),  -- 비밀번호
	memName			VARCHAR(30),  -- 이름
	memAddress		VARCHAR(100),  -- 주소
	memPhoneNumber VARCHAR(20)	,  -- 전화번호
	PRIMARY KEY(memId)
);

CREATE table t_car (
	carNumber		VARCHAR(30),  -- 차번호(PK)
	carName			VARCHAR(30),  -- 차이름
	carColor			VARCHAR(30),  -- 차색상
	displacement	INT,			  -- 배기량
	manufacturer 	VARCHAR(50),  -- 제조사
	PRIMARY KEY(carNumber)
);

CREATE table t_res (
	resNumber		VARCHAR(30) PRIMARY KEY,  -- 예약번호(PK)
	resDate			DATE,  -- 예약날짜
	startDate		DATE,  -- 이용시작일자
	returnDate		DATE,  -- 반납일자
	resCarNumber   VARCHAR(30),  -- 예약차번호(FK)
	resUserId		VARCHAR(20),  -- 예약자아이디(FK)
	CONSTRAINT FK_RES_CAR_NUMBER 
					FOREIGN KEY (resCarNumber)
					REFERENCES t_car(carNumber),
	CONSTRAINT FK_RES_USER_ID
					FOREIGN KEY (resUserId)
					REFERENCES t_member(memId)
);

DROP TABLE t_res;
DROP TABLE t_member;
DROP TABLE t_car;

INSERT INTO t_member (
	memId,
	memPwd,
	memName,
	memAddress,
	memPhoneNumber
)
VALUES 
	('hong100','1234','홍길동','서울','010-1234-1234'),
	('hong300','3456','홍길동','인천','010-1234-7777'),
	('hong200','2345','동길동','부산','010-2345-2345');
	
DELETE FROM t_member;
	
SELECT * FROM t_member;
SELECT * FROM t_member WHERE memName = '홍길동' ORDER BY memId;