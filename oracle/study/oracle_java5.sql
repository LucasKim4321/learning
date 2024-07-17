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
 
 
 