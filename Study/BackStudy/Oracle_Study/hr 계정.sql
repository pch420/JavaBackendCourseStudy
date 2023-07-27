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

-- 오라클에 저장된 여러 가지 파라미터 설정값을 알아보기
select * 
from NLS_SESSION_PARAMETERS;

-- 날짜 RR YY 차이 알아보기
CREATE TABLE EXAM
(a DATE, b date);

insert into EXAM (a,b)
values ( to_date('15/01/01','RR/MM/DD'), to_date('15/01/01','YY/MM/DD'));

SELECT TO_CHAR(A,'RRRR'), TO_CHAR(B, 'YYYY')
FROM EXAM;

-- 현재 날짜 반환
SELECT SYSDATE , SYSTIMESTAMP
FROM dual;

-- 연산 기능
SELECT SYSDATE 오늘, SYSDATE+1 내일, SYSDATE-1 어제, SYSDATE+30 다음달
FROM dual;

SELECT last_name, hire_date, TRUNC((sysdate-hire_date)/365) "년" 
FROM employees 
ORDER BY TRUNC((sysdate-hire_date)/365) desc;

SELECT last_name, hire_date, TRUNC((sysdate-hire_date)/365) "년" 
FROM employees 
ORDER BY 3 desc;

SELECT last_name, hire_date, TRUNC((sysdate-hire_date)/365) "년" 
FROM employees 
ORDER BY 년 desc;

-- 지정된 두 날짜의 개월수 반환
SELECT last_name, hire_date, TRUNC(MONTHS_BETWEEN(sysdate, hire_date)) "근무 월수" 
FROM employees 
ORDER BY 3 desc;

-- 월 더하기 및 빼기
SELECT sysdate 현재, ADD_MONTHS(sysdate,1) 다음달, ADD_MONTHS(sysdate,-1) 이전달 
FROM dual;

-- 지정된 날짜기준에 가장 가까운 요일의 날짜 반환
SELECT SYSDATE, NEXT_DAY(SYSDATE, '토'), NEXT_DAY(SYSDATE, '토요일'), NEXT_DAY(SYSDATE, 7)
FROM DUAL; 

-- 지정된 날짜의 월의 마지막 날짜 반환
SELECT SYSDATE, LAST_DAY(SYSDATE), LAST_DAY(ADD_MONTHS(SYSDATE,1))
FROM DUAL; 

-- 년도 및 월 반올림
SELECT last_name, hire_date, ROUND(hire_date,'YEAR'), ROUND(hire_date,'MONTH') 
FROM employees;

-- 년도 및 월 절삭
SELECT last_name, hire_date, TRUNC(hire_date,'YEAR'), TRUNC(hire_date,'MONTH') 
FROM employees;

-- 자동 형 변환
SELECT last_name, salary 
FROM employees
WHERE salary = '17000'; -- 문자가 숫자로 자동변환

SELECT last_name, salary 
FROM employees
WHERE HIRE_DATE = '03/06/17'; -- 문자가 날짜로 자동변환

-- 명시적 형변환 (날짜 --> 문자)
SELECT SYSDATE, TO_CHAR(SYSDATE, 'YYYY'), TO_CHAR(SYSDATE, 'MM')
FROM DUAL;
SELECT SYSDATE, TO_CHAR(SYSDATE, 'YYYY/MM/DD MON DAY DY')
FROM DUAL;
SELECT SYSDATE, TO_CHAR(SYSDATE, 'YYYY"년"MM"월"DD"일"')
FROM DUAL;

SELECT SYSDATE, TO_CHAR(SYSDATE, 'AM HH"시" HH24"시" MI"분" SS"초"')
FROM DUAL;

SELECT TO_CHAR(SYSDATE, 'YYYY/MM/DD,(AM) DY HH24:MI:SS') 
FROM dual;

-- 날짜에서 특정년도만 추출, 월만 추출, 일만 추출
select sysdate, to_char(sysdate, 'YY'), to_char(sysdate, 'MM')
from dual;

select sysdate, EXTRACT(YEAR FROM sysdate)년, 
                EXTRACT(MONTH FROM sysdate)월,
                EXTRACT(DAY FROM sysdate)일,
                EXTRACT(HOUR FROM SYSTIMESTAMP)시,
                EXTRACT(MINUTE FROM SYSTIMESTAMP)분,
                EXTRACT(SECOND FROM SYSTIMESTAMP)초
from dual;

SELECT last_name,hire_date, salary 
FROM employees 
WHERE TO_CHAR(hire_date, 'MM')='09';
-- extract로 변경하기
SELECT last_name,hire_date, salary 
FROM employees
WHERE EXTRACT(MONTH FROM HIRE_DATE)='09';

-- 명시적 형변환 (숫자 --> 문자)
SELECT last_name, salary, TO_CHAR(salary, '$999,999') 달러, TO_CHAR(salary, 'L999,999') 원화 
FROM employees;

SELECT TO_CHAR(987654321,'L999,999,999')
FROM DUAL;

-- 명시적 형변환 (문자 --> 수치)
SELECT TO_NUMBER('123') + 100 
FROM dual;

SELECT TO_NUMBER('123,456','999,999') + 100 
FROM dual;

SELECT TO_NUMBER('$123,456','$999,999') + 100 
FROM dual;

-- 명시적 형변환 (문자 --> 날짜)
-- 날짜포멧 변경
ALTER SESSION SET NLS_DATE_FORMAT='YYYY/MM/DD HH24:MI:SS';

SELECT TO_DATE( '20170802181030' , 'YYYYMMDDHH24MISS' ) 
FROM dual;

SELECT TO_DATE( '2017년08월02일' , 'YYYY"년"MM"월"DD"일"' ) 
FROM dual;

SELECT TO_DATE( '20170802181030' , 'YYYYMMDDHH24MISS' ) 
FROM dual;

-- 실제 DB에 날짜를 저장한다면?
-- 가. 20170802 (권장, raw data)
-- 나. 2017년08월02일 ==> 문제1: 저장크기 더 필요함, 문제2: 출력시 포맷변경이 제한적임, 문제3: Locale(지역화)

-- 조건: decode 함수
SELECT last_name,salary,DECODE(salary,24000, salary*0.3, 
                                      17000, salary*0.2, 
                                             salary) as "보너스"
FROM employees 
ORDER BY 2 desc;

SELECT COUNT(*) "총인원수",
  SUM(DECODE(TO_CHAR(hire_date, 'YYYY'), 2001, 1, 0)) "2001", 
  SUM(DECODE(TO_CHAR(hire_date, 'YYYY'), 2002, 1, 0)) "2002", 
  SUM(DECODE(TO_CHAR(hire_date, 'YYYY'), 2003, 1, 0)) "2003", 
  SUM(DECODE(TO_CHAR(hire_date, 'YYYY'), 2004, 1, 0)) "2004", 
  SUM(DECODE(TO_CHAR(hire_date, 'YYYY'), 2005, 1, 0)) "2005", 
  SUM(DECODE(TO_CHAR(hire_date, 'YYYY'), 2006, 1, 0)) "2006", 
  SUM(DECODE(TO_CHAR(hire_date, 'YYYY'), 2007, 1, 0)) "2007", 
  SUM(DECODE(TO_CHAR(hire_date, 'YYYY'), 2008, 1, 0)) "2008"
FROM employees;

-- decode 실습

drop table T_HOLHISTORY;

CREATE TABLE T_HOLHISTORY
(
SEQ_NU 		 NUMBER  NOT NULL,	-- 사원 순번
YEAR_VC	 	 VARCHAR2(4) NOT NULL,	-- 년도
EMPNO_VC 	 VARCHAR2(4) NOT NULL,	-- 사원번호
STDATE_VC 	 VARCHAR2(4) NOT NULL,	--휴가시작일
SMA_VC 	 	 VARCHAR2(1) NOT NULL,	--휴가 시작 오전 오후
EDDATE_VC 	 VARCHAR2(4) NOT NULL,	--휴가 종료일
EMA_VC 		 VARCHAR2(1) NOT NULL,	--휴가 종료 오전 오후
REASON_VC	 VARCHAR2(100) ,		--휴가 사유
STATE_VC 	 VARCHAR2(2) NOT NULL,	--현재 상태 (0 -> 허가 , 10 -> 대기 , 20 ->불가)	
AEMPNO_VC 	 VARCHAR2(4) NOT NULL,	--허가자 사번
REFUSE_VC 	 VARCHAR2(100) ,		-- 불허가 사유
INDATE_VC 	 VARCHAR2(8)		-- 입력날짜
);

INSERT INTO T_HOLHISTORY (SEQ_NU,YEAR_VC ,EMPNO_VC ,STDATE_VC,SMA_VC ,EDDATE_VC,EMA_VC ,REASON_VC,STATE_VC ,AEMPNO_VC,REFUSE_VC,INDATE_VC) VALUES (128,2004,'1024','0610',1,'0612',2,'그냥',10,1001,'',20040528);
INSERT INTO T_HOLHISTORY (SEQ_NU,YEAR_VC ,EMPNO_VC ,STDATE_VC,SMA_VC ,EDDATE_VC,EMA_VC ,REASON_VC,STATE_VC ,AEMPNO_VC,REFUSE_VC,INDATE_VC) VALUES (129,2004,'2018','0612',1,'0615',2,'여행',0,2001,'',20040607);
INSERT INTO T_HOLHISTORY (SEQ_NU,YEAR_VC ,EMPNO_VC ,STDATE_VC,SMA_VC ,EDDATE_VC,EMA_VC ,REASON_VC,STATE_VC ,AEMPNO_VC,REFUSE_VC,INDATE_VC) VALUES (130,2004,'3020','0527',2,'0528',1,'그냥',20,3001,'그냥',20040520);
INSERT INTO T_HOLHISTORY (SEQ_NU,YEAR_VC ,EMPNO_VC ,STDATE_VC,SMA_VC ,EDDATE_VC,EMA_VC ,REASON_VC,STATE_VC ,AEMPNO_VC,REFUSE_VC,INDATE_VC) VALUES (131,2004,'2022','0713',1,'0713',2,'병가',0,2001,'',20040712);
INSERT INTO T_HOLHISTORY (SEQ_NU,YEAR_VC ,EMPNO_VC ,STDATE_VC,SMA_VC ,EDDATE_VC,EMA_VC ,REASON_VC,STATE_VC ,AEMPNO_VC,REFUSE_VC,INDATE_VC) VALUES (132,2004,'1011','0830',1,'0830',2,'쓰러질거 같음',0,1001,'',20040801);
INSERT INTO T_HOLHISTORY (SEQ_NU,YEAR_VC ,EMPNO_VC ,STDATE_VC,SMA_VC ,EDDATE_VC,EMA_VC ,REASON_VC,STATE_VC ,AEMPNO_VC,REFUSE_VC,INDATE_VC) VALUES (133,2004,'1002','0515',1,'0515',2,'허가 안해주면 일 안함',0,1001,'',20040311);
INSERT INTO T_HOLHISTORY (SEQ_NU,YEAR_VC ,EMPNO_VC ,STDATE_VC,SMA_VC ,EDDATE_VC,EMA_VC ,REASON_VC,STATE_VC ,AEMPNO_VC,REFUSE_VC,INDATE_VC) VALUES (134,2004,'2027','0811',1,'0811',2,'병가',0,2001,'',20040808);
INSERT INTO T_HOLHISTORY (SEQ_NU,YEAR_VC ,EMPNO_VC ,STDATE_VC,SMA_VC ,EDDATE_VC,EMA_VC ,REASON_VC,STATE_VC ,AEMPNO_VC,REFUSE_VC,INDATE_VC) VALUES (135,2004,'1024','0915',2,'0915',2,'병원가야됨',0,1001,'',20040808);
INSERT INTO T_HOLHISTORY (SEQ_NU,YEAR_VC ,EMPNO_VC ,STDATE_VC,SMA_VC ,EDDATE_VC,EMA_VC ,REASON_VC,STATE_VC ,AEMPNO_VC,REFUSE_VC,INDATE_VC) VALUES (136,2004,'1024','0913',1,'0913',1,'그냥',0,1001,'',20040808);
INSERT INTO T_HOLHISTORY (SEQ_NU,YEAR_VC ,EMPNO_VC ,STDATE_VC,SMA_VC ,EDDATE_VC,EMA_VC ,REASON_VC,STATE_VC ,AEMPNO_VC,REFUSE_VC,INDATE_VC) VALUES (137,2004,'3017','0924',1,'0924',2,'쉬고싶어서',20,3001,'나두 쉬고 싶다…', 20040808);
INSERT INTO T_HOLHISTORY (SEQ_NU,YEAR_VC ,EMPNO_VC ,STDATE_VC,SMA_VC ,EDDATE_VC,EMA_VC ,REASON_VC,STATE_VC ,AEMPNO_VC,REFUSE_VC,INDATE_VC) VALUES (138,2004,'4021','0905',1,'0909',2,'휴가',0,4001,'',20040808);
INSERT INTO T_HOLHISTORY (SEQ_NU,YEAR_VC ,EMPNO_VC ,STDATE_VC,SMA_VC ,EDDATE_VC,EMA_VC ,REASON_VC,STATE_VC ,AEMPNO_VC,REFUSE_VC,INDATE_VC) VALUES (139,2004,'5003','0905',2,'0905',1,'미칠지경임',0,5001,'',20040808);
INSERT INTO T_HOLHISTORY (SEQ_NU,YEAR_VC ,EMPNO_VC ,STDATE_VC,SMA_VC ,EDDATE_VC,EMA_VC ,REASON_VC,STATE_VC ,AEMPNO_VC,REFUSE_VC,INDATE_VC) VALUES (140,2004,'6028','0904',2,'0905',1,'휴가',0,6001,'',20040811);
INSERT INTO T_HOLHISTORY (SEQ_NU,YEAR_VC ,EMPNO_VC ,STDATE_VC,SMA_VC ,EDDATE_VC,EMA_VC ,REASON_VC,STATE_VC ,AEMPNO_VC,REFUSE_VC,INDATE_VC) VALUES (141,2004,'6002','0901',1,'0903',2,'쉬고싶어요',0,6001,'',20040824);
INSERT INTO T_HOLHISTORY (SEQ_NU,YEAR_VC ,EMPNO_VC ,STDATE_VC,SMA_VC ,EDDATE_VC,EMA_VC ,REASON_VC,STATE_VC ,AEMPNO_VC,REFUSE_VC,INDATE_VC) VALUES (142,2004,'2018','0823',1,'0827',2,'휴가',10,2001,'',20040817);
INSERT INTO T_HOLHISTORY (SEQ_NU,YEAR_VC ,EMPNO_VC ,STDATE_VC,SMA_VC ,EDDATE_VC,EMA_VC ,REASON_VC,STATE_VC ,AEMPNO_VC,REFUSE_VC,INDATE_VC) VALUES (143,2004,'1002','0824',1,'0827',2,'휴가',0,1001,'',20040620);
INSERT INTO T_HOLHISTORY (SEQ_NU,YEAR_VC ,EMPNO_VC ,STDATE_VC,SMA_VC ,EDDATE_VC,EMA_VC ,REASON_VC,STATE_VC ,AEMPNO_VC,REFUSE_VC,INDATE_VC) VALUES (144,2004,'1019','0824',1,'0828',2,'쉬고싶어서',10,1001,'기다려바바',20040723);
INSERT INTO T_HOLHISTORY (SEQ_NU,YEAR_VC ,EMPNO_VC ,STDATE_VC,SMA_VC ,EDDATE_VC,EMA_VC ,REASON_VC,STATE_VC ,AEMPNO_VC,REFUSE_VC,INDATE_VC) VALUES (145,2004,'5003','0815',1,'0820',2,'휴가',0,5001,'',20040726);
INSERT INTO T_HOLHISTORY (SEQ_NU,YEAR_VC ,EMPNO_VC ,STDATE_VC,SMA_VC ,EDDATE_VC,EMA_VC ,REASON_VC,STATE_VC ,AEMPNO_VC,REFUSE_VC,INDATE_VC) VALUES (146,2004,'4007','0728',1,'0801',2,'환장할 듯.. 무조건 휴가 보내줘요',0,4001,'',20040729);
INSERT INTO T_HOLHISTORY (SEQ_NU,YEAR_VC ,EMPNO_VC ,STDATE_VC,SMA_VC ,EDDATE_VC,EMA_VC ,REASON_VC,STATE_VC ,AEMPNO_VC,REFUSE_VC,INDATE_VC) VALUES (147,2004,'6014','0920',1,'0925',2,'휴가',0,6001,'',20040830);
COMMIT;

--문제
--1.  각각의 사원번호에 대해 휴가 시작일과 휴가 종료일을 보여주되, 오전오후의 속성인
-- SMA_VC와 EMA_VC를 이용하여 1일 경우는 오전, 2일 경우는 오후로 출력하시오.
select EMPNO_VC as "사번", STDATE_VC as "휴가시작일", 
       DECODE(SMA_VC, 1, '오전', '오후') as "오전오후", 
       EDDATE_VC as "휴가종료일", 
       DECODE(EMA_VC, 1, '오전',2,'오후') as "오전오후"
from t_holhistory;

--문제
--2. 사원번호와 휴가신청 상태를 표시하되 상태( STATE_VC)의 
--현재상태 코드가 0일 경우 허가 , 10일 경우대기 , 20일 경우 불허가로 표시하시오.
select EMPNO_VC as "사번", STDATE_VC as "휴가시작일", 
       DECODE(STATE_VC,0,'허가',10,'대기',20,'불허가') as "상태"
from t_holhistory;

-- CASE : ANSI SQL, 동등비교
SELECT last_name,salary, CASE salary WHEN 24000 THEN salary*0.3
                                     WHEN 17000 THEN salary*0.2
                                     ELSE salary 
                         END 보너스
FROM employees 
ORDER BY 2 desc;

SELECT last_name,salary, CASE WHEN salary >=20000 THEN 1000
                              WHEN salary >=15000 THEN 2000
                              WHEN salary >=10000 THEN 3000
                              ELSE 4000
                         END 보너스
FROM employees 
ORDER BY 2 desc;

SELECT last_name,salary, CASE WHEN salary BETWEEN 20000 AND 25000 THEN '상' 
                              WHEN salary BETWEEN 10000 AND 20001 THEN '중' 
                              ELSE '하' 
                         END 등급
FROM employees 
ORDER BY 2 desc;

SELECT last_name,salary, CASE WHEN salary IN ( 24000, 17000 , 14000) THEN '상' 
                              WHEN salary IN ( 13500, 13000) THEN '중' 
                              ELSE '하' 
                         END 등급
FROM employees 
ORDER BY 2 desc;

-- 그룹함수
SELECT SUM(DISTINCT salary),SUM(ALL salary), SUM(salary) 
FROM employees;

SELECT SUM(salary)합계, AVG(salary)평균, MAX(salary)최대, MIN(salary)최소
FROM employees;

SELECT MIN( hire_date ), MAX( hire_date) 
FROM employees;

SELECT COUNT(last_name), COUNT(commission_pct), COUNT(*)
FROM employees;

SELECT SUM(salary)합계, AVG(salary)평균, MAX(salary)최대, MIN(salary)최소, COUNT(*)개수
FROM employees;

-- 명시적 그룹핑 - 부서번호
SELECT department_id, max(SALARY), min(SALARY),sum(SALARY),round(avg(SALARY),2),count(*)
FROM employees
GROUP BY department_id
order by 1;

-- department_id 107개행 sum(salary) 1개행 이므로 에러
select department_id, sum(salary)
from EMPLOYEES;

select department_id
from EMPLOYEES;

select sum(salary)
from EMPLOYEES;

select department_id, sum(salary)
from EMPLOYEES
group by department_id;

-- where 절에는 그룹함수 사용 불가 (아직 그룹으로 안묶였으므로)
SELECT department_id as id, SUM(salary)
FROM employees
--where SUM(salary) > 30000
group by department_id
having SUM(salary) > 30000;

