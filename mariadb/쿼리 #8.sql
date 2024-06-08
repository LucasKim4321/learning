USE mydb;

-- Member
CREATE TABLE MEMBER (
	memberno INT,
	id VARCHAR(50),
	name VARCHAR(50)
);
SHOW COLUMNS FROM MEMBER;

INSERT INTO MEMBER(memberno, id, name) VALUES (1, 'hong', '홍길동');

-- db autocommmit 상태
SELECT @@autocommit;  -- 상태 확인
SET @@autocommit = 0;  -- autocommit off
SET @@autocommit = 1;  -- on
SELECT * FROM MEMBER;

DELETE from member;
DROP TABLE member;