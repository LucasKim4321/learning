-- UPDATE
-- update ���̺� set �ʵ�� where ����

select * from tb_grade;

update tb_grade
        set tot = kor + eng + mat,
             avg = round((kor + eng + mat)/3,1)
        where class_cd in ('A', 'B');
        
        
-- commit : db�ݿ�
-- rollback : ������ commit ���·� ����

commit;

-- insert

select * from tb_grade;

insert into tb_grade
    (class_cd, student_no, student_nm, kor, eng, mat)
    values ('A',3, 'ȫ�浿', 97,88,95);
    
delete from tb_grade where student_nm='ȫ�浿';

-- ��� �ʵ忡 ���� ���� ���
insert into tb_grade values ('B', 4, '�̵���', 86, 92, 90, 0, 0);

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
-- insert select: ���̺� �˻��� �÷��� �����͵��� ����
-- insert all into : ���� ���̺� ������ �Է�

select * from tb_point_2017;
select * from tb_point_2018;
select * from tb_point_2019;

commit;

-- MERGE : ���ǿ� ���� ������ ���̺��� �����͸� �Է��ϰų� ����
-- �����Ͱ� ������ update, ������ insert

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
                        '', 0, '20191015082030');  -- ���� '����'���� �ϸ� null 
                        
-- delete
delete from tb_customer where customer_nm in ('���̷�');
-- delete from tb_customer where customer_nm = '���̷�';
          
           
-- commit: ������ ���̽��� �ٲ� ���� �ݿ�, insert, update, delete ���

commit;

-- rollback: ������ ���̽��� �ٲ� ������ ����ϰ� ���� Ŀ��(commit)���·� ����

select * from tb_grade
        order by class_cd, student_no;
        
delete from tb_grade where class_cd in ('B', 'C');

rollback;

show autocommit;
set autocommit off;

-- Ʈ������ (Transaction) : �����ͺ��̽� �۾����� �ϳ��� ���� �� �ִ� ����
-- 1���� Ʈ������ ���� => �۱��۾� -> ������ �ܾ�, �����忡�� ���, ��� ���� Ȯ��, �Ա�
select * from tb_customer;
select * from tb_customer where customer_cd = '2017042';

insert into tb_point values ('2017042', 5, '����̱� ���� ����Ʈ ����', 32000, '20190801234530');
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

-- ��������(sub query) : select ���� �ȿ� ���ο� select �������� sql�� ����

--select �ʵ��1, �ʵ��2, ...
--from (select�˻� ���) ��Ī
--where ���ǽ�
--order by

select * from t_member;
select * from t_member where name like'ȫ%';

select rownum, t1.*
from (select id, name from t_member where name like'ȫ%') t1;