select * from t_member;

select * from t_member where id = 'hong1';
select * from t_member where id like 'hong%';

insert into t_member (id, pwd, name, email)
values ('hong200', '3333', '全鉴脚', 'hongsun@gmail.com');

select count(*) from t_member;
select count(id) from t_member where id='hong10000';
-- decode( 炼扒侥, 蔼1, true老 版快 贸府, 蔼2, true老 版快 贸府 .... flase老 版快)
 select decode( count(*), 1, 'true', 'false') as isCheck from t_member;
 select decode( count(*), 1, 'true', 'false') as isCheck from t_member where id='hong100';