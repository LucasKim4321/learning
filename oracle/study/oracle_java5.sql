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
select count(*) from t_member where id='hong2' or id='hong3';
 select decode( count(*), 1, 'true', 2, 'abc', 'false') as result from t_member where id='hong2' or id='hong3';
 
 -- ���� ���� ����
 select * from t_member where id between 1 and 10;
 select * from t_member where joindate between '2024/06/26' and '2024/06/29';
 
 -- rownum �ο츦 ������� ���ڸ� �ű� ���� ���ο� ���� �߰�
 select rownum, id, pwd, name, email, joindate from t_member;
 select rownum as recNum, id, pwd, name, email, joindate from t_member;
 
 -- rownum�� �߰��� ���̺�� �ٽ� �νĽ��Ѽ� ������ ��
 select * from (select rownum as recNum, id, pwd, name, email, joindate from t_member) where recNum between 1 and 4;
 select rownum as recNum, id, pwd, name, email, joindate from t_member where recNum between 1 and 4;  -- ������
 
 -- rownum�� ������� ������ ���� rownum ������ ����
 select rownum as recNum, id, pwd, name, email, joindate from t_member order by joindate desc;
 select * from (select rownum as recNum, id, pwd, name, email, joindate from t_member) where recNum between 1 and 4  order by joindate desc;
 
 -- ������ ����� ���̺�� �ν� ��Ų �� rownum�� ���� 
 select rownum as recNum, id, pwd, name, email, joindate from (select * from t_member order by joindate desc);
 select * from (select rownum as recNum, id, pwd, name, email, joindate from (select * from t_member order by joindate desc)) where recnum between 1 and 4;
 
 -- ȫ�� �����ϰ� t101�� �����ϰ� rownum(recnum)�� 1~10 ������ ��
 select * from (select rownum as recNum, id, pwd, name, email, joindate from (select * from t_member order by joindate desc))
 where (name like '%ȫ%' and id like 't101%') and recnum between 1 and 10;
 
 -- between ��¥�� ���۳�¥���� ���������������� ���� ����   �� 2024/07/10����  2024/07/16������
 select * from (select rownum as recNum, id, pwd, name, email, joindate from (select * from t_member order by joindate desc))
 where (name like '%ȫ%' and id like 'h%') and joindate between '2024/07/10' and '2024/07/16';
 
 -- ���ǿ� �´� ���� ã�� �� �ű⿡ rownum�� �ű�
 select * from (select rownum as recNum, id, pwd, name, email, joindate from 
 (select * from t_member where (name like '%ȫ%' and id like 'h%') and joindate between '2024/07/10' and '2024/07/16' order by joindate desc));
 
  -- ���ǿ� �´� ���� ã�� �� �ű⿡ rownum�� �ű� �� 3���� 6������ ���� ã��
  select * from (select rownum as recNum, id, pwd, name, email, joindate from 
 (select * from t_member where (name like '%ȫ%' and id like 'h%') and joindate between '2024/07/10' and '2024/07/16' order by joindate desc))
 where recnum between 3 and 6;
 
 select * from t_member where id like 'm%';
 select * from t_member where id like 't%';
 select * from t_member where name like '%��%';
 select * from t_member where id like '%Hong%';
 
 select * from t_member;
 delete from t_member where id like 'm%';
 delete from t_member where id like 't%';
 commit;
 rollback;
 
 show autocommit;
 set autocommit off;
 set autocommit on;
 
 