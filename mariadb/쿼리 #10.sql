-- 외래키(참조키) : FOREIGN KEY

-- 부모 테이블
CREATE TABLE parent(
	region_id 	INT 			NOT NULL,
	region		VARCHAR(10)	NOT NULL,
	PRIMARY KEY (region_id)
) ENGINE = INNODB DEFAULT CHARACTER SET = UTF8;  -- 생략시 기본으로 들어감

INSERT INTO parent (region_id, region)
VALUES (1, '서울'), (2, '경기'), (3, '부산');

-- 자식 테이블 생성
CREATE TABLE child (
	cid INT NOT NULL AUTO_INCREMENT,
	region_id INT NOT NULL,
	NAME VARCHAR(10) NOT NULL,
	PRIMARY KEY (cid),
	CONSTRAINT fk_region 
					FOREIGN KEY (region_id)
					REFERENCES parent(region_id)
);

-- 부모 테이블 삭제
-- DROP TABLE parent;  -- 제약 조건에 의하여 삭제 오류

INSERT INTO child(region_id, NAME)
VALUES (1, '홍길동'), (2, '동순이'), (3, '강감찬');


-- 외래키 오류 -> 참조하는 테이블에 필드에 값이 없기 때문
INSERT INTO child(region_id, NAME)
VALUES (4, '이순신');  -- parent table에 region_id 값이 3까지만 있어서 오류

-- 외래키 삭제
ALTER TABLE child DROP CONSTRAINT fk_region;
-- 외래키 삭제 후 region_id에 조건 없이 추가 가능

-- 외래키 추가
ALTER TABLE child 
		ADD CONSTRAINT fk_region 
					FOREIGN KEY (region_id)
					REFERENCES parent(region_id);  
-- 조건을 벗어나는 값이 이미 존재하면 에러남
DELETE FROM child WHERE region_id=4;


SELECT * FROM child;
SHOW COLUMNS FROM child;
SELECT * FROM parent;
SHOW COLUMNS FROM parent;
DROP TABLE parent;
DROP TABLE child;