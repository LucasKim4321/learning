-- ȸ�� ���̺� ����
create table t_member (
    id       VARCHAR2(10) PRIMARY key,
    pwd    VARCHAR2(10),
    name  VARCHAR2(50),
    email   VARCHAR(50),
    joinDate date default sysdate
);

-- ȸ�� ���� �߰�
insert into t_member
values ('hong1','1234','ȫ�浿','hong@gmail.com',sysdate);
insert into t_member
values ('hong2','1234','ȫ���','hong@gmail.com',sysdate);
insert into t_member
values ('hong3','1234','�̼���','hong@gmail.com',sysdate);
insert into t_member
values ('hong4','1234','����','hong@gmail.com',sysdate);
insert into t_member
values ('hong5','1234','���','hong@gmail.com',sysdate);
insert into t_member
values ('hong6','1234','���2','hong@gmail.com',sysdate);
insert into t_member (id,pwd,email,joinDate)
values ('hong7','1234','hong@gmail.com',sysdate);

select * from t_member;

delete from t_member;

drop table t_member;
