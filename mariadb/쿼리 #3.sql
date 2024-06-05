SELECT * FROM students;

-- 조건문
SELECT * FROM students WHERE school_name = '남원';
SELECT student_name, school_name FROM students WHERE school_name = '활빈' OR school_name = '도화';

SELECT student_name, school_name FROM students
WHERE school_name = '도화' AND school_grade = '3';

-- DDL, DML, DCL

-- 구조 변경
SHOW COLUMNS FROM students;


-- 컬럼 추가
ALTER TABLE students ADD student_genter VARCHAR(1);

-- 컬럼 삭제
ALTER TABLE students DROP COLUMN is_admin;
ALTER TABLE students DROP COLUMN student_genter;

-- 컬럼 수정
ALTER TABLE students MODIFY COLUMN student_genter VARCHAR(2);

-- 컬럼 이름 변경
ALTER TABLE students CHANGE COLUMN student_genter student_gender VARCHAR(2);
ALTER TABLE students CHANGE COLUMN id sid INT AUTO_INCREMENT;

SELECT * FROM students;
SHOW COLUMNS FROM students;
