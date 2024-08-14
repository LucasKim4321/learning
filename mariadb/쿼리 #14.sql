USE shopdb;

SHOW COLUMNS FROM item;
SELECT * FROM item;
DELETE FROM item;
DROP TABLE item;

SHOW COLUMNS FROM board;
SELECT * FROM board;
DELETE FROM board;
DROP TABLE board;

SHOW COLUMNS order_seqFROM reply;
SELECT * FROM reply;
DELETE FROM reply;
DROP TABLE reply;

SHOW COLUMNS FROM member;
SELECT * FROM member;
DELETE FROM member;
DROP TABLE member;

SHOW COLUMNS FROM member_role_set;
SELECT * FROM member_role_set;
DELETE FROM member_role_set;
DROP TABLE member_role_set;

SHOW COLUMNS FROM persistent_logins;
SELECT * FROM persistent_logins;
DELETE FROM persistent_logins;
DROP TABLE persistent_logins;

SHOW COLUMNS FROM cart;
SELECT * FROM cart;
DELETE FROM cart;
DROP TABLE cart;

CREATE TABLE persistent_logins (
	username 	VARCHAR(64) NOT NULL,
	series 		VARCHAR(64) PRIMARY KEY,
	token 		VARCHAR(64) NOT NULL,
	last_used	TIMESTAMP 	NOT NULL
);

ALTER TABLE persistent_login RENAME persistent_logins;

-- 검색한 결과 반환
SELECT * from board
WHERE writer LIKE '%user1%'
AND content LIKE '%content5%';

-- 검색한 결과를 카운트해서 반환
SELECT COUNT(*) from item
WHERE item_id LIKE '%상품4%'
or item_detail LIKE '%설명8%';
