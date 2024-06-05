-- 산술 연산자 : +, -, *, /, %
SELECT 13+7 AS 'ADD', 17-3 AS 'SUB', 17*3 AS 'MUL', 17/3 AS 'DIV', 17%3 AS '나머지';

SELECT * FROM students;
SELECT student_name, school_grade+1, student_age+1 FROM students;  -- 보여지는 데잉터만 다르게 나옴(실제값은 그대로)

CREATE TABLE test (
	tid 				INT PRIMARY KEY AUTO_INCREMENT,  -- 기본키
	student_name 	VARCHAR(20),
	is_taken 		TINYINT(1),
	test_date 		DATE,
	kor 				INT UNSIGNED,  --  UNSIGNED음수 제외
	eng 				INT UNSIGNED,
	math				INT UNSIGNED,
	hist 				INT UNSIGNED  -- 마지막에 , 하면 에러
	
	-- PRIMARY KEY (tid)
);

INSERT INTO test
	( student_name, is_taken, test_date, kor, eng, math, hist)
VALUES 
	('홍길동',1,20191211,88,77,66,99),
	('성춘향',0,20191211,0,0,0,0),
	('이몽룡',0,20171211,0,0,0,0),
	('방자',1,20141211,100,37,43,100),
	('향단',1,20131211,97,47,66,100),
	('변사또',1,20091211,57,83,43,100),
	('심청',1,20081211,92,67,43,100),
	('심학규',1,20021211,85,77,55,80),
	('용왕',1,14991211,100,100,100,100),
	('곽씨',1,20191211,79,97,55,100),
	('뺑덕',1,20191211,89,100,43,50),
	('흥부',1,20191211,65,95,43,80),
	('놀부',1,20191211,62,85,55,100),
	('홍길순',1,20191211,75,83,66,100),
	('동길이',1,20191211,65,83,43,90),
	('강감찬',1,20191211,55,83,77,90),
	('이순신',1,20191211,45,83,43,100),
	('세종대왕',1,20191211,35,83,88,100),
	('이이',1,20191211,32,25,43,100),
	('둘리',1,11111211,22,10,40,20);

SELECT * FROM test WHERE (CHAR_LENGTH(student_name) <=2 );  -- 이름이 두글자 이하
SELECT * FROM test WHERE (CHAR_LENGTH(student_name) >2 );  -- 두글자 초과(세글자 이상)

SELECT student_name, CHAR_LENGTH(student_name), LENGTH(student_name) FROM test;

SELECT CONCAT (student_name, " 학생의 수학 성적은", math, "점 입니다.") FROM test;

SELECT CONCAT_WS('---', student_name, "학생의 수학 성적은 ",math,"점 입니다.") FROM test;  --  ---로 구분

SELECT SUBSTR(student_name, 2, 2) FROM test;  -- SUBSTR(대상, 시작위치,개수)  대상을 시작위치에서 갯수만큼 표시

-- 숫자형 함수
SELECT AVG(kor), AVG(eng), AVG(math), AVG(hist) FROM test;
SELECT COUNT(student_name) FROM test;
SELECT COUNT(*) FROM test;

SELECT MAX(kor), MAX(eng), MIN(math), MIN(hist) FROM test;
SELECT power(2,3);  -- 2의 3승
-- RNAD() 랜덤숫자 FLOOR 자리내림 CEIL 자리올림 ROUND 반올림
SELECT RAND(3), FLOOR(RAND()*100), CEIL(RAND()*100), ROUND(RAND()*100);

SELECT SUM(math) FROM test;
SELECT AVG(hist),
	FORMAT(AVG(hist),2),  -- 문자형으로 반환
	truncate(AVG(hist),2)  -- 숫자형으로 반환
	FROM test;

-- 날짜형 함수
SELECT CURRENT_DATE(),
	CURRENT_TIME(),
	CURRENT_TIMESTAMP(),
	SYSDATE();

SELECT ADDDATE( DATE(SYSDATE()), INTERVAL 365 DAY),
		 ADDDATE( DATE(SYSDATE()), INTERVAL -365 DAY),
		 DATE_SUB(DATE(SYSDATE()), INTERVAL 365 DAY);
		 
-- 날짜 차이
SELECT
	DATEDIFF(CURDATE(), "2024-06-05 23:35:43"),
	DATEDIFF(20240605333343,CURDATE());
	
-- 날짜 형식
SELECT CURDATE(), DATE_FORMAT(CURDATE(), "%M, %D, %Y, %W");

-- 현재 날짜에 연산
SELECT CURDATE(),CURDATE()+1, DAYNAME(CURDATE() +1), MONTHNAME(CURDATE());

SELECT CURDATE() AS '현재 날짜',  -- 별칭 가능
	DAYOFYEAR(CURDATE()),  -- 현재 날짜가 일년 중 몇번째 날인지
	WEEKOFYEAR(CURDATE());  -- 현재 주가 일년 중 몇번째 주인지
	
-- AS 키워드 별칭 붙여주는 기능
SELECT student_name AS 학생이름 FROM students;  -- ''없이 적어도됨 공백 넣으면 에러

SELECT mydb.students.student_name FROM students;  -- 기본선택방식

SELECT students.student_name, test.student_name FROM students, test;
SELECT s.student_name, t.student_name FROM students AS s, test AS t;

/*
 서브쿼리
1. 서브쿼리는 반드시 괄호로 감싸주어야 한다.
2. 서브쿼리는 연산자의 오른쪽에 위치해야 한다.
3. 서ㅓ브쿼리는 IN 연산자와 함께 사용하면 효율성이 떨어진다.
4. 서브쿼리안에서는 ORDER BY를 사용할 수 없다.
 	ORDER BY 결과 값의 출력에 관한 것으로 한번만 사용. 
*/

-- 수학 점수가 평균이상인 사람을 국어 기준으로 내림차순으로 표시
SELECT student_name, kor, eng, math FROM test
WHERE math >= (SELECT AVG(math) FROM test) ORDER BY kor DESC;
SELECT AVG(math) FROM test;

SELECT * FROM students;
SHOW COLUMNS FROM students;
SELECT * FROM test;
SHOW COLUMNS FROM test;
-- DROP TABLE test;