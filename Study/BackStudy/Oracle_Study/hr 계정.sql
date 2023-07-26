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