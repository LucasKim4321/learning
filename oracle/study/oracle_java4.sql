-- UPDATE
-- update 테이블 set 필드명 where 조건

select * from tb_grade;

update tb_grade
        set tot = kor + eng + mat,
             avg = round((kor + eng + mat)/3,1)
        where class_cd in ('A', 'B');
        
        
-- commit : db반영
-- rollback : 마지막 commit 상태로 복원

commit;

-- insert

select * from tb_grade;

insert into tb_grade
    (class_cd, student_no, student_nm, kor, eng, mat)
    values ('A',3, '홍길동', 97,88,95);
    
delete from tb_grade where student_nm='홍길동';

-- 모든 필드에 값이 있을 경우
insert into tb_grade values ('B', 4, '이도희', 86, 92, 90, 0, 0);

select * from tb_point;
            
select * from tb_point
            where reg_dttm >= 20170101000000 and reg_dttm <= 20190101000000;
            
select * from tb_point
            where reg_dttm <= '2019';
            
select customer_cd, seq_no, point_memo, point, reg_dttm from tb_point
            where reg_dttm >= 20170101000000;
            
insert all
        when substr(reg_dttm,1,4) = '2017' then into tb_point_2017
        when substr(reg_dttm,1,4) = '2018' then into tb_point_2018
        when substr(reg_dttm,1,4) = '2019' then into tb_point_2019
        else into tb_point_2019
        select customer_cd, seq_no, point_memo, point, reg_dttm from tb_point
        where reg_dttm >= 20170101000000;

-- insert into
-- insert select: 테이블 검색한 컬럼의 데이터들을 삽입
-- insert all into : 여러 테이블에 여러행 입력

select * from tb_point_2017;
select * from tb_point_2018;
select * from tb_point_2019;

commit;

-- MERGE : 조건에 따라 지정한 테이블이 데이터를 입력하거나 수정
-- 데이터가 있으면 update, 없으면 insert

select * from tb_customer;
select * from tb_add_customer;

describe tb_customer;

merge into tb_customer cu
          using tb_add_customer nc
          on (cu.customer_cd = nc.customer_cd)
          when matched then
            update set cu.customer_nm = nc.customer_nm,
                           cu.mw_flg = nc.mw_flg,
                          cu.birth_day = nc.birth_day,
                          cu.phone_number = nc.phone_number
          when not matched then
            insert (cu.customer_cd, cu.customer_nm, cu.mw_flg, cu.birth_day, cu.phone_number, cu.email, cu.total_point, cu.reg_dttm)
            values (nc.customer_cd, nc.customer_nm, nc.mw_flg, nc.birth_day, nc.phone_number,
                        '', 0, '20191015082030');  -- 값을 '공백'으로 하면 null 
                        
-- delete
delete from tb_customer where customer_nm in ('전미래');
-- delete from tb_customer where customer_nm = '전미래';
          
           
-- commit: 데이터 베이스에 바뀐 내용 반영, insert, update, delete 명령

commit;

-- rollback: 데이터 베이스에 바뀐 내용을 취소하고 최종 커밋(commit)상태로 복원

select * from tb_grade
        order by class_cd, student_no;
        
delete from tb_grade where class_cd in ('B', 'C');

rollback;

show autocommit;
set autocommit off;

-- 트랜젝션 (Transaction) : 데이터베이스 작업에서 하나로 묶을 수 있는 단위
-- 1개의 트랜젝션 단위 => 송금작업 -> 내통장 잔액, 내통장에서 출금, 상대 통장 확인, 입금
select * from tb_customer;
select * from tb_customer where customer_cd = '2017042';

insert into tb_point values ('2017042', 5, '드라이기 구매 포인트 적립', 32000, '20190801234530');
select * from tb_point;

update tb_customer cu
set cu.total_point = 1000+2000
where cu.customer_cd = '2017042';

select * from tb_customer;
select * from tb_point;
select sum(cp.point) from tb_point cp, tb_customer cu where cp.customer_cd = cu.customer_cd group by cp.customer_cd;

update tb_customer cu
set cu.total_point = (select sum(cp.point) from tb_point cp where cp.customer_cd = cu.customer_cd group by cp.customer_cd)
where cu.customer_cd = '2017042';

update tb_customer cu
set cu.total_point = 0
where cu.customer_cd = '2017042';

commit;
rollback;

-- 서브쿼리(sub query) : select 구문 안에 새로운 select 구문으로 sql을 구성

--select 필드명1, 필드명2, ...
--from (select검색 결과) 별칭
--where 조건식
--order by

select * from t_member;
select * from t_member where name like'홍%';

select rownum, t1.*
from (select id, name from t_member where name like'홍%') t1;