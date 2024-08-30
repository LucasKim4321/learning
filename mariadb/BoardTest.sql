-- BoardTest

-- 데이터베이스 생성
CREATE DATABASE board_test;
-- 데이터베이스 삭제
DROP DATABASE board_test;
-- 데이터베이스 선택
USE board_test;
-- 선택된 데이터베이스의 테이블 목록 표시
SHOW TABLES;

SHOW COLUMNS FROM board;
SELECT * FROM board;
DELETE FROM board;
DROP TABLE board;