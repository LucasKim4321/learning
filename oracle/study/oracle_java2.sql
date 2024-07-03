select * from tb_customer;
select customer_cd, customer_nm, phone_number, email from tb_customer;
-- 원래 공백 인식 안되는데 ""쓰면 인식됨
select customer_cd as 고객코드, customer_nm as 고객명, phone_number as "전화 번호", email as 이메일 from tb_customer;

select * from tb_customer;
select * from tb_customer where mw_flg ='M';
-- 각문자의 아스키 코드 값을 비교하고 앞문자 부터 비교한다 // 앞에서 부터 순서대로 // 없으면 거기까지만 비교 // 뒤에 문자가 없어도 비교 잘 됨.
select * from tb_customer where customer_cd > '2019' and mw_flg = 'W';
select * from tb_customer where customer_cd > '1' and mw_flg = 'W';  -- 앞문자 1의 아스키 코드 값이 대상의 앞문자 보다 큰지 비교 후 출력
select * from tb_customer where customer_cd > '2' and mw_flg = 'W';  -- 앞문자 2의 아스키 코드 값이 대상의 앞문자 보다 큰지 비교 후 출력
select * from tb_customer where customer_cd > '3' and mw_flg = 'W';  -- 앞문자 3의 아스키 코드 값이 대상의 앞문자 보다 큰지 비교 후 출력
describe tb_customer;

select * from tb_customer
where (birth_day >= '19900101' or total_point >= 20000);
--not > and > or 순으로 우선순위를 가지고 계산함 ()괜찮음

select * from tb_customer
where mw_flg = 'W' and total_point between 10000 and 20000;

select total_point from tb_customer;
select total_point from tb_customer
where total_point < 10000 or total_point >= 30000;

--2018시작하는 문자
select * from tb_customer where customer_cd like '2018%' or customer_cd like '2019%';  -- 특정 문자로 시작
select * from tb_customer where customer_nm like '%리';  -- 특정문자로 끝남
select * from tb_customer where customer_nm like '%원%';  -- 중간값이 같음
select email, total_point from tb_customer order by total_point desc;  --desc(내림차순)생략시 asc(오름차순) 기본

select * from tb_customer;

select * from tb_customer where customer_nm in('나경숙', '이혜옥', '이아름');  -- 정확히 일치하는 글자 검색
select * from tb_customer where customer_nm not in('나경숙', '이혜옥', '이아름');  -- 일치하는 항목 제외

select * from tb_customer order by mw_flg desc;
select * from tb_customer order by mw_flg asc;

select * from tb_customer order by 2 desc;  -- 컬럼을 기준으로 정렬  2번째 컬럼을 정렬 함
select * from tb_customer order by 1 desc;  -- 1번째 컬럼을 정렬 함

select * from tb_grade;
select class_cd from tb_grade group by class_cd;  -- class_cd를 기준으로 묶어서 표시  하나의 요소만 선택 가능
select class_cd, student_no from tb_grade group by class_cd;  -- 그룹으로 묶으면 하나의 요소만 선택 가능  이렇게 하면 에러남
select class_cd, sum(kor), avg(kor), min(kor), max(kor)  from tb_grade group by class_cd;

select class_cd, sum(kor), round(avg(kor),1) as 국어평균, round(avg(mat),1) as 수학평균, round(avg(eng),1) as 영어평균 from tb_grade group by class_cd;


select class_cd, sum(kor), 
        round(avg(kor),1) as 국어평균,
        round(avg(mat),1) as 수학평균,
        round(avg(eng),1) as 영어평균
    from tb_grade
    group by class_cd  -- class_cd를 기준으로 묶어서 표시
    having avg(kor) >=80;
    
select sales_dt, product_nm from tb_sales;
select distinct sales_dt, product_nm from tb_sales;  -- distinct 중복 제거

select * from tb_grade;
select * from tb_class_info;

select tb_grade.class_cd from tb_grade, tb_class_info;

select a.class_cd from tb_grade a, tb_class_info b;

select b.class_nm, a.student_no, a.student_nm, a.kor, a.eng, a.mat, a.tot, a.avg from tb_grade a, tb_class_info b;

select b.class_nm, a.student_no, a.student_nm, a.kor, a.eng, a.mat, a.tot, a.avg from tb_grade a, tb_class_info b where a.class_cd = b.class_cd;

select b.class_nm, a.student_no, a.student_nm, a.kor, a.eng, a.mat, a.tot, a.avg from tb_grade a join tb_class_info b on a.class_cd = b.class_cd;  -- 위에거랑 같음


select * from tb_grade_09;  -- T01 T04 T05 T07 T08
select * from tb_grade_08;  -- T01 T02 T04 T07 T09
select * from tb_grade_07;  -- T01부터 T10까지 다 있음

-- 테이블 join 테이블 일치하는 값만 합침
select 
    a.test_cd as "7월시험",
    a.kor, a.mat, a.eng,
    b.test_cd as "8월시험",
    b.kor, b.mat, b.eng
from tb_grade_07 a
join tb_grade_08 b
on a.test_cd = b.test_cd;

-- from 테이블 join 테이블 on 비교할 컬럼1, 컬럼2   // 컬럼1과 컬럼2를 비교해서 합치는 기능
-- 테이블 join 테이블 일치하는 값만 합침
-- 테이블 left join 테이블 왼쪽 테이블에 오른쪽 테이블을 첨부  // 왼쪽 테이블을 기준으로 테이블을 만들고 오른쪽 테이블에 동일 값이 없으면 null
-- 테이블 right join 테이블 오른쪽 테이블에 왼쪽 테이블을 첨부  // 오른쪽 테이블을 기준으로 테이블을 만들고 왼쪽 테이블에 동일 값이 없으면 null
-- 테이블 full outer join 테이블 왼쪽과 오른쪽 둘 모두를 기준으로 테이블을 작성  // 서로의 값을 전부 표시하고 없는 값은 null

-- grade07(왼쪽)을 기준으로 값을 표시하고 grade08(오른쪽)에 grade07과 일치하는 값이 없으면 null
select 
    a.test_cd as "7월시험",
    a.kor, a.mat, a.eng,
    b.test_cd as "8월시험",
    b.kor, b.mat, b.eng
from tb_grade_07 a
left join tb_grade_08 b
on a.test_cd = b.test_cd;

-- grade08(오른쪽)를 기준으로 값을 표시하고 grade07(왼쪽)에 grade08과 일치하는 값이 없으면 null
select 
    a.test_cd as "7월시험",
    a.kor, a.mat, a.eng,
    b.test_cd as "8월시험",
    b.kor, b.mat, b.eng
from tb_grade_07 a
right join tb_grade_08 b
on a.test_cd = b.test_cd;

-- grade09(오른쪽)를 기준으로 값을 표시하고 grade08(왼쪽)에 grade09와 일치하는 값이 없으면 null
select 
    a.test_cd as "8월시험",
    a.kor, a.mat, a.eng,
    b.test_cd as "9월시험",
    b.kor, b.mat, b.eng
from tb_grade_08 a
right join tb_grade_09 b
on a.test_cd = b.test_cd;

-- grade09(오른쪽)를 기준으로 값을 표시하고 grade08(왼쪽)에 grade09와 일치하는 값이 없으면 null
select 
    a.test_cd as "8월시험",
    a.kor, a.mat, a.eng,
    b.test_cd as "9월시험",
    b.kor, b.mat, b.eng
from tb_grade_08 a, tb_grade_09 b
where a.test_cd(+) = b.test_cd;  -- b에 a가 +된다

-- grade08과 grade09의 값을 전부 표시하고 값이 없는 쪽은 null
select 
    a.test_cd as "8월시험",
    a.kor, a.mat, a.eng,
    b.test_cd as "9월시험",
    b.kor, b.mat, b.eng
from tb_grade_08 a
full outer join tb_grade_09 b
on a.test_cd = b.test_cd;

--rownum 순서대로 번호를 붙임
select rownum, test_cd, kor, mat, eng from tb_grade_09;

select * from tb_grade_09;  -- T01 T04 T05 T07 T08
select * from tb_grade_08;  -- T01 T02 T04 T07 T09
select * from tb_grade_07;  -- T01부터 T10까지 다 있음