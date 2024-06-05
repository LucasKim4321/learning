-- 데이터 : SELECT FROM, INSERT INTO VALUES, UPDATE SET, DELETE FROM

SELECT * FROM students;

-- 데이터 수정
UPDATE students SET student_gender ='남자' WHERE  sid = 1;

-- 동시에 여러개 일괄 변경
UPDATE students SET student_gender ='여자' WHERE sid = 2 OR sid=4 OR sid=5 OR sid=7;

UPDATE students SET student_gender ='남자' WHERE sid IN (3,6,8,9,10,12,13);

UPDATE students SET student_gender ='여자' WHERE sid IN (10,11);

-- 삭제
-- DELETE FROM student;  -- 모두 삭제
DELETE FROM students WHERE sid = 1;
DELETE FROM students WHERE sid IN (2,3,4);
DELETE FROM students;

-- 테이블 구조
SHOW COLUMNS FROM students;

-- 테이블 구조 변경
ALTER TABLE students ADD student_age INT;
ALTER TABLE students ADD is_enrolled TINYINT;
ALTER TABLE students ADD enrolled_date DATE;

-- 데이터 추가
INSERT INTO students
(student_name,school_name,school_level, school_grade,student_gender,student_age,is_enrolled,enrolled_date)
VALUES
	('성춘향','남원','중학교',3,'여자',21,1,20180201),
	('이몽룡','남원','고등학교',1,'남자',52,1,20170202),
	('방자','남원','중학교',2,'여자',35,1,20190201),
	('향단','남원','중학교',2,'여자',28,1,20150221),
	('변사또','남원','고등학교',3,'남자',47,1,20110201),
	('심청','도화','고등학교',2,'여자',16,1,20080201),
	('심학규','도화','고등학교',3,'남자',45,1,20220201),
	('용왕','도화','고등학교',3,'남자',999,0,15000201),
	('곽씨','도화','고등학교',1,'여자',44,1,20000201),
	('뺑덕','남원','고등학교',2,'여자',43,1,20190201),
	('흥부','남원','고등학교',3,'남자',49,1,20180201),
	('놀부','조선','초등학교',3,'남자',51,1,20160201),
	('홍길동','활빈','중학교',3,'남자',33,1,20160201),
	('홍길순','활빈','고등학교',1,'여자',28,1,20120201),
	('동길이','활빈','중학교',2,'남자',30,1,20130201),
	('강감찬','남원','중학교',2,'남자',40,1,20200201),
	('이순신','남원','고등학교',3,'남자',45,1,20210201),
	('세종대왕','도화','고등학교',2,'남자',52,1,20230201),
	('이이','도화','고등학교',3,'남자',45,1,20130201),
	('둘리','도화','고등학교',3,'남자',2000,0,10000201);
	
-- LIKE, NOT LIKE  도% 도로 시작  %화 화로 끝남  %등% 등 포함
SELECT * FROM students WHERE school_name LIKE '도%';  -- 도로 시작
SELECT * FROM students WHERE school_name LIKE '%빈';  -- 빈으로 끝남
SELECT * FROM students WHERE school_level LIKE '%등%';  -- 등 포함
SELECT * FROM students WHERE school_name NOT LIKE '도%';  -- 도로 시작하지 않음

SELECT * FROM students WHERE school_level  LIKE '고_학교'; -- 한개의 문자는 와일드 카드

/*
-- 비교 연산자 : =, !=, >, >=, <=
BETWEEN(주어진 범위) => BETWEEN A AND B : A와 B사이
NOT BETWEEN(주어진 범위 밖에 있는) => A AND B : A와 사이 제외한 모든
IN(주어진 열에 여러조건을 제시할 때) => IN (값...);
NOT IN
LIKE, NOT LIKE, AND, OR 
*/

SELECT * FROM students WHERE school_name != '도화'AND school_name <>'남원';  -- 학교 이름이 도화,남원이 아닌
SELECT * FROM students WHERE student_age <= 30;  -- 나이가 30이하
SELECT * FROM students WHERE student_age IN (27,28,29);  -- 나이가 27,28,29
SELECT * FROM students WHERE school_name IN ('활빈','도화');  -- 

SELECT * FROM students WHERE student_age BETWEEN 30 AND 39;
SELECT * FROM students
	WHERE (school_name = '조선' or school_name = '도화')
	AND (student_age NOT BETWEEN 20 AND 29);

SELECT * FROM students;
SHOW COLUMNS FROM students;