-- SQL 모든 명령어
-- 대소문자 구별하지 않는다.
-- 세미콜론으로 끝내는 것을 원칙.

SHOW DATABASES;
-- db 생성하기
CREATE DATABASE mydb;
-- db열기
USE mydb;
-- 현재 db에 있는 테이블 보기
SHOW TABLES;
-- 테이블 구조 생성
CREATE TABLE students (
	id INT AUTO_INCREMENT,
	student_name VARCHAR(20),
	school_name VARCHAR(20),
	school_level VARCHAR(10),
	school_grade TINYINT(1),
	is_admin TINYINT(1),
	
	PRIMARY KEY(id)
);

-- 테이블 구조
SHOW COLUMNS FROM students;
-- 테이블에 있는 데이터 조회
SELECT * FROM students;
-- primary key : 중복된 값이 허용안됨. null값을 가질 수 없다. => 객체 무결성


-- 데이터 입력

-- 1.insert into 테이블명 (필드명1,필드명2...) values(값1,값2...);
INSERT INTO students (student_name, school_name, school_level,school_grade,is_admin)
VALUES('홍길동','조선','고등학교',2,0);

-- 2. maria db
INSERT INTO students (student_name, school_name, school_level,school_grade,is_admin)
VALUES
	('성춘향','남원','중학교',3,0),
	('이몽룡','남원','고등학교',1,0),
	('방자','남원','중학교',2,0),
	('향단','남원','중학교',2,0),
	('변사또','남원','고등학교',3,0),
	('심청','도화','고등학교',2,0),
	('심학규','도화','고등학교',3,0),
	('용왕','도화','고등학교',3,0),
	('곽씨','도화','고등학교',1,0),
	('뺑덕','남원','고등학교',2,0),
	('흥부','남원','고등학교',3,0),
	('놀부','조선','초등학교',3,0);

-- select from
SELECT student_name, school_name FROM students;
-- 중복 제거
SELECT DISTINCT school_name FROM students;
-- 원하는 자료의 수
SELECT id, school_name FROM students LIMIT 5;
SELECT id, school_name FROM students LIMIT 3,7;
-- 정렬 : 오름차순(asc), 내림차순(desc)
SELECT * FROM students ORDER BY school_grade ASC;
SELECT * FROM students ORDER BY school_grade DESC;
SELECT * FROM students ORDER BY school_level, school_grade DESC;
-- 테이블 삭제
DROP TABLE students;
-- db 삭제
DROP database mydb;