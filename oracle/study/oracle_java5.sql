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