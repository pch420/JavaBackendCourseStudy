show user;

DESC employees;
DESC departments;

-- 1. ��� �÷� ����
SELECT * FROM employees;
select * 
from EMPLOYEES;

SELECT * FROM departments;

-- 2. Ư�� �÷� ���� (�÷� �ص��� ���� select ������ ���� �״�� ����
SELECT employee_id, last_name, hire_date, salary
FROM employees;

-- 3. ���� ���� (������� �÷�������� ǥ�õǾ� ��µ�)
SELECT last_name, salary, salary * 12
FROM employees;

-- 4. ��Ī
SELECT last_name as �̸�, salary ����, salary * 12 as ����
FROM employees;

SELECT last_name as "��� �̸�", salary "��� ����", salary * 12 as "�� ��" 
FROM employees;

-- 5. null
SELECT last_name �̸�, salary ����, commission_pct ������,
salary* 12+commission_pct as ����
FROM employees;

SELECT last_name �̸�, salary ����, commission_pct ������,
salary * 12+NVL(commission_pct,0) as ����
FROM employees;

-- 6. ����: �÷� || �÷�
SELECT last_name || salary as "�̸� ����" 
FROM employees;

-- 6. ����: �÷� || '��'
SELECT last_name || '���'
FROM employees;

SELECT last_name || '�� ������ ' || job_id || ' �Դϴ�' as "����� ����" 
FROM employees;

-- 7. �ߺ�����
SELECT job_id 
FROM employees;

SELECT DISTINCT job_id 
FROM employees;

--//////////////////////////
-- 8. where ���� �� ������
SELECT employee_id,last_name,job_id, salary 
FROM employees
WHERE salary >= 10000;

SELECT employee_id,last_name,job_id, salary 
FROM employees
WHERE last_name = 'King';
-- SQL���� �ĺ��ڴ� ��ҹ��� ������ �������� ��(���ͳ�)�� ��ҹ��ڸ� �����Ѵ�.
SELECT employee_id,last_name,job_id, salary 
FROM employees
WHERE last_name = 'KING';

SELECT employee_id,last_name,salary,hire_date 
FROM employees
WHERE hire_date > '07/12/31';

-- 8. Between a AND b <- a, b ����
SELECT employee_id,last_name,salary,hire_date 
FROM employees
WHERE salary BETWEEN 7000 AND 8000;

SELECT employee_id,last_name,salary,hire_date 
FROM employees
WHERE hire_date BETWEEN '07/01/01' AND '08/12/31';

-- 9. in ������
SELECT employee_id,last_name,salary,hire_date 
FROM employees
WHERE employee_id IN ( 100,200,300 );

SELECT employee_id,last_name,salary,hire_date 
FROM employees
WHERE last_name IN ( 'King','Abel','Jones');

SELECT employee_id,last_name,salary,hire_date 
FROM employees 
WHERE hire_date IN ( '01/01/13','07/02/07');

-- 10. like + ���ϵ�ī�幮��( %, _ )
SELECT employee_id,last_name,salary 
FROM employees
WHERE last_name LIKE 'J%';

SELECT employee_id,last_name,salary 
FROM employees
WHERE last_name LIKE '%ai%';

SELECT employee_id,last_name,salary 
FROM employees
WHERE last_name LIKE '%in';

SELECT employee_id,last_name,salary 
FROM employees
WHERE last_name LIKE '_b%';

SELECT employee_id,last_name,salary 
FROM employees 
WHERE last_name LIKE '_____d';

SELECT employee_id,last_name,salary 
FROM employees 
WHERE last_name LIKE '%_%';

SELECT employee_id,last_name,salary,job_id 
FROM employees
WHERE job_id LIKE '%E___' ESCAPE 'E';

-- 11. �� ������ - and
SELECT last_name,job_id,salary 
FROM employees
WHERE job_id = 'IT_PROG' AND salary >= 5000;

-- 11. �� ������ - or
SELECT last_name,job_id,salary 
FROM employees
WHERE job_id = 'IT_PROG' OR salary >= 5000;

-- 11. �� ������ - not
SELECT last_name,job_id,salary 
FROM employees 
WHERE NOT salary < 20000;

SELECT last_name,job_id,salary 
FROM employees 
WHERE salary NOT IN (9000,8000,6000 );

SELECT last_name,job_id,salary 
FROM employees 
WHERE last_name NOT LIKE 'J%';

SELECT last_name,job_id,salary 
FROM employees 
WHERE salary NOT BETWEEN 2400 AND 20000;

SELECT last_name,job_id,salary 
FROM employees 
WHERE commission_pct IS NULL;

SELECT last_name,job_id,salary 
FROM employees 
WHERE MANAGER_ID IS NULL; -- ����

SELECT last_name,job_id,salary 
FROM employees 
WHERE manager_id IS NOT NULL;

-- �� ������ ���� ����: and �� or���� �켱������ ����.
SELECT last_name,job_id,salary,commission_pct 
FROM employees 
WHERE job_id ='AC_MGR' OR job_id='MK_REP' 
AND commission_pct IS NULL 
AND salary >=4000 
AND salary <= 9000;

SELECT last_name,job_id,salary,commission_pct 
FROM employees 
WHERE ( job_id ='AC_MGR' OR job_id='MK_REP' ) 
AND commission_pct IS NULL 
AND salary >=4000 
AND salary <= 9000;

-//////////////////////////////////////
-- 12 ����
SELECT employee_id,last_name,job_id,salary 
FROM employees
ORDER BY salary DESC;

SELECT employee_id,last_name,job_id,salary 
FROM employees
ORDER BY salary asc;

SELECT employee_id,last_name,job_id,salary 
FROM employees
ORDER BY salary; --�⺻�� ��������

SELECT employee_id,last_name,job_id,salary as "����" 
FROM employees
ORDER BY ���� DESC;

SELECT employee_id,last_name,job_id,salary as "����" 
FROM employees
ORDER BY 4 DESC;

SELECT employee_id,last_name as �̸�,job_id,salary 
FROM employees
ORDER BY last_name ASC; -- A:65 B:66

SELECT employee_id,last_name as �̸�,job_id,salary 
FROM employees
ORDER �̸� ASC;

SELECT employee_id,last_name as �̸�,job_id,salary 
FROM employees
ORDER BY 2 ASC;

SELECT employee_id,last_name,salary,hire_date as �Ի��� 
FROM employees
ORDER BY hire_date DESC;

SELECT employee_id,last_name,salary,hire_date as �Ի��� 
FROM employees
ORDER BY �Ի��� DESC;

SELECT employee_id,last_name,salary,hire_date as �Ի��� 
FROM employees
ORDER BY 4 DESC;

SELECT employee_id,last_name,salary,hire_date 
FROM employees
ORDER BY salary DESC, hire_date;

SELECT employee_id,last_name,salary,hire_date 
FROM employees
ORDER BY salary DESC, hire_date DESC;

SELECT employee_id,last_name,salary,hire_date 
FROM employees
ORDER BY 3 DESC, 4;

SELECT employee_id,last_name,salary,hire_date, COMMISSION_PCT
FROM employees
order by COMMISSION_PCT desc; -- ����Ŭ���� null ���� ���� ū ������ ó����

-- dual
select 25487*895632
from dual;
select sysdate
from dual;

-- 13. ������ �Լ� - �����Լ�
-- ù���ڸ� �빮��
SELECT INITCAP('ORACLE SQL')
FROM dual;

SELECT email, INITCAP(email)
FROM employees;

-- ��� �빮��
SELECT last_name, UPPER(last_name)
FROM employees;

SELECT last_name, salary
FROM employees
WHERE UPPER(last_name)='KING';

-- ��� �ҹ���
SELECT last_name, LOWER(last_name)
FROM employees;

-- ���ڿ� ����
SELECT CONCAT( last_name, salary)
FROM employees;

SELECT last_name || salary
FROM employees;

-- ���ڿ� ����
SELECT last_name, LENGTH(last_name)
FROM employees;

-- Ư������ ��ġ
SELECT INSTR('MILLER' , 'L', 1 , 2 ), INSTR('MILLER' , 'X', 1 , 2 )
FROM dual;

SELECT INSTR('MILLER' , 'L', 5 , 2 ), INSTR('MILLER' , 'X', 1 , 2 )
FROM dual;

-- �κп�
SELECT SUBSTR('900303-1234567' , 8 , 1 ) 
FROM dual;

SELECT SUBSTR('900303-1234567' , 8) 
FROM dual;

SELECT hire_date �Ի���, SUBSTR(hire_date,1,2) �Ի�⵵
FROM employees;

-- ġȯ
SELECT REPLACE('JACK and JUE' , 'J' , 'BL' ) 
FROM dual;

-- ���� ä���
SELECT LPAD('MILLER',10,'*')
FROM dual;

-- ������ ä���
SELECT RPAD('MILLER',10,'*')
FROM dual;

-- ���� �� Ư������ ���� - ����
SELECT LTRIM('MILLER', 'M') 
FROM dual;

SELECT LTRIM('MMMMMILMLER', 'M') 
FROM dual;

SELECT LTRIM('     MILLER     '), LENGTH(LTRIM('     MILLER     ')) 
FROM dual;

-- ���� �� Ư������ ���� - ������
SELECT RTRIM('MILLER', 'R') 
FROM dual;

SELECT RTRIM('MILRLERRRRRRRRRRR', 'R') 
FROM dual;

SELECT RTRIM('     MILLER     '), LENGTH(LTRIM('     MILLER     ')) 
FROM dual;

-- ���� �� Ư������ ���� - ����, ������, ����
SELECT TRIM( '0' FROM '0001234567000' ) 
FROM dual;
SELECT TRIM(BOTH '0' FROM '0001234567000' ) 
FROM dual;

SELECT TRIM(LEADING '0' FROM '0001234567000' ) 
FROM dual;

SELECT TRIM(TRAILING '0' FROM '0001234567000' ) 
FROM dual;

-- �ݿø�
SELECT ROUND( 456.789, 2 ) 
FROM dual;

SELECT ROUND( 456.789, -1 ) 
FROM dual;

SELECT ROUND( 456.789 ) 
FROM dual;

-- ����
SELECT TRUNC( 456.789, 2 ) 
FROM dual;

SELECT TRUNC( 456.789, -1 ) 
FROM dual;

SELECT TRUNC( 456.789 ) 
FROM dual;

-- ������ (% �����ڴ� �������� ��� �Ұ�- like�� ���ϵ�ī����)
SELECT MOD( 10 , 3 ) , MOD( 10 , 0 ) 
FROM dual;

-- �ø�
SELECT CEIL(10.6), CEIL(-10.6) 
FROM dual;

-- ����
SELECT FLOOR(10.6), FLOOR(-10.6) 
FROM dual;

-- ��� ���� 0 �Ǵ� ����� 1, ������ -1, 0�̸� 0 ��ȯ
SELECT SIGN( 100 ) , SIGN(-20) , SIGN(0) 
FROM dual;

-- ����Ŭ�� ����� ���� ���� �Ķ���� �������� �˾ƺ���
select * 
from NLS_SESSION_PARAMETERS;

-- ��¥ RR YY ���� �˾ƺ���
CREATE TABLE EXAM
(a DATE, b date);

insert into EXAM (a,b)
values ( to_date('15/01/01','RR/MM/DD'), to_date('15/01/01','YY/MM/DD'));

SELECT TO_CHAR(A,'RRRR'), TO_CHAR(B, 'YYYY')
FROM EXAM;

-- ���� ��¥ ��ȯ
SELECT SYSDATE , SYSTIMESTAMP
FROM dual;

-- ���� ���
SELECT SYSDATE ����, SYSDATE+1 ����, SYSDATE-1 ����, SYSDATE+30 ������
FROM dual;

SELECT last_name, hire_date, TRUNC((sysdate-hire_date)/365) "��" 
FROM employees 
ORDER BY TRUNC((sysdate-hire_date)/365) desc;

SELECT last_name, hire_date, TRUNC((sysdate-hire_date)/365) "��" 
FROM employees 
ORDER BY 3 desc;

SELECT last_name, hire_date, TRUNC((sysdate-hire_date)/365) "��" 
FROM employees 
ORDER BY �� desc;

-- ������ �� ��¥�� ������ ��ȯ
SELECT last_name, hire_date, TRUNC(MONTHS_BETWEEN(sysdate, hire_date)) "�ٹ� ����" 
FROM employees 
ORDER BY 3 desc;

-- �� ���ϱ� �� ����
SELECT sysdate ����, ADD_MONTHS(sysdate,1) ������, ADD_MONTHS(sysdate,-1) ������ 
FROM dual;

-- ������ ��¥���ؿ� ���� ����� ������ ��¥ ��ȯ
SELECT SYSDATE, NEXT_DAY(SYSDATE, '��'), NEXT_DAY(SYSDATE, '�����'), NEXT_DAY(SYSDATE, 7)
FROM DUAL; 

-- ������ ��¥�� ���� ������ ��¥ ��ȯ
SELECT SYSDATE, LAST_DAY(SYSDATE), LAST_DAY(ADD_MONTHS(SYSDATE,1))
FROM DUAL; 

-- �⵵ �� �� �ݿø�
SELECT last_name, hire_date, ROUND(hire_date,'YEAR'), ROUND(hire_date,'MONTH') 
FROM employees;

-- �⵵ �� �� ����
SELECT last_name, hire_date, TRUNC(hire_date,'YEAR'), TRUNC(hire_date,'MONTH') 
FROM employees;

-- �ڵ� �� ��ȯ
SELECT last_name, salary 
FROM employees
WHERE salary = '17000'; -- ���ڰ� ���ڷ� �ڵ���ȯ

SELECT last_name, salary 
FROM employees
WHERE HIRE_DATE = '03/06/17'; -- ���ڰ� ��¥�� �ڵ���ȯ

-- ����� ����ȯ (��¥ --> ����)
SELECT SYSDATE, TO_CHAR(SYSDATE, 'YYYY'), TO_CHAR(SYSDATE, 'MM')
FROM DUAL;
SELECT SYSDATE, TO_CHAR(SYSDATE, 'YYYY/MM/DD MON DAY DY')
FROM DUAL;
SELECT SYSDATE, TO_CHAR(SYSDATE, 'YYYY"��"MM"��"DD"��"')
FROM DUAL;

SELECT SYSDATE, TO_CHAR(SYSDATE, 'AM HH"��" HH24"��" MI"��" SS"��"')
FROM DUAL;

SELECT TO_CHAR(SYSDATE, 'YYYY/MM/DD,(AM) DY HH24:MI:SS') 
FROM dual;

-- ��¥���� Ư���⵵�� ����, ���� ����, �ϸ� ����
select sysdate, to_char(sysdate, 'YY'), to_char(sysdate, 'MM')
from dual;

select sysdate, EXTRACT(YEAR FROM sysdate)��, 
                EXTRACT(MONTH FROM sysdate)��,
                EXTRACT(DAY FROM sysdate)��,
                EXTRACT(HOUR FROM SYSTIMESTAMP)��,
                EXTRACT(MINUTE FROM SYSTIMESTAMP)��,
                EXTRACT(SECOND FROM SYSTIMESTAMP)��
from dual;

SELECT last_name,hire_date, salary 
FROM employees 
WHERE TO_CHAR(hire_date, 'MM')='09';
-- extract�� �����ϱ�
SELECT last_name,hire_date, salary 
FROM employees
WHERE EXTRACT(MONTH FROM HIRE_DATE)='09';

-- ����� ����ȯ (���� --> ����)
SELECT last_name, salary, TO_CHAR(salary, '$999,999') �޷�, TO_CHAR(salary, 'L999,999') ��ȭ 
FROM employees;

SELECT TO_CHAR(987654321,'L999,999,999')
FROM DUAL;

-- ����� ����ȯ (���� --> ��ġ)
SELECT TO_NUMBER('123') + 100 
FROM dual;

SELECT TO_NUMBER('123,456','999,999') + 100 
FROM dual;

SELECT TO_NUMBER('$123,456','$999,999') + 100 
FROM dual;

-- ����� ����ȯ (���� --> ��¥)
-- ��¥���� ����
ALTER SESSION SET NLS_DATE_FORMAT='YYYY/MM/DD HH24:MI:SS';

SELECT TO_DATE( '20170802181030' , 'YYYYMMDDHH24MISS' ) 
FROM dual;

SELECT TO_DATE( '2017��08��02��' , 'YYYY"��"MM"��"DD"��"' ) 
FROM dual;

SELECT TO_DATE( '20170802181030' , 'YYYYMMDDHH24MISS' ) 
FROM dual;

-- ���� DB�� ��¥�� �����Ѵٸ�?
-- ��. 20170802 (����, raw data)
-- ��. 2017��08��02�� ==> ����1: ����ũ�� �� �ʿ���, ����2: ��½� ���˺����� ��������, ����3: Locale(����ȭ)

-- ����: decode �Լ�
SELECT last_name,salary,DECODE(salary,24000, salary*0.3, 
                                      17000, salary*0.2, 
                                             salary) as "���ʽ�"
FROM employees 
ORDER BY 2 desc;

SELECT COUNT(*) "���ο���",
  SUM(DECODE(TO_CHAR(hire_date, 'YYYY'), 2001, 1, 0)) "2001", 
  SUM(DECODE(TO_CHAR(hire_date, 'YYYY'), 2002, 1, 0)) "2002", 
  SUM(DECODE(TO_CHAR(hire_date, 'YYYY'), 2003, 1, 0)) "2003", 
  SUM(DECODE(TO_CHAR(hire_date, 'YYYY'), 2004, 1, 0)) "2004", 
  SUM(DECODE(TO_CHAR(hire_date, 'YYYY'), 2005, 1, 0)) "2005", 
  SUM(DECODE(TO_CHAR(hire_date, 'YYYY'), 2006, 1, 0)) "2006", 
  SUM(DECODE(TO_CHAR(hire_date, 'YYYY'), 2007, 1, 0)) "2007", 
  SUM(DECODE(TO_CHAR(hire_date, 'YYYY'), 2008, 1, 0)) "2008"
FROM employees;

-- decode �ǽ�

drop table T_HOLHISTORY;

CREATE TABLE T_HOLHISTORY
(
SEQ_NU 		 NUMBER  NOT NULL,	-- ��� ����
YEAR_VC	 	 VARCHAR2(4) NOT NULL,	-- �⵵
EMPNO_VC 	 VARCHAR2(4) NOT NULL,	-- �����ȣ
STDATE_VC 	 VARCHAR2(4) NOT NULL,	--�ް�������
SMA_VC 	 	 VARCHAR2(1) NOT NULL,	--�ް� ���� ���� ����
EDDATE_VC 	 VARCHAR2(4) NOT NULL,	--�ް� ������
EMA_VC 		 VARCHAR2(1) NOT NULL,	--�ް� ���� ���� ����
REASON_VC	 VARCHAR2(100) ,		--�ް� ����
STATE_VC 	 VARCHAR2(2) NOT NULL,	--���� ���� (0 -> �㰡 , 10 -> ��� , 20 ->�Ұ�)	
AEMPNO_VC 	 VARCHAR2(4) NOT NULL,	--�㰡�� ���
REFUSE_VC 	 VARCHAR2(100) ,		-- ���㰡 ����
INDATE_VC 	 VARCHAR2(8)		-- �Է³�¥
);

INSERT INTO T_HOLHISTORY (SEQ_NU,YEAR_VC ,EMPNO_VC ,STDATE_VC,SMA_VC ,EDDATE_VC,EMA_VC ,REASON_VC,STATE_VC ,AEMPNO_VC,REFUSE_VC,INDATE_VC) VALUES (128,2004,'1024','0610',1,'0612',2,'�׳�',10,1001,'',20040528);
INSERT INTO T_HOLHISTORY (SEQ_NU,YEAR_VC ,EMPNO_VC ,STDATE_VC,SMA_VC ,EDDATE_VC,EMA_VC ,REASON_VC,STATE_VC ,AEMPNO_VC,REFUSE_VC,INDATE_VC) VALUES (129,2004,'2018','0612',1,'0615',2,'����',0,2001,'',20040607);
INSERT INTO T_HOLHISTORY (SEQ_NU,YEAR_VC ,EMPNO_VC ,STDATE_VC,SMA_VC ,EDDATE_VC,EMA_VC ,REASON_VC,STATE_VC ,AEMPNO_VC,REFUSE_VC,INDATE_VC) VALUES (130,2004,'3020','0527',2,'0528',1,'�׳�',20,3001,'�׳�',20040520);
INSERT INTO T_HOLHISTORY (SEQ_NU,YEAR_VC ,EMPNO_VC ,STDATE_VC,SMA_VC ,EDDATE_VC,EMA_VC ,REASON_VC,STATE_VC ,AEMPNO_VC,REFUSE_VC,INDATE_VC) VALUES (131,2004,'2022','0713',1,'0713',2,'����',0,2001,'',20040712);
INSERT INTO T_HOLHISTORY (SEQ_NU,YEAR_VC ,EMPNO_VC ,STDATE_VC,SMA_VC ,EDDATE_VC,EMA_VC ,REASON_VC,STATE_VC ,AEMPNO_VC,REFUSE_VC,INDATE_VC) VALUES (132,2004,'1011','0830',1,'0830',2,'�������� ����',0,1001,'',20040801);
INSERT INTO T_HOLHISTORY (SEQ_NU,YEAR_VC ,EMPNO_VC ,STDATE_VC,SMA_VC ,EDDATE_VC,EMA_VC ,REASON_VC,STATE_VC ,AEMPNO_VC,REFUSE_VC,INDATE_VC) VALUES (133,2004,'1002','0515',1,'0515',2,'�㰡 �����ָ� �� ����',0,1001,'',20040311);
INSERT INTO T_HOLHISTORY (SEQ_NU,YEAR_VC ,EMPNO_VC ,STDATE_VC,SMA_VC ,EDDATE_VC,EMA_VC ,REASON_VC,STATE_VC ,AEMPNO_VC,REFUSE_VC,INDATE_VC) VALUES (134,2004,'2027','0811',1,'0811',2,'����',0,2001,'',20040808);
INSERT INTO T_HOLHISTORY (SEQ_NU,YEAR_VC ,EMPNO_VC ,STDATE_VC,SMA_VC ,EDDATE_VC,EMA_VC ,REASON_VC,STATE_VC ,AEMPNO_VC,REFUSE_VC,INDATE_VC) VALUES (135,2004,'1024','0915',2,'0915',2,'�������ߵ�',0,1001,'',20040808);
INSERT INTO T_HOLHISTORY (SEQ_NU,YEAR_VC ,EMPNO_VC ,STDATE_VC,SMA_VC ,EDDATE_VC,EMA_VC ,REASON_VC,STATE_VC ,AEMPNO_VC,REFUSE_VC,INDATE_VC) VALUES (136,2004,'1024','0913',1,'0913',1,'�׳�',0,1001,'',20040808);
INSERT INTO T_HOLHISTORY (SEQ_NU,YEAR_VC ,EMPNO_VC ,STDATE_VC,SMA_VC ,EDDATE_VC,EMA_VC ,REASON_VC,STATE_VC ,AEMPNO_VC,REFUSE_VC,INDATE_VC) VALUES (137,2004,'3017','0924',1,'0924',2,'����;',20,3001,'���� ���� �ʹ١�', 20040808);
INSERT INTO T_HOLHISTORY (SEQ_NU,YEAR_VC ,EMPNO_VC ,STDATE_VC,SMA_VC ,EDDATE_VC,EMA_VC ,REASON_VC,STATE_VC ,AEMPNO_VC,REFUSE_VC,INDATE_VC) VALUES (138,2004,'4021','0905',1,'0909',2,'�ް�',0,4001,'',20040808);
INSERT INTO T_HOLHISTORY (SEQ_NU,YEAR_VC ,EMPNO_VC ,STDATE_VC,SMA_VC ,EDDATE_VC,EMA_VC ,REASON_VC,STATE_VC ,AEMPNO_VC,REFUSE_VC,INDATE_VC) VALUES (139,2004,'5003','0905',2,'0905',1,'��ĥ������',0,5001,'',20040808);
INSERT INTO T_HOLHISTORY (SEQ_NU,YEAR_VC ,EMPNO_VC ,STDATE_VC,SMA_VC ,EDDATE_VC,EMA_VC ,REASON_VC,STATE_VC ,AEMPNO_VC,REFUSE_VC,INDATE_VC) VALUES (140,2004,'6028','0904',2,'0905',1,'�ް�',0,6001,'',20040811);
INSERT INTO T_HOLHISTORY (SEQ_NU,YEAR_VC ,EMPNO_VC ,STDATE_VC,SMA_VC ,EDDATE_VC,EMA_VC ,REASON_VC,STATE_VC ,AEMPNO_VC,REFUSE_VC,INDATE_VC) VALUES (141,2004,'6002','0901',1,'0903',2,'����;��',0,6001,'',20040824);
INSERT INTO T_HOLHISTORY (SEQ_NU,YEAR_VC ,EMPNO_VC ,STDATE_VC,SMA_VC ,EDDATE_VC,EMA_VC ,REASON_VC,STATE_VC ,AEMPNO_VC,REFUSE_VC,INDATE_VC) VALUES (142,2004,'2018','0823',1,'0827',2,'�ް�',10,2001,'',20040817);
INSERT INTO T_HOLHISTORY (SEQ_NU,YEAR_VC ,EMPNO_VC ,STDATE_VC,SMA_VC ,EDDATE_VC,EMA_VC ,REASON_VC,STATE_VC ,AEMPNO_VC,REFUSE_VC,INDATE_VC) VALUES (143,2004,'1002','0824',1,'0827',2,'�ް�',0,1001,'',20040620);
INSERT INTO T_HOLHISTORY (SEQ_NU,YEAR_VC ,EMPNO_VC ,STDATE_VC,SMA_VC ,EDDATE_VC,EMA_VC ,REASON_VC,STATE_VC ,AEMPNO_VC,REFUSE_VC,INDATE_VC) VALUES (144,2004,'1019','0824',1,'0828',2,'����;',10,1001,'��ٷ��ٹ�',20040723);
INSERT INTO T_HOLHISTORY (SEQ_NU,YEAR_VC ,EMPNO_VC ,STDATE_VC,SMA_VC ,EDDATE_VC,EMA_VC ,REASON_VC,STATE_VC ,AEMPNO_VC,REFUSE_VC,INDATE_VC) VALUES (145,2004,'5003','0815',1,'0820',2,'�ް�',0,5001,'',20040726);
INSERT INTO T_HOLHISTORY (SEQ_NU,YEAR_VC ,EMPNO_VC ,STDATE_VC,SMA_VC ,EDDATE_VC,EMA_VC ,REASON_VC,STATE_VC ,AEMPNO_VC,REFUSE_VC,INDATE_VC) VALUES (146,2004,'4007','0728',1,'0801',2,'ȯ���� ��.. ������ �ް� �������',0,4001,'',20040729);
INSERT INTO T_HOLHISTORY (SEQ_NU,YEAR_VC ,EMPNO_VC ,STDATE_VC,SMA_VC ,EDDATE_VC,EMA_VC ,REASON_VC,STATE_VC ,AEMPNO_VC,REFUSE_VC,INDATE_VC) VALUES (147,2004,'6014','0920',1,'0925',2,'�ް�',0,6001,'',20040830);
COMMIT;

--����
--1.  ������ �����ȣ�� ���� �ް� �����ϰ� �ް� �������� �����ֵ�, ���������� �Ӽ���
-- SMA_VC�� EMA_VC�� �̿��Ͽ� 1�� ���� ����, 2�� ���� ���ķ� ����Ͻÿ�.
select EMPNO_VC as "���", STDATE_VC as "�ް�������", 
       DECODE(SMA_VC, 1, '����', '����') as "��������", 
       EDDATE_VC as "�ް�������", 
       DECODE(EMA_VC, 1, '����',2,'����') as "��������"
from t_holhistory;

--����
--2. �����ȣ�� �ް���û ���¸� ǥ���ϵ� ����( STATE_VC)�� 
--������� �ڵ尡 0�� ��� �㰡 , 10�� ����� , 20�� ��� ���㰡�� ǥ���Ͻÿ�.
select EMPNO_VC as "���", STDATE_VC as "�ް�������", 
       DECODE(STATE_VC,0,'�㰡',10,'���',20,'���㰡') as "����"
from t_holhistory;

-- CASE : ANSI SQL, �����
SELECT last_name,salary, CASE salary WHEN 24000 THEN salary*0.3
                                     WHEN 17000 THEN salary*0.2
                                     ELSE salary 
                         END ���ʽ�
FROM employees 
ORDER BY 2 desc;

SELECT last_name,salary, CASE WHEN salary >=20000 THEN 1000
                              WHEN salary >=15000 THEN 2000
                              WHEN salary >=10000 THEN 3000
                              ELSE 4000
                         END ���ʽ�
FROM employees 
ORDER BY 2 desc;

SELECT last_name,salary, CASE WHEN salary BETWEEN 20000 AND 25000 THEN '��' 
                              WHEN salary BETWEEN 10000 AND 20001 THEN '��' 
                              ELSE '��' 
                         END ���
FROM employees 
ORDER BY 2 desc;

SELECT last_name,salary, CASE WHEN salary IN ( 24000, 17000 , 14000) THEN '��' 
                              WHEN salary IN ( 13500, 13000) THEN '��' 
                              ELSE '��' 
                         END ���
FROM employees 
ORDER BY 2 desc;

-- �׷��Լ�
SELECT SUM(DISTINCT salary),SUM(ALL salary), SUM(salary) 
FROM employees;

SELECT SUM(salary)�հ�, AVG(salary)���, MAX(salary)�ִ�, MIN(salary)�ּ�
FROM employees;

SELECT MIN( hire_date ), MAX( hire_date) 
FROM employees;

SELECT COUNT(last_name), COUNT(commission_pct), COUNT(*)
FROM employees;

SELECT SUM(salary)�հ�, AVG(salary)���, MAX(salary)�ִ�, MIN(salary)�ּ�, COUNT(*)����
FROM employees;

-- ����� �׷��� - �μ���ȣ
SELECT department_id, max(SALARY), min(SALARY),sum(SALARY),round(avg(SALARY),2),count(*)
FROM employees
GROUP BY department_id
order by 1;

-- department_id 107���� sum(salary) 1���� �̹Ƿ� ����
select department_id, sum(salary)
from EMPLOYEES;

select department_id
from EMPLOYEES;

select sum(salary)
from EMPLOYEES;

select department_id, sum(salary)
from EMPLOYEES
group by department_id;

-- where ������ �׷��Լ� ��� �Ұ� (���� �׷����� �ȹ������Ƿ�)
SELECT department_id as id, SUM(salary)
FROM employees
--where SUM(salary) > 30000
group by department_id
having SUM(salary) > 30000;

-- �������� �˻�
select *
from user_constraints;

select *
from USER_CONSTRAINTS
where TABLE_NAME = 'EMPLOYEES';

select *
from USER_CONSTRAINTS
where TABLE_NAME = 'DEPARTMENTS';

-- (equi ����, inner ����)
SELECT last_name,department_name
FROM employees, departments 
WHERE employees.department_id = departments.department_id;

SELECT employees.last_name,departments.department_name
FROM employees, departments 
WHERE employees.department_id = departments.department_id;

-- ������ ���̺� ��� �����ϴ� �÷��� �ݵ�� ���̺��.�÷��� �������� �ۼ��ؾ� ��
SELECT last_name,department_name, employees.department_id 
FROM employees, departments 
WHERE employees.department_id = departments.department_id;

-- ���̺� ��Ī
SELECT emp.last_name,department_name, emp.department_id 
FROM employees emp, departments dept 
WHERE emp.department_id = dept.department_id;

-- ���� : ��Ī�� �����ϸ� �ݵ�� ��Ī�� ����ؾ� �ȴ�. ���̺�� ���Ұ�
SELECT employees.last_name,department_name, emp.department_id 
FROM employees emp, departments dept 
WHERE employees.department_id = dept.department_id;

-- �˻����� �߰� ==> ����Ŭ������ where ���� �������ǰ� �˻������� ���� �����Ѵ�.
SELECT emp.last_name,salary,department_name 
FROM employees emp, departments dept 
WHERE emp.department_id = dept.department_id 
      AND last_name='Whalen';

-- ���� ���� ��� ��� ����
SELECT d.department_name �μ���, COUNT(e.employee_id) �ο��� 
FROM employees e, departments d 
WHERE e.department_id = d.department_id AND TO_CHAR( hire_date , 'YYYY') <= 2005 
GROUP BY d.department_name
ORDER BY 2;

-- Non-Equi ���� (employees, job_grades ����)
SELECT last_name, salary, grade_level 
FROM employees e, job_grades g 
WHERE e.salary BETWEEN g.lowest_sal AND g.highest_sal;

-- n���� ���̺� ���ν� n-1���� ������ �ʿ�
SELECT last_name, salary, department_name, grade_level 
FROM employees e, departments d, job_grades g 
WHERE e.department_id = d.department_id 
      AND e.salary BETWEEN g.lowest_sal AND g.highest_sal;

-- self ����

-- ��� ���̺� �������� ����
SELECT employee_id, last_name, manager_id
FROM employees e;
-- ������ ���̺� �������� ����
SELECT employee_id, last_name
FROM employees m;

-- ������ ��� ���̺�, ������ ���̺��� ���� (inner ����, self ����)
SELECT e.last_name �����, m.last_name �����ڸ�, m2.last_name as "�������� �����ڸ�"
FROM employees e, employees m, employees m2
WHERE e.manager_id = m.employee_id 
      and m.manager_id = m2.employee_id;

-- outer ����
SELECT emp.last_name,department_name, emp.department_id 
FROM employees emp, departments dept 
WHERE emp.department_id = dept.department_id(+);

SELECT e.last_name �����, m.last_name �����ڸ� 
FROM employees e, employees m 
WHERE e.manager_id = m.employee_id(+);

SELECT e.last_name �����, m.last_name �����ڸ�, mm.last_name "�������� �����ڸ�" 
FROM employees e, employees m , employees mm 
WHERE e.manager_id = m.employee_id(+) 
      AND m.manager_id = mm.employee_id(+);
      
-- cartesian product ����
select emp.last_name, department_name, emp.department_id
from employees emp, departments dept;

-- ANSI
-- natural join --> �����÷��� ���̺��.�÷� �Ǵ� ��Ī.�÷� ���Ұ�, �ٸ� �÷��� ��밡��
SELECT last_name, department_name, department_id 
FROM employees NATURAL JOIN departments;

SELECT e.last_name, d.department_name, department_id 
FROM employees e NATURAL JOIN departments d;

SELECT last_name,department_name, department_id 
FROM employees e NATURAL JOIN departments d -- ��������
WHERE department_id=90;                     -- �˻�����

-- using �� --> �����÷��� ���̺��.�÷� �Ǵ� ��Ī.�÷� ���Ұ�, �ٸ� �÷��� ��밡��
SELECT last_name,department_name, department_id 
FROM employees e JOIN departments d USING(department_id);

SELECT last_name,department_name, department_id 
FROM employees e INNER JOIN departments d USING(department_id);

SELECT last_name,department_name, department_id 
FROM employees e INNER JOIN departments d USING(department_id); -- ��������
WHERE department_id=90;                                         -- �˻�����

-- ON �� --> ����Ŭ ���ΰ� �����ϰ� ���� �÷��� ��Ī.�÷� �������� ����ؾ� �ȴ�.
-- ������� 
SELECT last_name,department_name, e.department_id 
FROM employees e JOIN departments d ON e.department_id = d.department_id;

SELECT last_name,department_name, e.department_id 
FROM employees e INNER JOIN departments d ON e.department_id = d.department_id;

SELECT last_name,department_name, e.department_id 
FROM employees e INNER JOIN departments d ON e.department_id = d.department_id
WHERE e.department_id=90;

-- �ε����
SELECT last_name, salary, grade_level
FROM employees e, job_grades g
WHERE e.salary BETWEEN g.lowest_sal AND g.highest_sal;

SELECT last_name, salary, grade_level
FROM employees e INNER JOIN job_grades g ON e.salary BETWEEN g.lowest_sal AND g.highest_sal;

-- self ����
SELECT e.last_name �����, m.last_name �����ڸ� 
FROM employees e, employees m
WHERE e.manager_id = m.employee_id;

SELECT e.last_name �����, m.last_name �����ڸ� 
FROM employees e JOIN employees m ON e.manager_id = m.employee_id;

SELECT e.last_name �����, d.department_name �μ���, g.grade_level ��� 
FROM employees e INNER JOIN departments d ON e.department_id = d.department_id 
                 INNER JOIN job_grades g ON e.salary BETWEEN g.lowest_sal AND g.highest_sal;
                 
SELECT e.last_name �����, d.department_name �μ���, g.grade_level ��� 
FROM employees e INNER JOIN departments d USING(department_id)
                 INNER JOIN job_grades g ON e.salary BETWEEN g.lowest_sal AND g.highest_sal;
                 
-- cross join
SELECT last_name, department_name, e.department_id
FROM employees e CROSS JOIN departments d;

-- outer ����

-- 106��, department_id���� null ���� Grant ����� ������.
SELECT last_name,department_name, department_id
FROM employees e INNER JOIN departments d USING(department_id);

-- 107��, department_id���� null ���� Grant ��� ���Ե�
SELECT last_name,department_name, department_id
FROM employees e LEFT OUTER JOIN departments d USING(department_id);

SELECT last_name,department_name, department_id
FROM departments d RIGHT OUTER JOIN employees e USING(department_id);

SELECT last_name,department_name, e.department_id
FROM employees e LEFT OUTER JOIN departments d ON e.department_id = d.department_id;

SELECT last_name,department_name, e.department_id
FROM departments d RIGHT OUTER JOIN employees e ON e.department_id = d.department_id;

-- sub query --
SELECT salary
FROM employees
WHERE last_name = 'Whalen' ;

SELECT *
FROM employees
WHERE salary >= 4400;

-- main query
SELECT last_name,salary 
FROM employees WHERE salary >= (SELECT salary  -- sub query
																FROM employees 
																WHERE last_name='Whalen');
   
-- ������                             
-- ������� ��� ���޺��� �� ���� ������ �޴� ����� ��ȸ
SELECT AVG(salary) 
FROM employees; -- 6461.83

SELECT last_name,salary 
FROM employees
WHERE salary >= 6461.831775700934579439252336448598130841;

SELECT last_name,salary 
FROM employees WHERE salary >= (SELECT AVG(salary) 
                                FROM employees);

--������ �μ���ȣ�� 100�� ����� �߿��� �ִ� ������ �޴� ����� ������ ������ �޴� ����� ��ȸ
SELECT MAX(salary)
FROM employees
WHERE department_id = 100; --12008

SELECT last_name,salary 
FROM employees
WHERE salary = 12008;

SELECT last_name,salary 
FROM employees
WHERE salary = (select max(salary)
                from employees
                where department_id = 100);
                
SELECT department_id, MAX(salary) 
FROM employees 
GROUP BY department_id 
HAVING MAX(salary) > (SELECT MAX(salary) 
                      FROM employees 
                      WHERE department_id=100 );
                      
--������
-- ���߿����� IN : ���� ������ ��
SELECT salary 
FROM employees 
WHERE last_name IN ('Whalen','Fay');
                  
SELECT last_name, salary 
FROM employees 
WHERE salary IN ( SELECT salary 
                  FROM employees 
                  WHERE last_name IN ('Whalen','Fay') );
                  
-- ���߿����� > all : ���������� �ִ밪���� ū ���� ��ȸ
SELECT last_name, department_id, salary 
FROM employees 
WHERE salary > ALL (SELECT salary 
                    FROM employees 
                    WHERE job_id = 'IT_PROG');

SELECT last_name, department_id, salary 
FROM employees 
WHERE salary > (SELECT MAX(salary) 
                FROM employees 
                WHERE job_id = 'IT_PROG');   

-- ���߿����� < all : ���������� �ּҰ����� ���� ���� ��ȸ
SELECT last_name, department_id, salary 
FROM employees 
WHERE salary < ALL (SELECT salary 
                    FROM employees 
                    WHERE job_id = 'IT_PROG');
                    
SELECT last_name, department_id, salary 
FROM employees 
WHERE salary < (SELECT MIN(salary) 
                FROM employees 
                WHERE job_id = 'IT_PROG');   
                
-- ���߿����� > any : ���������� �ּҰ����� ū �������� ��ȸ                
SELECT last_name, department_id, salary 
FROM employees 
WHERE salary > ANY (SELECT salary 
                    FROM employees 
                    WHERE job_id = 'IT_PROG');  

SELECT last_name, department_id, salary 
FROM employees 
WHERE salary > (SELECT MIN(salary) 
                FROM employees 
                WHERE job_id = 'IT_PROG');    

-- ���߿����� < any : ���������� �ִ밪���� ���� �������� ��ȸ                
SELECT last_name, department_id, salary 
FROM employees 
WHERE salary < ANY (SELECT salary 
                    FROM employees 
                    WHERE job_id = 'IT_PROG');  

SELECT last_name, department_id, salary 
FROM employees 
WHERE salary < (SELECT MAX(salary) 
                FROM employees 
                WHERE job_id = 'IT_PROG');  

-- ���߿����� EXISTS : 
/*���������� ����� ������ ( �����ϸ� ) ���� ������ ����ǰ�
���������� ����� ������ ���� ������ ���� �ȵ�.*/

SELECT employee_id 
FROM employees 
WHERE commission_pct IS NOT NULL;

SELECT last_name, department_id, salary 
FROM employees 
WHERE EXISTS (SELECT employee_id 
              FROM employees 
              WHERE commission_pct IS NOT NULL);               

--���� �÷� �������� : ������������ ���� ���� �÷����� �˻��Ͽ� ���������� �������� ���ϴ� ��������
SELECT last_name, department_id, salary 
FROM employees 
WHERE (department_id, salary) IN ( SELECT department_id, MAX(salary) 
                                   FROM employees 
                                   GROUP BY department_id ) 
ORDER BY 2;

--�ζ��� ��( in-line view ) : FROM ������ ���� ��������
SELECT e.department_id , SUM(salary) ����, AVG(salary) ���, COUNT(*) �ο��� 
FROM employees e , departments d 
WHERE e.department_id = d.department_id 
GROUP BY e.department_id ORDER BY 1;

SELECT e.department_id, �հ�, ���, �ο��� 
FROM ( SELECT department_id, SUM(salary) �հ�, AVG(salary) ��� , COUNT(*) �ο��� 
       FROM employees 
       GROUP BY department_id ) e, departments d 
WHERE e.department_id = d.department_id 
ORDER By 1;
