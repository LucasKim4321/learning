-- 테이블 복사
CREATE TABLE students2 LIKE students;
CREATE TABLE IF NOT EXISTS mydbstudents2 LIKE students;

-- 테이블 데이터 복사
INSERT INTO students2 (SELECT * FROM students);

-- 원하는 필드의 데이터만 복사
INSERT INTO students2(student_name, school_name)(SELECT student_name, school_name FROM students);

-- 테이블 구조와 데이터 복사
CREATE TABLE students3 (SELECT * FROM students);
CREATE TABLE students4 AS SELECT * FROM students;

INSERT INTO students2
(student_name,school_name,school_level, school_grade,student_gender,student_age,is_enrolled,enrolled_date)
VALUES
	('곽씨','도화','고등학교',1,'여자',44,1,20000201),
	('뺑덕','남원','고등학교',2,'여자',43,1,20190201),
	('흥부','남원','고등학교',3,'남자',49,1,20180201),
	('놀부','조선','초등학교',3,'남자',51,1,20160201),
	('백설공주','활빈','중학교',3,'여자',33,1,20160201),
	('성냥팔이소녀','활빈','고등학교',1,'여자',28,1,20120201),
	('신데렐라','활빈','중학교',2,'여자',30,1,20130201),
	('엘사','활빈','고등학교',1,'여자',28,1,20120201);

-- 두 테이블의 데이터 병합(중복x)
SELECT 
	student_name, school_name, school_level
FROM students
UNION
	SELECT 
		student_name, school_name, school_level
		-- student_name, null, null
	FROM students2;
SELECT * FROM students2;
SELECT * FROM students;

-- 두 테이블의 데이터를 병합(중복o)
SELECT 
	student_name, school_name, school_level
FROM students
UNION ALL
	SELECT 
		student_name, school_name, school_level
		-- student_name, null, null
	FROM students2;
SELECT * FROM students2;
SELECT * FROM students;

-- GROUP BY 연산자 : 그룹핑   같은거끼리 묶여서 나옴
-- COUNT, SUM, AVG, MIN, MAX ...
SELECT math, count(tid) FROM test
GROUP BY math
ORDER BY math DESC;
SELECT * FROM test;

-- GROUP BY : HAVING => 그룹핑 상태에 사용되는 조건식
SELECT school_name, COUNT(sid) FROM students
GROUP BY school_name
HAVING COUNT(sid) > 4  -- 조건식을 만족하는 그룹
ORDER BY school_name ASC;

SELECT school_level, COUNT(*) FROM students
GROUP BY school_level
HAVING school_level = '중학교';

SELECT * FROM students;

-- test 복사본 test_backup 테이블 생성, student_name은 name으로 변경
CREATE TABLE test_backup (SELECT * FROM test);
CREATE TABLE test_backup (LIKE test);
INSERT INTO test_backup (SELECT * FROM test);
ALTER TABLE test_backup CHANGE COLUMN student_name name VARCHAR(20);
ALTER TABLE test_backup DROP name2;

DROP TABLE test_backup;

CREATE TABLE test_backup (LIKE test);
INSERT INTO test_backup (tid, student_name , kor, eng, math)
VALUES
	SELECT tid, student_name, kor, eng, math
	FROM test;

SELECT * FROM test_backup;
SHOW CREATE TABLE test_backup;
SHOW COLUMNS FROM test_backup;
DELETE FROM test_backup;
DROP TABLE test_backup;


SHOW CREATE TABLE students3;  -- 명령문의 구조 출력
SHOW CREATE TABLE students4;
SELECT * FROM students4;
SELECT * FROM students3;

DELETE FROM students2;  -- 테이블 데이터 삭제
DROP TABLE students3;  -- 테이블 삭제

SELECT * FROM students2;
SHOW COLUMNS FROM students2;
SELECT * FROM test;
SHOW COLUMNS FROM test;
SELECT * FROM tuitions;
SHOW COLUMNS FROM tuitions;
SELECT * FROM students;
SHOW COLUMNS FROM students;