create table member (
    mem_id           CHARACTER(8)  PRIMARY KEY,
    mem_name 	     VARCHAR2(10) NOT NULL,
    mem_number 	 INTEGER NOT NULL,
    addr               CHARACTER(2) NOT NULL,
    phone1           CHARACTER(3),
    phone2           CHARACTER(8),
    height             SMALLINT,
    debut_date       DATE
);

DESCRIBE member;


create table buy (
    num            INTEGER  PRIMARY KEY NOT NULL,
    mem_id        CHARACTER(8) NOT NULL,
    pro_name     CHARACTER(6) NOT NULL,
    group_name  CHARACTER(4),
    price     		  int NOT NULL,
    amount        SMALLINT NOT NULL
);
DESCRIBE buy;

drop table member;
drop table buy;

create table member (
    mem_id          CHARACTER(8)  PRIMARY key,
    mem_name     VARCHAR2(20),
    mem_number  INTEGER,
    addr              CHARACTER(10),
    phone1          CHARACTER(10),
    phone2          CHARACTER(10),
    height            SMALLINT,
    debut_date      DATE
);
DESCRIBE member;

insert into member
values ('APN', '에이핑크', '6', '경기', '031', '77777', '164', '2015-02-10');
insert into member
values ('BLK', '블랙핑크', '3', '서울', '02', '222222', '172', '2011-02-10');
insert into member
values ('GRL', '소녀시대', '1', '부산', '051', '333333', '154', '2009-02-10');

select * from member;

drop table member;

SELECT SUM(height) as sum_height FROM member;

SELECT SUM(height) FROM member;

select * from member where height<(SELECT SUM(height) FROM member)/3;


CREATE SEQUENCE buy_seq
START WITH 1
INCREMENT BY 1
NOCACHE
NOCYCLE;

create table buy (
    num           INTEGER  PRIMARY key,
    mem_id              CHARACTER(20),
    pro_name          CHARACTER(20),
    group_name          CHARACTER(20),
    price      int,
    amount            SMALLINT
);
CREATE OR REPLACE TRIGGER buy_before_insert
BEFORE INSERT ON buy
FOR EACH ROW
BEGIN
    :NEW.num := buy_seq.NEXTVAL;
END;
DESCRIBE buy;

insert into buy
values ('1', 'blk', '지갑', '잡화', '30', '2');
insert into buy
values ('2', 'blk', '맥북프로', '디지털', '1000', '1');
insert into buy
values ('3', 'apn', '아이폰', '디지털', '200', '1');

select * from buy;
drop table buy;