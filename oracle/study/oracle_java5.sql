select * from t_member;

select * from t_member where id = 'hong1';
select * from t_member where id like 'hong%';

insert into t_member (id, pwd, name, email)
values ('hong200', '3333', '홍순신', 'hongsun@gmail.com');

select count(*) from t_member;
select count(id) from t_member where id='hong10000';
-- decode( 조건식, 값1, true일 경우 처리, 값2, true일 경우 처리 .... flase일 경우)
 select decode( count(*), 1, 'true', 'false') as isCheck from t_member;
 select decode( count(*), 1, 'true', 'false') as isCheck from t_member where id='hong100';
 
 select * from t_member;
 select * from t_member order by name desc;
 select * from t_member order by joindate desc;
 select * from t_member order by id asc;
 select * from t_member where id='hong1';
 select * from t_member where id='hong1' or id='hong2' or id='hong3';
 select * from t_member where id in ('hong1', 'hong2', 'hong3');
 
 insert into t_member (id, pwd, name, email)
 values ('hong4', '4321', '홍순이', 'hong4@gmail.com');
 
 delete from t_member where id like 'm%';
 commit;
 
 select * from dual;
 
 
 select * from t_member;
select count(*) from t_member where id='hong2';
select count(*) from t_member where id='hong2' or id='hong3';
 select decode( count(*), 1, 'true', 2, 'abc', 'false') as result from t_member where id='hong2' or id='hong3';
 
 -- 사이 값이 나옴
 select * from t_member where id between 1 and 10;
 select * from t_member where joindate between '2024/06/26' and '2024/06/29';
 
 -- rownum 로우를 순서대로 숫자를 매긴 값을 새로운 열에 추가
 select rownum, id, pwd, name, email, joindate from t_member;
 select rownum as recNum, id, pwd, name, email, joindate from t_member;
 
 -- rownum이 추가된 테이블로 다시 인식시켜서 조건을 줌
 select * from (select rownum as recNum, id, pwd, name, email, joindate from t_member) where recNum between 1 and 4;
 select rownum as recNum, id, pwd, name, email, joindate from t_member where recNum between 1 and 4;  -- 에러뜸
 
 -- rownum을 만든다음 정렬이 들어가서 rownum 순서가 엉망
 select rownum as recNum, id, pwd, name, email, joindate from t_member order by joindate desc;
 select * from (select rownum as recNum, id, pwd, name, email, joindate from t_member) where recNum between 1 and 4  order by joindate desc;
 
 -- 정렬한 결과를 테이블로 인식 시킨 후 rownum을 해줌 
 select rownum as recNum, id, pwd, name, email, joindate from (select * from t_member order by joindate desc);
 select * from (select rownum as recNum, id, pwd, name, email, joindate from (select * from t_member order by joindate desc)) where recnum between 1 and 4;
 
 -- 홍을 포함하고 t101로 시작하고 rownum(recnum)이 1~10 사이의 값
 select * from (select rownum as recNum, id, pwd, name, email, joindate from (select * from t_member order by joindate desc))
 where (name like '%홍%' and id like 't101%') and recnum between 1 and 10;
 
 -- between 날짜는 시작날짜부터 마지막전날까지의 값이 나옴   예 2024/07/10포함  2024/07/16미포함
 select * from (select rownum as recNum, id, pwd, name, email, joindate from (select * from t_member order by joindate desc))
 where (name like '%홍%' and id like 'h%') and joindate between '2024/07/10' and '2024/07/16';
 
 -- 조건에 맞는 값을 찾은 후 거기에 rownum을 매김
 select * from (select rownum as recNum, id, pwd, name, email, joindate from 
 (select * from t_member where (name like '%홍%' and id like 'h%') and joindate between '2024/07/10' and '2024/07/16' order by joindate desc));
 
  -- 조건에 맞는 값을 찾은 후 거기에 rownum을 매긴 후 3부터 6까지의 값을 찾음
  select * from (select rownum as recNum, id, pwd, name, email, joindate from 
 (select * from t_member where (name like '%홍%' and id like 'h%') and joindate between '2024/07/10' and '2024/07/16' order by joindate desc))
 where recnum between 3 and 6;
 
 select * from t_member where id like 'm%';
 select * from t_member where id like 't%';
 select * from t_member where name like '%콩%';
 select * from t_member where id like '%Hong%';
 
 select * from t_member;
 delete from t_member where id like 'm%';
 delete from t_member where id like 't%';
 commit;
 rollback;
 
 show autocommit;
 set autocommit off;
 set autocommit on;
 
 