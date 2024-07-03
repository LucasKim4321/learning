select * from tb_customer;
select customer_cd, customer_nm, phone_number, email from tb_customer;
-- ���� ���� �ν� �ȵǴµ� ""���� �νĵ�
select customer_cd as ���ڵ�, customer_nm as ����, phone_number as "��ȭ ��ȣ", email as �̸��� from tb_customer;

select * from tb_customer;
select * from tb_customer where mw_flg ='M';
-- �������� �ƽ�Ű �ڵ� ���� ���ϰ� �չ��� ���� ���Ѵ� // �տ��� ���� ������� // ������ �ű������ �� // �ڿ� ���ڰ� ��� �� �� ��.
select * from tb_customer where customer_cd > '2019' and mw_flg = 'W';
select * from tb_customer where customer_cd > '1' and mw_flg = 'W';  -- �չ��� 1�� �ƽ�Ű �ڵ� ���� ����� �չ��� ���� ū�� �� �� ���
select * from tb_customer where customer_cd > '2' and mw_flg = 'W';  -- �չ��� 2�� �ƽ�Ű �ڵ� ���� ����� �չ��� ���� ū�� �� �� ���
select * from tb_customer where customer_cd > '3' and mw_flg = 'W';  -- �չ��� 3�� �ƽ�Ű �ڵ� ���� ����� �չ��� ���� ū�� �� �� ���
describe tb_customer;

select * from tb_customer
where (birth_day >= '19900101' or total_point >= 20000);
--not > and > or ������ �켱������ ������ ����� ()������

select * from tb_customer
where mw_flg = 'W' and total_point between 10000 and 20000;

select total_point from tb_customer;
select total_point from tb_customer
where total_point < 10000 or total_point >= 30000;

--2018�����ϴ� ����
select * from tb_customer where customer_cd like '2018%' or customer_cd like '2019%';  -- Ư�� ���ڷ� ����
select * from tb_customer where customer_nm like '%��';  -- Ư�����ڷ� ����
select * from tb_customer where customer_nm like '%��%';  -- �߰����� ����
select email, total_point from tb_customer order by total_point desc;  --desc(��������)������ asc(��������) �⺻

select * from tb_customer;

select * from tb_customer where customer_nm in('�����', '������', '�̾Ƹ�');  -- ��Ȯ�� ��ġ�ϴ� ���� �˻�
select * from tb_customer where customer_nm not in('�����', '������', '�̾Ƹ�');  -- ��ġ�ϴ� �׸� ����

select * from tb_customer order by mw_flg desc;
select * from tb_customer order by mw_flg asc;

select * from tb_customer order by 2 desc;  -- �÷��� �������� ����  2��° �÷��� ���� ��
select * from tb_customer order by 1 desc;  -- 1��° �÷��� ���� ��

select * from tb_grade;
select class_cd from tb_grade group by class_cd;  -- class_cd�� �������� ��� ǥ��  �ϳ��� ��Ҹ� ���� ����
select class_cd, student_no from tb_grade group by class_cd;  -- �׷����� ������ �ϳ��� ��Ҹ� ���� ����  �̷��� �ϸ� ������
select class_cd, sum(kor), avg(kor), min(kor), max(kor)  from tb_grade group by class_cd;

select class_cd, sum(kor), round(avg(kor),1) as �������, round(avg(mat),1) as �������, round(avg(eng),1) as ������� from tb_grade group by class_cd;


select class_cd, sum(kor), 
        round(avg(kor),1) as �������,
        round(avg(mat),1) as �������,
        round(avg(eng),1) as �������
    from tb_grade
    group by class_cd  -- class_cd�� �������� ��� ǥ��
    having avg(kor) >=80;
    
select sales_dt, product_nm from tb_sales;
select distinct sales_dt, product_nm from tb_sales;  -- distinct �ߺ� ����

select * from tb_grade;
select * from tb_class_info;

select tb_grade.class_cd from tb_grade, tb_class_info;

select a.class_cd from tb_grade a, tb_class_info b;

select b.class_nm, a.student_no, a.student_nm, a.kor, a.eng, a.mat, a.tot, a.avg from tb_grade a, tb_class_info b;

select b.class_nm, a.student_no, a.student_nm, a.kor, a.eng, a.mat, a.tot, a.avg from tb_grade a, tb_class_info b where a.class_cd = b.class_cd;

select b.class_nm, a.student_no, a.student_nm, a.kor, a.eng, a.mat, a.tot, a.avg from tb_grade a join tb_class_info b on a.class_cd = b.class_cd;  -- �����Ŷ� ����


select * from tb_grade_09;  -- T01 T04 T05 T07 T08
select * from tb_grade_08;  -- T01 T02 T04 T07 T09
select * from tb_grade_07;  -- T01���� T10���� �� ����

-- ���̺� join ���̺� ��ġ�ϴ� ���� ��ħ
select 
    a.test_cd as "7������",
    a.kor, a.mat, a.eng,
    b.test_cd as "8������",
    b.kor, b.mat, b.eng
from tb_grade_07 a
join tb_grade_08 b
on a.test_cd = b.test_cd;

-- from ���̺� join ���̺� on ���� �÷�1, �÷�2   // �÷�1�� �÷�2�� ���ؼ� ��ġ�� ���
-- ���̺� join ���̺� ��ġ�ϴ� ���� ��ħ
-- ���̺� left join ���̺� ���� ���̺� ������ ���̺��� ÷��  // ���� ���̺��� �������� ���̺��� ����� ������ ���̺� ���� ���� ������ null
-- ���̺� right join ���̺� ������ ���̺� ���� ���̺��� ÷��  // ������ ���̺��� �������� ���̺��� ����� ���� ���̺� ���� ���� ������ null
-- ���̺� full outer join ���̺� ���ʰ� ������ �� ��θ� �������� ���̺��� �ۼ�  // ������ ���� ���� ǥ���ϰ� ���� ���� null

-- grade07(����)�� �������� ���� ǥ���ϰ� grade08(������)�� grade07�� ��ġ�ϴ� ���� ������ null
select 
    a.test_cd as "7������",
    a.kor, a.mat, a.eng,
    b.test_cd as "8������",
    b.kor, b.mat, b.eng
from tb_grade_07 a
left join tb_grade_08 b
on a.test_cd = b.test_cd;

-- grade08(������)�� �������� ���� ǥ���ϰ� grade07(����)�� grade08�� ��ġ�ϴ� ���� ������ null
select 
    a.test_cd as "7������",
    a.kor, a.mat, a.eng,
    b.test_cd as "8������",
    b.kor, b.mat, b.eng
from tb_grade_07 a
right join tb_grade_08 b
on a.test_cd = b.test_cd;

-- grade09(������)�� �������� ���� ǥ���ϰ� grade08(����)�� grade09�� ��ġ�ϴ� ���� ������ null
select 
    a.test_cd as "8������",
    a.kor, a.mat, a.eng,
    b.test_cd as "9������",
    b.kor, b.mat, b.eng
from tb_grade_08 a
right join tb_grade_09 b
on a.test_cd = b.test_cd;

-- grade09(������)�� �������� ���� ǥ���ϰ� grade08(����)�� grade09�� ��ġ�ϴ� ���� ������ null
select 
    a.test_cd as "8������",
    a.kor, a.mat, a.eng,
    b.test_cd as "9������",
    b.kor, b.mat, b.eng
from tb_grade_08 a, tb_grade_09 b
where a.test_cd(+) = b.test_cd;  -- b�� a�� +�ȴ�

-- grade08�� grade09�� ���� ���� ǥ���ϰ� ���� ���� ���� null
select 
    a.test_cd as "8������",
    a.kor, a.mat, a.eng,
    b.test_cd as "9������",
    b.kor, b.mat, b.eng
from tb_grade_08 a
full outer join tb_grade_09 b
on a.test_cd = b.test_cd;

--rownum ������� ��ȣ�� ����
select rownum, test_cd, kor, mat, eng from tb_grade_09;

select * from tb_grade_09;  -- T01 T04 T05 T07 T08
select * from tb_grade_08;  -- T01 T02 T04 T07 T09
select * from tb_grade_07;  -- T01���� T10���� �� ����