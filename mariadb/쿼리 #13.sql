
-- 회원테이블(t_member) : 아이디(PK), 비밀번호, 이름 주소, 전화번호
-- 렌터카 테이블(t_car) : 차번호(PK), 차이름, 차색상, 배기량, 제조사
-- 예약테이블(t_res) : 예약번호(PK), 예약날짜, 이용시작일자, 반납일자, 예약차번호(FK), 예약자아이디(FK)

CREATE DATABASE rentcar;
USE rentcar;

CREATE table t_member (
	memId				VARCHAR(20),  -- 아이디(PK)
	memPassword		VARCHAR(30),  -- 비밀번호
	memName			VARCHAR(30),  -- 이름
	memAddress		VARCHAR(100),  -- 주소
	memPhoneNum    VARCHAR(20),  -- 전화번호
	PRIMARY KEY(memId)
);

	CREATE table t_car (
		carNumber		VARCHAR(30),  -- 차번호(PK)
		carName			VARCHAR(30),  -- 차이름
		carColor			VARCHAR(30),  -- 차색상
		displacement	INT,			  -- 배기량displacement
		manufacturer 	VARCHAR(50),  -- 제조사manufacturer
		segment			VARCHAR(30),  -- 크기
		
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
	memId,  -- (char)
	memPassword,  -- (char)
	memName,  -- (char)
	memAddress,  -- (char)
	memPhoneNum  -- (char)
)
VALUES 
	('hong100','1234','홍길동','서울','010-1234-1234'),
	('hong300','3456','홍길동','인천','010-1234-7777'),
	('hong400','3456','홍길동','인천','010-1234-7777'),
	('hong500','3456','홍길동','인천','010-1234-7777'),
	('hong600','3456','홍길동','인천','010-1234-7777'),
	('hong200','2345','동길동','부산','010-2345-2345');
	
		
INSERT INTO t_car (
		carNumber,-- 차번호(char)(PK)
		carName,  -- 차이름(char)
		carColor,  -- 차색상(char)
		displacement,  -- 배기량displacement  (int)
		manufacturer,  -- 제조사manufacturer(char)
		segment)  -- 크기(char)
VALUES
	('20다4567','HyundaiI30','white','1353','Hyundai','준중형차'),
	('20다4566','KiaRay','red','800','Hyundai','경차'),
	('20다4565','MiniCountryman','black','1100','Mini','소형차'),
	('20다4568','AudiA3','gray','1353','Audi','준중형차'),
	('20다4569','BMW3Series','gray','1700','BMW','중형차'),
	('20다4564','ToyotaAvalon','blue','2100','Toyota','준대형차'),
	('20다4563','BenzSClass','silver','2200','Benz','대형차'),
	('20다4562','LamborghiniMurcielago','yello','6192','Lamborghini','스포츠카'),
	('20다4570','KIACarnival','gray','2902','KIA','미니밴'),
	('20다4571','Wrangler','green','1995','Jeep','SUV');
	

INSERT t_res (
		resNumber,  -- 예약번호(char)(PK)
		resDate,  -- 예약날짜  (DATE)
		startDate,  -- 이용시작일자  (DATE)
		returnDate,  -- 반납일자  (DATE)
		resCarNumber,  -- 예약차번호(char)(FK)
		resUserId)  -- 예약자아이디(char)(FK)
VALUES
	('1234','2024-1-4','2024-1-4','2024-1-8','20다4569','hong500'),
	('1235','2024-2-1','2024-2-1','2024-3-1','20다4563','hong200'),
	('1236','2024-3-28','2024-3-28','2024-4-2','20다4571','hong400'),
	('1237','2024-4-16','2024-4-16','2024-4-17','20다4562','hong100');
	
UPDATE t_res
SET 
resDate ADDDATE(resDate,INTERVAL 1 DAY),
startDate ADDDATE(startDate,INTERVAL 1 DAY),
returnDate ADDDATE(returnDate,INTERVAL 1 DAY)
WHERE resNumber = '1234';

SHOW COLUMNS FROM t_member;
SELECT * FROM t_member;
SELECT * FROM t_car;
	
DELETE FROM t_car;
DROP TABLE t_car;

SELECT * FROM t_car WHERE carNumber = '20다4562';
SELECT * FROM t_car WHERE carNumber = '2222';
SELECT * FROM t_member WHERE memId = '122';
UPDATE t_car 
SET carName = '5555',
	 displacement = 1111,
	 carColor = '5555',
	 manufacturer = '5555',
	 segment = '5555'
WHERE carNumber = '2222';

UPDATE t_member SET memPassword = '5555', memName = '5555', memAddress = '5555', memPhoneNum = '5555' WHERE memId = 'hong600';


-- SELECT * FROM t_res WHERE not(('2024-4-2' <= startDate and startDate < '2024-4-9')OR('2024-4-2' < returnDate and returnDate <= '2024-4-9')); 반납일에도 시작 가능  반납일에 시작할 경우 시간으로 세분화
SELECT * FROM t_res WHERE not(('2024-1-5' <= startDate and startDate <= '2024-1-6')OR('2024-1-5' <= returnDate and returnDate <= '2024-1-6'));  -- 반납일에 시작 불가능

SELECT * FROM t_res;
SELECT * FROM t_member WHERE memId = 'hong600';
SELECT * FROM t_member;
SELECT * FROM t_car;
SELECT * FROM t_member WHERE memName = '홍길동' ORDER BY memId;

