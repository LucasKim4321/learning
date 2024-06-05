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
	('',1,20191211,65,83,43,100),
	('',1,20191211,65,83,43,100),
	('',1,20191211,65,83,43,100),
	('',1,20191211,65,83,43,100),
	('',1,20191211,65,83,43,100),
	('',1,20191211,65,83,43,100),
	('',1,20191211,65,83,43,100),
	('',1,20191211,65,83,43,100),
	('',1,20191211,65,83,43,100),
	('',1,20191211,65,83,43,100),
	('',1,20191211,65,83,43,100),
	('',1,20191211,65,83,43,100),
	('',1,20191211,65,83,43,100),
	('',1,20191211,65,83,43,100),
	('',1,20191211,65,83,43,100),
	('',1,20191211,65,83,43,100),
	('',1,20191211,65,83,43,100),
	('',1,20191211,65,83,43,100),
	('',1,20191211,65,83,43,100),
	('',1,20191211,65,83,43,100);

SELECT * FROM test;
SHOW COLUMNS FROM test;
-- DROP TABLE test;