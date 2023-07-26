show user;

DESC employees;
DESC departments;

-- 1. 모든 컬럼 보기
SELECT * FROM employees;
select * 
from EMPLOYEES;

SELECT * FROM departments;

-- 2. 특정 컬럼 보기 (컬럼 해드의 값은 select 문에서 적은 그대로 나옴
SELECT employee_id, last_name, hire_date, salary
FROM employees;

-- 3. 연산 가능 (연산식이 컬럼헤딩으로 표시되어 출력됨)
SELECT last_name, salary, salary * 12
FROM employees;

-- 4. 별칭
SELECT last_name as 이름, salary 월급, salary * 12 as 연봉
FROM employees;

SELECT last_name as "사원 이름", salary "사원 월급", salary * 12 as "연 봉" 
FROM employees;

-- 5. null
SELECT last_name 이름, salary 월급, commission_pct 수수료,
salary* 12+commission_pct as 연봉
FROM employees;

SELECT last_name 이름, salary 월급, commission_pct 수수료,
salary * 12+NVL(commission_pct,0) as 연봉
FROM employees;

-- 6. 연결: 컬럼 || 컬럼
SELECT last_name || salary as "이름 월급" 
FROM employees;

-- 6. 연결: 컬럼 || '값'
SELECT last_name || '사원'
FROM employees;

SELECT last_name || '의 직업은 ' || job_id || ' 입니다' as "사원별 직급" 
FROM employees;

-- 7. 중복제거
SELECT job_id 
FROM employees;

SELECT DISTINCT job_id 
FROM employees;

--//////////////////////////
-- 8. where 절의 비교 연산자
SELECT employee_id,last_name,job_id, salary 
FROM employees
WHERE salary >= 10000;

SELECT employee_id,last_name,job_id, salary 
FROM employees
WHERE last_name = 'King';
-- SQL문의 식별자는 대소문자 구별을 안하지만 값(리터널)은 대소문자를 구별한다.
SELECT employee_id,last_name,job_id, salary 
FROM employees
WHERE last_name = 'KING';

SELECT employee_id,last_name,salary,hire_date 
FROM employees
WHERE hire_date > '07/12/31';

-- 8. Between a AND b <- a, b 포함
SELECT employee_id,last_name,salary,hire_date 
FROM employees
WHERE salary BETWEEN 7000 AND 8000;

SELECT employee_id,last_name,salary,hire_date 
FROM employees
WHERE hire_date BETWEEN '07/01/01' AND '08/12/31';

-- 9. in 연산자
SELECT employee_id,last_name,salary,hire_date 
FROM employees
WHERE employee_id IN ( 100,200,300 );

SELECT employee_id,last_name,salary,hire_date 
FROM employees
WHERE last_name IN ( 'King','Abel','Jones');

SELECT employee_id,last_name,salary,hire_date 
FROM employees 
WHERE hire_date IN ( '01/01/13','07/02/07');

-- 10. like + 와일드카드문자( %, _ )
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

-- 11. 논리 연산자 - and
SELECT last_name,job_id,salary 
FROM employees
WHERE job_id = 'IT_PROG' AND salary >= 5000;

-- 11. 논리 연산자 - or
SELECT last_name,job_id,salary 
FROM employees
WHERE job_id = 'IT_PROG' OR salary >= 5000;

-- 11. 논리 연산자 - not
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
WHERE MANAGER_ID IS NULL; -- 사장

SELECT last_name,job_id,salary 
FROM employees 
WHERE manager_id IS NOT NULL;

-- 논리 연산자 사용시 주의: and 가 or보다 우선순위가 높다.
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
-- 12 정렬
SELECT employee_id,last_name,job_id,salary 
FROM employees
ORDER BY salary DESC;

SELECT employee_id,last_name,job_id,salary 
FROM employees
ORDER BY salary asc;

SELECT employee_id,last_name,job_id,salary 
FROM employees
ORDER BY salary; --기본은 오름차순

SELECT employee_id,last_name,job_id,salary as "월급" 
FROM employees
ORDER BY 월급 DESC;

SELECT employee_id,last_name,job_id,salary as "월급" 
FROM employees
ORDER BY 4 DESC;

SELECT employee_id,last_name as 이름,job_id,salary 
FROM employees
ORDER BY last_name ASC; -- A:65 B:66

SELECT employee_id,last_name as 이름,job_id,salary 
FROM employees
ORDER 이름 ASC;

SELECT employee_id,last_name as 이름,job_id,salary 
FROM employees
ORDER BY 2 ASC;

SELECT employee_id,last_name,salary,hire_date as 입사일 
FROM employees
ORDER BY hire_date DESC;

SELECT employee_id,last_name,salary,hire_date as 입사일 
FROM employees
ORDER BY 입사일 DESC;

SELECT employee_id,last_name,salary,hire_date as 입사일 
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
order by COMMISSION_PCT desc; -- 오라클에서 null 값을 가장 큰 값으로 처리함

-- dual
select 25487*895632
from dual;
select sysdate
from dual;

-- 13. 단일행 함수 - 문자함수
-- 첫글자만 대문자
SELECT INITCAP('ORACLE SQL')
FROM dual;

SELECT email, INITCAP(email)
FROM employees;

-- 모두 대문자
SELECT last_name, UPPER(last_name)
FROM employees;

SELECT last_name, salary
FROM employees
WHERE UPPER(last_name)='KING';

-- 모두 소문자
SELECT last_name, LOWER(last_name)
FROM employees;

-- 문자열 연결
SELECT CONCAT( last_name, salary)
FROM employees;

SELECT last_name || salary
FROM employees;

-- 문자열 길이
SELECT last_name, LENGTH(last_name)
FROM employees;

-- 특정문자 위치
SELECT INSTR('MILLER' , 'L', 1 , 2 ), INSTR('MILLER' , 'X', 1 , 2 )
FROM dual;

SELECT INSTR('MILLER' , 'L', 5 , 2 ), INSTR('MILLER' , 'X', 1 , 2 )
FROM dual;

-- 부분열
SELECT SUBSTR('900303-1234567' , 8 , 1 ) 
FROM dual;

SELECT SUBSTR('900303-1234567' , 8) 
FROM dual;

SELECT hire_date 입사일, SUBSTR(hire_date,1,2) 입사년도
FROM employees;

-- 치환
SELECT REPLACE('JACK and JUE' , 'J' , 'BL' ) 
FROM dual;

-- 왼쪽 채우기
SELECT LPAD('MILLER',10,'*')
FROM dual;

-- 오른쪽 채우기
SELECT RPAD('MILLER',10,'*')
FROM dual;

-- 공백 및 특정문자 삭제 - 왼쪽
SELECT LTRIM('MILLER', 'M') 
FROM dual;

SELECT LTRIM('MMMMMILMLER', 'M') 
FROM dual;

SELECT LTRIM('     MILLER     '), LENGTH(LTRIM('     MILLER     ')) 
FROM dual;

-- 공백 및 특정문자 삭제 - 오른쪽
SELECT RTRIM('MILLER', 'R') 
FROM dual;

SELECT RTRIM('MILRLERRRRRRRRRRR', 'R') 
FROM dual;

SELECT RTRIM('     MILLER     '), LENGTH(LTRIM('     MILLER     ')) 
FROM dual;

-- 공백 및 특정문자 삭제 - 왼쪽, 오른쪽, 양쪽
SELECT TRIM( '0' FROM '0001234567000' ) 
FROM dual;
SELECT TRIM(BOTH '0' FROM '0001234567000' ) 
FROM dual;

SELECT TRIM(LEADING '0' FROM '0001234567000' ) 
FROM dual;

SELECT TRIM(TRAILING '0' FROM '0001234567000' ) 
FROM dual;

-- 반올림
SELECT ROUND( 456.789, 2 ) 
FROM dual;

SELECT ROUND( 456.789, -1 ) 
FROM dual;

SELECT ROUND( 456.789 ) 
FROM dual;

-- 버림
SELECT TRUNC( 456.789, 2 ) 
FROM dual;

SELECT TRUNC( 456.789, -1 ) 
FROM dual;

SELECT TRUNC( 456.789 ) 
FROM dual;

-- 나머지 (% 연산자는 나머지로 사용 불가- like의 와일드카드임)
SELECT MOD( 10 , 3 ) , MOD( 10 , 0 ) 
FROM dual;

-- 올림
SELECT CEIL(10.6), CEIL(-10.6) 
FROM dual;

-- 내림
SELECT FLOOR(10.6), FLOOR(-10.6) 
FROM dual;

-- 양수 음수 0 판단 양수면 1, 음수면 -1, 0이면 0 반환
SELECT SIGN( 100 ) , SIGN(-20) , SIGN(0) 
FROM dual;