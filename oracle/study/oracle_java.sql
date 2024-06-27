-- 회원 테이블 생성
create table t_member (
    id       VARCHAR2(10) PRIMARY key,
    pwd    VARCHAR2(10),
    name  VARCHAR2(50),
    email   VARCHAR(50),
    joinDate date default sysdate
);

-- 회원 정보 추가
insert into t_member
values ('hong1','1234','홍길동','hong@gmail.com',sysdate);
insert into t_member
values ('hong2','1234','홍길순','hong@gmail.com',sysdate);
insert into t_member
values ('hong3','1234','이순신','hong@gmail.com',sysdate);
insert into t_member
values ('hong4','1234','세종','hong@gmail.com',sysdate);
insert into t_member
values ('hong5','1234','용왕','hong@gmail.com',sysdate);
insert into t_member
values ('hong6','1234','용왕2','hong@gmail.com',sysdate);
insert into t_member (id,pwd,email,joinDate)
values ('hong7','1234','hong@gmail.com',sysdate);

select * from t_member;

delete from t_member;

drop table t_member;
