select * from t_member;

select * from t_member where id = 'hong1';
select * from t_member where id like 'hong%';

insert into t_member (id, pwd, name, email)
values ('hong200', '3333', 'ȫ����', 'hongsun@gmail.com');

select count(*) from t_member;
select count(id) from t_member where id='hong10000';
-- decode( ���ǽ�, ��1, true�� ��� ó��, ��2, true�� ��� ó�� .... flase�� ���)
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
 values ('hong4', '4321', 'ȫ����', 'hong4@gmail.com');
 
 delete from t_member where id like 'm%';
 commit;
 
 select * from dual;
 
 
 select * from t_member;
select count(*) from t_member where id='hong2';
 select decode( count(*), 1, 'true', 2, 'abc', 'false') as result from t_member where id='hong2' or id='hong3';
 
 
 