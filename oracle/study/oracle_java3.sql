-- case

select * from tb_grade;

-- case when ���� then ��� end as ���� �߰��� �÷�
-- ���ǿ� �´� ���� �߷��� ���ο� �÷��� �߰��ؼ� ǥ��
select
    case class_cd 
            when  'A' then '�����Խù�' 
            when  'B' then '�ܰ���' 
            when  'C' then '�����Խù�' 
            when  'D' then '���ߺм���' 
            end ��,
    student_no, student_nm,
    case when kor >= 90 and kor <= 100 then  '��'
           when kor >= 80 and kor < 90 then  '��'
           when kor >= 70 and kor < 80 then  '��'
           when kor >= 60 and kor < 70 then  '��'
    end as kor_grade,
    case when eng >= 90 and eng <= 100 then  '��'
           when eng >= 80 and eng < 90 then  '��'
           when eng >= 70 and eng < 80 then  '��'
           when eng >= 60 and eng < 70 then  '��'
    end as eng_grade,
    case when mat in(90,91,92,93,94,95,96,97,98,99,100) then '��'
           when mat in(80,81,82,83,84,85,86,87,88,89) then '��'
           when mat in(70,71,72,73,74,75,76,77,78,79) then '��'
           when mat in(60,61,62,63,64,65,66,67,68,69) then '��'
           else '��'
    end as mat_grade
from tb_grade;

---------------------------------------

SELECT * FROM tb_customer;

-- ROWNUM : ���ڵ带 �˻��� �� �����Ǵ� �� ��ȣ
select rownum,    
    customer_cd, customer_nm, mw_flg
FROM tb_customer;

select rownum, a.* from tb_customer a;

-- �˻� �� ��  ���ȣ ���� �� �� �����۾� ó��
select rownum, customer_cd, customer_nm from tb_customer where mw_flg = 'M' order by customer_nm;

-- NULL : �ʵ忡 �Ҵ�� ���� ���� ����
-- IS NULL : ���� ���� ������ �˻�
-- IS NOT NULL : ���� �ִ� ������ �˻�

select * from tb_customer;

select * from tb_customer
        where phone_number is null or email is null;

select * from tb_customer where phone_number is not null;

-- �� ���̺��� ���� �� �̸����� ���ų�, ���� �� �̸����� �ִ� �� �˻�, ���� ������ ����
select * from tb_customer
        where (mw_flg='M' and email is null) or (mw_flg='W' and email is not null) order by mw_flg desc;
        
select * from tb_customer
where customer_nm in ('������', '�ڽ´�')
and phone_number is not null;

-- dual ���̺�: ����Ŭ���� �⺻������ ��ġ�� system ������ 1������ ������ ���̺�
select * from dual;  -- ���� ������
select 3*2 from dual;  -- ��� ����
select 3*2, 3+6, 9/3 from dual;

select 100*3, sysdate, sysdate+15, '1day SQL ' || '�ǽ�', substr('abcdefg', 1,4) from dual;



