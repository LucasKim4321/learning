CREATE DATABASE test;
USE test;


create table member (
    mem_id         char(8)  PRIMARY KEY,
    mem_name 	    varchar(10) NOT NULL,
    mem_number 	 INTEGER NOT NULL,
    addr           char(2) NOT NULL,
    phone1         char(3),
    phone2         char(8),
    height         SMALLINT,
    debut_date     DATE
);
SHOW COLUMNS FROM member;


create TABLE buy (
    num           int  PRIMARY KEY AUTO_INCREMENT NOT NULL,
    mem_id        char(8) NOT NULL,
    pro_name      char(6) NOT NULL,
    group_name    char(4),
    price     		int NOT NULL,
    amount        SMALLINT NOT NULL
);
SHOW COLUMNS FROM buy;

DROP TABLE member;
DROP TABLE buy;



create table member (
    mem_id         char(8)  PRIMARY KEY,
    mem_name 	    VARCHAR(20) NOT NULL,
    mem_number 	 INTEGER NOT NULL,
    addr           CHAR(10) NOT NULL,
    phone1         char(10),
    phone2         char(10),
    height         SMALLINT,
    debut_date     DATE
);

DESCRIBE member;
SHOW COLUMNS FROM member;


create table buy (
    num           int  PRIMARY KEY AUTO_INCREMENT NOT NULL,
    mem_id        char(8) NOT NULL,
    pro_name      char(10) NOT NULL,
    group_name    char(10),
    price     		int NOT NULL,
    amount        SMALLINT NOT NULL
);
DESCRIBE buy;
SHOW COLUMNS FROM buy;


insert into member
values ('APN', '에이핑크', '6', '경기', '031', '77777', '164', '2015-02-10');
insert into member
VALUES ('BLK', '블랙핑크', '3', '서울', '02', '222222', '172', '2011-02-10'),
		 ('GRL', '소녀시대', '1', '부산', '051', '333333', '154', '2009-02-10');

select * from member;

drop table member;

SELECT SUM(height) as sum_height FROM member;

SELECT SUM(height) FROM member;

select * from member where height>(SELECT SUM(height) FROM member)/(SELECT COUNT(mem_name) FROM member);

SELECT * FROM member ORDER BY debut_date DESC; 

SELECT * FROM member ORDER BY debut_date ASC; 

SELECT * FROM buy;

SELECT mem_id, SUM(amount) FROM buy GROUP BY mem_id;

insert into buy  (
	mem_id,
	pro_name,
	group_name,
	price,
	amount
)
values ('blk', '지갑', '잡화', '30', '2'),
('blk', '맥북프로', '디지털', '1000', '1'),
('apn', '아이폰', '디지털', '200', '1');

select * from buy;
DELETE FROM buy;
drop table buy;