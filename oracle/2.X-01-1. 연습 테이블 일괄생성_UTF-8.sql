----------------------------------------------------------------------------------------------------
-- 연습 테이블 생성
----------------------------------------------------------------------------------------------------

--------------------------------------------------
-- 고객 테이블
--------------------------------------------------

CREATE TABLE TB_CUSTOMER
(
  CUSTOMER_CD      CHAR(7 BYTE)                 NOT NULL,   -- 고객코드
  CUSTOMER_NM      VARCHAR2(10 BYTE)            NOT NULL,   -- 고객명
  MW_FLG           CHAR(1 BYTE)                 NOT NULL,   -- 성별구분
  BIRTH_DAY        CHAR(8 BYTE)                 NOT NULL,   -- 생일
  PHONE_NUMBER     VARCHAR2(16 BYTE),                       -- 전화번호
  EMAIL            VARCHAR2(30 BYTE),                       -- EMAIL
  TOTAL_POINT      NUMBER(10),                              -- 누적포인트
  REG_DTTM         CHAR(14 BYTE)                            -- 등록일
);
CREATE UNIQUE INDEX PK_TB_CUSTOMER ON TB_CUSTOMER (CUSTOMER_CD);
ALTER TABLE TB_CUSTOMER ADD (CONSTRAINT PK_TB_CUSTOMER PRIMARY KEY (CUSTOMER_CD));

--------------------------------------------------
-- 추가 고객 테이블
--------------------------------------------------

CREATE TABLE TB_ADD_CUSTOMER
(
  CUSTOMER_CD      CHAR(7 BYTE)                 NOT NULL,   -- 고객코드
  CUSTOMER_NM      VARCHAR2(10 BYTE)            NOT NULL,   -- 고객명
  MW_FLG           CHAR(1 BYTE)                 NOT NULL,   -- 성별구분
  BIRTH_DAY        CHAR(8 BYTE)                 NOT NULL,   -- 생일
  PHONE_NUMBER     VARCHAR2(16 BYTE)                        -- 전화번호
);
CREATE UNIQUE INDEX PK_TB_ADD_CUSTOMER ON TB_ADD_CUSTOMER (CUSTOMER_CD);
ALTER TABLE TB_ADD_CUSTOMER ADD (CONSTRAINT PK_TB_ADD_CUSTOMER PRIMARY KEY (CUSTOMER_CD));

--------------------------------------------------
-- 포인트 테이블
--------------------------------------------------

CREATE TABLE TB_POINT
(
  CUSTOMER_CD      CHAR(7 BYTE)                 NOT NULL,   -- 고객코드
  SEQ_NO           NUMBER(10)                   NOT NULL,   -- 일련번호
  POINT_MEMO       VARCHAR2(50),                            -- 포인트 내용
  POINT            NUMBER(10),                              -- 포인트
  REG_DTTM         CHAR(14 BYTE)                            -- 등록일
);
CREATE UNIQUE INDEX PK_TB_POINT ON TB_POINT (CUSTOMER_CD, SEQ_NO);
ALTER TABLE TB_POINT ADD (CONSTRAINT PK_TB_POINT PRIMARY KEY (CUSTOMER_CD, SEQ_NO));

--------------------------------------------------
-- 2017년 포인트 테이블
--------------------------------------------------

CREATE TABLE TB_POINT_2017
(
  CUSTOMER_CD      CHAR(7 BYTE)                 NOT NULL,   -- 고객코드
  SEQ_NO           NUMBER(10)                   NOT NULL,   -- 일련번호
  POINT_MEMO       VARCHAR2(50),                            -- 포인트 내용
  POINT            NUMBER(10),                              -- 포인트
  REG_DTTM         CHAR(14 BYTE)                            -- 등록일
);
CREATE UNIQUE INDEX PK_TB_POINT_2017 ON TB_POINT_2017 (CUSTOMER_CD, SEQ_NO);
ALTER TABLE TB_POINT_2017 ADD (CONSTRAINT PK_TB_POINT_2017 PRIMARY KEY (CUSTOMER_CD, SEQ_NO));

--------------------------------------------------
-- 2018년 포인트 테이블
--------------------------------------------------

CREATE TABLE TB_POINT_2018
(
  CUSTOMER_CD      CHAR(7 BYTE)                 NOT NULL,   -- 고객코드
  SEQ_NO           NUMBER(10)                   NOT NULL,   -- 일련번호
  POINT_MEMO       VARCHAR2(50),                            -- 포인트 내용
  POINT            NUMBER(10),                              -- 포인트
  REG_DTTM         CHAR(14 BYTE)                            -- 등록일
);
CREATE UNIQUE INDEX PK_TB_POINT_2018 ON TB_POINT_2018 (CUSTOMER_CD, SEQ_NO);
ALTER TABLE TB_POINT_2018 ADD (CONSTRAINT PK_TB_POINT_2018 PRIMARY KEY (CUSTOMER_CD, SEQ_NO));

--------------------------------------------------
-- 2019년 포인트 테이블
--------------------------------------------------

CREATE TABLE TB_POINT_2019
(
  CUSTOMER_CD      CHAR(7 BYTE)                 NOT NULL,   -- 고객코드
  SEQ_NO           NUMBER(10)                   NOT NULL,   -- 일련번호
  POINT_MEMO       VARCHAR2(50),                            -- 포인트 내용
  POINT            NUMBER(10),                              -- 포인트
  REG_DTTM         CHAR(14 BYTE)                            -- 등록일
);
CREATE UNIQUE INDEX PK_TB_POINT_2019 ON TB_POINT_2019 (CUSTOMER_CD, SEQ_NO);
ALTER TABLE TB_POINT_2019 ADD (CONSTRAINT PK_TB_POINT_2019 PRIMARY KEY (CUSTOMER_CD, SEQ_NO));

--------------------------------------------------
-- 기타정보 테이블
--------------------------------------------------

CREATE TABLE TB_ETC_INFO
(
  CUSTOMER_CD        CHAR(7 BYTE)                 NOT NULL,   -- 고객코드
  CUSTOMER_ENG_NM    VARCHAR2(20 BYTE),                       -- 영문 고객명
  ITEM_LIST          VARCHAR2(40 BYTE)                        -- 관심 품목
);
CREATE UNIQUE INDEX PK_TB_ETC_INFO ON TB_ETC_INFO (CUSTOMER_CD);
ALTER TABLE TB_ETC_INFO ADD (CONSTRAINT PK_TB_ETC_INFO PRIMARY KEY (CUSTOMER_CD));

--------------------------------------------------
-- 품목정보 테이블
--------------------------------------------------

CREATE TABLE TB_ITEM_INFO
(
  ITEM_CD          CHAR(7 BYTE)                 NOT NULL,   -- 관심 품목 코드
  ITEM_NM          VARCHAR2(20 BYTE)                        -- 관심 품목명

);
CREATE UNIQUE INDEX PK_TB_ITEM_INFO ON TB_ITEM_INFO (ITEM_CD);
ALTER TABLE TB_ITEM_INFO ADD (CONSTRAINT PK_TB_ITEM_INFO PRIMARY KEY (ITEM_CD));

--------------------------------------------------
-- 성적 테이블
--------------------------------------------------

CREATE TABLE TB_GRADE
(
  CLASS_CD         CHAR(1 BYTE)                 NOT NULL,   -- 반코드
  STUDENT_NO       NUMBER(2)                    NOT NULL,   -- 학생번호
  STUDENT_NM       VARCHAR2(10 BYTE)            NOT NULL,   -- 학생명
  KOR              NUMBER(3),                               -- 국어
  ENG              NUMBER(3),                               -- 영어
  MAT              NUMBER(3),                               -- 수학
  TOT              NUMBER(3),                               -- 합계
  AVG              NUMBER(5,1)                              -- 평균
);
CREATE UNIQUE INDEX PK_TB_GRADE ON TB_GRADE (CLASS_CD, STUDENT_NO);
ALTER TABLE TB_GRADE ADD (CONSTRAINT PK_TB_GRADE PRIMARY KEY (CLASS_CD, STUDENT_NO));

--------------------------------------------------
-- 7월 성적 테이블
--------------------------------------------------

CREATE TABLE TB_GRADE_07
(
  TEST_CD          CHAR(3 BYTE)                 NOT NULL,   -- 시험코드
  KOR              NUMBER(3),                               -- 국어
  ENG              NUMBER(3),                               -- 영어
  MAT              NUMBER(3)                                -- 수학
);
CREATE UNIQUE INDEX PK_TB_GRADE_07 ON TB_GRADE_07 (TEST_CD);
ALTER TABLE TB_GRADE_07 ADD (CONSTRAINT PK_TB_GRADE_07 PRIMARY KEY (TEST_CD));

--------------------------------------------------
-- 8월 성적 테이블
--------------------------------------------------

CREATE TABLE TB_GRADE_08
(
  TEST_CD          CHAR(3 BYTE)                 NOT NULL,   -- 시험코드
  KOR              NUMBER(3),                               -- 국어
  ENG              NUMBER(3),                               -- 영어
  MAT              NUMBER(3)                                -- 수학
);
CREATE UNIQUE INDEX PK_TB_GRADE_08 ON TB_GRADE_08 (TEST_CD);
ALTER TABLE TB_GRADE_08 ADD (CONSTRAINT PK_TB_GRADE_08 PRIMARY KEY (TEST_CD));

--------------------------------------------------
-- 9월 성적 테이블
--------------------------------------------------

CREATE TABLE TB_GRADE_09
(
  TEST_CD          CHAR(3 BYTE)                 NOT NULL,   -- 시험코드
  KOR              NUMBER(3),                               -- 국어
  ENG              NUMBER(3),                               -- 영어
  MAT              NUMBER(3)                                -- 수학
);
CREATE UNIQUE INDEX PK_TB_GRADE_09 ON TB_GRADE_09 (TEST_CD);
ALTER TABLE TB_GRADE_09 ADD (CONSTRAINT PK_TB_GRADE_09 PRIMARY KEY (TEST_CD));

--------------------------------------------------
-- 2020년 성적 테이블
--------------------------------------------------

CREATE TABLE TB_GRADE_2020
(
  TEST_MONTH       CHAR(2 BYTE)                 NOT NULL,   -- 월
  TEST_CD          CHAR(3 BYTE)                 NOT NULL,   -- 시험코드
  KOR              NUMBER(3),                               -- 국어
  ENG              NUMBER(3),                               -- 영어
  MAT              NUMBER(3)                                -- 수학
);

CREATE UNIQUE INDEX PK_TB_GRADE_2020 ON TB_GRADE_2020 (TEST_MONTH);
ALTER TABLE TB_GRADE_2020 ADD (CONSTRAINT PK_TB_GRADE_2020 PRIMARY KEY (TEST_MONTH));

--------------------------------------------------
-- 반 정보 테이블
--------------------------------------------------

CREATE TABLE TB_CLASS_INFO
(
  CLASS_CD         CHAR(1 BYTE)                 NOT NULL,   -- 반코드
  CLASS_NM         VARCHAR2(20 BYTE)            NOT NULL    -- 반명
);
CREATE UNIQUE INDEX PK_TB_CLASS_INFO ON TB_CLASS_INFO (CLASS_CD, CLASS_NM);
ALTER TABLE TB_CLASS_INFO ADD (CONSTRAINT PK_TB_CLASS_INFO PRIMARY KEY (CLASS_CD, CLASS_NM));

--------------------------------------------------
-- 판매 테이블
--------------------------------------------------

CREATE TABLE TB_SALES
(
  SALES_DT         CHAR(8 BYTE)                 NOT NULL,   -- 등록일
  SEQ_NO           NUMBER(5)                    NOT NULL,   -- 일련번호
  PRODUCT_NM       VARCHAR2(20 BYTE),                       -- 상품명
  PRICE            NUMBER(10),                              -- 단가(원)
  SALES_COUNT      NUMBER(3)                                -- 판매개수
);
CREATE UNIQUE INDEX PK_TB_SALES ON TB_SALES (SALES_DT, SEQ_NO);
ALTER TABLE TB_SALES ADD (CONSTRAINT PK_TB_SALES PRIMARY KEY (SALES_DT, SEQ_NO));

--------------------------------------------------
-- 9월 판매 테이블
--------------------------------------------------

CREATE TABLE TB_SALES_09
(
  SEQ_NO           NUMBER(10)                   NOT NULL,   -- 일련번호
  PRODUCT_NM       VARCHAR2(20 BYTE),                       -- 상품명
  CUSTOMER_CD      CHAR(7 BYTE),                            -- 고객코드
  SALES_COUNT      NUMBER(3)                                -- 판매개수
);
CREATE UNIQUE INDEX PK_TB_SALES_09 ON TB_SALES_09 (SEQ_NO);
ALTER TABLE TB_SALES_09 ADD (CONSTRAINT PK_TB_SALES_09 PRIMARY KEY (SEQ_NO));

--------------------------------------------------
-- 열차시각표 테이블
--------------------------------------------------

CREATE TABLE TB_TRAIN_TM
(
  TRAIN_NO         CHAR(5 BYTE)                 NOT NULL,   -- 열차번호
  RUN_ORDR         NUMBER(5)                    NOT NULL,   -- 운행순서
  STATION_NM       VARCHAR2(20 BYTE),                       -- 역명
  ARV_TM           CHAR(6 BYTE),                            -- 도착시각
  DPT_TM           CHAR(6 BYTE)                             -- 출발시각
);
CREATE UNIQUE INDEX PK_TB_TRAIN_TM ON TB_TRAIN_TM (TRAIN_NO, RUN_ORDR);
ALTER TABLE TB_TRAIN_TM ADD (CONSTRAINT PK_TB_TRAIN_TM PRIMARY KEY (TRAIN_NO, RUN_ORDR));


--------------------------------------------------
-- 포인트 정보 테이블 (연간정보, 프로시저로 등록/삭제)
--------------------------------------------------

CREATE TABLE TB_POINT_INFO
(
  YEAR             CHAR(4 BYTE)                 NOT NULL,   -- 연도
  RANK             NUMBER(10)                   NOT NULL,   -- 순위
  CUSTOMER_CD      CHAR(7 BYTE)                 NOT NULL,   -- 고객코드
  POINT            NUMBER(10),                              -- 포인트
  LAST_POINT_DT    CHAR(8 BYTE)                             -- 최종 포인트 적립일
);
CREATE UNIQUE INDEX PK_TB_POINT_INFO ON TB_POINT_INFO (YEAR, RANK);
ALTER TABLE TB_POINT_INFO ADD (CONSTRAINT PK_TB_POINT_INFO PRIMARY KEY (YEAR, RANK));
