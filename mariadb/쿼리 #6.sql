/*
 서브쿼리
1. 서브쿼리는 반드시 괄호로 감싸주어야 한다.
2. 서브쿼리는 연산자의 오른쪽에 위치해야 한다.
3. 서브쿼리는 IN 연산자와 함께 사용하면 효율성이 떨어진다.
4. 서브쿼리안에서는 ORDER BY를 사용할 수 없다.
 	ORDER BY 결과 값의 출력에 관한 것으로 한번만 사용. 
*/

-- 서브쿼리
-- 수학 점수가 평균이상인 사람을 국어 기준으로 내림차순으로 표시
SELECT student_name, kor, eng, math FROM test
WHERE math >= (SELECT AVG(math) FROM test) ORDER BY kor DESC;
SELECT AVG(math) FROM test;

SELECT student_name,math, kor,eng FROM test WHERE math >= (SELECT AVG(math) FROM test) ORDER BY math DESC;

-- 닷 연산자(.)
SELECT mydb.students.student_name FROM students;
SELECT test.* FROM test;

-- 두 개 이상 테이블에서 동일한 필드명이 있을 경우에는 반드시 테이블을 붙여서 식별해야한다.
SELECT student_name FROM students, test;  -- 중복된 필드명때문에 에러남
SELECT school_name, test_date FROM students, test;  -- 괜찮음
SELECT mydb.students.student_name, mydb.test.student_name FROM students, test; -- 따로 지정해주면 괜찮음
SELECT s.student_name, t.student_name FROM students AS s, test AS t;

-- JOIN 여러 테이블의 자료에서 데이터를 추출할 경우 데이터 조작 기능
-- INNER JOIN(교집합), LEFT JOIN(특정 테이블을 기준 : LEFT), RIGHT JOIN(특정 테이블을 기준 : RIGHT)

CREATE TABLE tutions (
	sid INT AUTO_INCREMENT,
	student_name VARCHAR(20) NOT NULL,  -- 제약조건 NOT NULL : 값을 지정하지 않으면 무조건 에러
	is_paid TINYINT(1),
	due_year INT NOT NULL,
	due_month INT NOT NULL,
	due_day INT NOT NULL,
	due_amount INT NOT NULL,
	memo VARCHAR(100),
	PRIMARY KEY(sid)
);

DROP TABLE tuitions;
INSERT INTO tutions (student_name,is_paid,due_year,due_month,due_day,due_amount,memo)
VALUES 
	('홍길동', 1, 2019, 11, 1, 300000, '의적'),
	('성춘향', 1, 2019, 11, 2, 300000, '퇴역기생의 딸'),
	('이몽룡', 1, 2019, 11, 3, 300000, '교직원 할인'),
	('방자', 1, 2019, 11, 4, 300000, '교직원 할인'),
	('향단', 1, 2019, 11, 5, 300000, '춘향의 노비'),
	('변사또', 1, 2019, 11, 26, 300000, '상습체납자'),
	('심청', 1, 2019, 11, 14, 300000, '사회보호대상자'),
	('심학규', 1, 2019, 11, 16, 300000, '사회보호대상자'),
	('용왕', 1, 2019, 11, 31, 300000, '용왕'),
	('곽씨', 1, 2019, 11, 21, 300000, '아줌마'),
	('뺑덕', 1, 2019, 11, 26, 300000, '이모'),
	('흥부', 1, 2019, 11, 17, 300000, '착함'),
	('놀부', 1, 2019, 11, 30, 300000, '욕심쟁이'),
	('이순신', 1, 2019, 11, 3, 300000, '국가유공자'),
	('강감찬', 1, 2019, 11, 7, 300000, '국가유공자');
	
-- 테이블 변경 --
ALTER TABLE tutions RENAME tuitions;

-- INNER JOIN : 오른족 테이블과 왼쪽 테이블 모두에서 일치하는 데이터를 대상으로 연산을 수행
SELECT s.student_name, t.student_name, t.math
FROM students AS s, test AS t
WHERE s.student_name = t.student_name AND t.is_taken =1;  -- student_name이 같고 is_taken=1 인것만

-- 위와 동일한 처리 --
SELECT s.student_name, s.school_name, t.math
FROM students AS s INNER JOIN test AS t
ON s.student_name = t.student_name AND t.is_taken =1;

-- 두개 이상의 테이블에서 JOIN --
-- 시험에 참여한 학생(test.is_taken =1) 중에서 students, test, tuitions
-- 세개의 테이블에 모두 존재하는 학생의 뎅이터 추출
SELECT students.student_name, test.math, tuitions.memo
FROM (
	-- 시험에 참여한 학생(test.is_taken=1)
	(students INNER JOIN test
	 ON students.student_name = test.student_name AND test.is_taken=1
	 )
	 INNER JOIN tuitions
	 ON tuitions.student_name = test.student_name
);


-- 위와 동일한 처리
SELECT 
	s.student_name, s.school_name, t.math, tu.memo
FROM
	students AS s, test AS t, tuitions AS tu
WHERE s.student_name = t.student_name
	AND t.student_name = tu.student_name
	AND t.is_taken = 1;

-- LEFT JOIN : 왼쪽 테이블의 모든 데이터와 왼쪽 테이블과 오른쪽 테이블의 일치하는 데이터를 대상으로 연산

-- INNER JOIN 결과 --
SELECT * FROM tuitions where CHAR_LENGTH(student_name) =2;
-- LEFT JOIN 결과 --

-- CHAR_LENGTH(tuitions.student_name) = 2와
-- tuitions.student_name = test.student_name조건을 만족하는 데이터를 먼저
-- 만족하지 않은 tuitions 테이블의 나머지를 나중에 반환
SELECT tuitions.*, test.*
FROM
	tuitions LEFT JOIN test
	ON CHAR_LENGTH(tuitions.student_name)=2
	AND tuitions.student_name = test.student_name;
	
UPDATE tuitions SET student_name = '놀부' WHERE sid=13;

-- RIGHT JOIN
SELECT tuitions.*, test.*
FROM
	tuitions RIGHT JOIN test
	ON CHAR_LENGTH(test.student_name) = 2
	AND tuitions.student_name = test.student_name;
	
SELECT * FROM test;
SHOW COLUMNS FROM test;
SELECT * FROM tuitions;
SHOW COLUMNS FROM tuitions;
SELECT * FROM students;
SHOW COLUMNS FROM students;
-- DROP TABLE tutions;
