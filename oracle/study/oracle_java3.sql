-- case

select * from tb_grade;

-- case when 조건 then 결과 end as 새로 추가될 컬럼
-- 조건에 맞는 값을 추려서 새로운 컬럼에 추가해서 표시
select
    case class_cd 
            when  'A' then '종합입시반' 
            when  'B' then '단과반' 
            when  'C' then '대학입시반' 
            when  'D' then '집중분석반' 
            end 반,
    student_no, student_nm,
    case when kor >= 90 and kor <= 100 then  '수'
           when kor >= 80 and kor < 90 then  '우'
           when kor >= 70 and kor < 80 then  '미'
           when kor >= 60 and kor < 70 then  '양'
    end as kor_grade,
    case when eng >= 90 and eng <= 100 then  '수'
           when eng >= 80 and eng < 90 then  '우'
           when eng >= 70 and eng < 80 then  '미'
           when eng >= 60 and eng < 70 then  '양'
    end as eng_grade,
    case when mat in(90,91,92,93,94,95,96,97,98,99,100) then '수'
           when mat in(80,81,82,83,84,85,86,87,88,89) then '우'
           when mat in(70,71,72,73,74,75,76,77,78,79) then '미'
           when mat in(60,61,62,63,64,65,66,67,68,69) then '양'
           else '가'
    end as mat_grade
from tb_grade;

---------------------------------------

SELECT * FROM tb_customer;

-- ROWNUM : 레코드를 검색할 때 생성되는 행 번호
select rownum,    
    customer_cd, customer_nm, mw_flg
FROM tb_customer;

select rownum, a.* from tb_customer a;

-- 검색 할 때  행번호 생성 한 후 정렬작업 처리
select rownum, customer_cd, customer_nm from tb_customer where mw_flg = 'M' order by customer_nm;

-- NULL : 필드에 할당된 값이 없는 상태
-- IS NULL : 값이 없는 데이터 검색
-- IS NOT NULL : 값이 있는 데이터 검색

select * from tb_customer;

select * from tb_customer
        where phone_number is null or email is null;

select * from tb_customer where phone_number is not null;

-- 고객 테이블에서 남성 중 이메일이 없거나, 여성 중 이메일이 있는 고객 검색, 남성 순으로 정렬
select * from tb_customer
        where (mw_flg='M' and email is null) or (mw_flg='W' and email is not null) order by mw_flg desc;
        
select * from tb_customer
where customer_nm in ('강원진', '박승대')
and phone_number is not null;

-- dual 테이블: 오라클에서 기본적으로 설치된 system 권한의 1행으로 구성된 테이블
select * from dual;  -- 더미 데이터
select 3*2 from dual;  -- 계산 가능
select 3*2, 3+6, 9/3 from dual;

select 100*3, sysdate, sysdate+15, '1day SQL ' || '실습', substr('abcdefg', 1,4) from dual;



