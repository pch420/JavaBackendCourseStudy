SHOW USER;

INSERT INTO dept( deptno, dname, loc ) 
VALUES ( 50 ,'����','����');

INSERT INTO dept( deptno, dname) 
VALUES ( 51 , '����');

INSERT INTO dept 
VALUES ( 60 ,'�λ�','���');

-- error �߻���
INSERT INTO dept 
VALUES ( 61 ,'�λ�');

INSERT INTO dept(deptno, dname , loc ) 
VALUES ( 80 ,'�λ�', NULL );

commit;

select *
from dept;

CREATE TABLE mydept 
AS 
SELECT * 
FROM dept 
WHERE 1=2;

CREATE TABLE mydept10 
AS 
SELECT * 
FROM dept;

SELECT * 
FROM dept;

--mydept
select *
from mydept;

insert into mydept
select deptno, dname, loc
from dept;

commit;

-- ������ insert all
CREATE TABLE myemp_hire 
AS 
SELECT empno,ename,hiredate,sal 
FROM emp 
WHERE 1=2;

CREATE TABLE myemp_mgr 
AS 
SELECT empno,ename,mgr 
FROM emp 
WHERE 1=2;

select *
from myemp_hire;

select *
from myemp_mgr;

INSERT ALL 
INTO myemp_hire VALUES ( empno,ename,hiredate,sal ) 
INTO myemp_mgr VALUES ( empno,ename,mgr ) 
SELECT empno,ename,hiredate,sal,mgr 
FROM emp;

commit;

SELECT empno,ename,hiredate,sal,mgr 
FROM emp;

-- ���� insert all
CREATE TABLE myemp_hire2
AS 
SELECT empno,ename,hiredate,sal 
FROM emp 
WHERE 1=2;

CREATE TABLE myemp_mgr2 
AS 
SELECT empno,ename,mgr,sal 
FROM emp 
WHERE 1=2;

select *
from myemp_hire2;

select *
from myemp_mgr2;

INSERT ALL
WHEN sal = 800 THEN
 INTO myemp_hire2 VALUES ( empno,ename,hiredate,sal )
WHEN sal < 2500 THEN
 INTO myemp_mgr2 VALUES ( empno,ename,mgr,sal )
SELECT empno,ename,hiredate,sal,mgr
FROM emp;

-- insert first
CREATE TABLE myemp_hire3
AS 
SELECT empno,ename,hiredate,sal 
FROM emp 
WHERE 1=2;

CREATE TABLE myemp_mgr3 
AS 
SELECT empno,ename,mgr,sal 
FROM emp 
WHERE 1=2;

select *
from myemp_hire3;

select *
from myemp_mgr3;

INSERT FIRST
WHEN sal = 800 THEN
 INTO myemp_hire3 VALUES ( empno,ename,hiredate,sal )
WHEN sal < 2500 THEN
 INTO myemp_mgr3 VALUES ( empno,ename,mgr,sal )
SELECT empno,ename,hiredate,sal,mgr
FROM emp;

--update ��
select *
from mydept;

UPDATE mydept 
SET dname='����',loc='���' 
WHERE deptno = 50;

commit;

UPDATE mydept 
SET dname='����',loc='���' ;

rollback;

UPDATE mydept 
SET dname= ( SELECT dname 
             FROM dept 
             WHERE deptno = 10) ,
    loc= ( SELECT loc 
           FROM dept 
           WHERE deptno=20)
WHERE deptno = 60;

select * 
from mydept;

-- delete
DELETE FROM mydept
where deptno = 50;

commit;

DELETE FROM mydept;

DELETE 
FROM mydept 
WHERE loc = (SELECT loc 
             FROM dept 
             WHERE deptno = 20);
             
-- �ѱ� byte Ȯ��
select *
from NLS_DATABASE_PARAMETERS
where parameter = 'NLS_CHARACTERSET';

-- �Ϲ����� ���1
-- ���������� ���� ������ ��� �÷��� �ߺ� �����ϰ� null ������ <- �� Ư¡ ������ ���Ἲ ������ �ȵǼ� �� �Ⱦ�
-- ������ �� �÷��� ������� ���� �÷��� �ڵ����� null �����.
CREATE TABLE scott.employee -- ��Ű��
( empno NUMBER(4), 
  ename VARCHAR2(20), 
  hiredate DATE, 
  sal NUMBER(7,2));
  
CREATE TABLE employee10 -- ��Ű������
( empno NUMBER(4), 
  ename VARCHAR2(20), 
  hiredate DATE, 
  sal NUMBER(7,2));
  
-- �Ϲ����� ���2 - default �ɼ�
CREATE TABLE scott.employee -- ��Ű��
( empno NUMBER(4), 
  ename VARCHAR2(20), 
  hiredate DATE, 
  sal NUMBER(7,2));
  
-- default �ɼ�
CREATE TABLE employee2 
( empno NUMBER(4), 
  ename VARCHAR2(20), 
  hiredate DATE DEFAULT SYSDATE, 
  sal NUMBER(7,2));

INSERT INTO employee2 ( empno,ename,sal) 
VALUES ( 10, 'ȫ�浿',3000);
commit;

select *
from employee2;

-- ��������
-- �������Ǹ�, ���̺�� �����ؾ���
-- �÷������� primary key ��������Ÿ�� ����
CREATE TABLE department 
( deptno NUMBER(2) CONSTRAINT department_deptno_pk PRIMARY KEY, 
  dname VARCHAR2(15), 
  loc VARCHAR2(15) );
  
CREATE TABLE department10
( deptno NUMBER(2) PRIMARY KEY, --�������Ǹ� �ڵ�����, SYSxxx
  dname VARCHAR2(15), 
  loc VARCHAR2(15) );

-- �������� Ȯ��
select *
from user_constraints
where table_name = 'DEPARTMENT10';

-- ���̺� ������ primary key ��������Ÿ�� ����
CREATE TABLE department2
( deptno NUMBER(2), 
  dname VARCHAR2(15), 
  loc VARCHAR2(15) , 
CONSTRAINT department2_deptno_pk PRIMARY KEY(deptno)
);

CREATE TABLE department3
( deptno NUMBER(2), 
  dname VARCHAR2(15), 
  loc VARCHAR2(15) , 
CONSTRAINT department3_deptno_pk PRIMARY KEY(deptno, loc) -- �����÷��� ���̺� ������ ������
);

-- �÷� ������ Unique ��������
CREATE TABLE department4 
( deptno NUMBER(2) CONSTRAINT department4_deptno_pk PRIMARY KEY, -- unique, not null
  dname VARCHAR2(15) CONSTRAINT department4_dname_uk UNIQUE,  -- unique, null ���
  loc VARCHAR2(15) );

insert into department4 ( deptno, dname, loc ) values ( 1, 'aa', 'bb');
insert into department4 ( deptno, dname, loc ) values ( 2, null, 'bb');

-- ���̺� ������ Unique ��������
CREATE TABLE department5
( deptno NUMBER(2) CONSTRAINT department5_deptno_pk PRIMARY KEY, 
  dname VARCHAR2(15), 
  loc VARCHAR2(15),
CONSTRAINT department5_dname_uk UNIQUE(dname)
);

CREATE TABLE department11
( deptno NUMBER(2) , 
  dname VARCHAR2(15), 
  loc VARCHAR2(15),
CONSTRAINT department5_deptno_pk PRIMARY KEY(deptno),
CONSTRAINT department5_dname_uk UNIQUE(dname)
);

-- �÷� ������ not null ��������Ÿ�� ���� 
CREATE TABLE department6 ( deptno NUMBER(2) CONSTRAINT department6_deptno_pk PRIMARY KEY, 
                           dname VARCHAR2(15) CONSTRAINT department6_dname_uk UNIQUE, 
                           loc VARCHAR2(15) CONSTRAINT department6_loc_nn NOT NULL);

CREATE TABLE department12 ( deptno NUMBER(2), 
                           dname VARCHAR2(15) , 
                           loc VARCHAR2(15) CONSTRAINT department12_loc_nn NOT NULL,
                           CONSTRAINT department12_deptno_pk PRIMARY KEY(deptno),
                           CONSTRAINT department12_dname_uk UNIQUE(dname)
                           );
                           
-- ���̺� ������ not null ��������Ÿ���� �����ȵ�

-- �÷� ������ check ��������Ÿ�� ���� 
CREATE TABLE department7
( deptno NUMBER(2) , 
  dname VARCHAR2(15) CONSTRAINT department7_dname_ck CHECK( dname IN('����','�λ�')) ,
  loc VARCHAR2(15) );
  
insert into department7 ( deptno, dname, loc ) values ( 1, '����', 'bb');
insert into department7 ( deptno, dname, loc ) values ( 2, '�λ�', 'bb');
insert into department7 ( deptno, dname, loc ) values ( 3, '����', 'bb'); -- error : dname���� ����, �λ縸 �ü� ���� 

-- ���̺� ������ check ��������Ÿ�� ���� 
CREATE TABLE department8
( deptno NUMBER(2) , 
  dname VARCHAR2(15), 
  loc VARCHAR2(15),
CONSTRAINT department8_dname_ck CHECK( dname IN('����','�λ�'))
);


-- FK �ǽ� - �÷�����

-- master ���̺� ����
create table m1
(  no NUMBER(2) CONSTRAINT m1_no_pk PRIMARY KEY,
  name VARCHAR2(10) );
  
insert into m1 ( no, name ) values ( 10, 'aa');
insert into m1 ( no, name ) values ( 20, 'bb');
insert into m1 ( no, name ) values ( 30, 'cc');
commit;

select *
from m1;

-- slave ���̺�
create table s1
( num NUMBER(4) CONSTRAINT s1_num_pk PRIMARY KEY,
  email VARCHAR2(20),
  -- fk �۾�
  no NUMBER(2) CONSTRAINT s1_no_fk  REFERENCES  m1(no)
);

insert into s1 ( num, email, no ) values ( 100, 'xxx', 10);
insert into s1 ( num, email, no ) values ( 200, 'xxx2', 20);
insert into s1 ( num, email, no ) values ( 300, 'xxx3', 30);
insert into s1 ( num, email, no ) values ( 400, 'xxx4', null);

insert into s1 ( num, email, no ) values ( 500, 'xxx5', 40); -- ����


-- FK �ǽ� - ���̺� ����
-- master ���̺� ����
create table m2
(  no NUMBER(2) CONSTRAINT m2_no_pk PRIMARY KEY,
  name VARCHAR2(10) );
  
insert into m2 ( no, name ) values ( 10, 'aa');
insert into m2 ( no, name ) values ( 20, 'bb');
insert into m2 ( no, name ) values ( 30, 'cc');
commit;

select *
from m2;

-- slave ���̺�
create table s2
( num NUMBER(4) CONSTRAINT s2_num_pk PRIMARY KEY,
  email VARCHAR2(20),
  no NUMBER(2),
  
  -- fk �۾�
   CONSTRAINT s2_no_fk FOREIGN KEY(no) REFERENCES m2(no)
);

insert into s2 ( num, email, no ) values ( 100, 'xxx', 10);
insert into s2 ( num, email, no ) values ( 200, 'xxx2', 20);
insert into s2 ( num, email, no ) values ( 300, 'xxx3', 30);
insert into s2 ( num, email, no ) values ( 400, 'xxx4', null);

insert into s2 ( num, email, no ) values ( 500, 'xxx5', 40); -- ����

-- ##################################################
-- 1. FK �̽� : slave�� �����ϴ� master�� ���� ������ �� ����.
delete from m1
where no = 10;

-- ON DELETE CASCADE
-- master ���̺� ����
create table m3
(  no NUMBER(2) CONSTRAINT m3_no_pk PRIMARY KEY,
  name VARCHAR2(10) );
  
insert into m3 ( no, name ) values ( 10, 'aa');
insert into m3 ( no, name ) values ( 20, 'bb');
insert into m3 ( no, name ) values ( 30, 'cc');
commit;

select *
from m3;

-- slave ���̺�
create table s3
( num NUMBER(4) CONSTRAINT s3_num_pk PRIMARY KEY,
  email VARCHAR2(20),
  -- fk �۾�
  no NUMBER(2) CONSTRAINT s3_no_fk  REFERENCES  m3(no) ON DELETE CASCADE
);

insert into s3 ( num, email, no ) values ( 100, 'xxx', 10);
insert into s3 ( num, email, no ) values ( 200, 'xxx2', 20);
insert into s3 ( num, email, no ) values ( 300, 'xxx3', 30);
insert into s3 ( num, email, no ) values ( 400, 'xxx4', null);
commit;

select *
from m3;

select *
from s3;

delete from m3
where no = 10;

-- ON DELETE SET NULL
-- master ���̺� ����
create table m4
(  no NUMBER(2) CONSTRAINT m4_no_pk PRIMARY KEY,
  name VARCHAR2(10) );
  
insert into m4 ( no, name ) values ( 10, 'aa');
insert into m4 ( no, name ) values ( 20, 'bb');
insert into m4 ( no, name ) values ( 30, 'cc');
commit;

select *
from m4;

-- slave ���̺�
create table s4
( num NUMBER(4) CONSTRAINT s4_num_pk PRIMARY KEY,
  email VARCHAR2(20),
  -- fk �۾�
  no NUMBER(2) CONSTRAINT s4_no_fk  REFERENCES  m4(no) ON DELETE SET NULL
);

insert into s4 ( num, email, no ) values ( 100, 'xxx', 10);
insert into s4 ( num, email, no ) values ( 200, 'xxx2', 20);
insert into s4 ( num, email, no ) values ( 300, 'xxx3', 30);
insert into s4 ( num, email, no ) values ( 400, 'xxx4', null);
commit;

select *
from m4;

select *
from s4;

delete from m4
where no = 10;

-- ���̺� ����
drop table mydept;
drop table mydept10;

-- m1 �� s1 �������� Ȯ��
select *
from user_constraints
where table_name='S1';

select *
from user_constraints
where table_name='M1';

drop table m1 CASCADE CONSTRAINTS; -- master ������ slave �� FK �������� ���� (���� ��������)

select *
from s1;

-- ���̺�����ǽ�
create table student
( studno number(5) constraint student_studno_pk primary key,
  stuname varchar2(10) );

CREATE TABLE subject
( subno NUMBER(5), 
  subname VARCHAR2(20) constraint subject_subname_nn not null,
  term VARCHAR2(1) , 
  type VARCHAR2(4) , 
CONSTRAINT subject_subno_pk PRIMARY KEY(subno),
constraint subject_term_ck check(term in('1','2')),
constraint subject_type_ck check(type in('�ʼ�','����'))
);

create table sugang
( studno number(5),
  subno number(5),
  regdate date,
  resut number(3),
  constraint sugang_studno_subno_pk primary key(studno,subno),
  constraint sugang_studno_fk foreign key(studno) references student(studno),
  constraint sugang_subno_fk foreign key(subno) references subject(subno)
);

--���̺���

CREATE TABLE emp04 
AS 
SELECT * FROM emp;

--�÷��߰�
ALTER TABLE emp04 
ADD ( email VARCHAR2(10) , address VARCHAR2(20) );

--�÷����� - ũ�⺯��
ALTER TABLE emp04 
MODIFY ( email VARCHAR2(40) );

--�÷�����
ALTER TABLE emp04 
DROP ( email );

desc emp04;

select *
from emp04;

CREATE TABLE dept03 
( deptno NUMBER(2), 
  dname VARCHAR2(15), 
  loc VARCHAR2(15) );
  
-- ���߿� �������� �߰� <- �������� ���� ����ϴ� ���
ALTER TABLE dept03
ADD CONSTRAINT dept03_deptno_pk PRIMARY KEY(deptno);

ALTER TABLE dept03
ADD CONSTRAINT dept03_loc_uk UNIQUE(loc);

-- NULL ==> not null (�����۾�)
ALTER TABLE dept03
MODIFY ( dname VARCHAR2(15) CONSTRAINT dept03_dname_nn NOT NULL );

-- Primary key ����
ALTER TABLE dept03
DROP PRIMARY KEY;

-- Unique ����
ALTER TABLE dept03
DROP UNIQUE(loc);

-- Not Null ����
ALTER TABLE dept03
DROP CONSTRAINT dept03_dname_nn;

SELECT *
FROM user_constraints
WHERE table_name='DEPT03';

--####################################
SELECT *
FROM user_constraints
WHERE table_name='M2';

SELECT *
FROM user_constraints
WHERE table_name='S2';

-- m2�� primary key ���� 
ALTER TABLE m2
DROP PRIMARY KEY CASCADE; -- M2, S2 �������� ����

--view
--������ SQL��
SELECT empno,ename, d.dname, d.deptno 
FROM emp e JOIN dept d ON e.deptno = d.deptno 
WHERE e.deptno = 20;

--������ SQL�� ==> �ܼ�ȭ
CREATE VIEW emp_view 
AS
SELECT empno,ename, d.dname, d.deptno 
FROM emp e JOIN dept d ON e.deptno = d.deptno 
WHERE e.deptno = 20;

CREATE VIEW emp_view10 (no,name,dname,dno)
AS
SELECT empno,ename, d.dname, d.deptno 
FROM emp e JOIN dept d ON e.deptno = d.deptno 
WHERE e.deptno = 20;

-- view ����
select *
from emp_view;

-- ���̺��� Ư�� �÷� ��ȣ ����
-- emp�� sal�� �ſ� �ΰ��� �÷��̶�� ����
CREATE VIEW emp_view2 
AS 
SELECT empno,ename,job,mgr,hiredate,comm,deptno 
FROM emp;

select *
from emp_view2;

SELECT view_name, text 
FROM user_views;

-- �� ���� ==> alter view sql���� ����. create or replace �̿�
CREATE OR REPLACE VIEW emp_view2 -- ������ ���λ���, ������ �������
AS 
SELECT empno,ename,job
FROM emp;

--CTAS
create table copy_emp
as
select *
from emp;

select *
from copy_emp;

create or replace view copy_emp_view
as
select *
from copy_emp; -- Base Table : view�� ���� �� �� ���̺�

select *
from copy_emp_view;

-- view�� DML �۾� - (���� ���̺� ������, view ������ �� group by, distinct �� ����� DML �ȵ�)
DELETE FROM copy_emp_view
where deptno = 20;

-- DML �Ұ����ϵ��� �б��� �� ����
create or replace view copy_emp_view2
as
select *
from copy_emp -- Base Table
with read only; -- DML �Ұ�

-- ����
DELETE FROM copy_emp_view2
where deptno = 20;

-- view�� sql���� ������ �ִ� ���� Ȯ���� �� ���� (DATA�� ������ �ִ°� �ƴ�)
SELECT * 
FROM user_views; 

-- �� ����
drop view COPY_EMP_VIEW2;

-- ������
-- base table
create table copy_dept
as
select deptno as no, dname as name, loc as addr
from dept
where 1=2;

select *
from copy_dept;

CREATE SEQUENCE copy_dept_no_seq 
START WITH 10    -- 10���� ����
INCREMENT BY 10  -- 10�� ����
MAXVALUE 100     -- �ִ� 100����
MINVALUE 5       -- �ּڰ� 5 ����
CYCLE            -- �ٽ� ���۰��� MINVALUE �� ���� ������
NOCACHE;         -- �̸� ��������

-- ���������� ���� �������� ��� : ��������.nextval, ���� �� Ȯ�� : ��������.currval
select copy_dept_no_seq.nextval
from dual;

CREATE SEQUENCE dept_deptno_seq2
START WITH 100
INCREMENT BY -10
MAXVALUE 150 
MINVALUE 10 
CYCLE            -- �ٽ� ���۰��� maxvalue����
NOCACHE;

select dept_deptno_seq2.nextval,dept_deptno_seq2.currval
from dual;

CREATE SEQUENCE my_seq;

-- ��Ÿ���� ( start with �� ������ ���� ==> ������ ������ start with �����Ұ�)
select *
from user_sequences;

--my_seq ������ �̿��ؼ� copy_dept ���̺��� no �÷��� �ѹ���..
insert into copy_dept (no, name, addr) values (my_seq.nextval, 'aa', '����');
insert into copy_dept (no, name, addr) values (my_seq.nextval, 'bb', '����');
insert into copy_dept (no, name, addr) values (my_seq.nextval, 'cc', '����');

select *
from copy_dept;

drop sequence DEPT_DEPTNO_SEQ2;

-- index ��ü�� ������ �ִ� �ּҰ�: rowid
select rowid, empno, ename
from emp;

--AAAE+K   AAE    AAAAIv  AAA
--���̺����� �������� ������ ������������

select *
from USER_INDEXES
where TABLE_NAME = 'EMP'; -- pk�� empno ������ �ε����� ������.

select *
from emp;

-- ename�� �ε��� �߰� ==> ���� �� BƮ���� �����ϴ� ������尡 �ſ� ũ��. ���� �ε����� �����ϸ� �ȵȴ�.
CREATE INDEX emp_ename_idx 
ON emp(ename);

select *
from emp
where ename = 'SMITH';

select *
from emp
where UPPER(ename) = 'SMITH'; -- �Լ��� �ε��� �ȵ�

select *
from USER_INDEXES
where TABLE_NAME = 'EMP'; -- pk�� empno ������ �ε����� ������.

DROP INDEX emp_ename_idx;

select deptno as no, dname, loc 
from dept;

-- �Խ��� ���̺� �ۼ�
create table board
( num NUMBER(4) CONSTRAINT board_num_pk PRIMARY KEY,
  title VARCHAR2(200) CONSTRAINT board_title_nn NOT NULL,
  author VARCHAR2(20) CONSTRAINT board_author_nn NOT NULL,
  content VARCHAR2(400),
  writeday DATE DEFAULT SYSDATE,
  readcnt NUMBER(4) DEFAULT 0 );
  
create sequence board_seq;

insert into board ( num, title, author, content )
values ( board_seq.nextval , '�׽�Ʈ', 'ȫ�浿', '�׽�Ʈ�Դϴ�' );
commit;