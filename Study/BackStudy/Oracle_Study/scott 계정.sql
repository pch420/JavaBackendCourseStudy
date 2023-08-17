SHOW USER;

INSERT INTO dept( deptno, dname, loc ) 
VALUES ( 50 ,'개발','서울');

INSERT INTO dept( deptno, dname) 
VALUES ( 51 , '개발');

INSERT INTO dept 
VALUES ( 60 ,'인사','경기');

-- error 발생됨
INSERT INTO dept 
VALUES ( 61 ,'인사');

INSERT INTO dept(deptno, dname , loc ) 
VALUES ( 80 ,'인사', NULL );

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

-- 무조건 insert all
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

-- 조건 insert all
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

--update 문
select *
from mydept;

UPDATE mydept 
SET dname='영업',loc='경기' 
WHERE deptno = 50;

commit;

UPDATE mydept 
SET dname='영업',loc='경기' ;

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
             
-- 한글 byte 확인
select *
from NLS_DATABASE_PARAMETERS
where parameter = 'NLS_CHARACTERSET';

-- 일반적인 방법1
-- 제약조건이 없기 때문에 모든 컬럼에 중복 가능하고 null 가능함 <- 이 특징 때문에 무결성 보장이 안되서 잘 안씀
-- 저장할 때 컬럼을 명시하지 않은 컬럼은 자동으로 null 저장됨.
CREATE TABLE scott.employee -- 스키마
( empno NUMBER(4), 
  ename VARCHAR2(20), 
  hiredate DATE, 
  sal NUMBER(7,2));
  
CREATE TABLE employee10 -- 스키마생략
( empno NUMBER(4), 
  ename VARCHAR2(20), 
  hiredate DATE, 
  sal NUMBER(7,2));
  
-- 일반적인 방법2 - default 옵션
CREATE TABLE scott.employee -- 스키마
( empno NUMBER(4), 
  ename VARCHAR2(20), 
  hiredate DATE, 
  sal NUMBER(7,2));
  
-- default 옵션
CREATE TABLE employee2 
( empno NUMBER(4), 
  ename VARCHAR2(20), 
  hiredate DATE DEFAULT SYSDATE, 
  sal NUMBER(7,2));

INSERT INTO employee2 ( empno,ename,sal) 
VALUES ( 10, '홍길동',3000);
commit;

select *
from employee2;

-- 제약조건
-- 제약조건명, 테이블명 유일해야함
-- 컬럼레벨의 primary key 제약조건타입 지정
CREATE TABLE department 
( deptno NUMBER(2) CONSTRAINT department_deptno_pk PRIMARY KEY, 
  dname VARCHAR2(15), 
  loc VARCHAR2(15) );
  
CREATE TABLE department10
( deptno NUMBER(2) PRIMARY KEY, --제약조건명 자동생성, SYSxxx
  dname VARCHAR2(15), 
  loc VARCHAR2(15) );

-- 제약조건 확인
select *
from user_constraints
where table_name = 'DEPARTMENT10';

-- 테이블 레벨의 primary key 제약조건타입 지정
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
CONSTRAINT department3_deptno_pk PRIMARY KEY(deptno, loc) -- 복합컬럼은 테이블 레벨만 가능함
);

-- 컬럼 레벨의 Unique 제약조건
CREATE TABLE department4 
( deptno NUMBER(2) CONSTRAINT department4_deptno_pk PRIMARY KEY, -- unique, not null
  dname VARCHAR2(15) CONSTRAINT department4_dname_uk UNIQUE,  -- unique, null 허용
  loc VARCHAR2(15) );

insert into department4 ( deptno, dname, loc ) values ( 1, 'aa', 'bb');
insert into department4 ( deptno, dname, loc ) values ( 2, null, 'bb');

-- 테이블 레벨의 Unique 제약조건
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

-- 컬럼 레벨의 not null 제약조건타입 지정 
CREATE TABLE department6 ( deptno NUMBER(2) CONSTRAINT department6_deptno_pk PRIMARY KEY, 
                           dname VARCHAR2(15) CONSTRAINT department6_dname_uk UNIQUE, 
                           loc VARCHAR2(15) CONSTRAINT department6_loc_nn NOT NULL);

CREATE TABLE department12 ( deptno NUMBER(2), 
                           dname VARCHAR2(15) , 
                           loc VARCHAR2(15) CONSTRAINT department12_loc_nn NOT NULL,
                           CONSTRAINT department12_deptno_pk PRIMARY KEY(deptno),
                           CONSTRAINT department12_dname_uk UNIQUE(dname)
                           );
                           
-- 테이블 레벨의 not null 제약조건타입은 지원안됨

-- 컬럼 레벨의 check 제약조건타입 지정 
CREATE TABLE department7
( deptno NUMBER(2) , 
  dname VARCHAR2(15) CONSTRAINT department7_dname_ck CHECK( dname IN('개발','인사')) ,
  loc VARCHAR2(15) );
  
insert into department7 ( deptno, dname, loc ) values ( 1, '개발', 'bb');
insert into department7 ( deptno, dname, loc ) values ( 2, '인사', 'bb');
insert into department7 ( deptno, dname, loc ) values ( 3, '관리', 'bb'); -- error : dname에는 개발, 인사만 올수 있음 

-- 테이블 레벨의 check 제약조건타입 지정 
CREATE TABLE department8
( deptno NUMBER(2) , 
  dname VARCHAR2(15), 
  loc VARCHAR2(15),
CONSTRAINT department8_dname_ck CHECK( dname IN('개발','인사'))
);


-- FK 실습 - 컬럼레벨

-- master 테이블 생성
create table m1
(  no NUMBER(2) CONSTRAINT m1_no_pk PRIMARY KEY,
  name VARCHAR2(10) );
  
insert into m1 ( no, name ) values ( 10, 'aa');
insert into m1 ( no, name ) values ( 20, 'bb');
insert into m1 ( no, name ) values ( 30, 'cc');
commit;

select *
from m1;

-- slave 테이블
create table s1
( num NUMBER(4) CONSTRAINT s1_num_pk PRIMARY KEY,
  email VARCHAR2(20),
  -- fk 작업
  no NUMBER(2) CONSTRAINT s1_no_fk  REFERENCES  m1(no)
);

insert into s1 ( num, email, no ) values ( 100, 'xxx', 10);
insert into s1 ( num, email, no ) values ( 200, 'xxx2', 20);
insert into s1 ( num, email, no ) values ( 300, 'xxx3', 30);
insert into s1 ( num, email, no ) values ( 400, 'xxx4', null);

insert into s1 ( num, email, no ) values ( 500, 'xxx5', 40); -- 에러


-- FK 실습 - 테이블 레벨
-- master 테이블 생성
create table m2
(  no NUMBER(2) CONSTRAINT m2_no_pk PRIMARY KEY,
  name VARCHAR2(10) );
  
insert into m2 ( no, name ) values ( 10, 'aa');
insert into m2 ( no, name ) values ( 20, 'bb');
insert into m2 ( no, name ) values ( 30, 'cc');
commit;

select *
from m2;

-- slave 테이블
create table s2
( num NUMBER(4) CONSTRAINT s2_num_pk PRIMARY KEY,
  email VARCHAR2(20),
  no NUMBER(2),
  
  -- fk 작업
   CONSTRAINT s2_no_fk FOREIGN KEY(no) REFERENCES m2(no)
);

insert into s2 ( num, email, no ) values ( 100, 'xxx', 10);
insert into s2 ( num, email, no ) values ( 200, 'xxx2', 20);
insert into s2 ( num, email, no ) values ( 300, 'xxx3', 30);
insert into s2 ( num, email, no ) values ( 400, 'xxx4', null);

insert into s2 ( num, email, no ) values ( 500, 'xxx5', 40); -- 에러

-- ##################################################
-- 1. FK 이슈 : slave가 참조하는 master의 값을 삭제할 수 없다.
delete from m1
where no = 10;

-- ON DELETE CASCADE
-- master 테이블 생성
create table m3
(  no NUMBER(2) CONSTRAINT m3_no_pk PRIMARY KEY,
  name VARCHAR2(10) );
  
insert into m3 ( no, name ) values ( 10, 'aa');
insert into m3 ( no, name ) values ( 20, 'bb');
insert into m3 ( no, name ) values ( 30, 'cc');
commit;

select *
from m3;

-- slave 테이블
create table s3
( num NUMBER(4) CONSTRAINT s3_num_pk PRIMARY KEY,
  email VARCHAR2(20),
  -- fk 작업
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
-- master 테이블 생성
create table m4
(  no NUMBER(2) CONSTRAINT m4_no_pk PRIMARY KEY,
  name VARCHAR2(10) );
  
insert into m4 ( no, name ) values ( 10, 'aa');
insert into m4 ( no, name ) values ( 20, 'bb');
insert into m4 ( no, name ) values ( 30, 'cc');
commit;

select *
from m4;

-- slave 테이블
create table s4
( num NUMBER(4) CONSTRAINT s4_num_pk PRIMARY KEY,
  email VARCHAR2(20),
  -- fk 작업
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

-- 테이블 삭제
drop table mydept;
drop table mydept10;

-- m1 과 s1 제약조건 확인
select *
from user_constraints
where table_name='S1';

select *
from user_constraints
where table_name='M1';

drop table m1 CASCADE CONSTRAINTS; -- master 삭제시 slave 의 FK 제약조건 삭제 (값은 남아있음)

select *
from s1;

-- 테이블생성실습
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
constraint subject_type_ck check(type in('필수','선택'))
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

--테이블변경

CREATE TABLE emp04 
AS 
SELECT * FROM emp;

--컬럼추가
ALTER TABLE emp04 
ADD ( email VARCHAR2(10) , address VARCHAR2(20) );

--컬럼변경 - 크기변경
ALTER TABLE emp04 
MODIFY ( email VARCHAR2(40) );

--컬럼삭제
ALTER TABLE emp04 
DROP ( email );

desc emp04;

select *
from emp04;

CREATE TABLE dept03 
( deptno NUMBER(2), 
  dname VARCHAR2(15), 
  loc VARCHAR2(15) );
  
-- 나중에 제약조건 추가 <- 현업에서 많이 사용하는 방식
ALTER TABLE dept03
ADD CONSTRAINT dept03_deptno_pk PRIMARY KEY(deptno);

ALTER TABLE dept03
ADD CONSTRAINT dept03_loc_uk UNIQUE(loc);

-- NULL ==> not null (변경작업)
ALTER TABLE dept03
MODIFY ( dname VARCHAR2(15) CONSTRAINT dept03_dname_nn NOT NULL );

-- Primary key 삭제
ALTER TABLE dept03
DROP PRIMARY KEY;

-- Unique 삭제
ALTER TABLE dept03
DROP UNIQUE(loc);

-- Not Null 삭제
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

-- m2의 primary key 삭제 
ALTER TABLE m2
DROP PRIMARY KEY CASCADE; -- M2, S2 제약조건 삭제

--view
--복잡한 SQL문
SELECT empno,ename, d.dname, d.deptno 
FROM emp e JOIN dept d ON e.deptno = d.deptno 
WHERE e.deptno = 20;

--복잡한 SQL문 ==> 단순화
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

-- view 실행
select *
from emp_view;

-- 테이블의 특정 컬럼 보호 목적
-- emp의 sal이 매우 민감한 컬럼이라고 가정
CREATE VIEW emp_view2 
AS 
SELECT empno,ename,job,mgr,hiredate,comm,deptno 
FROM emp;

select *
from emp_view2;

SELECT view_name, text 
FROM user_views;

-- 뷰 수정 ==> alter view sql문은 없다. create or replace 이용
CREATE OR REPLACE VIEW emp_view2 -- 없으면 새로생성, 있으면 덮어쓰기함
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
from copy_emp; -- Base Table : view를 만들 때 쓴 테이블

select *
from copy_emp_view;

-- view의 DML 작업 - (원본 테이블도 수정됨, view 생성할 때 group by, distinct 등 적용시 DML 안됨)
DELETE FROM copy_emp_view
where deptno = 20;

-- DML 불가능하도록 읽기모드 뷰 생성
create or replace view copy_emp_view2
as
select *
from copy_emp -- Base Table
with read only; -- DML 불가

-- 에러
DELETE FROM copy_emp_view2
where deptno = 20;

-- view가 sql문을 가지고 있는 것을 확인할 수 있음 (DATA를 가지고 있는게 아님)
SELECT * 
FROM user_views; 

-- 뷰 삭제
drop view COPY_EMP_VIEW2;

-- 시퀀스
-- base table
create table copy_dept
as
select deptno as no, dname as name, loc as addr
from dept
where 1=2;

select *
from copy_dept;

CREATE SEQUENCE copy_dept_no_seq 
START WITH 10    -- 10부터 시작
INCREMENT BY 10  -- 10씩 증가
MAXVALUE 100     -- 최댓값 100까지
MINVALUE 5       -- 최솟값 5 까지
CYCLE            -- 다시 시작값은 MINVALUE 값 부터 시작함
NOCACHE;         -- 미리 생성안함

-- 시퀀스에서 값을 가져오는 방법 : 시퀀스명.nextval, 현재 값 확인 : 시퀀스명.currval
select copy_dept_no_seq.nextval
from dual;

CREATE SEQUENCE dept_deptno_seq2
START WITH 100
INCREMENT BY -10
MAXVALUE 150 
MINVALUE 10 
CYCLE            -- 다시 시작값은 maxvalue부터
NOCACHE;

select dept_deptno_seq2.nextval,dept_deptno_seq2.currval
from dual;

CREATE SEQUENCE my_seq;

-- 메타정보 ( start with 값 정보는 없음 ==> 시퀀스 수정시 start with 수정불가)
select *
from user_sequences;

--my_seq 시퀀스 이용해서 copy_dept 테이블의 no 컬럼을 넘버링..
insert into copy_dept (no, name, addr) values (my_seq.nextval, 'aa', '서울');
insert into copy_dept (no, name, addr) values (my_seq.nextval, 'bb', '서울');
insert into copy_dept (no, name, addr) values (my_seq.nextval, 'cc', '서울');

select *
from copy_dept;

drop sequence DEPT_DEPTNO_SEQ2;

-- index 객체가 가지고 있는 주소값: rowid
select rowid, empno, ename
from emp;

--AAAE+K   AAE    AAAAIv  AAA
--테이블정보 파일정보 블럭정보 블럭내의행정보

select *
from USER_INDEXES
where TABLE_NAME = 'EMP'; -- pk인 empno 때문에 인덱스가 존재함.

select *
from emp;

-- ename에 인덱스 추가 ==> 정렬 및 B트리를 구현하는 오버헤드가 매우 크다. 따라서 인덱스는 남발하면 안된다.
CREATE INDEX emp_ename_idx 
ON emp(ename);

select *
from emp
where ename = 'SMITH';

select *
from emp
where UPPER(ename) = 'SMITH'; -- 함수는 인덱스 안됨

select *
from USER_INDEXES
where TABLE_NAME = 'EMP'; -- pk인 empno 때문에 인덱스가 존재함.

DROP INDEX emp_ename_idx;

select deptno as no, dname, loc 
from dept;

-- 게시판 테이블 작성
create table board
( num NUMBER(4) CONSTRAINT board_num_pk PRIMARY KEY,
  title VARCHAR2(200) CONSTRAINT board_title_nn NOT NULL,
  author VARCHAR2(20) CONSTRAINT board_author_nn NOT NULL,
  content VARCHAR2(400),
  writeday DATE DEFAULT SYSDATE,
  readcnt NUMBER(4) DEFAULT 0 );
  
create sequence board_seq;

insert into board ( num, title, author, content )
values ( board_seq.nextval , '테스트', '홍길동', '테스트입니다' );
commit;